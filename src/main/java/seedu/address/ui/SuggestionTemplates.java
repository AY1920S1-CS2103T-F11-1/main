package seedu.address.ui;

import java.util.stream.Collectors;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


/**
 * Represents the possible Suggestions that could be displated by AutoCompleteTextField
 */
public class SuggestionTemplates {
    private SuggestionLabels suggestionLabels = new SuggestionLabels();
    private TextFlow textFlow;

    //IMPORT/EXPORT Commands
    public TextFlow importTemplate;
    public TextFlow exportTemplate;

    //HISTORY Commands
    public TextFlow historyTemplate;
    public TextFlow undoTemplate;
    public TextFlow redoTemplate;
    public TextFlow helpTemplate;

    //ADD Commands
    public TextFlow addMentorTemplate;
    public TextFlow addParticipantTemplate;
    public TextFlow addTeamTemplate;

    //EDIT Commands
    public TextFlow editMentorTemplate;
    public TextFlow editParticipantTemplate;
    public TextFlow editTeamTemplate;

    //DELETE Command
    public TextFlow deleteMentorTemplate;
    public TextFlow deleteParticipantTemplate;
    public TextFlow deleteTeamTemplate;

    //FIND Command
    public TextFlow findMentorTemplate;
    public TextFlow findParticipantTemplate;
    public TextFlow findTeamTemplate;

    //LIST Command
    public TextFlow listMentorTemplate;
    public TextFlow listParticipantTemplate;
    public TextFlow listTeamTemplate;

    //SCORE Commands
    public TextFlow scoreAddTemplate;
    public TextFlow scoreSubTemplate;
    public TextFlow scoreSetTemplate;
    public TextFlow leaderboardTemplate;
    public TextFlow getTopTemplate;

    public SuggestionTemplates() {

        importTemplate = new TextFlow(
                suggestionLabels.importWord, suggestionLabels.filepathPrefix,
                suggestionLabels.filepath, suggestionLabels.importInstruction
        );

        exportTemplate = new TextFlow(
                suggestionLabels.exportWord, suggestionLabels.entity,
                suggestionLabels.filepathPrefix, suggestionLabels.filepath,
                suggestionLabels.exportInstruction
        );

        //HISTORY Commands
        historyTemplate = new TextFlow(suggestionLabels.history, suggestionLabels.historyInstruction);

        undoTemplate = new TextFlow(suggestionLabels.undo, suggestionLabels.undoInstruction);

        redoTemplate = new TextFlow(suggestionLabels.redo, suggestionLabels.redoInstruction); //HELP Command

        helpTemplate = new TextFlow(suggestionLabels.help, suggestionLabels.helpInstruction);

        //ADD Commands
        addMentorTemplate = new TextFlow(
                suggestionLabels.addMentor,
                suggestionLabels.namePrefix, suggestionLabels.name,
                suggestionLabels.phonePrefix, suggestionLabels.phone,
                suggestionLabels.emailPrefix, suggestionLabels.email,
                suggestionLabels.organizationPrefix, suggestionLabels.organization,
                suggestionLabels.specialisationPrefix, suggestionLabels.specialisation,
                suggestionLabels.addMentorInstruction
        ));

        addTeamTemplate = new TextFlow(
                suggestionLabels.addTeam,
                suggestionLabels.namePrefix, suggestionLabels.name,
                suggestionLabels.projectNamePrefix, suggestionLabels.projectName,
                suggestionLabels.subjectPrefix, suggestionLabels.subject,
                suggestionLabels.locationPrefix, suggestionLabels.table,
                suggestionLabels.addTeamInstruction
        );

        addParticipantTemplate = new TextFlow(
                suggestionLabels.addParticipant,
                suggestionLabels.namePrefix, suggestionLabels.name,
                suggestionLabels.phonePrefix, suggestionLabels.phone,
                suggestionLabels.emailPrefix, suggestionLabels.email,
                suggestionLabels.addParticipantInstruction

        );

        //EDIT Commands
        editParticipantTemplate = new TextFlow(suggestionLabels.editParticipant, suggestionLabels.participantId,
                suggestionLabels.parameters, suggestionLabels.editParticipantInstruction
        );

        editMentorTemplate = new TextFlow(suggestionLabels.editMentor, suggestionLabels.mentorId,
                suggestionLabels.parameters, suggestionLabels.editMentorInstruction
        );

        editTeamTemplate = new TextFlow(suggestionLabels.editTeam, suggestionLabels.teamId,
                suggestionLabels.parameters, suggestionLabels.editTeamInstruction
        );

        //DELETE Commands
        deleteParticipantTemplate = new TextFlow(
                suggestionLabels.deleteParticipant, suggestionLabels.participantId,
                suggestionLabels.deleteParticipantInstruction
        );

        deleteMentorTemplate = new TextFlow(
                suggestionLabels.deleteMentor, suggestionLabels.mentorId,
                suggestionLabels.deleteMentorInstruction
        );

        deleteTeamTemplate = new TextFlow(
                suggestionLabels.deleteTeam, suggestionLabels.teamId,
                suggestionLabels.deleteTeamInstruction
        );


        findParticipantTemplate = new TextFlow(
                suggestionLabels.findParticipant, suggestionLabels.participantId,
                suggestionLabels.findParticipantInstruction
        );

        findMentorTemplate = new TextFlow(suggestionLabels.findMentor, suggestionLabels.mentorId, suggestionLabels.findMentorInstruction);

        findTeamTemplate = new TextFlow(suggestionLabels.findTeam, suggestionLabels.teamId, suggestionLabels.findTeamInstruction);


        listParticipantTemplate = new TextFlow(suggestionLabels.listParticipant, suggestionLabels.listParticipantInstruction);

        listMentorTemplate = new TextFlow(suggestionLabels.listMentor, suggestionLabels.listMentorInstruction);

        listTeamTemplate = new TextFlow(suggestionLabels.listTeam, suggestionLabels.listTeamInstruction));


        scoreAddTemplate = new TextFlow(
                suggestionLabels.scoreAdd, suggestionLabels.teamId,
                suggestionLabels.points, suggestionLabels.scoreAddInstruction
        );

        scoreSubTemplate = new TextFlow(
                suggestionLabels.scoreSub, suggestionLabels.teamId,
                suggestionLabels.points, suggestionLabels.scoreSubInstruction
        );

        scoreSetTemplate = new TextFlow(
                suggestionLabels.scoreSet, suggestionLabels.teamId,
                suggestionLabels.newPoints, suggestionLabels.scoreSetInstruction
        );

        leaderboardTemplate = new TextFlow(suggestionLabels.leaderboard, suggestionLabels.leaderboardInstruction);

        getTopTemplate = new TextFlow(suggestionLabels.getTop, suggestionLabels.number, suggestionLabels.getTopInstruction);

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
