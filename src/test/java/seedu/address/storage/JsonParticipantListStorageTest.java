package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.io.TempDir;

import seedu.address.model.entity.Participant;
import seedu.address.model.entitylist.ParticipantList;
import seedu.address.testutil.TypicalParticipants;

class JsonParticipantListStorageTest {
    @TempDir
    public Path testFolder;

    @org.junit.jupiter.api.Test
    void readAndSaveParticipantList_allInOrder_success() throws Exception {
        Path filePath = testFolder.resolve("TempParticipantList.json");
        ParticipantList original = TypicalParticipants.getTypicalParticipantList();
        JsonParticipantListStorage pStorage = new JsonParticipantListStorage(filePath);

        //Save and read participantList to and from JSON
        pStorage.saveParticipantList(original);
        Optional<ParticipantList> returnedList = pStorage.readParticipantList();

        if (returnedList.isEmpty()) {
            fail("Participant List read from storage is empty. Optional<ParticipantList> is empty.");
        } else {
            List<Participant> returnedParticipantList = returnedList.get().getSpecificTypedList();
            assertEquals(returnedParticipantList, TypicalParticipants.getTypicalParticipants());
        }
    }




    //
    //@org.junit.jupiter.api.Test
    //void getParticipantListFilePath() {
    //    Name n = new Name("p one");
    //    Id i = new Id(PrefixType.P, 1);
    //    Email e = new Email("p1@gmail.com");
    //    Phone p = new Phone("91231233");
    //    Participant p1 = new Participant(new Name("p one"),
    //                                     new Id(PrefixType.P, 1),
    //                                     new Email("p1@gmail.com"),
    //                                     new Phone("91231233"));
    //    Participant p2 = new Participant(new Name("p two"),
    //            new Id(PrefixType.P, 2),
    //            new Email("p2@gmail.com"),
    //            new Phone("92222222"));
    //    Participant p3 = new Participant(new Name("p three"),
    //            new Id(PrefixType.P, 3),
    //            new Email("p3@gmail.com"),
    //            new Phone("93333333"));
    //
    //    ParticipantList pList = new ParticipantList();
    //    try {
    //        pList.add(p1);
    //        pList.add(p2);
    //        pList.add(p3);
    //    } catch (AlfredException ae) {
    //        System.out.println("Oops");
    //    }
    //
    //    JsonParticipantListStorage j = new JsonParticipantListStorage(Paths.get("data" , "participantlist.json"));
    //    try {
    //        j.saveParticipantList(pList);
    //    } catch (IOException io) {
    //        fail("Problem saving Participant List");
    //    }
    //
    //    try {
    //        ParticipantList newPList = j.readParticipantList(Paths.get("data", "participantlist.json")).get();
    //        List<Participant> newList = newPList.getSpecificTypedList();
    //        List<Participant> origList = pList.getSpecificTypedList();
    //        assertEquals(newList.get(0).getEmail(), origList.get(0).getEmail());
    //        assertEquals(newList.get(0).getName(), origList.get(0).getName());
    //        assertEquals(newList.get(0).getId(), origList.get(0).getId());
    //        assertEquals(newList.get(0).getPhone(), origList.get(0).getPhone());
    //        assertEquals(newList, origList);
    //        //assertEquals(newList, pList.getSpecificTypedList());
    //    } catch (Exception newE) {
    //        fail("Exception encountered reading ParticipantList: " + newE.getMessage());
    //    }
    //
    //
    //
    //}

    //@org.junit.jupiter.api.Test
    //void readParticipantList() {
    //}
    //
    //@org.junit.jupiter.api.Test
    //void testReadParticipantList() {
    //}
    //
    //@org.junit.jupiter.api.Test
    //void saveParticipantList() {
    //}
    //
    //@org.junit.jupiter.api.Test
    //void testSaveParticipantList() {
    //}
}
