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
    public static final Prefix PREFIX_SUBJECT_NAME = new Prefix("s/");
    public static final Prefix PREFIX_PROJECT_NAME = new Prefix("pn/");
    public static final Prefix PREFIX_PROJECT_TYPE = new Prefix("pt/");
    public static final Prefix PREFIX_LOCATION = new Prefix("l/");
    public static final String ENTITY_ISSUE = "issue";
    public static final String PREFIX_ENTITY_MENTOR = "M";
    public static final String PREFIX_ENTITY_PARTICIPANT = "P";
    public static final String PREFIX_ENTITY_TEAM = "T";
}
