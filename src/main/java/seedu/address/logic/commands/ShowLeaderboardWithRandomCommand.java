package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import java.util.Comparator;
import java.util.logging.Logger;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.util.LeaderboardUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.entity.CommandType;
import seedu.address.model.entity.Team;

/**
 * Shows the full leader board as it currently stands based
 * on the teams' scores.
 */
public class ShowLeaderboardWithRandomCommand extends LeaderboardCommand {

    public static final String MESSAGE_SUCCESS = "Showing Leaderboard as it Stands with Random Winners.";
    private static final String MESSAGE_LEADERBOARD_HEADER = "Current Standings of Teams: ";
    private final Logger logger = LogsCenter.getLogger(getClass());

    public ShowLeaderboardWithRandomCommand(Comparator ... comparators) {
        super(comparators);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.setLeaderboardWithRandom(comparators);

        System.out.println(MESSAGE_LEADERBOARD_HEADER);
        logger.info("Showing Leaderboard with Random Winners.");
        return new CommandResult(MESSAGE_SUCCESS, CommandType.L);
    }
}
