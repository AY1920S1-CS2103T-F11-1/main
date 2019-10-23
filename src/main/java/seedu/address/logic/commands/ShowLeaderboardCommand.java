package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.entity.PrefixType;

/**
 * Shows the full leader board as it currently stands based
 * on the teams' scores.
 */
public class ShowLeaderboardCommand extends Command {

    public static final String COMMAND_WORD = "leaderboard";
    public static final String MESSAGE_SUCCESS = "Showing Leaderboard as it Stands.";
    private static final String MESSAGE_LEADERBOARD_HEADER = "Current Standings of Teams: ";


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.getLeaderboard();

        System.out.println(MESSAGE_LEADERBOARD_HEADER);
        return new CommandResult(MESSAGE_SUCCESS, PrefixType.L);
    }

}
