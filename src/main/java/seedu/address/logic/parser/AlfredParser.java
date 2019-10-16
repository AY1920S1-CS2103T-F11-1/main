package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.addcommand.AddMentorCommand;
import seedu.address.logic.commands.addcommand.AddParticipantCommand;
import seedu.address.logic.commands.addcommand.AddTeamCommand;
import seedu.address.logic.commands.deletecommand.DeleteMentorCommand;
import seedu.address.logic.commands.deletecommand.DeleteParticipantCommand;
import seedu.address.logic.commands.deletecommand.DeleteTeamCommand;
import seedu.address.logic.commands.editcommand.EditMentorCommand;
import seedu.address.logic.commands.editcommand.EditParticipantCommand;
import seedu.address.logic.commands.editcommand.EditTeamCommand;
import seedu.address.logic.parser.addcommandparser.AddMentorCommandParser;
import seedu.address.logic.parser.addcommandparser.AddParticipantCommandParser;
import seedu.address.logic.parser.addcommandparser.AddTeamCommandParser;
import seedu.address.logic.parser.deletecommandparser.DeleteMentorCommandParser;
import seedu.address.logic.parser.deletecommandparser.DeleteParticipantCommandParser;
import seedu.address.logic.parser.deletecommandparser.DeleteTeamCommandParser;
import seedu.address.logic.parser.editcommandparser.EditMentorCommandParser;
import seedu.address.logic.parser.editcommandparser.EditParticipantCommandParser;
import seedu.address.logic.parser.editcommandparser.EditTeamCommandParser;
import seedu.address.logic.parser.exceptions.ParseException;

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

        case AddParticipantCommand.COMMAND_WORD:
            logger.info("Adding a new Participant...");
            return new AddParticipantCommandParser().parse(arguments);

            //Dummy cases so that GUI works
        case AddTeamCommand.COMMAND_WORD:
            logger.info("Adding a new Team...");
            return new AddTeamCommandParser().parse(arguments);

        case AddMentorCommand.COMMAND_WORD:
            logger.info("Adding a new Mentor...");
            return new AddMentorCommandParser().parse(arguments);

        case AddCommand.COMMAND_WORD:
            logger.info("Add a new person(in old AddressBook...");
            return new AddCommandParser().parse(arguments);

        case EditParticipantCommand.COMMAND_WORD:
            logger.info("Editing an existing Participant...");
            return new EditParticipantCommandParser().parse(arguments);

        case EditTeamCommand.COMMAND_WORD:
            logger.info("Editing an existing Team...");
            return new EditTeamCommandParser().parse(arguments);

        case EditMentorCommand.COMMAND_WORD:
            logger.info("Editing an existing mentor...");
            return new EditMentorCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            logger.info("Editing an existing person(in old AddressBook)..");
            return new EditCommandParser().parse(arguments);

        case DeleteParticipantCommand.COMMAND_WORD:
            logger.info("Deleting an existing Participant...");
            return new DeleteParticipantCommandParser().parse(arguments);

        case DeleteTeamCommand.COMMAND_WORD:
            logger.info("Deleting an existing Team...");
            return new DeleteTeamCommandParser().parse(arguments);

        case DeleteMentorCommand.COMMAND_WORD:
            logger.info("Deleting an existing Mentor...");
            return new DeleteMentorCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            logger.info("Deleting an existing person(in old AddressBook)..");
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        default:
            logger.info("Unknown command type: " + commandWord);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
