package seedu.address.model.entity;

public enum ProjectType {

    PLACEHOLDER("placeholder");

    private final String projectTypeString;

    public static final String MESSAGE_CONSTRAINTS = "PROJECT_TYPE should be valid.";

    private ProjectType(String projectTypeString) {
        this.projectTypeString = projectTypeString;
    }

    // TODO: Implement
    public static boolean isValidProjectType(String ProjectType) {
        return true;
    }

    /**
     * Returns string representation of object.
     *
     * @return Project type in string format.
     */
    @Override
    public String toString() {
        return this.projectTypeString;
    }

    /**
     * Returns string representation of object, for storage.
     *
     * @return Project type in string format.
     */
    public String toStorageValue(){
        return this.toString();
    }
}
