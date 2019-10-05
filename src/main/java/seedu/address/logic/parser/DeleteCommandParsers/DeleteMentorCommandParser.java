package seedu.address.logic.parser.DeleteCommandParsers;

import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.deletecommand.DeleteTeamCommand;
import seedu.address.logic.parser.AlfredParserUtil;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.PrefixType;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteMentorCommandParser implements Parser<DeleteCommand> {

    @Override
    public DeleteCommand parse(String args) throws ParseException {
        try {
            Id id = 
            return new DeleteTeamCommand(id);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE), pe);
        }
    }

}
