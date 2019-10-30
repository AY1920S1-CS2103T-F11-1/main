package seedu.address.ui;

import static seedu.address.ui.SuggestionLabels.ADD_MENTOR;
import static seedu.address.ui.SuggestionLabels.ADD_MENTOR_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.ADD_PARTICIPANT;
import static seedu.address.ui.SuggestionLabels.ADD_PARTICIPANT_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.ADD_TEAM;
import static seedu.address.ui.SuggestionLabels.ADD_TEAM_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.DELETE_MENTOR;
import static seedu.address.ui.SuggestionLabels.DELETE_MENTOR_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.DELETE_PARTICIPANT;
import static seedu.address.ui.SuggestionLabels.DELETE_PARTICIPANT_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.DELETE_TEAM;
import static seedu.address.ui.SuggestionLabels.DELETE_TEAM_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.EDIT_MENTOR;
import static seedu.address.ui.SuggestionLabels.EDIT_MENTOR_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.EDIT_PARTICIPANT;
import static seedu.address.ui.SuggestionLabels.EDIT_PARTICIPANT_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.EDIT_TEAM;
import static seedu.address.ui.SuggestionLabels.EDIT_TEAM_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.EMAIL;
import static seedu.address.ui.SuggestionLabels.EMAIL_PREFIX;
import static seedu.address.ui.SuggestionLabels.ENTITY;
import static seedu.address.ui.SuggestionLabels.EXPORT;
import static seedu.address.ui.SuggestionLabels.EXPORT_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.FILEPATH_PREFIX;
import static seedu.address.ui.SuggestionLabels.FILE_PATH;
import static seedu.address.ui.SuggestionLabels.FIND_MENTOR;
import static seedu.address.ui.SuggestionLabels.FIND_MENTOR_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.FIND_PARTICIPANT;
import static seedu.address.ui.SuggestionLabels.FIND_PARTICIPANT_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.FIND_TEAM;
import static seedu.address.ui.SuggestionLabels.FIND_TEAM_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.GET_TOP;
import static seedu.address.ui.SuggestionLabels.GET_TOP_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.HELP;
import static seedu.address.ui.SuggestionLabels.HELP_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.HISTORY;
import static seedu.address.ui.SuggestionLabels.HISTORY_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.IMPORT;
import static seedu.address.ui.SuggestionLabels.IMPORT_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.LEADERBOARD;
import static seedu.address.ui.SuggestionLabels.LEADERBOARD_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.LIST_MENTOR;
import static seedu.address.ui.SuggestionLabels.LIST_MENTOR_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.LIST_PARTICIPANT;
import static seedu.address.ui.SuggestionLabels.LIST_PARTICIPANT_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.LIST_TEAM;
import static seedu.address.ui.SuggestionLabels.LIST_TEAM_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.LOCATION_PREFIX;
import static seedu.address.ui.SuggestionLabels.MENTOR_ID;
import static seedu.address.ui.SuggestionLabels.NAME;
import static seedu.address.ui.SuggestionLabels.NAME_PREFIX;
import static seedu.address.ui.SuggestionLabels.NEW_POINTS;
import static seedu.address.ui.SuggestionLabels.NUMBER;
import static seedu.address.ui.SuggestionLabels.ORGANIZATION;
import static seedu.address.ui.SuggestionLabels.ORGANIZATION_PREFIX;
import static seedu.address.ui.SuggestionLabels.PARAMETERS;
import static seedu.address.ui.SuggestionLabels.PARTICIPANT_ID;
import static seedu.address.ui.SuggestionLabels.PHONE;
import static seedu.address.ui.SuggestionLabels.PHONE_PREFIX;
import static seedu.address.ui.SuggestionLabels.POINTS;
import static seedu.address.ui.SuggestionLabels.PROJECT_NAME;
import static seedu.address.ui.SuggestionLabels.PROJECT_NAME_PREFIX;
import static seedu.address.ui.SuggestionLabels.REDO;
import static seedu.address.ui.SuggestionLabels.REDO_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.SCORE_ADD;
import static seedu.address.ui.SuggestionLabels.SCORE_ADD_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.SCORE_SET;
import static seedu.address.ui.SuggestionLabels.SCORE_SET_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.SCORE_SUB;
import static seedu.address.ui.SuggestionLabels.SCORE_SUB_INSTRUCTION;
import static seedu.address.ui.SuggestionLabels.SPECIALISATION;
import static seedu.address.ui.SuggestionLabels.SPECIALISATION_PREFIX;
import static seedu.address.ui.SuggestionLabels.SUBJECT;
import static seedu.address.ui.SuggestionLabels.SUBJECT_PREFIX;
import static seedu.address.ui.SuggestionLabels.TABLE;
import static seedu.address.ui.SuggestionLabels.TEAM_ID;
import static seedu.address.ui.SuggestionLabels.UNDO;
import static seedu.address.ui.SuggestionLabels.UNDO_INSTRUCTION;

import java.util.stream.Collectors;

import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


/**
 * Represents the possible Suggestions that could be displated by AutoCompleteTextField
 */
public enum SuggestionTemplates {
    //IMPORT/EXPORT Commands
    IMPORT_TEMPLATE(new TextFlow(
            IMPORT.getText(), FILEPATH_PREFIX.getText(),
            FILE_PATH.getText(), IMPORT_INSTRUCTION.getText()
    )),
    EXPORT_TEMPLATE(new TextFlow(
            EXPORT.getText(), ENTITY.getText(),
            FILEPATH_PREFIX.getText(), FILE_PATH.getText(),
            EXPORT_INSTRUCTION.getText()
    )),
    //HISTORY Commands
    HISTORY_TEMPLATE(new TextFlow(HISTORY.getText(), HISTORY_INSTRUCTION.getText())),
    UNDO_TEMPLATE(new TextFlow(UNDO.getText(), UNDO_INSTRUCTION.getText())),
    REDO_TEMPLATE(new TextFlow(REDO.getText(), REDO_INSTRUCTION.getText())), //HELP Command
    HELP_TEMPLATE(new TextFlow(HELP.getText(), HELP_INSTRUCTION.getText())),
    //ADD Commands
    ADD_MENTOR_TEMPLATE(new TextFlow(
            ADD_MENTOR.getText(),
            NAME_PREFIX.getText(), NAME.getText(),
            PHONE_PREFIX.getText(), PHONE.getText(),
            EMAIL_PREFIX.getText(), EMAIL.getText(),
            ORGANIZATION_PREFIX.getText(), ORGANIZATION.getText(),
            SPECIALISATION_PREFIX.getText(), SPECIALISATION.getText(),
            ADD_MENTOR_INSTRUCTION.getText()
    )),

    ADD_TEAM_TEMPLATE(new TextFlow(
            ADD_TEAM.getText(),
            NAME_PREFIX.getText(), NAME.getText(),
            PROJECT_NAME_PREFIX.getText(), PROJECT_NAME.getText(),
            SUBJECT_PREFIX.getText(), SUBJECT.getText(),
            LOCATION_PREFIX.getText(), TABLE.getText(),
            ADD_TEAM_INSTRUCTION.getText()
    )),

    ADD_PARTICIPANT_TEMPLATE(new TextFlow(
            ADD_PARTICIPANT.getText(),
            NAME_PREFIX.getText(), NAME.getText(),
            PHONE_PREFIX.getText(), PHONE.getText(),
            EMAIL_PREFIX.getText(), EMAIL.getText(),
            ADD_PARTICIPANT_INSTRUCTION.getText()

    )),

    //EDIT Commands
    EDIT_PARTICIPANT_TEMPLATE(new TextFlow(EDIT_PARTICIPANT.getText(), PARTICIPANT_ID.getText(),
            PARAMETERS.getText(), EDIT_PARTICIPANT_INSTRUCTION.getText()
    )),

    EDIT_MENTOR_TEMPLATE(new TextFlow(EDIT_MENTOR.getText(), MENTOR_ID.getText(),
            PARAMETERS.getText(), EDIT_MENTOR_INSTRUCTION.getText()
    )),
    EDIT_TEAM_TEMPLATE(new TextFlow(EDIT_TEAM.getText(), TEAM_ID.getText(),
            PARAMETERS.getText(), EDIT_TEAM_INSTRUCTION.getText()
    )),

    //DELETE Commands
    DELETE_PARTICIPANT_TEMPLATE(new TextFlow(
            DELETE_PARTICIPANT.getText(), PARTICIPANT_ID.getText(),
            DELETE_PARTICIPANT_INSTRUCTION.getText()
    )),
    DELETE_MENTOR_TEMPLATE(new TextFlow(
            DELETE_MENTOR.getText(), MENTOR_ID.getText(),
            DELETE_MENTOR_INSTRUCTION.getText()
    )),
    DELETE_TEAM_TEMPLATE(new TextFlow(
            DELETE_TEAM.getText(), TEAM_ID.getText(),
            DELETE_TEAM_INSTRUCTION.getText()
    )),


    FIND_PARTICIPANT_TEMPLATE(new TextFlow(
            FIND_PARTICIPANT.getText(), PARTICIPANT_ID.getText(),
            FIND_PARTICIPANT_INSTRUCTION.getText()
    )),
    FIND_MENTOR_TEMPLATE(new TextFlow(FIND_MENTOR.getText(), MENTOR_ID.getText(), FIND_MENTOR_INSTRUCTION.getText())),
    FIND_TEAM_TEMPLATE(new TextFlow(FIND_TEAM.getText(), TEAM_ID.getText(), FIND_TEAM_INSTRUCTION.getText())),


    LIST_PARTICIPANT_TEMPLATE(new TextFlow(LIST_PARTICIPANT.getText(), LIST_PARTICIPANT_INSTRUCTION.getText())),
    LIST_MENTOR_TEMPLATE(new TextFlow(LIST_MENTOR.getText(), LIST_MENTOR_INSTRUCTION.getText())),
    LIST_TEAM_TEMPLATE(new TextFlow(LIST_TEAM.getText(), LIST_TEAM_INSTRUCTION.getText())),


    SCORE_ADD_TEMPLATE(new TextFlow(
            SCORE_ADD.getText(), TEAM_ID.getText(),
            POINTS.getText(), SCORE_ADD_INSTRUCTION.getText()
    )),
    SCORE_SUB_TEMPLATE(new TextFlow(
            SCORE_SUB.getText(), TEAM_ID.getText(),
            POINTS.getText(), SCORE_SUB_INSTRUCTION.getText()
    )),
    SCORE_SET_TEMPLATE(new TextFlow(
            SCORE_SET.getText(), TEAM_ID.getText(),
            NEW_POINTS.getText(), SCORE_SET_INSTRUCTION.getText()
    )),
    LEADERBOARD_TEMPLATE(new TextFlow(LEADERBOARD.getText(), LEADERBOARD_INSTRUCTION.getText())),
    GET_TOP_TEMPLATE(new TextFlow(GET_TOP.getText(), NUMBER.getText(), GET_TOP_INSTRUCTION.getText()));

    private TextFlow textFlow;

    SuggestionTemplates(TextFlow textFlow) {
        this.textFlow = textFlow;
    }

    public TextFlow getTextFlow() {
        return textFlow;
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
