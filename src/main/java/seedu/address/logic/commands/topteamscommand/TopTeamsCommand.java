package seedu.address.logic.commands.topteamscommand;

import static seedu.address.logic.parser.CliSyntax.PREFIX_TIE_BREAK;
import java.util.ArrayList;
import java.util.Comparator;

import seedu.address.logic.commands.Command;
import seedu.address.model.entity.Team;

/**
 * Displays the top specified number of teams on the UI.
 */
public abstract class TopTeamsCommand extends Command {

    public static final String COMMAND_WORD = "getTop";
    public static final String INVALID_VALUE_WARNING = "The value of K inputted is not a valid positive integer.";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": shows the top K teams as the leaderboard stands"
            + " where K is an integer value you type in. \n"
            + "Format: " + COMMAND_WORD + " K \n"
            + "Format (With Tiebreak): " + COMMAND_WORD + " K " + PREFIX_TIE_BREAK + "[Tie-break Methods]\n"
            + "For example: " + COMMAND_WORD + " 5 " + PREFIX_TIE_BREAK + "moreParticipants random";

    protected int numberOfTeams;
    protected ArrayList<Comparator<Team>> comparators;

    public TopTeamsCommand(int k, ArrayList<Comparator<Team>> comparators) {
        this.numberOfTeams = k;
        this.comparators = comparators;
    }

}
