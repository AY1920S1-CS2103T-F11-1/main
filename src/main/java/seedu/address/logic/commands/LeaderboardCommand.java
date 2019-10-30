package seedu.address.logic.commands;

import java.util.Comparator;
import seedu.address.model.entity.Team;

public abstract class LeaderboardCommand extends Command {

    public static final String COMMAND_WORD = "leaderboard";

    protected Comparator<Team>[] comparators;

    public LeaderboardCommand(Comparator<Team> ... comparators) {
        this.comparators = comparators;
    }

}
