package seedu.address.logic.parser.scorecommandparser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import seedu.address.logic.commands.scorecommand.SetScoreCommand;
import seedu.address.logic.parser.AlfredParserUtil;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.PrefixType;
import seedu.address.model.entity.Score;

public class SetScoreCommandParser implements Parser<SetScoreCommand> {


    @Override
    public SetScoreCommand parse(String args) throws ParseException {
        String score;
        String id;
        Id teamId;
        Score teamScore;

        try {
            id = AlfredParserUtil.getEntityFromCommand(args, "Won't be here.");
            score = AlfredParserUtil.getArgumentsFromCommand(args, "Won't be here.");
            teamId = AlfredParserUtil.parseIndex(id, PrefixType.T);
            teamScore = AlfredParserUtil.parseScore(score);
        } catch (ParseException pe) {
            throw new ParseException(String.format(pe.getMessage(), SetScoreCommand.MESSAGE_USAGE));
        }
        return new SetScoreCommand(teamId, teamScore);
    }
}
