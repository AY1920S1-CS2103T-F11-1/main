package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.entity.Mentor;
import seedu.address.model.entity.Participant;
import seedu.address.model.entity.Team;
import seedu.address.model.person.Person;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyAlfred {
    ObservableList<Participant> getParticipantList();

    ObservableList<Mentor> getMentorList();

    ObservableList<Team> getTeamList();

    /**
     * Returns an unmodifiable view of the persons list.
     * This list will not contain any duplicate persons.
     */
   // ObservableList<Person> getPersonList();

}
