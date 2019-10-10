package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.io.TempDir;

import seedu.address.model.entity.Mentor;
import seedu.address.model.entitylist.MentorList;
import seedu.address.testutil.TypicalMentors;

class JsonMentorListStorageTest {
    @TempDir
    public Path testFolder;

    @org.junit.jupiter.api.Test
    void readAndSaveMentorList_allInOrder_success() throws Exception {
        Path filePath = testFolder.resolve("TempMentorList.json");
        MentorList original = TypicalMentors.getTypicalMentorList();
        JsonMentorListStorage mStorage = new JsonMentorListStorage(filePath);

        //Save and read participantList to and from JSON
        mStorage.saveMentorList(original);
        mStorage.saveMentorList(original, Paths.get("data" , "mentorlist.json"));
        Optional<MentorList> returnedList = mStorage.readMentorList();

        if (returnedList.isEmpty()) {
            fail("Mentor List read from storage is empty. Optional<MentorList> is empty.");
        } else {
            List<Mentor> returnedMentorList = returnedList.get().getSpecificTypedList();
            assertEquals(returnedMentorList, TypicalMentors.getTypicalMentors());
        }
    }

}
