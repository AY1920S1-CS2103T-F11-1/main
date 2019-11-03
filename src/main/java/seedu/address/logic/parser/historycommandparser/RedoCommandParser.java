package seedu.address.logic.parser.historycommandparser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.historycommand.RedoCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses the input arguments and returns the appropriate RedoCommand object.
 */
public class RedoCommandParser implements Parser<RedoCommand> {
    private static final String ARGUMENT_REGEX = "^[1-9]$|^[1-4][0-9]$"; //Matches any integer from 1 to 49

    /**
     * Parses the given {@code String} of arguments in the context of a RedoCommand
     * and returns an appropriate RedoCommand tailored to the arguments for execution.
     * @param args the arguments to be parsed by RedoCommandParser
     * @return a RedoCommand specific to the input arguments for execution.
     * @throws ParseException if the args do not conform to the expected format for the RedoCommand.
     */
    public RedoCommand parse(String args) throws ParseException {
        args = args.trim();

        if (args.equals("")) {
            return new RedoCommand(1);
        } else if (args.matches(ARGUMENT_REGEX)) {
            return new RedoCommand(Integer.parseInt(args));
        } else {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                                                   RedoCommand.MESSAGE_USAGE));
        }
    }
}
