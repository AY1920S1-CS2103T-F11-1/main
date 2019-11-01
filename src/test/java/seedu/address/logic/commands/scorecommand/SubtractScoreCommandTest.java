package seedu.address.logic.commands.scorecommand;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_TEAM_DISPLAYED_INDEX;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.AlfredException;
import seedu.address.model.Model;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.PrefixType;
import seedu.address.model.entity.Score;
import seedu.address.model.entity.Team;
import seedu.address.stub.ModelManagerStub;
import seedu.address.testutil.TeamBuilder;

class SubtractScoreCommandTest {

    public static final Id validTeamId = new Id(PrefixType.T, 1);
    public static final Score validScore = new Score(20);

    @Test
    public void constructor_nullInputs_throwsNullPointerException() {
        // Null team id inputted.
        assertThrows(NullPointerException.class, () -> new SubtractScoreCommand(null, validScore));
        // Null score inputted.
        assertThrows(NullPointerException.class, () -> new SubtractScoreCommand(validTeamId, null));
        // Both inputs are null.
        assertThrows(NullPointerException.class, () -> new SubtractScoreCommand(null, null));
    }

    @Test
    public void execute_validParameters_success() throws AlfredException {
        Model model = new ModelManagerStub();
        Team teamToScore = new TeamBuilder().build();
        model.addTeam(teamToScore);
        SubtractScoreCommand subtractScoreCommand = new SubtractScoreCommand(validTeamId, validScore);

        String expectedMessage = String.format(SubtractScoreCommand.MESSAGE_SCORE_TEAM_SUCCESS,
                validScore.toString(), teamToScore.getName().toString());

        Model expectedModel = new ModelManagerStub();
        expectedModel.addTeam(teamToScore);
        expectedModel.addTeamScore(teamToScore, validScore);

        assertCommandSuccess(subtractScoreCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_nonExistentTeamId_commandFailure() {
        Model model = new ModelManagerStub(); // empty model
        SubtractScoreCommand subtractScoreCommand = new SubtractScoreCommand(validTeamId, validScore);

        assertCommandFailure(subtractScoreCommand, model, MESSAGE_INVALID_TEAM_DISPLAYED_INDEX);
    }

    @Test
    public void execute_subtractedScoreBelowMinimum_scoreSetToMinimum() throws AlfredException {
        Model model = new ModelManagerStub(); // empty model
        Team teamToScore = new TeamBuilder().withScore(5).build();
        Team teamWithMinScore = new TeamBuilder().withScore(0).build();
        model.addTeam(teamToScore);
        SubtractScoreCommand subtractScoreCommand = new SubtractScoreCommand(teamToScore.getId(), validScore);

        Model expectedModel = new ModelManagerStub();
        expectedModel.addTeam(teamWithMinScore);
        String expectedMessage = String.format(SubtractScoreCommand.MESSAGE_SCORE_TEAM_SUCCESS,
                validScore.toString(), teamToScore.getName().toString());

        assertCommandSuccess(subtractScoreCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_teamScoreAtMinimum_scoreUnchanged() throws AlfredException {
        Model model = new ModelManagerStub(); // empty model
        Team teamToScore = new TeamBuilder().withScore(0).build();
        Team teamWithMinScore = new TeamBuilder().withScore(0).build();
        model.addTeam(teamToScore);
        SubtractScoreCommand subtractScoreCommand = new SubtractScoreCommand(teamToScore.getId(), validScore);

        Model expectedModel = new ModelManagerStub();
        expectedModel.addTeam(teamWithMinScore);

        String expectedMessage = Score.MIN_SCORE_MESSAGE;

        // Checks if both teams are equal after adding score, which should be true as the score shouldn't be below 0.
        assertEquals(teamToScore, teamWithMinScore);
        // Checks if the appropriate message is shown when this command is run.
        assertCommandFailure(subtractScoreCommand, model, expectedMessage);
    }
}
