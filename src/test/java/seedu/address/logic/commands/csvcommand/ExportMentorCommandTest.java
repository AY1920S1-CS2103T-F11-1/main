package seedu.address.logic.commands.csvcommand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import seedu.address.commons.exceptions.AlfredException;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.stub.ModelManagerStub;
import seedu.address.testutil.FileUtil;
import seedu.address.testutil.TestUtil;
import seedu.address.testutil.TypicalMentors;

public class ExportMentorCommandTest {

    /**
     * Initializes mentor list.
     */
    private void initializeMentors(Model model) throws AlfredException {
        model.addMentor(TypicalMentors.A);
        model.addMentor(TypicalMentors.B);
        model.addMentor(TypicalMentors.C);
    }

    @Test
    public void equals_sameCommands_returnTrue() throws CommandException {
        // Same command returns true
        ExportMentorCommand command1 = new ExportMentorCommand("src/main/test", "Alfred.csv");
        assertEquals(command1, command1);

        // Same parameter returns true
        ExportMentorCommand command2 = new ExportMentorCommand("src/main/test", "Alfred.csv");
        assertEquals(command1, command2);

        // Empty strings result in default names
        command1 = new ExportMentorCommand("", "");
        command2 = new ExportMentorCommand(
                ExportMentorCommand.DEFAULT_FILE_PATH,
                ExportMentorCommand.DEFAULT_FILE_NAME
        );
        assertEquals(command1, command2);

        // Path ending with File.separator has no difference on the outcome
        String filePath = ".";
        command1 = new ExportMentorCommand(filePath + File.separator, "Alfred.csv");
        command2 = new ExportMentorCommand(filePath, "Alfred.csv");
        assertEquals(command1, command2);
    }

    @Test
    public void equals_differentCommands_returnFalse() throws CommandException {
        // Different class returns false
        ExportMentorCommand command1 = new ExportMentorCommand("src/main/test", "Alfred.csv");
        ExportParticipantCommand exportParticipantCommand = new ExportParticipantCommand(
                "src/main/test",
                "Alfred.csv"
        );
        assertNotEquals(command1, exportParticipantCommand);

        // Different parameters returns false
        ExportMentorCommand command2 = new ExportMentorCommand("src/main/test", "Alfred1.csv");
        assertNotEquals(command1, command2);
    }

    @Test
    public void constructor_nonCsvFilePassed_assertionErrorThrown() {
        String fileName = "Alfred.txt";
        assertThrows(AssertionError.class, () -> new ExportMentorCommand("", fileName));
    }

    @Test
    public void constructor_invalidFilePathPassed_throwsCommandException() throws AlfredException {
        Model model = new ModelManagerStub();
        initializeMentors(model);
        String invalidFilePath = "::";
        Executable execute = () -> new ExportMentorCommand(invalidFilePath, "");
        assertThrows(CommandException.class, execute);
    }

    @Test
    public void execute_emptyModelPassed_successWithNoFileCreated() throws AlfredException {
        Model emptyModel = new ModelManagerStub();
        String filePath = TestUtil.getFilePathInCsvUtilTestFolder("").toString();
        String fileName = "Alfred.csv";
        assertEquals(
                ExportMentorCommand.MESSAGE_EMPTY_DATA,
                new ExportMentorCommand(filePath, fileName).execute(emptyModel).getFeedbackToUser()
        );
        assertFalse(TestUtil.getFilePathInCsvUtilTestFolder(fileName).toFile().exists());
    }

    @Test
    public void execute_validParametersPassed_success() throws AlfredException, IOException {
        Model model = new ModelManagerStub();
        initializeMentors(model);

        File expectedFile = TestUtil.getFilePathInCsvUtilTestFolder("ExpectedMentors.csv").toFile();
        String filePath = TestUtil.getFilePathInSandboxFolder("").toString();
        String fileName = "Alfred.csv";
        String expectedMessage = String.format(
                ExportMentorCommand.MESSAGE_SUCCESS,
                filePath + File.separator + fileName
        );

        assertEquals(expectedMessage, new ExportMentorCommand(filePath, fileName).execute(model).getFeedbackToUser());

        File outcomeFile = TestUtil.getFilePathInSandboxFolder("Alfred.csv").toFile();
        outcomeFile.deleteOnExit();
        assertTrue(FileUtil.hasEqualContents(expectedFile, outcomeFile));
    }

}