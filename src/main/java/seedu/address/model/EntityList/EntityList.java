package seedu.address.model.EntityList;

import seedu.address.model.Entity.Entity;
import seedu.address.model.Entity.ID;

public interface EntityList {
    public Entity get(ID id);

    // This exception will be ModelException - Pending Joanna's PR.
    public void update(Entity entity) throws Exception;

    // As above, exception will be generalized.
    public void delete(Entity entity) throws Exception;

    // As above.
    public void add(Entity entity) throws Exception;

    public boolean isContain(ID id);
}
