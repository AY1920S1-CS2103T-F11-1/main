package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.PrefixType;

class AlfredParserUtilTest {

    @Test
    void parseIndex() throws ParseException {
        Id id = new Id(PrefixType.P, 2);
        assertEquals(id, AlfredParserUtil.parseIndex("P2", PrefixType.P));
    }
}