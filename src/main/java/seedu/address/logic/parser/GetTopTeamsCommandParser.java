package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LOCATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIE_BREAK;

import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.commands.GetTopTeamsCommand;
import seedu.address.logic.commands.GetTopTeamsRandomCommand;
import seedu.address.logic.commands.TopTeamsCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new GetTopTeamCommand object.
 */
public class GetTopTeamsCommandParser implements Parser<TopTeamsCommand> {

    private final Logger logger = LogsCenter.getLogger(getClass());

    @Override
    public TopTeamsCommand parse(String userInput) throws ParseException {
        userInput = userInput.trim();
        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(userInput, PREFIX_TIE_BREAK);
        String numberOfTeams = argumentMultimap.getPreamble();

        if (!StringUtil.isNonZeroUnsignedInteger(numberOfTeams)) {
            logger.severe("Invalid value given for K - Value is not a valid positive integer: " + numberOfTeams);
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    TopTeamsCommand.INVALID_VALUE_WARNING));
        }
        int topK = Integer.parseInt(numberOfTeams);

        if (!argumentMultimap.getValue(PREFIX_TIE_BREAK).isPresent()) {
            return new GetTopTeamsCommand(topK);
        }
        if (argumentMultimap.getValue(PREFIX_TIE_BREAK).get().equals(GetTopTeamsRandomCommand.APPLY_WORD)) {
            return new GetTopTeamsRandomCommand(topK);
        }
        throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, TopTeamsCommand.INVALID_TIE_BREAK));

    }
}
