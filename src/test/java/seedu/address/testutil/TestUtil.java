package seedu.address.testutil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A utility class for test cases.
 */
public class TestUtil {

    /**
     * Folder used for temp files created during testing. Ignored by Git.
     */
    private static final Path SANDBOX_FOLDER = Paths.get("src", "test", "data", "sandbox");

    /**
     * Appends {@code fileName} to the sandbox folder path and returns the resulting path.
     * Creates the sandbox folder if it doesn't exist.
     */
    public static Path getFilePathInSandboxFolder(String fileName) {
        try {
            Files.createDirectories(SANDBOX_FOLDER);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return SANDBOX_FOLDER.resolve(fileName);
    }

    /**
     * Returns the middle index of the person in the {@code alfredModel}'s person list.
     */
    /*public static Index getMidIndex(AlfredModel alfredModel) {
        return Index.fromOneBased(alfredModel.getFilteredPersonList().size() / 2);
    }
    */


    /**
     * Returns the last index of the person in the {@code alfredModel}'s person list.
     */
    /*public static Index getLastIndex(AlfredModel alfredModel) {
        return Index.fromOneBased(alfredModel.getFilteredPersonList().size());
    }*/


    /**
     * Returns the person in the {@code alfredModel}'s person list at {@code index}.
     */
    /*public static Person getPerson(AlfredModel alfredModel, Index index) {
        return alfredModel.getFilteredPersonList().get(index.getZeroBased());
    }

     */
}
