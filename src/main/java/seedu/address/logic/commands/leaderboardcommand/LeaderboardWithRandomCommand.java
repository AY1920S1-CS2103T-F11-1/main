package seedu.address.logic.commands.leaderboardcommand;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.entity.CommandType;
import seedu.address.model.entity.Team;

/**
 * Shows the full leaderboard as it currently stands based
 * on the teams' scores, with ties broken on random selection.
 */
public class LeaderboardWithRandomCommand extends LeaderboardCommand {

    public static final String MESSAGE_SUCCESS = "Showing Leaderboard as it Stands with Random Winners.";
    private static final String MESSAGE_LEADERBOARD_HEADER = "Current Standings of Teams: ";
    private final Logger logger = LogsCenter.getLogger(getClass());

    public LeaderboardWithRandomCommand(ArrayList<Comparator<Team>> comparators) {
        super(comparators);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.setLeaderboardWithRandom(comparators);

        System.out.println(MESSAGE_LEADERBOARD_HEADER);
        logger.info("Showing Leaderboard with Random Winners.");
        model.updateHistory(this);
        model.recordCommandExecution(this.getCommandInputString());
        return new CommandResult(MESSAGE_SUCCESS, CommandType.L);
    }
}
