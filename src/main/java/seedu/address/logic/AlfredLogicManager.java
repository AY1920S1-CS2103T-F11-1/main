package seedu.address.logic;

import java.util.logging.Logger;

import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.AlfredParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.AlfredModel;
import seedu.address.model.entity.Mentor;
import seedu.address.model.entity.Participant;
import seedu.address.model.entity.Team;
import seedu.address.storage.AlfredStorage;

/**
 * The main AlfredLogicManager of the app.
 */
public class AlfredLogicManager implements AlfredLogic {
    public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    private final Logger logger = LogsCenter.getLogger(AlfredLogicManager.class);

    private final AlfredModel alfredModel;
    private final AlfredStorage alfredStorage;
    // Will this be changed to alfredParser?
    private final AlfredParser addressBookParser;

    public AlfredLogicManager(AlfredModel alfredModel, AlfredStorage alfredStorage) {
        this.alfredModel = alfredModel;
        this.alfredStorage = alfredStorage;
        this.addressBookParser = new AlfredParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        Command command = addressBookParser.parseCommand(commandText);
        commandResult = command.execute(alfredModel);

        return commandResult;
    }

    @Override
    public FilteredList<Participant> getFilteredParticipantList() {
        return alfredModel.getParticipantFilteredList();
    }

    @Override
    public FilteredList<Mentor> getFilteredMentorList() {
        return alfredModel.getMentorFilteredList();
    }

    @Override
    public FilteredList<Team> getFilteredTeamList() {
        return alfredModel.getTeamFilteredList();
    }


    @Override
    public GuiSettings getGuiSettings() {
        return alfredModel.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        alfredModel.setGuiSettings(guiSettings);
    }
}
