package seedu.address.ui;

import java.util.stream.Collectors;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


/**
 * represents the possible suggestions that could be displated by autocompletetextfield
 */
public class SuggestionTemplates {
    //IMPORT/EXPORT Commands
    public static final TextFlow IMPORT_TEMPLATE;
    public static final TextFlow EXPORT_TEMPLATE;

    //HISTORY Commands
    public static final TextFlow HISTORY_TEMPLATE;
    public static final TextFlow UNDO_TEMPLATE;
    public static final TextFlow REDO_TEMPLATE;
    public static final TextFlow HELP_TEMPLATE;

    //ADD Commands
    public static final TextFlow ADD_MENTOR_TEMPLATE;
    public static final TextFlow ADD_PARTICIPANT_TEMPLATE;
    public static final TextFlow ADD_TEAM_TEMPLATE;

    //EDIT Commands
    public static final TextFlow EDIT_MENTOR_TEMPLATE;
    public static final TextFlow EDIT_PARTICIPANT_TEMPLATE;
    public static final TextFlow EDIT_TEAM_TEMPLATE;

    //DELETE Command
    public static final TextFlow DELETE_MENTOR_TEMPLATE;
    public static final TextFlow DELETE_PARTICIPANT_TEMPLATE;
    public static final TextFlow DELETE_TEAM_TEMPLATE;

    //FIND Command
    public static final TextFlow FIND_MENTOR_TEMPLATE;
    public static final TextFlow FIND_PARTICIPANT_TEMPLATE;
    public static final TextFlow FIND_TEAM_TEMPLATE;

    //LIST Command
    public static final TextFlow LIST_MENTOR_TEMPLATE;
    public static final TextFlow LIST_PARTICIPANT_TEMPLATE;
    public static final TextFlow LIST_TEAM_TEMPLATE;

    //SCORE Commands
    public static final TextFlow SCORE_ADD_TEMPLATE;
    public static final TextFlow SCORE_SUB_TEMPLATE;
    public static final TextFlow SCORE_SET_TEMPLATE;
    public static final TextFlow LEADERBOARD_TEMPLATE;
    public static final TextFlow GET_TOP_TEMPLATE;

    private static SuggestionLabels suggestionLabels = new SuggestionLabels();


   static {

        Text filepathPrefix1 = new Text("fp/");
        Text filepath1 = new Text("PATH_TO_CSV_FILE ");
        filepath1.setFill(Color.GREY);
        IMPORT_TEMPLATE = new TextFlow(
                suggestionLabels.importWord, filepathPrefix1,
                filepath1, suggestionLabels.importInstruction
        );


        Text entity1 = new Text("[team/mentor/participant] ");
        Text filepathPrefix2 = new Text("fp/");
        Text filepath2 = new Text("PATH_TO_CSV_FILE ");
        filepath2.setFill(Color.GREY);
        entity1.setFill(Color.GREY);
        EXPORT_TEMPLATE = new TextFlow(
                suggestionLabels.exportWord, entity1,
                filepathPrefix2, filepath2,
                suggestionLabels.exportInstruction
        );

        //HISTORY Commands
        HISTORY_TEMPLATE = new TextFlow(
                suggestionLabels.history, suggestionLabels.historyInstruction
        );

        UNDO_TEMPLATE = new TextFlow(
                suggestionLabels.undo, suggestionLabels.undoInstruction
        );

        REDO_TEMPLATE = new TextFlow(
                suggestionLabels.redo, suggestionLabels.redoInstruction
        );
        //HELP Command

        HELP_TEMPLATE = new TextFlow(
                suggestionLabels.help, suggestionLabels.helpInstruction
        );

        //ADD Commands
        Text namePrefix1 = new Text("n/");
        Text name1 = new Text("NAME ");
        Text phonePrefix1 = new Text("p/");
        Text phone1 = new Text("PHONE ");
        Text emailPrefix1 = new Text("e/");
        Text email1 = new Text("EMAIL ");
        Text organizationPrefix1 = new Text("o/");
        Text organization1 = new Text("ORGANIZATION ");
        Text specialisationPrefix1 = new Text("s/");
        Text specialisation1 = new Text("SPECIALISATION");

        name1.setFill(Color.GREY);
        phone1.setFill(Color.GREY);
        email1.setFill(Color.GREY);
        organization1.setFill(Color.GREY);
        specialisation1.setFill(Color.GREY);
        ADD_MENTOR_TEMPLATE = new TextFlow(
                suggestionLabels.addMentor,
                namePrefix1, name1,
                phonePrefix1, phone1,
                emailPrefix1, email1,
                organizationPrefix1, organization1,
                specialisationPrefix1, specialisation1,
                suggestionLabels.addMentorInstruction
        );

        Text namePrefix2 = new Text("n/");
        Text name2 = new Text("NAME ");
        Text projectNamePrefix2 = new Text("pn/");
        Text projectName2 = new Text("PROJECT_NAME ");
        Text subjectPrefix2 = new Text("s/");
        Text subject2 = new Text("SUBJECT ");
        Text locationPrefix2 = new Text("l/");
        Text table2 = new Text("TABLE_NUMBER ");


        name2.setFill(Color.GREY);
        projectName2.setFill(Color.GREY);
        subject2.setFill(Color.GREY);
        table2.setFill(Color.GREY);

        ADD_TEAM_TEMPLATE = new TextFlow(
                suggestionLabels.addTeam,
                namePrefix2, name2,
                projectNamePrefix2, projectName2,
                subjectPrefix2, subject2,
                locationPrefix2, table2,
                suggestionLabels.addTeamInstruction
        );

        Text namePrefix3 = new Text("n/");
        Text name3 = new Text("NAME ");
        Text phonePrefix3 = new Text("p/");
        Text phone3 = new Text("PHONE ");
        Text emailPrefix3 = new Text("e/");
        Text email3 = new Text("EMAIL ");

        name3.setFill(Color.GREY);
        phone3.setFill(Color.GREY);
        email3.setFill(Color.GREY);

        ADD_PARTICIPANT_TEMPLATE = new TextFlow(
                suggestionLabels.addParticipant,
                namePrefix3, name3,
                phonePrefix3, phone3,
                emailPrefix3, email3,
                suggestionLabels.addParticipantInstruction

        );


        //EDIT Commands
        Text participantId1 = new Text("PARTICIPANT_ID ");
        Text parameters1 = new Text("[PARAMETERS] ");

        participantId1.setFill(Color.GREY);
        parameters1.setFill(Color.GREY);
        EDIT_PARTICIPANT_TEMPLATE = new TextFlow(suggestionLabels.editParticipant, participantId1,
                parameters1, suggestionLabels.editParticipantInstruction
        );

        Text mentorId2 = new Text("MENTOR_ID ");
        Text parameters2 = new Text("[PARAMETERS] ");

        mentorId2.setFill(Color.GREY);
        parameters2.setFill(Color.GREY);
        EDIT_MENTOR_TEMPLATE = new TextFlow(suggestionLabels.editMentor, mentorId2,
                parameters2, suggestionLabels.editMentorInstruction
        );

        Text teamId3 = new Text("TEAM_ID ");
        Text parameters3 = new Text("[PARAMETERS] ");

        teamId3.setFill(Color.GREY);
        parameters3.setFill(Color.GREY);
        EDIT_TEAM_TEMPLATE = new TextFlow(suggestionLabels.editTeam, teamId3,
                parameters3, suggestionLabels.editTeamInstruction
        );

        //DELETE Commands
        Text participantId4 = new Text("PARTICIPANT_ID ");

        participantId4.setFill(Color.GREY);

        DELETE_PARTICIPANT_TEMPLATE = new TextFlow(
                suggestionLabels.deleteParticipant, participantId4,
                suggestionLabels.deleteParticipantInstruction
        );

        Text mentorId5 = new Text("MENTOR_ID ");

        mentorId5.setFill(Color.GREY);

        DELETE_MENTOR_TEMPLATE = new TextFlow(
                suggestionLabels.deleteMentor, mentorId5,
                suggestionLabels.deleteMentorInstruction
        );

        Text teamId6 = new Text("TEAM_ID");

        teamId6.setFill(Color.GREY);

        DELETE_TEAM_TEMPLATE = new TextFlow(
                suggestionLabels.deleteTeam, teamId6,
                suggestionLabels.deleteTeamInstruction
        );

        Text participantId7 = new Text("PARTICIPANT_ID ");

        participantId7.setFill(Color.GREY);


        FIND_PARTICIPANT_TEMPLATE = new TextFlow(
                suggestionLabels.findParticipant, participantId7,
                suggestionLabels.findParticipantInstruction
        );

        Text mentorId8 = new Text("MENTOR_ID ");

        mentorId8.setFill(Color.GREY);
        FIND_MENTOR_TEMPLATE = new TextFlow(
                suggestionLabels.findMentor, mentorId8, suggestionLabels.findMentorInstruction
        );

        Text teamId8 = new Text("TEAM_ID ");

        teamId8.setFill(Color.GREY);

        FIND_TEAM_TEMPLATE = new TextFlow(
                suggestionLabels.findTeam, teamId8, suggestionLabels.findTeamInstruction
        );


        LIST_PARTICIPANT_TEMPLATE = new TextFlow(
                suggestionLabels.listParticipant, suggestionLabels.listParticipantInstruction
        );

        LIST_MENTOR_TEMPLATE = new TextFlow(
                suggestionLabels.listMentor, suggestionLabels.listMentorInstruction
        );

        LIST_TEAM_TEMPLATE = new TextFlow(
                suggestionLabels.listTeam, suggestionLabels.listTeamInstruction
        );

        Text teamId9 = new Text("TEAM_ID ");
        Text points9 = new Text("NEW_POINTS ");

        teamId9.setFill(Color.GREY);
        points9.setFill(Color.GREY);

        SCORE_ADD_TEMPLATE = new TextFlow(
                suggestionLabels.scoreAdd, teamId9,
                points9, suggestionLabels.scoreAddInstruction
        );

        Text teamId10 = new Text("TEAM_ID ");
        Text points10 = new Text("NEW_POINTS ");

        teamId10.setFill(Color.GREY);
        points10.setFill(Color.GREY);

        SCORE_SUB_TEMPLATE = new TextFlow(
                suggestionLabels.scoreSub, teamId10,
                points10, suggestionLabels.scoreSubInstruction
        );

        Text teamId11 = new Text("TEAM_ID ");
        Text newPoints11 = new Text("NEW_POINTS ");

        teamId11.setFill(Color.GREY);
        newPoints11.setFill(Color.GREY);

        SCORE_SET_TEMPLATE = new TextFlow(
                suggestionLabels.scoreSet, teamId11,
                newPoints11, suggestionLabels.scoreSetInstruction
        );

        LEADERBOARD_TEMPLATE = new TextFlow(suggestionLabels.leaderboard, suggestionLabels.leaderboardInstruction);

        Text number12 = new Text("NUMBER ");

        number12.setFill(Color.GREY);

        GET_TOP_TEMPLATE = new TextFlow(suggestionLabels.getTop, number12, suggestionLabels.getTopInstruction);

    }


    /**
     * Returns a String that represents the template form of commands.
     * Only prefix and commands are returned.
     * Constants that are used to guide the user(e.g NAME, PHONE_NUMBER) are not returned).
     */
    public static final String getString(TextFlow template) {
        String result = template.getChildren()
                .stream()
                .map(textElement -> (Text) textElement)
                .map(t -> t.getText())
                .filter(s -> !s.matches("\\[[A-Za-z{}_ ]+\\] |[A-Z_{} ]+|\\([A-Za-z_ ]+\\)"))
                .collect(Collectors.joining(" "));
        return result;

    }


}
