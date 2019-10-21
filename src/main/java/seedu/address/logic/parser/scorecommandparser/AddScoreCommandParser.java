package seedu.address.logic.parser.scorecommandparser;

import seedu.address.logic.commands.scorecommand.AddScoreCommand;
import seedu.address.logic.parser.AlfredParserUtil;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.PrefixType;
import seedu.address.model.entity.Score;

public class AddScoreCommandParser implements Parser<AddScoreCommand> {

    @Override
    public AddScoreCommand parse(String args) throws ParseException {
        String score;
        String id;
        Id teamId;
        Score teamScore;
        System.out.println(args);

        try {
            id = AlfredParserUtil.getEntityFromCommand(args, "Won't be here.");
            score = AlfredParserUtil.getArgumentsFromCommand(args, "Won't be here.");
            teamId = AlfredParserUtil.parseIndex(id, PrefixType.T);
            teamScore = AlfredParserUtil.parseScore(score);
        } catch (ParseException pe) {
            throw new ParseException(String.format(pe.getMessage(), AddScoreCommand.MESSAGE_USAGE));
        }
        return new AddScoreCommand(teamId, teamScore);
    }

}
