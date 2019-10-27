package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.GetTopTeamsCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ShowLeaderboardCommand;
import seedu.address.logic.commands.addcommand.AddCommand;
import seedu.address.logic.commands.csvcommand.ExportCommand;
import seedu.address.logic.commands.csvcommand.ImportCommand;
import seedu.address.logic.commands.deletecommand.DeleteCommand;
import seedu.address.logic.commands.findcommand.FindCommand;
import seedu.address.logic.commands.historycommand.HistoryCommand;
import seedu.address.logic.commands.historycommand.RedoCommand;
import seedu.address.logic.commands.historycommand.UndoCommand;
import seedu.address.logic.commands.listcommand.ListCommand;
import seedu.address.logic.commands.viewcommand.ViewCommand;
import seedu.address.logic.parser.addcommandparser.AddCommandAllocator;
import seedu.address.logic.parser.csvcommandparser.ExportCommandParser;
import seedu.address.logic.parser.csvcommandparser.ImportCommandParser;
import seedu.address.logic.parser.deletecommandparser.DeleteCommandAllocator;
import seedu.address.logic.parser.editcommandparser.EditCommandAllocator;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.findcommandparser.FindCommandAllocator;
import seedu.address.logic.parser.listcommandparser.ListCommandParser;
import seedu.address.logic.parser.viewcommandparser.ViewCommandAllocator;

/**
 * Parses user input.
 */
public class AlfredParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    private final Logger logger = LogsCenter.getLogger(AlfredParser.class);

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full   input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        logger.info("Finding command type of " + commandWord);
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandAllocator().allocate(arguments);

        case FindCommand.COMMAND_WORD:
            return new FindCommandAllocator().allocate(arguments);

        case DeleteCommand.COMMAND_WORD:
            logger.info("Deleting an existing Participant...");
            return new DeleteCommandAllocator().allocate(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommandParser().parse(arguments);

        case ShowLeaderboardCommand.COMMAND_WORD:
            return new ShowLeaderboardCommand();

        case GetTopTeamsCommand.COMMAND_WORD:
            return new GetTopTeamsCommandParser().parse(arguments);

        case ViewCommand.COMMAND_WORD:
            return new ViewCommandAllocator().allocate(arguments);

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case ImportCommand.COMMAND_WORD:
            return new ImportCommandParser().parse(arguments);

        case ExportCommand.COMMAND_WORD:
            return new ExportCommandParser().parse(arguments);

        case UndoCommand.COMMAND_WORD:
            return new UndoCommand();

        case RedoCommand.COMMAND_WORD:
            return new RedoCommand();

        case HistoryCommand.COMMAND_WORD:
            return new HistoryCommand();

        case EditCommand.COMMAND_WORD:
            logger.info("Editing an existing Entity...");
            return new EditCommandAllocator().allocate(arguments);

        default:
            logger.info("Unknown command type: " + commandWord);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
