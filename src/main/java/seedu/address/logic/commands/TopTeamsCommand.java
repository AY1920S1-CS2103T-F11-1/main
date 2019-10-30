package seedu.address.logic.commands;

import java.util.Comparator;
import seedu.address.model.entity.Team;

public abstract class TopTeamsCommand extends Command {

    public static final String COMMAND_WORD = "getTop";
    public static final String INVALID_TIE_BREAK = "The tie-break method specified does not exist or is not "
            + "supported by Alfred.";
    public static final String INVALID_VALUE_WARNING = "The value of K inputted is not a valid integer.";

    protected int numberOfTeams;
    protected Comparator<Team>[] comparators;

    public TopTeamsCommand(int k, Comparator<Team> ... comparators) {
        this.numberOfTeams = k;
        this.comparators = comparators;
    }

}
