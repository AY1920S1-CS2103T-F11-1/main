package seedu.address.logic.parser.DeleteCommandParsers;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import seedu.address.logic.commands.deletecommand.DeleteCommand;
import seedu.address.logic.commands.deletecommand.DeleteMentorCommand;
import seedu.address.logic.parser.AlfredParserUtil;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.PrefixType;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteMentorCommandParser implements Parser<DeleteCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteMentorCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteMentorCommand parse(String args) throws ParseException {
        try {
            Id id = AlfredParserUtil.parseIndex(args, PrefixType.M);
            return new DeleteMentorCommand(id);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteMentorCommand.MESSAGE_USAGE), pe);
        }
    }

}
