package seedu.address;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;
import seedu.address.commons.core.Config;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.Version;
import seedu.address.commons.exceptions.AlfredException;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.util.ConfigUtil;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.AlfredLogic;
import seedu.address.logic.AlfredLogicManager;
import seedu.address.model.AlfredModel;
import seedu.address.model.AlfredModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.storage.AlfredStorage;
import seedu.address.storage.AlfredStorageManager;

import seedu.address.storage.JsonMentorListStorage;
import seedu.address.storage.JsonParticipantListStorage;
import seedu.address.storage.JsonTeamListStorage;
import seedu.address.storage.JsonUserPrefsStorage;
import seedu.address.storage.MentorListStorage;
import seedu.address.storage.ParticipantListStorage;


import seedu.address.storage.TeamListStorage;
import seedu.address.storage.UserPrefsStorage;
import seedu.address.ui.Ui;
import seedu.address.ui.UiManager;

/**
 * Runs the application.
 */
public class MainApp extends Application {

    public static final Version VERSION = new Version(0, 6, 0, true);

    private static final Logger logger = LogsCenter.getLogger(MainApp.class);

    protected Ui ui;
    protected AlfredLogic alfredLogic;
    protected AlfredStorage alfredStorage;
    protected AlfredModel alfredModel;
    protected Config config;

    @Override
    public void init() throws Exception {
        logger.info("=============================[ Initializing AddressBook ]===========================");
        super.init();

        AppParameters appParameters = AppParameters.parse(getParameters());
        config = initConfig(appParameters.getConfigPath());

        //Initialise UserPrefs
        UserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(config.getUserPrefsFilePath());
        UserPrefs userPrefs = initPrefs(userPrefsStorage);


        //Initialise EntityList Storage and AlfredStorage
        ParticipantListStorage participantListStorage = new JsonParticipantListStorage(userPrefs.getParticipantListFilePath());
        MentorListStorage mentorListStorage = new JsonMentorListStorage(userPrefs.getMentorListFilePath());
        TeamListStorage teamListStorage = new JsonTeamListStorage(userPrefs.getTeamListFilePath());
        AlfredStorage alfredStorage = new AlfredStorageManager(participantListStorage, mentorListStorage, teamListStorage, userPrefsStorage);

        initLogging(config);

        alfredModel = initModelManager(alfredStorage, userPrefs);

        alfredLogic = new AlfredLogicManager(alfredModel, alfredStorage);

        ui = new UiManager(alfredLogic);
    }

    // Feels like Single responsibility principle is violated if I moved the
    // initialisation phase over to AlfredModelManager?
    protected AlfredModel initModelManager(AlfredStorage alfredStorage, UserPrefs userPrefs) throws AlfredException {
        return AlfredModelManager.initModelManager(alfredStorage, userPrefs);
    }

    private void initLogging(Config config) {
        LogsCenter.init(config);
    }

    /**
     * Returns a {@code Config} using the file at {@code configFilePath}. <br>
     * The default file path {@code Config#DEFAULT_CONFIG_FILE} will be used instead
     * if {@code configFilePath} is null.
     */
    protected Config initConfig(Path configFilePath) {
        Config initializedConfig;
        Path configFilePathUsed;

        configFilePathUsed = Config.DEFAULT_CONFIG_FILE;

        if (configFilePath != null) {
            logger.info("Custom Config file specified " + configFilePath);
            configFilePathUsed = configFilePath;
        }

        logger.info("Using config file : " + configFilePathUsed);

        try {
            Optional<Config> configOptional = ConfigUtil.readConfig(configFilePathUsed);
            initializedConfig = configOptional.orElse(new Config());
        } catch (DataConversionException e) {
            logger.warning("Config file at " + configFilePathUsed + " is not in the correct format. "
                    + "Using default config properties");
            initializedConfig = new Config();
        }

        // Update config file in case it was missing to begin with or there are
        // new/unused fields
        try {
            ConfigUtil.saveConfig(initializedConfig, configFilePathUsed);
        } catch (IOException e) {
            logger.warning("Failed to save config file : " + StringUtil.getDetails(e));
        }
        return initializedConfig;
    }

    /**
     * Returns a {@code UserPrefs} using the file at {@code storage}'s user prefs
     * file path, or a new {@code UserPrefs} with default configuration if errors
     * occur when reading from the file.
     */
    protected UserPrefs initPrefs(UserPrefsStorage storage) {
        Path prefsFilePath = storage.getUserPrefsFilePath();
        logger.info("Using prefs file : " + prefsFilePath);

        UserPrefs initializedPrefs;
        try {
            Optional<UserPrefs> prefsOptional = storage.readUserPrefs();
            initializedPrefs = prefsOptional.orElse(new UserPrefs());
        } catch (DataConversionException e) {
            logger.warning("UserPrefs file at " + prefsFilePath + " is not in the correct format. "
                    + "Using default user prefs");
            initializedPrefs = new UserPrefs();
        } catch (IOException e) {
            logger.warning("Problem while reading from the file. Will be starting with an empty AddressBook");
            initializedPrefs = new UserPrefs();
        }

        // Update prefs file in case it was missing to begin with or there are
        // new/unused fields
        try {
            storage.saveUserPrefs(initializedPrefs);
        } catch (IOException e) {
            logger.warning("Failed to save config file : " + StringUtil.getDetails(e));
        }

        return initializedPrefs;
    }

    @Override
    public void start(Stage primaryStage) {
        logger.info("Starting AddressBook " + MainApp.VERSION);
        ui.start(primaryStage);
    }

    @Override
    public void stop() {
        logger.info("============================ [ Stopping Address Book ] =============================");
        try {
            alfredStorage.saveUserPrefs(alfredModel.getUserPrefs());
        } catch (IOException e) {
            logger.severe("Failed to save preferences " + StringUtil.getDetails(e));
        }
    }
}
