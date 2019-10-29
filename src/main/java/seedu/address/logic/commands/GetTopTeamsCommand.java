package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.entity.CommandType;

/**
 * Shows the Top K teams currently in the leader board, where K is
 * an integer the user inputs.
 */
public class GetTopTeamsCommand extends TopTeamsCommand {

    public static final String MESSAGE_SUCCESS = "Showing Current Top %1$s";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": shows the top K teams as the leaderboard stands"
            + " where K is an integer value you type in. \n"
            + "Format: " + COMMAND_WORD + " K \n"
            + "For example: " + COMMAND_WORD + " 5";
    private final Logger logger = LogsCenter.getLogger(getClass());

    public GetTopTeamsCommand(int k) {
        super(k);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.getTopK(this.numberOfTeams);
        logger.info("Showing Top " + this.numberOfTeams + " Teams.");
        return new CommandResult(String.format(MESSAGE_SUCCESS, numberOfTeams), CommandType.K);
    }
}
