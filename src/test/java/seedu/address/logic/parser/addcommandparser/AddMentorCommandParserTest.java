package seedu.address.logic.parser.addcommandparser;

import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.ORGANIZATION_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.SUBJECT_DESC_BOB;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalMentors.BOB;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.addcommand.AddMentorCommand;
import seedu.address.model.entity.Mentor;
import seedu.address.testutil.MentorBuilder;

class AddMentorCommandParserTest {

    private AddMentorCommandParser parser = new AddMentorCommandParser();

    @Disabled
    @Test
    void parse_allFieldsPresent_success() {
        Mentor expectedMentor = new MentorBuilder(BOB).build();

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_BOB + PHONE_DESC_BOB + EMAIL_DESC_BOB
                + SUBJECT_DESC_BOB + ORGANIZATION_DESC_BOB, new AddMentorCommand(expectedMentor));

        // multiple names - last name accepted
        assertParseSuccess(parser, NAME_DESC_AMY + NAME_DESC_BOB + PHONE_DESC_BOB + EMAIL_DESC_BOB
                + SUBJECT_DESC_BOB + ORGANIZATION_DESC_BOB, new AddMentorCommand(expectedMentor));

    }
}