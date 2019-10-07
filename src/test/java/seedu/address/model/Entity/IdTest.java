package seedu.address.model.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.PrefixType;

public class IdTest {
    @Test
    public void id_equals_returnTrue() {
        assertEquals(new Id(PrefixType.P, 1), new Id(PrefixType.P, 1));
    }
}
