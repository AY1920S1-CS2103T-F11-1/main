package seedu.address.logic.parser.deletecommandparser;

import seedu.address.logic.commands.deletecommand.DeleteCommand;
import seedu.address.logic.commands.deletecommand.DeleteTeamCommand;
import seedu.address.logic.parser.AlfredParserUtil;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.PrefixType;


/**
 * Parses input arguments and creates a new {@link DeleteTeamCommand} object.
 */
public class DeleteTeamCommandParser implements Parser<DeleteCommand> {

    private static final String MESSAGE_USAGE = "Wrong usage.";

    /**
     * Parses the given {@code String} of arguments in the context of the {@code DeleteTeamCommand}
     * and returns a {@code DeleteTeamCommand} object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteTeamCommand parse(String args) throws ParseException {
        try {
            Id id = AlfredParserUtil.parseIndex(args, PrefixType.T);
            return new DeleteTeamCommand(id);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(DeleteTeamCommand.MESSAGE_INVALID_TEAM_DISPLAYED_INDEX), pe);
        }
    }

}
