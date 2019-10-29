package seedu.address.ui;

import java.util.stream.Collectors;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * Represents the possible Suggestions that could be displated by AutoCompleteTextField
 */
public class SuggestionTemplates {
    //Constants used as instructions
    private final Text ADD_PARTICIPANT_INSTRUCTION = new Text("(Adds a new Participant)");
    private final Text ADD_MENTOR_INSTRUCTION = new Text("(Adds a new Mentor)");
    private final Text ADD_TEAM_INSTRUCTION = new Text("(Adds a new Team)");

    private final Text EDIT_PARTICIPANT_INSTRUCTION = new Text("(Edits existing Participant according to PARAMETERS)");
    private final Text EDIT_MENTOR_INSTRUCTION = new Text("(Edits existing Mentor according to PARAMETERS)");
    private final Text EDIT_TEAM_INSTRUCTION = new Text("(Edits existing Team according to PARAMETERS)");

    private final Text FIND_PARTICIPANT_INSTRUCTION = new Text("(Finds a new Participant)");
    private final Text FIND_MENTOR_INSTRUCTION = new Text("(Finds a new Mentor)");
    private final Text FIND_TEAM_INSTRUCTION = new Text("(Finds a new Team)");

    private final Text DELETE_PARTICIPANT_INSTRUCTION = new Text("(Deletes an existing Participant)");
    private final Text DELETE_MENTOR_INSTRUCTION = new Text("(Deletes an existing Mentor)");
    private final Text DELETE_TEAM_INSTRUCTION = new Text("(Deletes an existing Team)");

    private final Text LIST_PARTICIPANT_INSTRUCTION = new Text("(Lists all Participants)");
    private final Text LIST_MENTOR_INSTRUCTION = new Text("(Lists all Mentors)");
    private final Text LIST_TEAM_INSTRUCTION = new Text("(Lists all Teams)");

    private final Text SCORE_ADD_INSTRUCTION = new Text("(Adds POINTS to Team with TEAM_ID)");
    private final Text SCORE_SUB_INSTRUCTION = new Text("(Subtracts POINTS to Team with TEAM_ID)");
    private final Text SCORE_SET_INSTRUCTION = new Text("(Set Team with TEAM_ID to obtain a SCORE)");
    private final Text LEADERBOARD_INSTRUCTION = new Text("(Lists all Teams from highest to lowest Score)");
    private final Text GET_TOP_INSTRUCTION = new Text("(Lists the top NUMBER of Teams according to Score)");

    private final Text IMPORT_INSTRUCTION = new Text("(Adds multiple Participants with details in .csv file)");
    private final Text EXPORT_INSTRUCTION = new Text("(Export Entity and their details into .csv file specified by FILE_PATH)");


    private final Text HISTORY_INSTRUCTION = new Text("(Gets all past commands you have entered)");
    private final Text UNDO_INSTRUCTION = new Text("(Undoes the most recent command)");
    private final Text REDO_INSTRUCTION = new Text("(Redoes the most recent command that you have undone)");

    private final Text HELP_INSTRUCTION = new Text("(Opens a new Help Window)");

    //Constants that are used as template(this Text is also indicative of command type)
    private final Text ADD_PARTICIPANT = new Text("add participant ");
    private final Text ADD_MENTOR = new Text("add mentor ");
    private final Text ADD_TEAM = new Text("add team ");

    private final Text LIST_PARTICIPANT = new Text("list participant ");
    private final Text LIST_MENTOR = new Text("list mentor ");
    private final Text LIST_TEAM = new Text("list team ");

    private final Text EDIT_PARTICIPANT = new Text("edit participant ");
    private final Text EDIT_MENTOR = new Text("edit mentor ");
    private final Text EDIT_TEAM = new Text("edit team ");

    private final Text FIND_PARTICIPANT = new Text("find participant ");
    private final Text FIND_MENTOR = new Text("find mentor ");
    private final Text FIND_TEAM = new Text("find team ");

    private final Text DELETE_PARTICIPANT = new Text("delete participant ");
    private final Text DELETE_MENTOR = new Text("delete mentor ");
    private final Text DELETE_TEAM = new Text("delete team ");

    private final Text SCORE_ADD = new Text("score add ");
    private final Text SCORE_SUB = new Text("score sub ");
    private final Text SCORE_SET = new Text("score set ");
    private final Text LEADERBOARD = new Text("leaderboard ");
    private final Text GET_TOP = new Text("getTop ");

    private final Text HISTORY = new Text("history ");
    private final Text UNDO = new Text("undo ");
    private final Text REDO = new Text("redo ");

    private final Text IMPORT = new Text("import ");
    private final Text EXPORT = new Text("export ");

    private final Text HELP = new Text("help ");

    //Constants that are used as template
    private final Text NAME_PREFIX = new Text("n/");
    private final Text PHONE_PREFIX = new Text("p/");
    private final Text EMAIL_PREFIX = new Text("e/");
    private final Text ORGANIZATION_PREFIX = new Text("o/");
    private final Text SPECIALISATION_PREFIX = new Text("s/ ");
    private final Text PROJECT_NAME_PREFIX = new Text("pn/ ");
    private final Text PROJECT_TYPE_PREFIX = new Text("pt/ ");
    private final Text LOCATION_PREFIX = new Text("l/ ");
    private final Text FILEPATH_PREFIX = new Text("fp/ ");

    //Constants (that are used are guides)
    private final Text NAME = new Text("NAME ");
    private final Text PHONE = new Text("PHONE_NUMBER ");
    private final Text EMAIL = new Text("EMAIL_ADDRESS ");
    private final Text TEAM_ID = new Text("TEAM_ID ");
    private final Text PARTICIPANT_ID = new Text("PARTICIPANT_ID ");
    private final Text MENTOR_ID = new Text("MENTOR_ID ");
    private final Text NUMBER = new Text("NUMBER ");
    private final Text POINTS = new Text("POINTS ");
    private final Text NEW_POINTS = new Text("NEW_POINTS ");
    private final Text CSV_PATH= new Text("PATH_TO_CSV_FILE ");
    private final Text PARAMETERS = new Text("[PARAMETERS] ");
    private final Text ORGANIZATION = new Text("ORGANIZATION ");
    private final Text SPECIALISATION = new Text("SPECIALISATION ");
    private final Text PROJECT_NAME = new Text("PROJECT_NAME ");
    private final Text PROJECT_TYPE = new Text("PROJECT_TYPE ");
    private final Text TABLE = new Text("TABLE_NUMBER ");
    private final Text FILE_PATH = new Text("PATH_TO_CSV_FILE ");
    private final Text ENTITY = new Text("[{team/mentor/participant}] ");

    //The final template for each instruction that will be displayed as suggestion to User.
    //Combination of preceding constants(which are used as building blocks/

    public final TextFlow ADD_PARTICIPANT_TEMPLATE;
    public final TextFlow ADD_MENTOR_TEMPLATE;
    public final TextFlow ADD_TEAM_TEMPLATE;

    public final TextFlow EDIT_PARTICIPANT_TEMPLATE;
    public final TextFlow EDIT_MENTOR_TEMPLATE;
    public final TextFlow EDIT_TEAM_TEMPLATE;

    public final TextFlow FIND_PARTICIPANT_TEMPLATE;
    public final TextFlow FIND_MENTOR_TEMPLATE;
    public final TextFlow FIND_TEAM_TEMPLATE;

    public final TextFlow DELETE_PARTICIPANT_TEMPLATE;
    public final TextFlow DELETE_MENTOR_TEMPLATE;
    public final TextFlow DELETE_TEAM_TEMPLATE;

    public final TextFlow LIST_PARTICIPANT_TEMPLATE;
    public final TextFlow LIST_MENTOR_TEMPLATE;
    public final TextFlow LIST_TEAM_TEMPLATE;

    public final TextFlow SCORE_ADD_TEMPLATE;
    public final TextFlow SCORE_SUB_TEMPLATE;
    public final TextFlow SCORE_SET_TEMPLATE;
    public final TextFlow LEADERBOARD_TEMPLATE;
    public final TextFlow GET_TOP_TEMPLATE;

    public final TextFlow IMPORT_TEMPLATE;
    public final TextFlow EXPORT_TEMPLATE;

    public final TextFlow HISTORY_TEMPLATE;
    public final TextFlow UNDO_TEMPLATE;
    public final TextFlow REDO_TEMPLATE;

    public final TextFlow HELP_TEMPLATE;


    /**
     * Constructs a {@codeSuggestionTemplates} that provides a list of Templates for each Command.
     * Each of these templates will be displaed as a suggestion to user  when they type, in {@codeAutoCompleteTextField}.
     */
    public SuggestionTemplates() {
        initialize();
        //ADD Commands
        ADD_PARTICIPANT_TEMPLATE = new TextFlow(ADD_PARTICIPANT, NAME_PREFIX,
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
                PROJECT_TYPE_PREFIX, PROJECT_TYPE,
                LOCATION_PREFIX, TABLE,
                ADD_TEAM_INSTRUCTION
        );

        //EDIT Commands
        EDIT_PARTICIPANT_TEMPLATE = new TextFlow(EDIT_PARTICIPANT, PARTICIPANT_ID, PARAMETERS, EDIT_PARTICIPANT_INSTRUCTION);
        EDIT_MENTOR_TEMPLATE = new TextFlow(EDIT_MENTOR, MENTOR_ID, PARAMETERS, EDIT_MENTOR_INSTRUCTION);
        EDIT_TEAM_TEMPLATE = new TextFlow(EDIT_TEAM, TEAM_ID, PARAMETERS, EDIT_TEAM_INSTRUCTION);

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
    private void initialize() {
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
        PROJECT_TYPE.setFill(Color.GREY);
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
