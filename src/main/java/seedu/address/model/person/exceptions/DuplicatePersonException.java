package seedu.address.model.person.exceptions;

public class DuplicatePersonException extends RuntimeException {
    /**
     * Creates a new instance of DuplicateEntityException according to type of entity.
     * @param Type of entity.
     */
    public DuplicatePersonException() {
        super("Operation would result in duplicate ");
    }
}
