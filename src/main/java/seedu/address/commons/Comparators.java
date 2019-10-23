package seedu.address.commons;

import java.util.Comparator;

import seedu.address.model.entity.Team;

/**
 * Contains common comparators that will come in use within Alfred, for example to
 * rank teams by score.
 */
public class Comparators {

    /**
     * Creates a new comparator used to sort teams by their score
     * in descending order, mainly for the leader board.
     *
     * @return a new Comparator for Teams.
     */
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

    /**
     * Creates a new comparator used to sort teams by their score
     * in ascending order, mainly for the loser board.
     *
     * @return a new Comparator for Teams.
     */
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
