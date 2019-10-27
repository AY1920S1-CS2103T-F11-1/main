package seedu.address.logic.parser.findcommandparser;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.findcommand.FindParticipantCommand;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.PrefixType;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

public class FindParticipantParserTest {
    private FindParticipantCommandParser findParticipantParser = new FindParticipantCommandParser();
    private Id id = new Id(PrefixType.P, 1);

    @Test
    public void parse_validArgs_returnsFindCommand() {
        assertParseSuccess(findParticipantParser, "participant n/ifje",
                new FindParticipantCommand(Optional.of("ifje"),
                        Optional.empty(),
                        Optional.empty()));
    }

    @Test
    public void parse_inValidArgs_throwsParseException() {
        // No command provided
        assertParseFailure(findParticipantParser, "", String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, FindParticipantCommand.MESSAGE_USAGE));
    }
}
