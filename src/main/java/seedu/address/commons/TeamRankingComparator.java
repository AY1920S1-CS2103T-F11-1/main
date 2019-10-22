package seedu.address.commons;

import java.util.Comparator;
import seedu.address.model.entity.Team;

public class TeamRankingComparator implements Comparator<Team> {

    @Override
    public int compare(Team o1, Team o2) {
        int scoreTeam1 = o1.getScore().getScore();
        int scoreTeam2 = o2.getScore().getScore();
        return scoreTeam2 - scoreTeam1;
    }

}
