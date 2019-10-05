package seedu.address.logic.parser.DeleteCommandParsers;

import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.deletecommand.DeleteTeamCommand;
import seedu.address.logic.parser.AlfredParserUtil;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.PrefixType;


/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteTeamCommandParser implements Parser<DeleteCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteTeamCommand parse(String args) throws ParseException {
        try {
            Id id = AlfredParserUtil.parseIndex(args, PrefixType.T);
            return new DeleteTeamCommand(id);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE), pe);
        }
    }

}
