package seedu.address.logic.parser;

import seedu.address.logic.commands.Command;
import seedu.address.logic.parser.exceptions.ParseException;

public interface CommandAllocator<T extends Command> {

    /**
     * Parses {@code userInput} to determine which specific parser to call for the specific
     * user command and accordingly returns the corresponding command.
     * @throws ParseException if {@code userInput} does not conform the expected format
     */
    T allocate(String userInput) throws ParseException;

}
