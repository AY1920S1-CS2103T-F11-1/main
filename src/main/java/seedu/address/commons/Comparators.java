package seedu.address.commons;

import java.util.Comparator;
import seedu.address.model.entity.Team;

public class Comparators {

    public static Comparator<Team> rankByScore() {
        return new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                int scoreTeam1 = o1.getScore().getScore();
                int scoreTeam2 = o2.getScore().getScore();
                return scoreTeam2 - scoreTeam1;
            }
        };
    }

    public static Comparator<Team> rankByScoreReverse() {
        return new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                int scoreTeam1 = o1.getScore().getScore();
                int scoreTeam2 = o2.getScore().getScore();
                return scoreTeam1 - scoreTeam2;
            }
        };
    }

}
