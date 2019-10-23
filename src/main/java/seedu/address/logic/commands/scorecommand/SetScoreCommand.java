package seedu.address.logic.commands.scorecommand;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_TEAM_DISPLAYED_INDEX;

import seedu.address.commons.exceptions.AlfredException;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.PrefixType;
import seedu.address.model.entity.Score;
import seedu.address.model.entity.Team;

public class SetScoreCommand extends ScoreCommand {

    public static final String MESSAGE_SCORE_TEAM_SUCCESS = "Changed %1$s's score to : %2$s";
    public static final String COMMAND_WORD = "score set";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": updates the specified team's score to match the score mentioned. \n"
            + "Format: " + COMMAND_WORD + " [teamID] [new score] \n"
            + "For example: " + COMMAND_WORD + " T-5 45";

    public SetScoreCommand(Id teamId, Score score) {
        super(teamId, score);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        Team teamToScore;

        try {
            teamToScore = model.getTeam(id);
        } catch (AlfredException ae) {
            throw new CommandException(MESSAGE_INVALID_TEAM_DISPLAYED_INDEX);
        }

        try {
            model.updateTeamScore(teamToScore, score);
        } catch (AlfredException e) {
            throw new CommandException(e.getMessage());
        }

        return new CommandResult(String.format(MESSAGE_SCORE_TEAM_SUCCESS,
                teamToScore.getName().toString(), score.toString()), PrefixType.T);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SetScoreCommand // instanceof handles nulls
                && id.equals(((SetScoreCommand) other).id))
                && score.equals(((SetScoreCommand) other).score);
    }

}
