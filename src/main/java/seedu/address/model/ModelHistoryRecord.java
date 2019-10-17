package seedu.address.model;

import seedu.address.model.entitylist.MentorList;
import seedu.address.model.entitylist.ParticipantList;
import seedu.address.model.entitylist.TeamList;

/**
 * Represents a snapshot of all the EntityLists and their last used IDs at a point in time.
 */
public class ModelHistoryRecord {
    private ParticipantList pList;
    private MentorList mList;
    private TeamList tList;

    private int pListId;
    private int mListId;
    private int tListId;

    public ModelHistoryRecord(ParticipantList pList, int pListId,
                              MentorList mList, int mListId,
                              TeamList tList, int tListId) {
        this.pList = pList;
        this.pListId = pListId;
        this.mList = mList;
        this.mListId = mListId;
        this.tList = tList;
        this.tListId = tListId;
    }

    public ParticipantList getParticipantList() {
        return this.pList;
    }

    public int getParticipantListLastUsedId() {
        return this.pListId;
    }

    public MentorList getMentorList() {
        return this.mList;
    }

    public int getMentorListLastUsedId() {
        return this.mListId;
    }

    public TeamList getTeamList() {
        return this.tList;
    }

    public int getTeamListLastUsedId() {
        return this.tListId;
    }
}
