package seedu.address.model.EntityList;

import java.util.ArrayList;
import java.util.List;
import seedu.address.model.Entity.Entity;
import seedu.address.model.Entity.Id;
import seedu.address.model.Entity.Mentor;
import seedu.address.model.Entity.PrefixType;

public class MentorList extends EntityList {
    private List<Mentor> mentors;
    private int lastUsedId;

    /**
     * Constructor.
     */
    public MentorList() {
        this.mentors = new ArrayList<>();
        this.lastUsedId = 0;
    }

    /**
     * Gets Mentor by ID.
     *
     * @param id
     * @return Mentor
     */
    public Mentor get(Id id) throws AlfredException {
        for (Mentor m: this.mentors) {
            if (m.getId() == id) {
                return m;
            }
        }
        throw new AlfredException("Mentor to get does not exist");
    }

    /**
     * Updates Mentor by ID.
     *
     * @param id
     * @param updatedMentor
     * @return boolean
     */
    public boolean update(Id id, Mentor updatedMentor) {
        for (int i = 0; i < this.mentors.size(); i++) {
            if (this.mentors.get(i).getId() == id) {
                this.mentors.set(i, updatedMentor);
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
        for (Mentor m: this.mentors) {
            if (m.getId() == mentor.getId()) {
                throw new AlfredException("Item to add already exists!");
            }
        }
        this.mentors.add(mentor);
    }

    /**
     * Deletes Mentor by id.
     *
     * @param id
     * @throws Exception
     */
    public Mentor delete(Id id) throws AlfredException {
        for (Mentor m: this.mentors) {
            if (m.getId() == id) {
                this.mentors.remove(m);
                return m;
            }
        }
        throw new AlfredException("Mentor to delete does not exist.");
    }

    /**
     * Returns a list but with element type Mentor.
     *
     * @return List<Mentor>.
     */
    public List<Mentor> getSpecificTypedList() {
        return this.mentors;
    }

    /**
     * List the mentors.
     *
     * @return List<Mentor>
     */
    @Override
    public List<? extends Entity> list() {
        return this.mentors;
    }

    /**
     * Checks if a given ID exists.
     *
     * @param id
     * @return boolean
     */
    @Override
    public boolean contains(Id id) {
        for (Mentor m: this.mentors) {
            if (m.getId() == id) {
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
    @Override
    public Id generateID() {
        this.lastUsedId++;
        return new Id(PrefixType.M, this.lastUsedId);
    }
}
