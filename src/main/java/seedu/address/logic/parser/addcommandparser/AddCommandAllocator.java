package seedu.address.logic.parser.addcommandparser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.addcommand.AddCommand;
import seedu.address.logic.parser.AlfredParserUtil;
import seedu.address.logic.parser.CliSyntax;
import seedu.address.logic.parser.CommandAllocator;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Allocates the user's add command input to the correct parser in order to
 * call the appropriate entity's add parser.
 */
public class AddCommandAllocator implements CommandAllocator<AddCommand> {

    @Override
    public AddCommand allocate(String userInput) throws ParseException {

        String entity = AlfredParserUtil.getEntityFromCommand(userInput, AddCommand.MESSAGE_USAGE);
        String args = AlfredParserUtil.getArgumentsFromCommand(userInput, AddCommand.MESSAGE_USAGE);

        System.out.println(entity);

        switch (entity) {

        case CliSyntax.ENTITY_MENTOR:
            return new AddMentorCommandParser().parse(args);

        case CliSyntax.ENTITY_PARTICIPANT:
            return new AddParticipantCommandParser().parse(args);

        case CliSyntax.ENTITY_TEAM:
            return new AddTeamCommandParser().parse(args);

        default:
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));

        }


    }

}
