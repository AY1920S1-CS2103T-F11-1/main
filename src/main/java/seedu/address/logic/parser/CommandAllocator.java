package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public interface CommandAllocator<T extends Command> {

    /**
     * Parses {@code userInput} to determine which specific parser to call for the specific
     * user command and accordingly returns the corresponding command.
     * @throws ParseException if {@code userInput} does not conform the expected format
     */
    T allocate(String userInput) throws ParseException;
}
