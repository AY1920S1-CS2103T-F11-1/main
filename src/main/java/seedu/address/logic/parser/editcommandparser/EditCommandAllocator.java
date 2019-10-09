package seedu.address.logic.parser.editcommandparser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import seedu.address.logic.commands.editcommand.EditCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.CliSyntax;
import seedu.address.logic.parser.exceptions.ParseException;

public class EditCommandAllocator {

    public EditCommand getEditCommand(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args);
        String id = argMultimap.getPreamble();
        String idPrefix = Character.toString(id.charAt(0));

        switch (idPrefix) {

        case CliSyntax.ENTITY_PARTICIPANT:
            return new EditParticipantCommandParser().parse(args);

        case CliSyntax.ENTITY_MENTOR:
            return new EditMentorCommandParser().parse(args);

        case CliSyntax.ENTITY_TEAM:
            return new EditTeamCommandParser().parse(args);

        default:
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    seedu.address.logic.commands.EditCommand.MESSAGE_USAGE));
        }
    }
}
