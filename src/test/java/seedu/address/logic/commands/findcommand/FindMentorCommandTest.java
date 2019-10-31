package seedu.address.logic.commands.findcommand;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import seedu.address.commons.exceptions.AlfredException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.testutil.TypicalMentors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

public class FindMentorCommandTest {
    Model modelManager = mock(ModelManager.class);

    @Test
    public void execute_validParameters_success() throws AlfredException {
        when(modelManager.findMentor(any())).thenReturn(
                TypicalMentors.getTypicalMentors());
        doNothing().when(modelManager).updateHistory(any());
        FindMentorCommand command = new FindMentorCommand(
                Optional.empty(),
                Optional.of("email"),
                Optional.empty(),
                Optional.empty()
        );
        String expectedMessage = FindMentorCommand.MESSAGE_SUCCESS;

        assertCommandSuccess(command,
                this.modelManager, expectedMessage, this.modelManager);
    }

    @Test
    public void execute_multipleValidParameters_success() throws AlfredException {
        when(modelManager.findMentor(any())).thenReturn(
                TypicalMentors.getTypicalMentors());
        doNothing().when(modelManager).updateHistory(any());
        FindMentorCommand command = new FindMentorCommand(
                Optional.of("P"),
                Optional.of("example"),
                Optional.empty(),
                Optional.empty()
        );
        String expectedMessage = FindMentorCommand.MESSAGE_SUCCESS;

        assertCommandSuccess(command,
                this.modelManager, expectedMessage, this.modelManager);
    }
}
