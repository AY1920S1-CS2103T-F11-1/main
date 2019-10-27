package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jdk.jfr.StackTrace;
import seedu.address.commons.exceptions.AlfredException;
import seedu.address.commons.exceptions.AlfredModelException;
import seedu.address.commons.exceptions.AlfredModelHistoryException;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.logic.commands.addcommand.AddMentorCommand;
import seedu.address.logic.commands.addcommand.AddParticipantCommand;
import seedu.address.logic.commands.listcommand.ListParticipantCommand;
import seedu.address.model.entity.Email;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.Mentor;
import seedu.address.model.entity.Name;
import seedu.address.model.entity.Participant;
import seedu.address.model.entity.Phone;
import seedu.address.model.entity.PrefixType;
import seedu.address.model.entity.SubjectName;
import seedu.address.model.entitylist.MentorList;
import seedu.address.model.entitylist.ParticipantList;
import seedu.address.model.entitylist.TeamList;
import seedu.address.testutil.TypicalMentors;
import seedu.address.testutil.TypicalParticipants;
import seedu.address.testutil.TypicalTeams;

class ModelHistoryManagerTest {
    private ParticipantList pList;
    private MentorList mList;
    private TeamList tList;
    private ModelHistoryManager hm;
    private Participant newP;
    private Mentor newM;

    @BeforeEach
    void beforeEach() throws AlfredException {
        pList = TypicalParticipants.getTypicalParticipantList();
        ParticipantList.setLastUsedId(1);
        mList = TypicalMentors.getTypicalMentorList();
        MentorList.setLastUsedId(2);
        tList = TypicalTeams.getTypicalTeamList();
        TeamList.setLastUsedId(3);
        hm = new ModelHistoryManager(pList, ParticipantList.getLastUsedId(),
                                     mList, MentorList.getLastUsedId(),
                                     tList, TeamList.getLastUsedId());
        newP = new Participant(new Name("Test Person"),
                               new Id(PrefixType.P, 123),
                               new Email("testperson@gmail.com"),
                               new Phone("93200000"));

        newM = new Mentor(new Name("Test Mentor"),
                          new Id(PrefixType.M, 10),
                          new Phone("+6592222222"),
                          new Email("testmentor@gmail.com"),
                          new Name("Test Organization"),
                          SubjectName.SOCIAL);
    }

    @Test
    void updateHistory_isTrackableStateCommand() throws AlfredException {
        pList.add(newP);
        hm.updateHistory(pList, ParticipantList.getLastUsedId(),
                         mList, MentorList.getLastUsedId(),
                         tList, TeamList.getLastUsedId(), new AddParticipantCommand(newP));
        assertEquals(2, hm.getLengthOfHistory()); //ModelHistoryRecord with TrackableState Command added successfully.
        assertTrue(hm.canUndo());
    }

    @Test
    void updateHistory_notTrackableStateCommand() throws AlfredException {
        hm.updateHistory(pList, ParticipantList.getLastUsedId(),
                         mList, MentorList.getLastUsedId(),
                         tList, TeamList.getLastUsedId(), new ListParticipantCommand());
        assertEquals(1, hm.getLengthOfHistory());
        assertFalse(hm.canUndo());
    }

    @Test
    void undo_testEqualityOfLists_success() throws AlfredException {
        ParticipantList newPList = pList.copy();
        newPList.add(newP);
        hm.updateHistory(newPList, ParticipantList.getLastUsedId(),
                         mList, MentorList.getLastUsedId(),
                         tList, TeamList.getLastUsedId(), new AddParticipantCommand(newP));
        assertTrue(hm.canUndo());
        ModelHistoryRecord hr = hm.undo();
        ParticipantList historyPList = hr.getParticipantList();
        assertEquals(pList.getSpecificTypedList(), historyPList.getSpecificTypedList());
    }

    @Test
    void undo_testLastUsedIdSetting_success() throws AlfredModelHistoryException, AlfredException {
        pList.add(newP);
        hm.updateHistory(pList, ParticipantList.getLastUsedId(),
                         mList, MentorList.getLastUsedId(),
                         tList, TeamList.getLastUsedId(), new AddParticipantCommand(newP));
        ModelHistoryRecord hr = hm.undo();
        assertEquals(hr.getParticipantListLastUsedId(), ParticipantList.getLastUsedId());
    }

    @Test
    void canUndo_testUndoEndPoint() throws AlfredException {
        pList.add(newP);
        hm.updateHistory(pList, ParticipantList.getLastUsedId(),
                         mList, MentorList.getLastUsedId(),
                         tList, TeamList.getLastUsedId(), new AddParticipantCommand(newP));
        assertTrue(hm.canUndo());
        ModelHistoryRecord hr = hm.undo();
        assertFalse(hm.canUndo());
    }

    @Test
    void canUndo_initialModelHistoryManager_false() {
        assertFalse(hm.canUndo());
    }

    @Test
    void canRedo_testRedoEndPoint() throws AlfredException {
        assertFalse(hm.canRedo());
        pList.add(newP);
        hm.updateHistory(pList, ParticipantList.getLastUsedId(),
                         mList, MentorList.getLastUsedId(),
                         tList, TeamList.getLastUsedId(), new AddParticipantCommand(newP));
        assertFalse(hm.canRedo());
        hm.undo();
        assertTrue(hm.canRedo());
        mList.add(newM);
        //Overwrites the valid redo-able commands, so canRedo() should return false.
        hm.updateHistory(pList, ParticipantList.getLastUsedId(),
                         mList, MentorList.getLastUsedId(),
                         tList, TeamList.getLastUsedId(), new AddMentorCommand(newM));
        assertFalse(hm.canRedo());
    }

    @Test
    void redo_testEqualityOfLists_success() throws AlfredException {
        pList.add(newP);
        hm.updateHistory(pList, ParticipantList.getLastUsedId(),
                         mList, MentorList.getLastUsedId(),
                         tList, TeamList.getLastUsedId(), new AddParticipantCommand(newP));
        ModelHistoryRecord hr = hm.undo();
        hr = hm.redo();
        assertEquals(pList.getSpecificTypedList(), hr.getParticipantList().getSpecificTypedList());
    }

    @Test
    void redo_testLastUsedIdSetting_success() throws AlfredException {
        pList.add(newP);
        hm.updateHistory(pList, ParticipantList.getLastUsedId(),
                         mList, MentorList.getLastUsedId(),
                         tList, TeamList.getLastUsedId(), new AddParticipantCommand(newP));
        ModelHistoryRecord hr = hm.undo();
        hr = hm.redo();
        assertEquals(pList.getLastUsedId(), hr.getParticipantListLastUsedId());
    }

    @Test
    void canRedo_initialModelHistoryManager_false() {
        assertFalse(hm.canRedo());
    }

    @Test
    void getCommandHistory_initial() {
        assertEquals(hm.getCommandHistory().size(), 3);
        assertEquals(hm.getCommandHistory().get(0).getCommandType(), CommandRecord.CommandType.END);
        assertEquals(hm.getCommandHistory().get(1).getCommandType(), CommandRecord.CommandType.CURR);
        assertEquals(hm.getCommandHistory().get(2).getCommandType(), CommandRecord.CommandType.END);
    }

    @Test
    void getCommandHistory_withUndoRedo() throws AlfredException {
        pList.add(newP);
        hm.updateHistory(pList, ParticipantList.getLastUsedId(),
                mList, MentorList.getLastUsedId(),
                tList, TeamList.getLastUsedId(), new AddParticipantCommand(newP));
        mList.add(newM);
        hm.updateHistory(pList, ParticipantList.getLastUsedId(),
                         mList, MentorList.getLastUsedId(),
                         tList, TeamList.getLastUsedId(), new AddMentorCommand(newM));
        hm.undo();
        assertEquals(hm.getCommandHistory().size(), 5);
        assertEquals(hm.getCommandHistory().get(0).getCommandType(), CommandRecord.CommandType.END);
        assertEquals(hm.getCommandHistory().get(1).getCommandType(), CommandRecord.CommandType.REDO);
        assertEquals(hm.getCommandHistory().get(2).getCommandType(), CommandRecord.CommandType.CURR);
        assertEquals(hm.getCommandHistory().get(3).getCommandType(), CommandRecord.CommandType.UNDO);
        assertEquals(hm.getCommandHistory().get(4).getCommandType(), CommandRecord.CommandType.END);
    }

    @Test
    void getLengthOfHistory() {
        assertEquals(1, hm.getLengthOfHistory());
    }
}
