package seedu.address.logic;

import java.nio.file.Path;

import java.util.List;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.entity.Mentor;
import seedu.address.model.entity.Participant;
import seedu.address.model.entity.Team;
import seedu.address.model.person.Person;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException;


    /** Returns an unmodifiable view of the filtered list of persons */
   // ObservableList<Person> getFilteredPersonList();

    //TODO: will change this to return an ObservableList later on
    public FilteredList<Participant> getFilteredParticipantList();
    public FilteredList<Team> getFilteredTeamList();
    public FilteredList<Mentor> getFilteredMentorList();
    /**
     * Returns the user prefs' address book file path.
     */
    //Path getAddressBookFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);
}
