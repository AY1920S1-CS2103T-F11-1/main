package seedu.address.logic.parser;

import static seedu.address.logic.parser.CliSyntax.PREFIX_TIE_BREAK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import seedu.address.commons.util.LeaderboardUtil;
import seedu.address.logic.commands.leaderboardcommand.LeaderboardCommand;
import seedu.address.logic.commands.leaderboardcommand.ShowLeaderboardWithRandomCommand;
import seedu.address.logic.commands.leaderboardcommand.ShowSimpleLeaderboardCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.entity.Team;

/**
 * Parses the user's leaderboard command in the context of a
 * {@code LeaderboardCommand} command.
 */
public class ShowLeaderBoardCommandParser implements Parser<LeaderboardCommand> {

    private static final String METHOD_SPLIT_REGEX = "\\s+";

    @Override
    public LeaderboardCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(userInput, PREFIX_TIE_BREAK);
        ArrayList<Comparator<Team>> comparators = new ArrayList<>();

        if (!argumentMultimap.getValue(PREFIX_TIE_BREAK).isPresent()) {
            return new ShowSimpleLeaderboardCommand(comparators);
        }

        String[] tieBreakMethods = argumentMultimap.getValue(PREFIX_TIE_BREAK).get().split(METHOD_SPLIT_REGEX);

        for (String method : tieBreakMethods) {
            if (method.equals(LeaderboardUtil.RANDOM)) {
                continue;
            }
            comparators.add(AlfredParserUtil.getAppropriateComparator(method));
        }
        // Reverse the order of comparators for them to applied in the order users specified.
        Collections.reverse(comparators);

        return AlfredParserUtil.isRandomPresent(tieBreakMethods)
                ? new ShowLeaderboardWithRandomCommand(comparators)
                : new ShowSimpleLeaderboardCommand(comparators);
    }
}
