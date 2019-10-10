package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.io.TempDir;

import seedu.address.model.entity.Team;
import seedu.address.model.entitylist.TeamList;
import seedu.address.testutil.TypicalTeams;

class JsonTeamListStorageTest {
    @TempDir
    public Path testFolder;

    @org.junit.jupiter.api.Test
    void readAndSaveTeamList_allInOrder_success() throws Exception {
        Path filePath = testFolder.resolve("TempTeamList.json");
        TeamList original = TypicalTeams.getTypicalTeamList();
        JsonTeamListStorage tStorage = new JsonTeamListStorage(filePath);

        //Save and read participantList to and from JSON
        tStorage.saveTeamList(original);
        tStorage.saveTeamList(original, Paths.get("data" , "teamlist.json"));
        Optional<TeamList> returnedList = tStorage.readTeamList();

        if (returnedList.isEmpty()) {
            fail("Team List read from storage is empty. Optional<TeamList> is empty.");
        } else {
            List<Team> returnedTeamList = returnedList.get().getSpecificTypedList();
            assertEquals(returnedTeamList, TypicalTeams.getTypicalTeams());
        }
    }
}
