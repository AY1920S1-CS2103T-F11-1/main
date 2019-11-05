package seedu.address.logic.parser;

import static seedu.address.logic.parser.CliSyntax.PREFIX_TIE_BREAK;

import java.util.ArrayList;
import java.util.Comparator;

import seedu.address.logic.commands.leaderboardcommand.LeaderboardCommand;
import seedu.address.logic.commands.leaderboardcommand.LeaderboardWithRandomCommand;
import seedu.address.logic.commands.leaderboardcommand.SimpleLeaderboardCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.entity.Team;

/**
 * Parses the user's leaderboard command in the context of a
 * {@code LeaderboardCommand} command.
 */
public class LeaderboardCommandParser implements Parser<LeaderboardCommand> {

    private static final String METHOD_SPLIT_REGEX = "\\s+";

    @Override
    public LeaderboardCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(userInput, PREFIX_TIE_BREAK);
        ArrayList<Comparator<Team>> comparators = new ArrayList<>();

        if (!argumentMultimap.getValue(PREFIX_TIE_BREAK).isPresent()) {
            return new SimpleLeaderboardCommand(comparators);
        }

        // Split on whitespace as this is what is required from the user.
        String[] tieBreakMethods = argumentMultimap.getValue(PREFIX_TIE_BREAK).get().split(METHOD_SPLIT_REGEX);

        comparators = AlfredParserUtil.processedComparators(tieBreakMethods);

        return AlfredParserUtil.isRandomPresent(tieBreakMethods) ? new LeaderboardWithRandomCommand(comparators)
                : new SimpleLeaderboardCommand(comparators);
    }
}
