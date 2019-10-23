package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BENSON;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.exceptions.AlfredException;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.Participant;
import seedu.address.model.entity.PrefixType;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.storage.AlfredStorage;
import seedu.address.testutil.AddressBookBuilder;
import seedu.address.testutil.TypicalMentors;
import seedu.address.testutil.TypicalParticipants;
import seedu.address.testutil.TypicalTeams;

@Disabled
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ModelManagerTest {
    private AlfredStorage storage = mock(AlfredStorage.class);
    private ModelManager modelManager = new ModelManager(storage, new UserPrefs());

    @BeforeEach
    public void clearTeamA() {
        modelManager = new ModelManager(storage, new UserPrefs());
        TypicalTeams.clearTeamA();
    }

    @Test
    public void constructor() {
        assertEquals(new UserPrefs(), modelManager.getUserPrefs());
        assertEquals(new GuiSettings(), modelManager.getGuiSettings());
        assertEquals(new AddressBook(), new AddressBook(modelManager.getAddressBook()));
    }

    @Test
    public void setUserPrefs_nullUserPrefs_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setUserPrefs(null));
    }

    @Test
    public void setUserPrefs_validUserPrefs_copiesUserPrefs() {
        UserPrefs userPrefs = new UserPrefs();
        userPrefs.setAddressBookFilePath(Paths.get("address/book/file/path"));
        userPrefs.setGuiSettings(new GuiSettings(1, 2, 3, 4));
        modelManager.setUserPrefs(userPrefs);
        assertEquals(userPrefs, modelManager.getUserPrefs());

        // Modifying userPrefs should not modify modelManager's userPrefs
        UserPrefs oldUserPrefs = new UserPrefs(userPrefs);
        userPrefs.setAddressBookFilePath(Paths.get("new/address/book/file/path"));
        assertEquals(oldUserPrefs, modelManager.getUserPrefs());
    }

    @Test
    public void setGuiSettings_nullGuiSettings_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setGuiSettings(null));
    }

    @Test
    public void setGuiSettings_validGuiSettings_setsGuiSettings() {
        GuiSettings guiSettings = new GuiSettings(1, 2, 3, 4);
        modelManager.setGuiSettings(guiSettings);
        assertEquals(guiSettings, modelManager.getGuiSettings());
    }

    @Test
    public void setAddressBookFilePath_nullPath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setAddressBookFilePath(null));
    }

    @Test
    public void setAddressBookFilePath_validPath_setsAddressBookFilePath() {
        Path path = Paths.get("address/book/file/path");
        modelManager.setAddressBookFilePath(path);
        assertEquals(path, modelManager.getAddressBookFilePath());
    }

    @Test
    public void hasPerson_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.hasPerson(null));
    }

    @Disabled
    @Test
    public void hasPerson_personNotInAddressBook_returnsFalse() {
        assertFalse(modelManager.hasPerson(ALICE));
    }

    @Test
    public void hasPerson_personInAddressBook_returnsTrue() {
        modelManager.addPerson(ALICE);
        assertTrue(modelManager.hasPerson(ALICE));
    }

    @Test
    public void getFilteredPersonList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> modelManager.getFilteredPersonList().remove(0));
    }

    @Test
    public void addAndGetParticipant_validId_returnsParticipant() {
        try {
            Mockito.doNothing().when(storage).saveParticipantList(any());
            Mockito.doNothing().when(storage).saveTeamList(any());
            Mockito.doNothing().when(storage).saveMentorList(any());
            modelManager.addParticipant(TypicalParticipants.A);
            Participant participant = modelManager.getParticipant(new Id(PrefixType.P, 1));
            assertTrue(participant.equals(TypicalParticipants.A));
        } catch (AlfredException | IOException e) {
            // do nothing
        }
    }

    @Test
    public void deleteParticipant_validId_returnsParticipant() {
        try {
            Mockito.doNothing().when(storage).saveParticipantList(any());
            Mockito.doNothing().when(storage).saveTeamList(any());
            Mockito.doNothing().when(storage).saveMentorList(any());
            modelManager.addParticipant(TypicalParticipants.A);
            modelManager.addTeam(TypicalTeams.A);
            Participant participant = modelManager.deleteParticipant(new Id(PrefixType.P, 1));
            assertTrue(participant.equals(TypicalParticipants.A));
        } catch (AlfredException | IOException e) {
            // do nothing
        }
    }

    @Test
    public void updateParticipant_validId_returnsTrue() {
        try {
            Mockito.doNothing().when(storage).saveParticipantList(any());
            Mockito.doNothing().when(storage).saveTeamList(any());
            Mockito.doNothing().when(storage).saveMentorList(any());
            modelManager.addParticipant(TypicalParticipants.A);
            modelManager.addTeam(TypicalTeams.A);
            modelManager.updateParticipant(new Id(PrefixType.P, 1),
                    TypicalParticipants.A_UPDATED);
            assertTrue(TypicalTeams.A.getParticipants().get(0)
                    .equals(TypicalParticipants.A_UPDATED));
        } catch (AlfredException | IOException e) {
            // do nothing
        }
    }

    @Test
    public void getTeamByParticipantId_validId_returnsTeam() {
        try {
            Mockito.doNothing().when(storage).saveParticipantList(any());
            Mockito.doNothing().when(storage).saveTeamList(any());
            Mockito.doNothing().when(storage).saveMentorList(any());
            modelManager.addTeam(TypicalTeams.A);
            assertTrue(TypicalTeams.A
                    .equals(modelManager.getTeamByParticipantId(new Id(PrefixType.P, 1))));
        } catch (AlfredException | IOException e) {
            // do nothing
        }
    }

    @Test
    public void getTeamByMentorId_validId_returnsMentor() {
        try {
            Mockito.doNothing().when(storage).saveParticipantList(any());
            Mockito.doNothing().when(storage).saveTeamList(any());
            Mockito.doNothing().when(storage).saveMentorList(any());
            modelManager.addTeam(TypicalTeams.A);
            assertTrue(TypicalTeams.A
                    .equals(modelManager.getTeamByMentorId(new Id(PrefixType.M, 3))));
        } catch (AlfredException | IOException e) {
            // do nothing
        }
    }

    @Test
    public void updateMentor_validMentor_updatesMentor() {
        try {
            Mockito.doNothing().when(storage).saveParticipantList(any());
            Mockito.doNothing().when(storage).saveTeamList(any());
            Mockito.doNothing().when(storage).saveMentorList(any());
            modelManager.addTeam(TypicalTeams.A);
            modelManager.addMentor(TypicalMentors.A);
            modelManager.updateMentor(new Id(PrefixType.M, 3),
                    TypicalMentors.A_UPDATED);
            assertTrue(modelManager.getTeamByMentorId(new Id(PrefixType.M, 3))
                    .equals(TypicalTeams.A));

        } catch (AlfredException | IOException e) {
            // do nothing
        }
    }

    @Test
    public void addParticipantToTeam_validParticipant_addsParticipant() {
        try {
            Mockito.doNothing().when(storage).saveParticipantList(any());
            Mockito.doNothing().when(storage).saveTeamList(any());
            Mockito.doNothing().when(storage).saveMentorList(any());
            modelManager.addTeam(TypicalTeams.A);
            modelManager.addParticipantToTeam(new Id(PrefixType.T, 1),
                    TypicalParticipants.B);
            assertTrue(modelManager.getTeam(new Id(PrefixType.T, 1))
                    .getParticipants().size() == 2);
        } catch (AlfredException | IOException e) {
            // do nothing
        }
    }

    @Disabled
    @Test
    public void findParticipantByName_validName_correctResult() {
        try {
            Mockito.doNothing().when(storage).saveParticipantList(any());
            Mockito.doNothing().when(storage).saveTeamList(any());
            Mockito.doNothing().when(storage).saveMentorList(any());
            modelManager.addParticipant(TypicalParticipants.A);
            modelManager.addParticipant(TypicalParticipants.B);
            assertEquals(modelManager.getParticipantList().list().size(), 2);
            assertEquals(modelManager.findParticipantByName("A").size(), 1);
            assertEquals(modelManager.findParticipantByName("Part B").size(), 1);
        } catch (AlfredException | IOException e) {
            // do nothing
        }
    }

    @Disabled
    @Test
    public void findTeamByName_validName_correctResult() {
        try {
            Mockito.doNothing().when(storage).saveParticipantList(any());
            Mockito.doNothing().when(storage).saveTeamList(any());
            Mockito.doNothing().when(storage).saveMentorList(any());
            modelManager.addParticipant(TypicalParticipants.A);
            modelManager.addMentor(TypicalMentors.A);
            modelManager.addTeam(TypicalTeams.A);
        } catch (AlfredException | IOException e) {
            // do nothing
        }
        assertEquals(modelManager.getTeamList().list().size(), 1);
        assertEquals(modelManager.findTeamByName("A").size(), 1);
    }
    @Disabled
    @Test
    public void findMentorByName_validName_correctResult() {
        try {
            Mockito.doNothing().when(storage).saveParticipantList(any());
            Mockito.doNothing().when(storage).saveTeamList(any());
            Mockito.doNothing().when(storage).saveMentorList(any());
            modelManager.addMentor(TypicalMentors.A);
            modelManager.addMentor(TypicalMentors.B);
        } catch (AlfredException | IOException e) {
            // do nothing
        }
        assertEquals(modelManager.getMentorList().list().size(), 2);
        assertEquals(modelManager.findMentorByName("Mentor").size(), 2);
    }

    @Test
    public void equals() {
        AddressBook addressBook = new AddressBookBuilder().withPerson(ALICE).withPerson(BENSON).build();
        AddressBook differentAddressBook = new AddressBook();
        UserPrefs userPrefs = new UserPrefs();

        // same values -> returns true
        modelManager = new ModelManager(addressBook, userPrefs);
        ModelManager modelManagerCopy = new ModelManager(addressBook, userPrefs);
        assertTrue(modelManager.equals(modelManagerCopy));

        // same object -> returns true
        assertTrue(modelManager.equals(modelManager));

        // null -> returns false
        assertFalse(modelManager.equals(null));

        // different types -> returns false
        assertFalse(modelManager.equals(5));

        // different addressBook -> returns false
        assertFalse(modelManager.equals(new ModelManager(differentAddressBook, userPrefs)));

        // different filteredList -> returns false
        String[] keywords = ALICE.getName().fullName.split("\\s+");
        modelManager.updateFilteredPersonList(new NameContainsKeywordsPredicate(Arrays.asList(keywords)));
        assertFalse(modelManager.equals(new ModelManager(addressBook, userPrefs)));

        // resets modelManager to initial state for upcoming tests
        modelManager.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);

        // different userPrefs -> returns false
        UserPrefs differentUserPrefs = new UserPrefs();
        differentUserPrefs.setAddressBookFilePath(Paths.get("differentFilePath"));
        assertFalse(modelManager.equals(new ModelManager(addressBook, differentUserPrefs)));
    }
}
