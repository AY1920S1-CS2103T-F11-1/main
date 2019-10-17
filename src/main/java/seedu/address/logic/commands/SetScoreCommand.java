package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import seedu.address.commons.exceptions.AlfredException;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.Score;
import seedu.address.model.entity.Team;

public class SetScoreCommand extends Command {

    public static final String MESSAGE_EDIT_TEAM_SUCCESS = "Updated %1$s 's score to : %2$s";
    public static final String MESSAGE_INVALID_TEAM_DISPLAYED_INDEX =
            "The team index provided is invalid";
    public static final String COMMAND_WORD = "setScore";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":  "
            + "Parameters: ";

    private Score score;
    private Id id;

    public SetScoreCommand(Id id, Score score) {
        this.id = id;
        this.score = score;
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

        return new CommandResult(String.format(MESSAGE_EDIT_TEAM_SUCCESS,
                teamToScore.getName().toString(), score.toString()));


    }
}
