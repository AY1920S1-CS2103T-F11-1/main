package seedu.address.logic.parser.scorecommandparser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.scorecommand.SubtractScoreCommand;
import seedu.address.logic.parser.AlfredParserUtil;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.entity.CommandType;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.PrefixType;
import seedu.address.model.entity.Score;

/**
 * Parses input arguments and creates a new {@link SubtractScoreCommand} object.
 */
public class SubtractScoreCommandParser implements Parser<SubtractScoreCommand> {

    @Override
    public SubtractScoreCommand parse(String args) throws ParseException {
        String score;
        String id;
        Id teamId;
        Score teamScore;

        try {
            id = AlfredParserUtil.getSpecifierFromCommand(args);
            score = AlfredParserUtil.getArgumentsFromCommand(args);
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    SubtractScoreCommand.MESSAGE_USAGE));
        }

        teamId = AlfredParserUtil.parseIndex(id, PrefixType.T);
        teamScore = AlfredParserUtil.parseScore(score);

        return new SubtractScoreCommand(teamId, teamScore);
    }

}
