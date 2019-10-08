package seedu.address.logic.parser.editcommandparser;

import static java.util.Objects.compare;
import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ORGANISATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SUBJECT_NAME;

import seedu.address.logic.commands.editcommand.EditCommand;
import seedu.address.logic.commands.editcommand.EditMentorCommand;
import seedu.address.logic.parser.AlfredParserUtil;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.PrefixType;

/**
 * Parses input arguments and creates a new {@link EditMentorCommand} object.
 */
public class EditMentorCommandParser implements Parser<EditCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the {@code EditMentorCommand}
     * and returns an {@code EditMentorCommand} object for execution.
     * @throws ParseException if the user input does not conform the expected format.
     */
    public EditMentorCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ORGANISATION,
                        PREFIX_SUBJECT_NAME);
        Id id;

        try {
            id = AlfredParserUtil.parseIndex(argMultimap.getPreamble(), PrefixType.M);
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    seedu.address.logic.commands.EditCommand.MESSAGE_USAGE), pe);
        }

        return null;
    }
}
