package seedu.address.model;

import java.util.ArrayList;

import seedu.address.commons.exceptions.AlfredModelHistoryException;
import seedu.address.model.entitylist.MentorList;
import seedu.address.model.entitylist.ParticipantList;
import seedu.address.model.entitylist.TeamList;

/**
 * ModelHistoryManager records the state of ModelManager at the end of
 * the execution of each command.
 */
public class ModelHistoryManager implements ModelHistory {
    private ArrayList<ModelHistoryRecord> history;
    private int index; //Points to the current state in `history`

    public ModelHistoryManager(ParticipantList pList, int pListId,
                               MentorList mList, int mListId,
                               TeamList tList, int tListId) {
        //Index 0 will always represent the starting state of model. No further
        //undo-s are available beyond this point.
        ModelHistoryRecord initRecord = new ModelHistoryRecord(pList, pListId,
                                                               mList, mListId,
                                                               tList, tListId);
        this.index = 0;
        this.history = new ArrayList<ModelHistoryRecord>();
        this.history.add(initRecord);
    }

    public void updateHistory(ParticipantList pList, int pListId,
                              MentorList mList, int mListId,
                              TeamList tList, int tListId) {
        ModelHistoryRecord newRecord = new ModelHistoryRecord(pList, pListId,
                                                              mList, mListId,
                                                              tList, tListId);

        this.index += 1;
        this.history.add(this.index, newRecord);
    }

    public boolean canUndo() {
        if (index > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canRedo() {
        //TODO: Update this in v1.3-4
        return false;
    }

    public ModelHistoryRecord undo() throws AlfredModelHistoryException {
        if (this.canUndo()) {
            this.index -= 1;
            return this.history.get(this.index);
        } else {
            throw new AlfredModelHistoryException("Unable to undo any further!");
        }
    }

    public ModelHistoryRecord redo() throws AlfredModelHistoryException {
        //TODO: Update this in v1.3-1.4
        throw new AlfredModelHistoryException("Not yet implemented");
    }
}
