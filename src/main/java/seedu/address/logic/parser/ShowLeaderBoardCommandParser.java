package seedu.address.logic.parser;

import static seedu.address.logic.parser.CliSyntax.PREFIX_TIE_BREAK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import seedu.address.logic.commands.ShowLeaderboardCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.entity.Team;

public class ShowLeaderBoardCommandParser implements Parser<ShowLeaderboardCommand> {

    private static final String METHOD_SPLIT_REGEX = "\\s+";

    @Override
    public ShowLeaderboardCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(userInput, PREFIX_TIE_BREAK);

        if (!argumentMultimap.getValue(PREFIX_TIE_BREAK).isPresent()) {
            return new ShowLeaderboardCommand();
        }

        String[] tieBreakMethods = argumentMultimap.getValue(PREFIX_TIE_BREAK).get().split(METHOD_SPLIT_REGEX);
        ArrayList<Comparator<Team>> comparators = new ArrayList<>();

        for (String method : tieBreakMethods) {
            comparators.add(AlfredParserUtil.getAppropriateComparator(method));
        }
        // Reverse the order of comparators for them to applied in the order users specified.
        Collections.reverse(comparators);
        return new ShowLeaderboardCommand(comparators.toArray(new Comparator[comparators.size()]));
    }
}
