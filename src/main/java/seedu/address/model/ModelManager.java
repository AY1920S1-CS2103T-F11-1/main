package seedu.address.model;
import static java.util.Objects.requireNonNull;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;

import java.util.logging.Logger;

import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.AlfredException;

import seedu.address.model.entity.Id;
import seedu.address.model.entity.Mentor;
import seedu.address.model.entity.Participant;

import seedu.address.model.entity.Team;

import seedu.address.storage.AlfredStorage;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);


    private final UserPrefs userPrefs;
    private final Alfred alfred;

    // EntityLists
    private FilteredList<Participant> participantFilteredList;
    private FilteredList<Team> teamFilteredList;
    private FilteredList<Mentor> mentorFilteredList;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    private ModelManager(ReadOnlyAlfred initialData, ReadOnlyUserPrefs userPrefs) throws AlfredException {
        super();
        requireAllNonNull(initialData, userPrefs);


        logger.fine("Initializing with Participant List: " + initialData.getParticipantList())
        logger.fine("Initializing with Mentor List" + initialData.getMentorList());
        logger.fine("Initializing with Team List: " + teamFilteredList);
        logger.fine("Initializing with UserPrefs: " + userPrefs);


        this.userPrefs = new UserPrefs(userPrefs);
        this.alfred = (Alfred) initialData;
        this.participantFilteredList = new FilteredList<Participant>(initialData.getParticipantList());
        this.teamFilteredList = new FilteredList<Team>((initialData.getTeamList()));
        this.mentorFilteredList = new FilteredList<Mentor>(initialData.getMentorList());
    }

    /**
     * Returns a {@code ModelManager} with the data from {@code storage}'s address book and {@code userPrefs}. <br>
     * The data from the sample address book will be used instead if {@code storage}'s address book is not found,
     * or an empty address book will be used instead if errors occur when reading {@code storage}'s address book.
     */
    public static Model initModelManager(AlfredStorage storage, ReadOnlyUserPrefs userPrefs) throws AlfredException {
        ReadOnlyAlfred initialData = new Alfred(storage, userPrefs);


        return new ModelManager(initialData, userPrefs);
    }

    /**
     * Initializes the various lists used. If storage contains no data, it defaults
     * to loading the sample lists provided.
     */
    //We have two methods to initialize model manager, which one do you want to use?
    /*
    public void initialize() {
        // Try loading the 3 lists into memory.
        try {
            Optional<TeamList> storageTeamList = this.storage.readTeamList();
            if (storageTeamList.isEmpty()) {
                this.teamList = new TeamList();
            } else {
                this.teamList = storageTeamList.get();
            }
        } catch (IOException | AlfredException e) {
            logger.warning("TeamList is empty in storage. Writing a new one.");
            this.teamList = new TeamList();
        }

        try {
            Optional<ParticipantList> storageParticipantList = this.storage.readParticipantList();
            if (storageParticipantList.isEmpty()) {
                this.participantList = new ParticipantList();
            } else {
                this.participantList = storageParticipantList.get();
            }
        } catch (IOException | AlfredException e) {
            logger.warning("ParticipantList is empty in storage. Writing a new one.");
            this.participantList = new ParticipantList();
        }

        try {
            Optional<MentorList> storageMentorList = this.storage.readMentorList();
            if (storageMentorList.isEmpty()) {
                this.mentorList = new MentorList();
            } else {
                this.mentorList = storageMentorList.get();
            }
        } catch (IOException | AlfredException e) {
            logger.warning("MentorList is empty in storage. Writing a new one.");
            this.mentorList = new MentorList();
        }
        // Optional TODO: reimplement this logic here.
        // Optional<ReadOnlyAddressBook> addressBookOptional;
        // ReadOnlyAddressBook initialData;
        // try {
        // addressBookOptional = storage.readAddressBook();
        // if (!addressBookOptional.isPresent()) {
        // logger.info("Data file not found. Will be starting with a sample
        // AddressBook");
        // }
        // initialData =
        // addressBookOptional.orElseGet(SampleDataUtil::getSampleAddressBook);
        // } catch (DataConversionException e) {
        // logger.warning("Data file not in the correct format. Will be starting with an
        // empty AddressBook");
        // initialData = new AddressBook();
        // } catch (IOException e) {
        // logger.warning("Problem while reading from the file. Will be starting with an
        // empty AddressBook");
        // initialData = new AddressBook();
        // }
    }
    */


    // =========== UserPrefs
    // ==================================================================================
    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getAddressBookFilePath() {
        return userPrefs.getAddressBookFilePath();
    }

    @Override
    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        userPrefs.setAddressBookFilePath(addressBookFilePath);
    }

    // ========== EntityListMethods ===============


    /**
     * Returns the participant list located in the Model Manager.
     *
     * @return ReadableEntityList
     */
    public FilteredList<Participant> getParticipantFilteredList() {
        return this.participantFilteredList;
    }

    /**
     * Returns the team list located in the Model Manager.
     *
     * @return ReadableEntityList
     */
    public FilteredList<Team> getTeamFilteredList() {
        return this.teamFilteredList;
    }

    /**
     * Returns the mentor list located in the Model Manager.
     *
     * @return ReadableEntityList
     */
    public FilteredList<Mentor> getMentorFilteredList() {
        return this.mentorFilteredList;
    }

    // ========== Entity Methods =============================

    /* Participant Methods */

    /**
     * Gets the participant by id.
     *
     * @param id
     * @return Participant Object
     * @throws AlfredException if the Participant cannot be found.
     */
    public Participant getParticipant(Id id) throws AlfredException {
        return alfred.getParticipant(id);
    }

    /**
     * Adds the participant into the list.
     *
     * @param participant
     * @throws AlfredException
     */
    public void addParticipant(Participant participant) throws AlfredException {
        this.alfred.addParticipant(participant);

    }

    /**
     * Updates the participant in the list, if any.
     *
     * @param id
     * @param participant
     */
    public void updateParticipant(Id id, Participant participant) {
        try {
            this.alfred.updateParticipant();

        } catch (AlfredException e) {
            return;
        }
    }

    /**
     * Deletes the participant by id.
     *
     * @param id
     * @return Participant
     */
    public Participant deleteParticipant(Id id) throws AlfredException {
        Participant deletedParticipant = this.alfred.deleteParticipant(id);

        return deletedParticipant;
    }

    /* Team Methods */

    /**
     * Gets team by id.
     *
     * @param id
     * @return
     * @throws AlfredException
     */
    public Team getTeam(Id id) throws AlfredException {
        return this.alfred.getTeam(id);
    }

    /**
     * Gets the team by participant id.
     *
     * @param participantId
     * @return Team
     * @throws AlfredException
     */
    public Team getTeamByParticipantId(Id participantId) throws AlfredException {
        return this.alfred.getTeamByParticipantId(participantId);
    }

    /* OR KIV: this.teamList.setPredicate(t -> {
                   for (Participant p : t.getParticipants()) {
                       if (p.getId().equals(participantId)) {
                           return true;
                       }
                   }
                   return false;
                   }
                   );

   /**
    * Gets the team by mentor id.
    *
    * @param mentorId
    * @return Team
    * @throws AlfredException
    */
    public Team getTeamByMentorId(Id mentorId) throws AlfredException {
        this.alfred.getTeamByMentorId(mentorId);
    }

    /**
     * Updates the team with the given teamID.
     *
     * @param teamId
     * @param updatedTeam
     * @throws AlfredException
     */
    public void updateTeam(Id teamId, Team updatedTeam) throws AlfredException {
        this.alfred.updateTeam(teamId, updatedTeam);

    }

    /**
     * Adds the team.
     *
     * @param team
     * @throws AlfredException
     */
    public void addTeam(Team team) throws AlfredException {
        this.alfred.addTeam(team);

    }

    /**
     * Adds the participant to the given team.
     *
     * @param teamId
     * @param participant
     * @throws AlfredException if the team does not exist.
     */
    public void addParticipantToTeam(Id teamId, Participant participant) throws AlfredException {
        this.alfred.addParticipantToTeam(teamId, participant);
    }

    /**
     * Adds the participant to the given team.
     *
     * @param teamId
     * @param mentor
     * @throws AlfredException if the team does not exist.
     */
    public void addMentorToTeam(Id teamId, Mentor mentor) throws AlfredException {
        this.alfred.addMentorToTeam(teamId, mentor);

    }

    /**
     * Deletes the team.
     *
     * @param id
     * @return Team
     * @throws AlfredException
     */
    public Team deleteTeam(Id id) throws AlfredException {
        this.alfred.deleteTeam(id);
    }

    /* Mentor Methods */

    /**
     * Gets the mentor by id.
     *
     * @param id
     * @return Mentor
     * @throws AlfredException
     */
    public Mentor getMentor(Id id) throws AlfredException {
        this.alfred.getMentor(id);
    }

    /**
     * Adds mentor into the list.
     *
     * @param mentor
     * @throws AlfredException
     */
    public void addMentor(Mentor mentor) throws AlfredException {
        this.alfred.addMentor(mentor);
    }

    /**
     * Updates the mentor.
     *
     * @param id
     * @param updatedMentor
     */
    public void updateMentor(Id id, Mentor updatedMentor) throws AlfredException {
        this.alfred.updateMentor(id, updatedMentor);

    }

    /**
     * Deletes the mentor.
     *
     * @param id
     * @return Mentor that is deleted
     * @throws AlfredException
     */
    public Mentor deleteMentor(Id id) throws AlfredException {
        this.alfred.deleteMentor(id);
    }


}
