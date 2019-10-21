package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import seedu.address.commons.exceptions.AlfredException;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.Score;
import seedu.address.model.entity.Team;

public class SetScoreCommand extends ScoreCommand {

    public static final String MESSAGE_SCORE_TEAM_SUCCESS = "Updated %1$s 's score to : %2$s";
    public static final String MESSAGE_INVALID_TEAM_DISPLAYED_INDEX =
            "The team index provided is invalid";
    public static final String COMMAND_WORD = "score update";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": updates the specified team's score to match the score mentioned. \n"
            + "Format: " + COMMAND_WORD + " [teamID] [new score] \n"
            + "For example: " + COMMAND_WORD + " T-5 45";

    public SetScoreCommand(Id id, Score score) {
        super(id, score);
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

        teamToScore.setScore(score);

        return new CommandResult(String.format(MESSAGE_SCORE_TEAM_SUCCESS,
                teamToScore.getName().toString(), score.toString()));
    }
}
