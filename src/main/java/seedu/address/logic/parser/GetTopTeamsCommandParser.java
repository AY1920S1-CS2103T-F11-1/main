package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.commands.GetTopTeamsCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new GetTopTeamCommand object.
 */
public class GetTopTeamsCommandParser implements Parser<GetTopTeamsCommand> {

    private final Logger logger = LogsCenter.getLogger(getClass());

    @Override
    public GetTopTeamsCommand parse(String userInput) throws ParseException {
        userInput = userInput.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(userInput)) {
            logger.severe("Invalid value given for K - Value is not a valid positive integer.");
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, GetTopTeamsCommand.MESSAGE_USAGE));
        }

        int topK = Integer.parseInt(userInput);
        return new GetTopTeamsCommand(topK);
    }
}
