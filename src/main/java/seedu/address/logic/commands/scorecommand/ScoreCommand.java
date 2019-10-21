package seedu.address.logic.commands.scorecommand;


import static java.util.Objects.requireNonNull;
import seedu.address.logic.commands.Command;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.Score;

/**
 * Changes a {@code Team}'s score in Alfred.
 */
public abstract class ScoreCommand extends Command {

    public static final String COMMAND_WORD = "score";
    public static final String MESSAGE_USAGE = COMMAND_WORD + " updates, adds or subtracts the given score "
            + "to the specified team's score."
            + "Format: " + COMMAND_WORD + " update/add/sub Team-Id Score \n"
            + "For example: score add T-4 25";

    public static final String MESSAGE_SCORE_NOT_MENTIONED = "The score to update with or update to "
            + "must be mentioned.";

    protected Id id;
    protected Score score;

    public ScoreCommand(Id TeamId, Score score) {
        requireNonNull(TeamId);
        requireNonNull(score);
        this.id = TeamId;
        this.score = score;
    }
}
