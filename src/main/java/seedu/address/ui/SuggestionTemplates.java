package seedu.address.ui;

import java.util.stream.Collectors;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * Represents the possible Suggestions that could be displated by AutoCompleteTextField
 */
public class SuggestionTemplates {

    //The final template for each instruction that will be displayed as suggestion to User.
    //Combination of preceding constants(which are used as building blocks/

    public static final TextFlow ADD_PARTICIPANT_TEMPLATE;
    public static final TextFlow ADD_MENTOR_TEMPLATE;
    public static final TextFlow ADD_TEAM_TEMPLATE;

    public static final TextFlow EDIT_PARTICIPANT_TEMPLATE;
    public static final TextFlow EDIT_MENTOR_TEMPLATE;
    public static final TextFlow EDIT_TEAM_TEMPLATE;

    public static final TextFlow FIND_PARTICIPANT_TEMPLATE;
    public static final TextFlow FIND_MENTOR_TEMPLATE;
    public static final TextFlow FIND_TEAM_TEMPLATE;

    public static final TextFlow DELETE_PARTICIPANT_TEMPLATE;
    public static final TextFlow DELETE_MENTOR_TEMPLATE;
    public static final TextFlow DELETE_TEAM_TEMPLATE;

    public static final TextFlow LIST_PARTICIPANT_TEMPLATE;
    public static final TextFlow LIST_MENTOR_TEMPLATE;
    public static final TextFlow LIST_TEAM_TEMPLATE;

    public static final TextFlow SCORE_ADD_TEMPLATE;
    public static final TextFlow SCORE_SUB_TEMPLATE;
    public static final TextFlow SCORE_SET_TEMPLATE;
    public static final TextFlow LEADERBOARD_TEMPLATE;
    public static final TextFlow GET_TOP_TEMPLATE;

    public static final TextFlow IMPORT_TEMPLATE;
    public static final TextFlow EXPORT_TEMPLATE;

    public static final TextFlow HISTORY_TEMPLATE;
    public static final TextFlow UNDO_TEMPLATE;
    public static final TextFlow REDO_TEMPLATE;

    public static final TextFlow HELP_TEMPLATE;

    //Constants used as instructions
    private static final Text ADD_PARTICIPANT_INSTRUCTION = new Text("(Adds a new Participant)");
    private static final Text ADD_MENTOR_INSTRUCTION = new Text("(Adds a new Mentor)");
    private static final Text ADD_TEAM_INSTRUCTION = new Text("(Adds a new Team)");

    private static final Text EDIT_PARTICIPANT_INSTRUCTION = new Text(
            "(Edits existing Participant according to PARAMETERS)"
    );
    private static final Text EDIT_MENTOR_INSTRUCTION = new Text("(Edits existing Mentor according to PARAMETERS)");
    private static final Text EDIT_TEAM_INSTRUCTION = new Text("(Edits existing Team according to PARAMETERS)");

    private static final Text FIND_PARTICIPANT_INSTRUCTION = new Text("(Finds a new Participant)");
    private static final Text FIND_MENTOR_INSTRUCTION = new Text("(Finds a new Mentor)");
    private static final Text FIND_TEAM_INSTRUCTION = new Text("(Finds a new Team)");

    private static final Text DELETE_PARTICIPANT_INSTRUCTION = new Text("(Deletes an existing Participant)");
    private static final Text DELETE_MENTOR_INSTRUCTION = new Text("(Deletes an existing Mentor)");
    private static final Text DELETE_TEAM_INSTRUCTION = new Text("(Deletes an existing Team)");

    private static final Text LIST_PARTICIPANT_INSTRUCTION = new Text("(Lists all Participants)");
    private static final Text LIST_MENTOR_INSTRUCTION = new Text("(Lists all Mentors)");
    private static final Text LIST_TEAM_INSTRUCTION = new Text("(Lists all Teams)");

    private static final Text SCORE_ADD_INSTRUCTION = new Text("(Adds POINTS to Team with TEAM_ID)");
    private static final Text SCORE_SUB_INSTRUCTION = new Text("(Subtracts POINTS to Team with TEAM_ID)");
    private static final Text SCORE_SET_INSTRUCTION = new Text("(Set Team with TEAM_ID to obtain a SCORE)");
    private static final Text LEADERBOARD_INSTRUCTION = new Text("(Lists all Teams from highest to lowest Score)");
    private static final Text GET_TOP_INSTRUCTION = new Text("(Lists the top NUMBER of Teams according to Score)");

    private static final Text IMPORT_INSTRUCTION = new Text("(Adds multiple Participants with details in .csv file)");
    private static final Text EXPORT_INSTRUCTION = new Text(
            "(Export Entity and their details into .csv file specified by FILE_PATH)"
    );


    private static final Text HISTORY_INSTRUCTION = new Text("(Gets all past commands you have entered)");
    private static final Text UNDO_INSTRUCTION = new Text("(Undoes the most recent command)");
    private static final Text REDO_INSTRUCTION = new Text("(Redoes the most recent command that you have undone)");

    private static final Text HELP_INSTRUCTION = new Text("(Opens a new Help Window)");

    //Constants that are used as template(this Text is also indicative of command type)
    private static final Text ADD_PARTICIPANT = new Text("add participant ");
    private static final Text ADD_MENTOR = new Text("add mentor ");
    private static final Text ADD_TEAM = new Text("add team ");

    private static final Text LIST_PARTICIPANT = new Text("list participant ");
    private static final Text LIST_MENTOR = new Text("list mentor ");
    private static final Text LIST_TEAM = new Text("list team ");

    private static final Text EDIT_PARTICIPANT = new Text("edit participant ");
    private static final Text EDIT_MENTOR = new Text("edit mentor ");
    private static final Text EDIT_TEAM = new Text("edit team ");

    private static final Text FIND_PARTICIPANT = new Text("find participant ");
    private static final Text FIND_MENTOR = new Text("find mentor ");
    private static final Text FIND_TEAM = new Text("find team ");

    private static final Text DELETE_PARTICIPANT = new Text("delete participant ");
    private static final Text DELETE_MENTOR = new Text("delete mentor ");
    private static final Text DELETE_TEAM = new Text("delete team ");

    private static final Text SCORE_ADD = new Text("score add ");
    private static final Text SCORE_SUB = new Text("score sub ");
    private static final Text SCORE_SET = new Text("score set ");
    private static final Text LEADERBOARD = new Text("leaderboard ");
    private static final Text GET_TOP = new Text("getTop ");

    private static final Text HISTORY = new Text("history ");
    private static final Text UNDO = new Text("undo ");
    private static final Text REDO = new Text("redo ");

    private static final Text IMPORT = new Text("import ");
    private static final Text EXPORT = new Text("export ");

    private static final Text HELP = new Text("help ");

    //Constants that are used as template
    private static final Text NAME_PREFIX = new Text("n/");
    private static final Text PHONE_PREFIX = new Text("p/");
    private static final Text EMAIL_PREFIX = new Text("e/");
    private static final Text ORGANIZATION_PREFIX = new Text("o/");
    private static final Text SPECIALISATION_PREFIX = new Text("s/ ");
    private static final Text PROJECT_NAME_PREFIX = new Text("pn/ ");
    private static final Text SUBJECT_PREFIX = new Text("s/ ");
    private static final Text LOCATION_PREFIX = new Text("l/ ");
    private static final Text FILEPATH_PREFIX = new Text("fp/ ");

    //Constants (that are used are guides)
    private static final Text NAME = new Text("NAME ");
    private static final Text PHONE = new Text("PHONE_NUMBER ");
    private static final Text EMAIL = new Text("EMAIL_ADDRESS ");
    private static final Text TEAM_ID = new Text("TEAM_ID ");
    private static final Text PARTICIPANT_ID = new Text("PARTICIPANT_ID ");
    private static final Text MENTOR_ID = new Text("MENTOR_ID ");
    private static final Text NUMBER = new Text("NUMBER ");
    private static final Text POINTS = new Text("POINTS ");
    private static final Text NEW_POINTS = new Text("NEW_POINTS ");
    private static final Text CSV_PATH = new Text("PATH_TO_CSV_FILE ");
    private static final Text PARAMETERS = new Text("[PARAMETERS] ");
    private static final Text ORGANIZATION = new Text("ORGANIZATION ");
    private static final Text SPECIALISATION = new Text("SPECIALISATION ");
    private static final Text PROJECT_NAME = new Text("PROJECT_NAME ");
    private static final Text SUBJECT = new Text("SUBJECT ");
    private static final Text TABLE = new Text("TABLE_NUMBER ");
    private static final Text FILE_PATH = new Text("PATH_TO_CSV_FILE ");
    private static final Text ENTITY = new Text("[{team/mentor/participant}] ");



    /**
     * Constructs a {@codeSuggestionTemplates} that provides a list of Templates for each Command.
     * Each of these templates will be displaed as a suggestion to user  when they type,
     * in {@codeAutoCompleteTextField}.
     */
    static {
        initialize();
        //ADD Commands
        ADD_PARTICIPANT_TEMPLATE = new TextFlow(ADD_PARTICIPANT, NAME_PREFIX, NAME,
                PHONE_PREFIX, PHONE,
                EMAIL_PREFIX, EMAIL,
                ADD_PARTICIPANT_INSTRUCTION);

        ADD_MENTOR_TEMPLATE = new TextFlow(ADD_MENTOR, NAME_PREFIX, NAME,
                PHONE_PREFIX, PHONE,
                EMAIL_PREFIX, EMAIL,
                ORGANIZATION_PREFIX, ORGANIZATION,
                SPECIALISATION_PREFIX, SPECIALISATION,
                ADD_MENTOR_INSTRUCTION
        );

        ADD_TEAM_TEMPLATE = new TextFlow(ADD_TEAM, NAME_PREFIX, NAME,
                PROJECT_NAME_PREFIX, PROJECT_NAME,
                SUBJECT_PREFIX, SUBJECT,
                LOCATION_PREFIX, TABLE,
                ADD_TEAM_INSTRUCTION
        );

        //EDIT Commands
        EDIT_PARTICIPANT_TEMPLATE = new TextFlow(EDIT_PARTICIPANT, PARTICIPANT_ID,
                PARAMETERS, EDIT_PARTICIPANT_INSTRUCTION);
        EDIT_MENTOR_TEMPLATE = new TextFlow(EDIT_MENTOR, MENTOR_ID,
                PARAMETERS, EDIT_MENTOR_INSTRUCTION);
        EDIT_TEAM_TEMPLATE = new TextFlow(EDIT_TEAM, TEAM_ID,
                PARAMETERS, EDIT_TEAM_INSTRUCTION);

        //DELETE Commands
        DELETE_PARTICIPANT_TEMPLATE = new TextFlow(DELETE_PARTICIPANT, PARTICIPANT_ID, DELETE_PARTICIPANT_INSTRUCTION);
        DELETE_MENTOR_TEMPLATE = new TextFlow(DELETE_MENTOR, MENTOR_ID, DELETE_MENTOR_INSTRUCTION);
        DELETE_TEAM_TEMPLATE = new TextFlow(DELETE_TEAM, TEAM_ID, DELETE_TEAM_INSTRUCTION);

        //FIND Commands
        FIND_PARTICIPANT_TEMPLATE = new TextFlow(FIND_PARTICIPANT, PARTICIPANT_ID, FIND_PARTICIPANT_INSTRUCTION);
        FIND_MENTOR_TEMPLATE = new TextFlow(FIND_MENTOR, MENTOR_ID, FIND_MENTOR_INSTRUCTION);
        FIND_TEAM_TEMPLATE = new TextFlow(FIND_TEAM, TEAM_ID, FIND_TEAM_INSTRUCTION);

        //LIST Commands
        LIST_PARTICIPANT_TEMPLATE = new TextFlow(LIST_PARTICIPANT, LIST_PARTICIPANT_INSTRUCTION);
        LIST_MENTOR_TEMPLATE = new TextFlow(LIST_MENTOR, LIST_MENTOR_INSTRUCTION);
        LIST_TEAM_TEMPLATE = new TextFlow(LIST_TEAM, LIST_TEAM_INSTRUCTION);

        //LEADERBOARD and JUDGING Commands
        SCORE_ADD_TEMPLATE = new TextFlow(SCORE_ADD, TEAM_ID, POINTS, SCORE_ADD_INSTRUCTION);
        SCORE_SUB_TEMPLATE = new TextFlow(SCORE_SUB, TEAM_ID, POINTS, SCORE_SUB_INSTRUCTION);
        SCORE_SET_TEMPLATE = new TextFlow(SCORE_SET, TEAM_ID, NEW_POINTS, SCORE_SET_INSTRUCTION);
        LEADERBOARD_TEMPLATE = new TextFlow(LEADERBOARD, LEADERBOARD_INSTRUCTION);
        GET_TOP_TEMPLATE = new TextFlow(GET_TOP, NUMBER, GET_TOP_INSTRUCTION);

        //IMPORT/EXPORT CSV Commands
        IMPORT_TEMPLATE = new TextFlow(IMPORT, FILEPATH_PREFIX, FILE_PATH, IMPORT_INSTRUCTION);
        EXPORT_TEMPLATE = new TextFlow(EXPORT, ENTITY, FILEPATH_PREFIX, FILE_PATH, EXPORT_INSTRUCTION);

        //HISTORY Commands
        HISTORY_TEMPLATE = new TextFlow(HISTORY, HISTORY_INSTRUCTION);
        UNDO_TEMPLATE = new TextFlow(UNDO, UNDO_INSTRUCTION);
        REDO_TEMPLATE = new TextFlow(REDO, REDO_INSTRUCTION);

        //HELP Command
        HELP_TEMPLATE = new TextFlow(HELP, HELP_INSTRUCTION);

    }

    /**
     * Sets the colour for each Text object.
     */
    private static void initialize() {
        //Set the instruction of each commands to cornflower blue
        ADD_PARTICIPANT_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        ADD_MENTOR_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        ADD_TEAM_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);

        EDIT_PARTICIPANT_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        EDIT_MENTOR_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        EDIT_TEAM_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);

        FIND_PARTICIPANT_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        FIND_MENTOR_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        FIND_TEAM_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);

        DELETE_PARTICIPANT_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        DELETE_MENTOR_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        DELETE_TEAM_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);

        LIST_PARTICIPANT_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        LIST_MENTOR_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        LIST_TEAM_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);

        SCORE_ADD_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        SCORE_SET_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        SCORE_SUB_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        LEADERBOARD_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        GET_TOP_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);


        EXPORT_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        IMPORT_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);

        HISTORY_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        UNDO_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);
        REDO_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);

        HELP_INSTRUCTION.setFill(Color.CORNFLOWERBLUE);

        //Sett the template guides to Gray
        NAME.setFill(Color.GREY);
        PHONE.setFill(Color.GREY);
        EMAIL.setFill(Color.GREY);

        TEAM_ID.setFill(Color.GREY);
        PARTICIPANT_ID.setFill(Color.GREY);
        MENTOR_ID.setFill(Color.GREY);

        NUMBER.setFill(Color.GREY);
        POINTS.setFill(Color.GREY);
        NEW_POINTS.setFill(Color.GREY);

        CSV_PATH.setFill(Color.GREY);
        PARAMETERS.setFill(Color.GREY);
        ORGANIZATION.setFill(Color.GREY);
        SPECIALISATION.setFill(Color.GREY);
        PROJECT_NAME.setFill(Color.GREY);
        SUBJECT.setFill(Color.GREY);
        TABLE.setFill(Color.GREY);
        ENTITY.setFill(Color.GREY);

    }

    /**
     * Returns a String that represents the template form of commands.
     * Only prefix and commands are returned.
     * Constants that are used to guide the user(e.g NAME, PHONE_NUMBER) are not returned).
     */
    public static String getString(TextFlow template) {
        String result = template.getChildren()
                .stream()
                .map(textElement -> (Text) textElement)
                .map(t -> t.getText())
                .filter(s -> !s.matches("\\[[A-Za-z{}_ ]+\\] |[A-Z_{} ]+|\\([A-Za-z_ ]+\\)"))
                .collect(Collectors.joining(" "));
        return result;

    }

}
