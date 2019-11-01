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

class SetScoreCommandTest {

    public static final Id validTeamId = new Id(PrefixType.T, 1);
    public static final Score validScore = new Score(20);

    @Test
    public void constructor_nullInputs_throwsNullPointerException() {
        // Null team id inputted.
        assertThrows(NullPointerException.class, () -> new SetScoreCommand(null, validScore));
        // Null score inputted.
        assertThrows(NullPointerException.class, () -> new SetScoreCommand(validTeamId, null));
        // Both inputs are null.
        assertThrows(NullPointerException.class, () -> new SetScoreCommand(null, null));
    }

    @Test
    public void execute_validParameters_success() throws AlfredException {
        Model model = new ModelManagerStub();
        Team teamToScore = new TeamBuilder().build();
        model.addTeam(teamToScore);
        SetScoreCommand setScoreCommand = new SetScoreCommand(validTeamId, validScore);

        String expectedMessage = String.format(SetScoreCommand.MESSAGE_SCORE_TEAM_SUCCESS,
                teamToScore.getName().toString(), validScore.toString());

        Model expectedModel = new ModelManagerStub();
        expectedModel.addTeam(teamToScore);
        expectedModel.updateTeamScore(teamToScore, validScore);

        assertCommandSuccess(setScoreCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_nonExistentTeamId_commandFailure() {
        Model model = new ModelManagerStub(); // empty model
        SetScoreCommand setScoreCommand = new SetScoreCommand(validTeamId, validScore);

        assertCommandFailure(setScoreCommand, model, MESSAGE_INVALID_TEAM_DISPLAYED_INDEX);
    }
}
