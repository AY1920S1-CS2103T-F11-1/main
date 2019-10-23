package seedu.address.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import seedu.address.commons.exceptions.AlfredException;
import seedu.address.commons.exceptions.AlfredModelHistoryException;
import seedu.address.logic.commands.Command;
import seedu.address.model.entity.Participant;
import seedu.address.model.entitylist.MentorList;
import seedu.address.model.entitylist.ParticipantList;
import seedu.address.model.entitylist.TeamList;

/**
 * ModelHistoryManager tracks the state of ModelManager across the execution of all commands.
 */
public class ModelHistoryManager implements ModelHistory {
    private static final int capacity = 50; //Length of command/state history that will be tracked/can be undone

    private LinkedList<ModelHistoryRecord> history;
    private ModelHistoryRecord current; //points to the current state of Model

    /**
     * Constructor for ModelHistoryManager. Initialised with the starting state of the EntityLists
     * and their last used IDs when Alfred is first started.
     * @param pList
     * @param pListId
     * @param mList
     * @param mListId
     * @param tList
     * @param tListId
     * @throws AlfredModelHistoryException
     */
    public ModelHistoryManager(ParticipantList pList, int pListId,
                               MentorList mList, int mListId,
                               TeamList tList, int tListId) throws AlfredModelHistoryException {
        //Index 0 will always represent the starting state of model. No further
        //undo-s are available beyond this point.
        try {
            ModelHistoryRecord initRecord = new ModelHistoryRecord(pList, pListId,
                                                                   mList, mListId,
                                                                   tList, tListId,
                                                                   null); //Command is initialised to null
            this.current = initRecord;
            this.history = new LinkedList<ModelHistoryRecord>();
            this.history.add(this.current);
        } catch (AlfredException e) {
            throw new AlfredModelHistoryException("Problem encountered making deep copy of EntityLists");
        }
    }

    private void addToHistory(ModelHistoryRecord r) {
        //if (this.history.size() <= ModelHistoryManager.capacity) {
        //    int currentIndex = this.history.indexOf(this.current);
        //    if (currentIndex != this.history.size() - 1) {
        //        //Current state has possible redos. Adding a new command to history invalidates the future redos.
        //        this.history = new LinkedList(this.history.subList(0, currentIndex + 1)); //toIndex is exclusive
        //    }
        //    this.history.add(r);
        //} else {
        //    this.history.remove(0);
        //    this.history.add(r);
        //}
        //This method's logic is responsible for ensuring a valid sequence of commands for Undo/Redo
        if (this.history.size() >= ModelHistoryManager.capacity) {
            System.out.println("In greater than capacity");
            this.history.remove(0);
        }

        int currentIndex = this.history.indexOf(this.current);
        System.out.println("Current index: " + currentIndex); //DEBUG
        if (currentIndex != this.history.size() - 1) {
            System.out.println("In invalidation of redos command history");
            //Current state has possible redos. Adding a new command to history invalidates the future redos.
            this.history = new LinkedList(this.history.subList(0, currentIndex + 1)); //toIndex is exclusive
        }
        this.history.add(r);
        this.current = r;
    }

    /**
     * Generates a new ModelHistoryRecord to record the current state of the EntityLists and their last
     * used IDs.
     * @param pList ParticipantList (current state)
     * @param pListId ParticipantList's Last Used Id
     * @param mList MentorList (current state)
     * @param mListId MentorLists's Last Used Id
     * @param tList TeamList (current state)
     * @param tListId TeamList's Last Used Id
     * @throws AlfredModelHistoryException
     */
    public void updateHistory(ParticipantList pList, int pListId,
                              MentorList mList, int mListId,
                              TeamList tList, int tListId, Command c) throws AlfredModelHistoryException {
        try {
            ModelHistoryRecord newRecord = new ModelHistoryRecord(pList, pListId,
                                                                  mList, mListId,
                                                                  tList, tListId,
                                                                  c);
            addToHistory(newRecord);
        } catch (AlfredException e) {
            throw new AlfredModelHistoryException("Problem encountered making deep copy of EntityLists");
        }
    }

    /**
     * Returns a boolean indicating whether the model can return to a previous backward state.
     * @return boolean indicating whether an undo is possible.
     */
    public boolean canUndo() {
        if (this.history.indexOf(this.current) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a boolean indicating whether the model can go a previous forward state.
     * @return boolean indicating whether an redo is possible.
     */
    public boolean canRedo() {
        if (this.history.indexOf(this.current) == this.history.size() - 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Performs an undo operation and returns a ModelHistoryRecord that stores
     * the state of the EntityLists and last used IDs after a command is undone.
     * @return ModelHistoryRecord with state after command is undone
     * @throws AlfredModelHistoryException
     */
    public ModelHistoryRecord undo() throws AlfredModelHistoryException {
        if (this.canUndo()) {
            int currentIndex = this.history.indexOf(this.current); //Get prev state pointer index
            this.current = this.history.get(currentIndex - 1); //Update the current state pointer
            ParticipantList.setLastUsedId(this.current.getParticipantListLastUsedId());
            MentorList.setLastUsedId(this.current.getMentorListLastUsedId());
            TeamList.setLastUsedId(this.current.getTeamListLastUsedId());
            return this.current;
        } else {
            throw new AlfredModelHistoryException("Unable to undo any further!");
        }
    }

    public String getCommandHistory() {
        String commandHistory = "";
        int currentIndex = this.history.indexOf(this.current);
        System.out.println("Current Index: " + currentIndex);
        for (int j = this.history.size() - 1; j > currentIndex; j--) {
            Command futureCommand = this.history.get(j).getCommand();
            commandHistory += ((j - currentIndex) + ": " + futureCommand + "\n");
        }
        commandHistory += "=============================================================\n";

        int index = 1;
        for (int j = this.history.indexOf(this.current); j >= 0; j--) {
            Command histCommand = this.history.get(j).getCommand();
            if (histCommand == null) {
                commandHistory += "*: Initialised State. Cannot undo.\n";
            } else {
                commandHistory += (index + ": " + histCommand + "\n");
            }
            index++;
        }
        return commandHistory;
    }

    /**
     * Performs a redo operation and returns a ModelHistoryRecord that stores
     * the state of the EntityLists and last used IDs after a command is redone.
     * @return ModelHistoryRecord with state after command is redone
     * @throws AlfredModelHistoryException
     */
    public ModelHistoryRecord redo() throws AlfredModelHistoryException {
        //TODO: Update this in v1.3-1.4
        throw new AlfredModelHistoryException("Not yet implemented");
    }

    /**
     * Returns the length of the current history of states.
     * @return Integer representing the length of the current history of states.
     */
    public int getLengthOfHistory() {
        return this.history.size();
    }
}
