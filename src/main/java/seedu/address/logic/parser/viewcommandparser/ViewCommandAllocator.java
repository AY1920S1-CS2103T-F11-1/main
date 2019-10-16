package seedu.address.logic.parser.viewcommandparser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import seedu.address.logic.commands.viewcommand.ViewCommand;
import seedu.address.logic.parser.AlfredParserUtil;
import seedu.address.logic.parser.CliSyntax;
import seedu.address.logic.parser.exceptions.ParseException;

public class ViewCommandAllocator {

    public ViewCommand getViewCommand(String arg) throws ParseException {

        String prefix = AlfredParserUtil.getIdPrefix(arg);

        switch (prefix) {
        case CliSyntax.PREFIX_ENTITY_MENTOR:
            return new ViewMentorCommandParser().parse(arg);

        case CliSyntax.PREFIX_ENTITY_PARTICIPANT:
            return new ViewParticipantCommandParser().parse(arg);

        case CliSyntax.PREFIX_ENTITY_TEAM:
            return new ViewTeamCommandParser().parse(arg);

        default:
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ViewCommand.MESSAGE_USAGE));
        }

    }

}
