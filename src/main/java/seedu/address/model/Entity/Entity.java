package seedu.address.model.Entity;

public abstract class Entity {
    protected final ID id; // Note: id is unique and should never be mutable.
    protected String name;

    /**
     * Constructor.
     *
     * @param id
     * @param name
     */
    public Entity(ID id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter methods

    /**
     * Gets the name.
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the id.
     *
     * @return ID
     */
    public ID getId() {
        return this.id;
    }

    // Setter methods

    /**
     * Sets the name of the entity.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
