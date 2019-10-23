package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.commands.GetTopTeamsCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class GetTopTeamsCommandParser implements Parser<GetTopTeamsCommand> {


    @Override
    public GetTopTeamsCommand parse(String userInput) throws ParseException {
        if (! StringUtil.isNonZeroUnsignedInteger(userInput)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, GetTopTeamsCommand.MESSAGE_USAGE));
        }

        int topK = Integer.parseInt(userInput.trim());
        return new GetTopTeamsCommand(topK);
    }
}
