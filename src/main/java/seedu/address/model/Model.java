package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.exceptions.AlfredException;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.Mentor;
import seedu.address.model.entity.Participant;
import seedu.address.model.entity.Team;
import seedu.address.model.entitylist.ReadOnlyEntityList;
import seedu.address.model.person.Person;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /**
     * Initializes the model.
     */
    void initialize();

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Returns the ParticipantList.
     */
    ReadOnlyEntityList getParticipantList();

    /**
     * Returns the TeamList.
     */
    ReadOnlyEntityList getTeamList();

    /**
     * Returns the MentorList.
     */
    ReadOnlyEntityList getMentorList();

    /* Get the filtered lists */

    FilteredList<Participant> getFilteredParticipantList();

    FilteredList<Team> getFilteredTeamList();

    FilteredList<Mentor> getFilteredMentorList();

    /* Below is the API exposed for the controllers to call */

    /* Participant methods */

    Participant getParticipant(Id id) throws AlfredException;

    void addParticipant(Participant participant) throws AlfredException;

    void updateParticipant(Id id, Participant participant) throws AlfredException;

    Participant deleteParticipant(Id id) throws AlfredException;

    /* Team methods */

    Team getTeam(Id teamId) throws AlfredException;

    Team getTeamByParticipantId(Id participantId) throws AlfredException;

    Team getTeamByMentorId(Id mentorId) throws AlfredException;

    void addTeam(Team team) throws AlfredException;

    void addParticipantToTeam(Id teamId, Participant participant) throws AlfredException;

    void addMentorToTeam(Id teamId, Mentor mentor) throws AlfredException;

    void updateTeam(Id teamId, Team team) throws AlfredException;

    Team deleteTeam(Id id) throws AlfredException;

    /* Mentor methods */

    Mentor getMentor(Id id) throws AlfredException;

    void addMentor(Mentor mentor) throws AlfredException;

    void updateMentor(Id id, Mentor mentor) throws AlfredException;

    Mentor deleteMentor(Id id) throws AlfredException;

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);
}
