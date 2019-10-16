package seedu.address.logic.parser.viewcommandparser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.viewcommand.ViewParticipantCommand;
import seedu.address.logic.commands.viewcommand.ViewTeamCommand;
import seedu.address.logic.parser.AlfredParserUtil;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.PrefixType;
import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class ViewTeamCommandParser implements Parser<ViewTeamCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ViewTeamCommand parse(String args) throws ParseException {
        Id id;

        try {
            id = AlfredParserUtil.parseIndex(args, PrefixType.T);
        }
        catch (ParseException p) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ViewTeamCommand.MESSAGE_USAGE), p);
        }
        return new ViewTeamCommand(id);
    }
}
