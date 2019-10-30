package seedu.address.logic.commands.leaderboardcommand;

import java.util.Comparator;

import seedu.address.logic.commands.Command;
import seedu.address.model.entity.Team;

/**
 * Displays the current leaderboard on the UI.
 */
public abstract class LeaderboardCommand extends Command {

    public static final String COMMAND_WORD = "leaderboard";

    protected Comparator<Team>[] comparators;

    public LeaderboardCommand(Comparator<Team> ... comparators) {
        this.comparators = comparators;
    }

}
