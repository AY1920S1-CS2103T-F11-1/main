package seedu.address.logic.parser.scorecommandparser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.scorecommand.ScoreCommand;
import seedu.address.logic.commands.scorecommand.SubtractScoreCommand;
import seedu.address.logic.parser.AlfredParserUtil;
import seedu.address.logic.parser.CliSyntax;
import seedu.address.logic.parser.CommandAllocator;
import seedu.address.logic.parser.exceptions.ParseException;

public class ScoreCommandAllocator implements CommandAllocator<ScoreCommand> {

    @Override
    public ScoreCommand allocate(String userInput) throws ParseException {

        String entity = AlfredParserUtil.getEntityFromCommand(userInput, ScoreCommand.MESSAGE_USAGE);
        String args = AlfredParserUtil.getArgumentsFromCommand(userInput, ScoreCommand.MESSAGE_USAGE);

        switch (entity) {
            case CliSyntax.SCORE_ADD:
                return new AddScoreCommandParser().parse(args);

            case CliSyntax.SCORE_UPDATE:
                return new SetScoreCommandParser().parse(args);

            case CliSyntax.SCORE_SUBTRACT:
                return new SubtractScoreCommandParser().parse(args);

            default:
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                        ScoreCommand.MESSAGE_USAGE));
        }
    }
}
