package seedu.address.model.entitylist;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.commons.exceptions.AlfredException;
import seedu.address.commons.exceptions.AlfredModelException;
import seedu.address.model.entity.Entity;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.Mentor;
import seedu.address.model.entity.Participant;
import seedu.address.model.entity.PrefixType;
import seedu.address.model.entity.Team;

/**
 * This interface serves as the new API for the model.
 * {@code MentorList} should behave as a singleton.
 */
public class MentorList extends EntityList {
    private static int lastUsedId = 0;

    private final ObservableList<Mentor> mentorObservableList = FXCollections.observableArrayList();
    private final ObservableList<Mentor> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(mentorObservableList);

    /**
     * Constructor.
     */
    public MentorList() {}

    /**
     * Gets Mentor by ID.
     *
     * @param id
     * @return Mentor
     */
    public Mentor get(Id id) throws AlfredException {
        requireNonNull(id);
        Optional<Mentor> resultMentor = mentorObservableList.stream().filter(p -> (p.getId()).equals(id)).findFirst();
        return resultMentor.orElseThrow(() -> new AlfredModelException("Participant to get does not exist"));

        /* for (Mentor m: this.mentors) {
            if (m.getId().equals(id)) {
                return m;
            }
        }
        throw new AlfredModelException("Mentor to get does not exist");

        */
    }

    /**
     * Updates Mentor by ID.
     *
     * @param id
     * @param updatedMentor
     * @return boolean
     */
    public boolean update(Id id, Mentor updatedMentor) {
        for (int i = 0; i < this.mentorObservableList.size(); i++) {
            if (this.mentorObservableList.get(i).getId().equals(id)) {
                this.mentorObservableList.set(i, updatedMentor);
                return true;
            }
        }
        return false;
    }

    /**
     * Adds the mentor into the list.
     *
     * @param mentor
     * @throws AlfredException
     */
    public void add(Mentor mentor) throws AlfredException {
        for (Mentor m: this.mentorObservableList) {
            if (m.getId() == mentor.getId()) {
                throw new AlfredModelException("Item to add already exists!");
            }
        }
        this.mentorObservableList.add(mentor);
    }

    /**
     * Deletes Mentor by id.
     *
     * @param id
     * @throws Exception
     */
    public Mentor delete(Id id) throws AlfredException {
        for (Mentor m: this.mentorObservableList) {
            if (m.getId().equals(id)) {
                this.mentorObservableList.remove(m);
                return m;
            }
        }
        throw new AlfredModelException("Mentor to delete does not exist.");
    }

    /**
     * Returns a list but with element type Mentor.
     *
     * @return List of Mentors.
     */
    public ObservableList<Mentor> getSpecificTypedList() {
        return this.internalUnmodifiableList;
    }

    /**
     * List the mentors.
     *
     * @return List of Mentors.
     */
    @Override
    public ObservableList<? extends Entity> list() {
        return this.internalUnmodifiableList;
    }

    /**
     * Checks if a given ID exists.
     *
     * @param id
     * @return boolean
     */
    @Override
    public boolean contains(Id id) {
        for (Mentor m: this.mentorObservableList) {
            if (m.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Generates the ID for the object.
     *
     * @return ID
     */
    public static Id generateId() {
        lastUsedId++;
        return new Id(PrefixType.M, lastUsedId);
    }

    /**
     * Sets the lastUsedId class attribute.
     *
     * @param number
     */
    public static void setLastUsedId(int number) {
        lastUsedId = number;
    }
}
