package seedu.address.logic.commands.scorecommand;


import static java.util.Objects.requireNonNull;
import seedu.address.logic.commands.Command;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.Score;

/**
 * Changes a {@code Team}'s score in Alfred.
 */
public abstract class ScoreCommand extends Command {

    public static final int MAXIMUM_SCORE = 100;
    public static final String COMMAND_WORD = "score";
    public static final String MESSAGE_SCORE_NOT_MENTIONED = "The score to update with or update to "
            + "must be mentioned.";
    public static final String INVALID_SCORE = "The score must be an Integer between 0 and 100.";

    protected Id id;
    protected Score score;

    public ScoreCommand(Id id, Score score) {
        requireNonNull(id);
        requireNonNull(score);
        this.id = id;
        this.score = score;
    }
}
