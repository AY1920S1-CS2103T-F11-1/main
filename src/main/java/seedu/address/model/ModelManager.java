package seedu.address.model;

import java.io.IOException;
import static java.util.Objects.requireNonNull;
import seedu.address.commons.exceptions.DataConversionException;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.AlfredException;
import seedu.address.commons.exceptions.AlfredModelException;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.Mentor;
import seedu.address.model.entity.Participant;
import seedu.address.model.entity.PrefixType;
import seedu.address.model.entity.Team;
import seedu.address.model.entitylist.MentorList;
import seedu.address.model.entitylist.ParticipantList;
import seedu.address.model.entitylist.ReadOnlyEntityList;
import seedu.address.model.entitylist.TeamList;

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
     * Returns a {@code ModelManager} with the data from {@code storage}'s address book and {@code userPrefs}. <br>
     * The data from the sample address book will be used instead if {@code storage}'s address book is not found,
     * or an empty address book will be used instead if errors occur when reading {@code storage}'s address book.
     */
    public static Model initModelManager(AlfredStorage alfredStorage, ReadOnlyUserPrefs userPrefs) throws AlfredException {
        ReadOnlyAlfred initialData = new Alfred( alfredStorage, userPrefs);


        return new ModelManager(initialData, userPrefs);
    }

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
        this.alfred = (Alfred)initialData;
        this.participantFilteredList = new FilteredList<Participant>(initialData.getParticipantList());
        this.teamFilteredList = new FilteredList<Team>((initialData.getTeamList()));
        this.mentorFilteredList = new FilteredList<Mentor>(initialData.getMentorList());
    }

    public ModelManager() throws AlfredException {
        this(new Alfred(), new UserPrefs());
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
        this.saveList(PrefixType.P);
    }

    /**
     * Updates the participant in the list, if any.
     *
     * @param id
     * @param participant
     */
    public void updateParticipant(Id id, Participant participant) throws AlfredException {
        try {
            // Update the participant in the team list as well
            Team targetTeam = this.getTeamByParticipantId(id);
            boolean isSuccessful = targetTeam.updateParticipant(participant);
            if (!isSuccessful) {
                logger.warning("The participant is not in the team provided");
                return;
            }

            this.participantFilteredList.update(id, participant);
            this.saveList(PrefixType.P);
            this.saveList(PrefixType.T);
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
        Team targetTeam = this.getTeamByParticipantId(id);
        Participant participantToDelete = this.getParticipant(id);
        boolean isSuccessful = targetTeam.deleteParticipant(participantToDelete);
        if (!isSuccessful) {
            logger.warning("Participant does not exist");
            throw new AlfredModelException("Participant does not exist");
        }

        Participant deletedParticipant = this.participantFilteredList.delete(id);
        this.saveList(PrefixType.P);
        this.saveList(PrefixType.T);
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
        return this.teamFilteredList.get(id);
    }

    /**
     * Gets the team by participant id.
     *
     * @param participantId
     * @return Team
     * @throws AlfredException
     */
    public Team getTeamByParticipantId(Id participantId) throws AlfredException {
        for (Team t : teamFilteredList) {
            for (Participant p : t.getParticipants()) {
                if (p.getId().equals(participantId)) {
                    return t;
                }
            }
        }
        throw new AlfredModelException("Team with said participant cannot be found.");
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
        for (Team t : teamFilteredList) {
            Optional<Mentor> mentor = t.getMentor();
            if (mentor.isPresent()) {
                if (mentor.get().getId().equals(mentorId)) {
                    return t;
                }
            }
        }
        throw new AlfredModelException("Team with said mentor cannot be found.");
    }

    /**
     * Updates the team with the given teamID.
     *
     * @param teamId
     * @param updatedTeam
     * @throws AlfredException
     */
    public void updateTeam(Id teamId, Team updatedTeam) throws AlfredException {
        this.teamFilteredList.update(teamId, updatedTeam);
        this.saveList(PrefixType.T);
    }

    /**
     * Adds the team.
     *
     * @param team
     * @throws AlfredException
     */
    public void addTeam(Team team) throws AlfredException {
        this.teamFilteredList.add(team);
        this.saveList(PrefixType.T);
    }

    /**
     * Adds the participant to the given team.
     *
     * @param teamId
     * @param participant
     * @throws AlfredException if the team does not exist.
     */
    public void addParticipantToTeam(Id teamId, Participant participant) throws AlfredException {
        // TODO: Check if participant is in ParticipantList before adding.
        // TODO: Throw specific error.
        Team targetTeam = this.getTeam(teamId);
        boolean isSuccessful = targetTeam.addParticipant(participant);
        if (!isSuccessful) {
            logger.severe("Participant is already present in team");
            throw new AlfredModelException("Participant is already present in team");
        }
        this.saveList(PrefixType.T);
    }

    /**
     * Adds the participant to the given team.
     *
     * @param teamId
     * @param mentor
     * @throws AlfredException if the team does not exist.
     */
    public void addMentorToTeam(Id teamId, Mentor mentor) throws AlfredException {
        // TODO: Check if Mentor is in MentorList before adding.
        // TODO: Throw specific error.
        Team targetTeam = this.getTeam(teamId);
        boolean isSuccessful = targetTeam.addMentor(mentor);
        if (!isSuccessful) {
            logger.severe("Team already has a mentor");
            throw new AlfredModelException("Team already has a mentor");
        }
        this.saveList(PrefixType.T);
    }

    /**
     * Deletes the team.
     *
     * @param id
     * @return Team
     * @throws AlfredException
     */
    public Team deleteTeam(Id id) throws AlfredException {
        Team teamToDelete = this.teamFilteredList.delete(id);
        this.saveList(PrefixType.T);
        this.saveList(PrefixType.P);
        return teamToDelete;
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
        return this.mentorFilteredList.get(id);
    }

    /**
     * Adds mentor into the list.
     *
     * @param mentor
     * @throws AlfredException
     */
    public void addMentor(Mentor mentor) throws AlfredException {
        this.mentorFilteredList.add(mentor);
        this.saveList(PrefixType.M);
    }

    /**
     * Updates the mentor.
     *
     * @param id
     * @param updatedMentor
     */
    public void updateMentor(Id id, Mentor updatedMentor) throws AlfredException {
        // TODO: Throw specific exception.
        try {
            Team targetTeam = this.getTeamByMentorId(id);
            boolean isSuccessful = targetTeam.updateMentor(updatedMentor);
            if (!isSuccessful) {
                logger.severe("Unable to update the mentor in team as it is not the " + "same id");
            }

            this.mentorFilteredList.update(id, updatedMentor);
        } catch (AlfredException e) {
            return;
        }
        this.mentorFilteredList.update(id, updatedMentor);
        this.saveList(PrefixType.M);
        this.saveList(PrefixType.T);
    }

    /**
     * Deletes the mentor.
     *
     * @param id
     * @return Mentor that is deleted
     * @throws AlfredException
     */
    public Mentor deleteMentor(Id id) throws AlfredException {
        Mentor mentorToDelete = this.mentorFilteredList.delete(id);
        this.saveList(PrefixType.M);
        this.saveList(PrefixType.T);
        return mentorToDelete;
    }

    // =========== Utils
    // ==============================================================

    /**
     * Helper function to save the lists.
     * 
     * @param type
     */
    private void saveList(PrefixType type) {
        try {
            switch (type) {
            case T:
                this.storage.saveTeamList(this.teamFilteredList);
                break;
            case M:
                this.storage.saveMentorList(this.mentorFilteredList);
                break;
            case P:
                this.storage.saveParticipantList(this.participantFilteredList);
                break;
            default:
            }
        } catch (IOException e) {
            logger.severe("Failed to save the list into storage due to IOException");
        }

    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return userPrefs.equals(other.userPrefs) && participantFilteredList.equals(other.participantFilteredList)
                && teamFilteredList.equals(other.teamFilteredList) && mentorFilteredList.equals(other.mentorFilteredList);

    }
}
