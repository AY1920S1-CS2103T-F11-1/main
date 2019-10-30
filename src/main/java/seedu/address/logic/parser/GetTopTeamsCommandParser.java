package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIE_BREAK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.util.LeaderboardUtil;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.commands.SimpleTopTeamsCommand;
import seedu.address.logic.commands.TopTeamsRandomCommand;
import seedu.address.logic.commands.TopTeamsCommand;
import seedu.address.logic.commands.leaderboardcommand.ShowLeaderboardWithRandomCommand;
import seedu.address.logic.commands.leaderboardcommand.ShowSimpleLeaderboardCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.entity.Team;

/**
 * Parses input arguments and creates a new GetTopTeamCommand object.
 */
public class GetTopTeamsCommandParser implements Parser<TopTeamsCommand> {

    private static final String METHOD_SPLIT_REGEX = "\\s+";
    private final Logger logger = LogsCenter.getLogger(getClass());

    @Override
    public TopTeamsCommand parse(String userInput) throws ParseException {
        userInput = userInput.trim();
        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(userInput, PREFIX_TIE_BREAK);
        ArrayList<Comparator<Team>> comparators = new ArrayList<>();
        String numberOfTeams = argumentMultimap.getPreamble();

        if (!StringUtil.isNonZeroUnsignedInteger(numberOfTeams)) {
            logger.severe("Invalid value given for K - Value is not a valid positive integer: " + numberOfTeams);
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    TopTeamsCommand.INVALID_VALUE_WARNING));
        }
        int topK = Integer.parseInt(numberOfTeams);

        if (!argumentMultimap.getValue(PREFIX_TIE_BREAK).isPresent()) {
            return new SimpleTopTeamsCommand(topK);
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
                ? new TopTeamsRandomCommand(topK, comparators.toArray(new Comparator[comparators.size()]))
                : new SimpleTopTeamsCommand(topK, comparators.toArray(new Comparator[comparators.size()]));

    }
}
