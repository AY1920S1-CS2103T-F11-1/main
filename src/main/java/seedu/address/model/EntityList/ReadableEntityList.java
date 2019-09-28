package seedu.address.model.EntityList;

import java.util.List;
import seedu.address.model.Entity.Entity;
import seedu.address.model.Entity.Id;

public interface ReadableEntityList {
    /**
     * Checks if a given entity list contains a certain entity.
     *
     * @param id
     * @return boolean
     */
    public boolean contains(Id id);

    /**
     * List the entities.
     *
     * @return List<? extends Entity>
     */
    public List<? extends Entity> list();
}
