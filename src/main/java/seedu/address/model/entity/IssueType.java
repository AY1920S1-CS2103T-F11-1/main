package seedu.address.model.entity;

public enum IssueType {
    TODO("Todo"),
    DEADLINE("Deadline"),
    EVENT("Event");

    private final String stringFormat;

    public static final String MESSAGE_CONSTRAINTS = "Issue type should be a string of either one of the following values:\n" +
            "Todo: to indicate Issue is a TODO\n" +
            "Deadline: to indicate Issue is a DEADLINE\n" +
            "Event: to indicate Issue is an EVENT\n";

    private IssueType(String stringFormat) {
        this.stringFormat = stringFormat;
    }

    public static boolean isValidIssueType(String name) {
        return true;
    }

    @Override
    public String toString() {
        return this.stringFormat;
    }
}
