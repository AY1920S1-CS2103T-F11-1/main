package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");
    public static final Prefix PREFIX_ORGANISATION = new Prefix("o/");
    public static final Prefix PREFIX_SCORE = new Prefix("sc/"); // needed this for MESSAGE_USAGE, feel free to change
    public static final Prefix PREFIX_SUBJECT_NAME = new Prefix("s/");
    public static final Prefix PREFIX_PROJECT_NAME = new Prefix("pn/");
    public static final Prefix PREFIX_PROJECT_TYPE = new Prefix("pt/");
    public static final Prefix PREFIX_LOCATION = new Prefix("l/");
    public static final Prefix PREFIX_FILE_PATH = new Prefix("fp/");
    public static final Prefix PREFIX_FILE_NAME = new Prefix("fn/");
    public static final String ENTITY_MENTOR = "mentor";
    public static final String ENTITY_PARTICIPANT = "participant";
    public static final String ENTITY_TEAM = "team";
}
