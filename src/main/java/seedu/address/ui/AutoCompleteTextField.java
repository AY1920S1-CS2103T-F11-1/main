package seedu.address.ui;

import static seedu.address.ui.SuggestionTemplates.ADD_MENTOR_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.ADD_PARTICIPANT_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.ADD_TEAM_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.DELETE_MENTOR_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.DELETE_PARTICIPANT_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.DELETE_TEAM_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.EDIT_MENTOR_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.EDIT_PARTICIPANT_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.EDIT_TEAM_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.EXPORT_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.FIND_MENTOR_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.FIND_PARTICIPANT_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.FIND_TEAM_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.GET_TOP_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.HELP_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.HISTORY_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.IMPORT_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.LEADERBOARD_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.LIST_MENTOR_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.LIST_PARTICIPANT_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.LIST_TEAM_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.REDO_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.SCORE_ADD_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.SCORE_SET_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.SCORE_SUB_TEMPLATE;
import static seedu.address.ui.SuggestionTemplates.UNDO_TEMPLATE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;

import seedu.address.commons.core.LogsCenter;


/**
 * Represents an AutoCompleteTextField that provide command suggestions as user types in command inputs.
 */
public class AutoCompleteTextField extends TextField {
    private SuggestionTemplates suggestionTemplates = new SuggestionTemplates();
    private final Logger logger = LogsCenter.getLogger(AutoCompleteTextField.class);
    /**
     * Represent the list of possible commands users can enter.
     */
    private final SortedSet<String> commandSuggestionSet = new TreeSet<String>();
    private final List<String> commandSuggestionList = Arrays.asList(
            "add participant",
            "add mentor",
            "add team",
            "list participants",
            "list mentors",
            "list teams",
            "edit participant",
            "edit mentor",
            "edit team",
            "delete participant",
            "delete mentor",
            "delete team",
            "find participant",
            "find mentor",
            "find team",
            "leaderboard",
            "getTop",
            "score add",
            "score sub",
            "score set",
            "history",
            "undo",
            "redo",
            "import",
            "export",
            "help"
    );


    /**
     * Represents a popup for user to select a command that is suggested.
     */
    private ContextMenu commandsPopup;

    /**
     * Constructs an AutoCompleteTextField that provide command suggestions as user types in command inputs.
     */
    public AutoCompleteTextField() {
        super();
        commandSuggestionSet.addAll(commandSuggestionList);
        commandsPopup = new ContextMenu();
        textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldString, String newString) {
                //Guard clause
                if (getText().length() == 0) {
                    commandsPopup.hide();
                    return;
                }

                List<String> filteredSuggestionResults = commandSuggestionSet
                        .stream()
                        //Only command suggestion that starts with user input will be filtered out
                        //This is done in a case insensitive manner
                        .filter(suggestion -> suggestion.toLowerCase().startsWith(getText().toLowerCase()))
                        .collect(Collectors.toList());

                List<String> finalSuggestionResults = new LinkedList<String>();
                finalSuggestionResults.addAll(filteredSuggestionResults);
                logger.info("Number of results:" + finalSuggestionResults.size());

                //Guard clause
                if (finalSuggestionResults.size() < 1) {
                    commandsPopup.hide();
                    return;
                }

                populatePopup(finalSuggestionResults);
                if (!commandsPopup.isShowing()) {
                    commandsPopup.show(AutoCompleteTextField.this, Side.BOTTOM, 0, 0);
                }
            }
        });

        //Set the commandsPopup to be hidden if the text field is out of focus
        // or whenever focus value is changes/clicked.
        focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                commandsPopup.hide();
            }
        });
    }

    /**
     * Populate the content of the commandsPopup with elements in List of Strings.
     *
     * @param finalSuggestionResults List of Strings to populate content of commandsPopup.
     */
    private void populatePopup(List<String> finalSuggestionResults) {
        List<CustomMenuItem> menuItems = new LinkedList<>();
        int maxSuggestion = 5;
        int numSuggestion = Math.min(finalSuggestionResults.size(), maxSuggestion);

        for (int j = 0; j < numSuggestion; j++) {
            String suggestion = finalSuggestionResults.get(j);
            logger.info("Command type suggested is: " + suggestion);
            TextFlow suggestionTemplate = getSuggestionTemplate(suggestion);
            logger.info("Suggestion template is: " + suggestionTemplate.toString());
            CustomMenuItem item = new CustomMenuItem(suggestionTemplate, true);
            item.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    setText(SuggestionTemplates.getString(suggestionTemplate));
                    positionCaret(100);
                    //commandsPopup hides after user picks a suggestion
                    commandsPopup.hide();
                }
            });
            menuItems.add(item);
        }
        //Clears all current menu items in popup, and adds new items.
        commandsPopup.getItems().clear();
        logger.info("Number of menu items to be added in pop-up box: " + menuItems.size());
        commandsPopup.getItems().addAll(menuItems);
        logger.info("number of items in commandsPopup: " + commandsPopup.getItems().size());
    }

    private TextFlow getSuggestionTemplate(String suggestion) {
        //Note that "score' has to be checked for first as "score add" contains "add"
        if (suggestion.contains("score")) {
            return getScoreTemplate(suggestion);
        }
        if (suggestion.contains("add")) {
            return getAddTemplate(suggestion);
        }
        if (suggestion.contains("list")) {
            return getListTemplate(suggestion);
        }
        if (suggestion.contains("edit")) {
            return getEditTemplate(suggestion);
        }
        if (suggestion.contains("delete")) {
            return getDeleteTemplate(suggestion);
        }
        if (suggestion.contains("find")) {
            return getFindTemplate(suggestion);
        }

        return getOtherTemplate(suggestion);
    }

    private TextFlow getAddTemplate(String suggestion) {
        switch (suggestion) {

        case "add participant":
            logger.info("Add participant template is shown on GUI");
            return suggestionTemplates.addParticipantTemplate;

        case "add team":
            return suggestionTemplates.addTeamTemplate;

        case "add mentor":
            return suggestionTemplates.addMentorTemplate;
        default:
            logger.info("ADD Command Template is null");
            return null;
        }
    }

    private TextFlow getListTemplate(String suggestion) {
        switch (suggestion) {

        case "list participants":
            return suggestionTemplates.listParticipantTemplate;

        case "list teams":
            return suggestionTemplates.listTeamTemplate;

        case "list mentors":
            return suggestionTemplates.listMentorTemplate;

        default:
            logger.info("LIST Command Template is null");
            return null;

        }
    }

    private TextFlow getEditTemplate(String suggestion) {
        switch (suggestion) {

        case "edit participant":
            return suggestionTemplates.editParticipantTemplate;

        case "edit team":
            return suggestionTemplates.editTeamTemplate;

        case "edit mentor":
            return suggestionTemplates.editMentorTemplate;

        default:
            logger.info("EDIT Command Template is null");
            return null;

        }
    }

    private TextFlow getDeleteTemplate(String suggestion) {
        switch (suggestion) {

        case "delete participant":
            return suggestionTemplates.deleteParticipantTemplate;
        case "delete team":
            return suggestionTemplates.listMentorTemplate;

        case "delete mentor":
            return DELETE_MENTOR_TEMPLATE.getTextFlow();

        default:
            logger.info("DELETE Command Template is null");
            return null;

        }
    }

    private TextFlow getFindTemplate(String suggestion) {
        switch (suggestion) {

        case "find participant":
            return FIND_PARTICIPANT_TEMPLATE.getTextFlow();

        case "find team":
            return FIND_TEAM_TEMPLATE.getTextFlow();

        case "find mentor":
            return FIND_MENTOR_TEMPLATE.getTextFlow();

        default:
            logger.info("FIND Command Template is null");
            return null;


        }
    }

    private TextFlow getScoreTemplate(String suggestion) {
        switch (suggestion) {

        case "score add":
            return SCORE_ADD_TEMPLATE.getTextFlow();

        case "score sub":
            return SCORE_SUB_TEMPLATE.getTextFlow();

        case "score set":
            return SCORE_SET_TEMPLATE.getTextFlow();

        default:
            logger.info("SCORE Command Template is null");
            return null;
        }
    }

    private TextFlow getOtherTemplate(String suggestion) {
        switch (suggestion) {
        case "undo":
            return UNDO_TEMPLATE.getTextFlow();

        case "redo":
            return REDO_TEMPLATE.getTextFlow();

        case "history":
            return HISTORY_TEMPLATE.getTextFlow();

        case "leaderboard":
            return LEADERBOARD_TEMPLATE.getTextFlow();

        case "import":
            return IMPORT_TEMPLATE.getTextFlow();

        case "export":
            return EXPORT_TEMPLATE.getTextFlow();

        case "getTop":
            return GET_TOP_TEMPLATE.getTextFlow();

        case "help":
            return HELP_TEMPLATE.getTextFlow();

        default:
            logger.info("Other Template is null");
            return null;
        }
    }

}
