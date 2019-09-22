package seedu.address.model.Entity;

import java.util.Date;
import java.util.Optional;

public class Issue extends Entity {
    private String description;
    private IssueType type;
    private boolean isCompleted;
    private Optional<Date> time;

    /**
     * Constructor without date.
     *
     * @param name
     * @param id
     * @param description
     * @param type
     * @param isCompleted
     */
    public Issue(
            Name name,
            ID id,
            String description,
            IssueType type,
            boolean isCompleted
    ) {
        super(id, name);
        this.description = description;
        this.type = type;
        this.isCompleted = isCompleted;
        this.time = Optional.empty();
    }

    /**
     * Constructor with date.
     *
     * @param name
     * @param id
     * @param description
     * @param type
     * @param time
     * @param isCompleted
     */
    public Issue(
            Name name,
            ID id,
            String description,
            IssueType type,
            Optional<Date> time,
            boolean isCompleted
    ) {
        super(id, name);
        this.description = description;
        this.type = type;
        this.isCompleted = isCompleted;
        this.time = time;
    }

    // Getters

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public IssueType getType() {
        return type;
    }

    public Optional<Date> getTime() {
        return time;
    }

    // Setters

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void setType(IssueType type) {
        this.type = type;
    }

    public void setTime(Optional<Date> time) {
        this.time = time;
    }
}
