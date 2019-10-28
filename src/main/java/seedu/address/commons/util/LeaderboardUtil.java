package seedu.address.commons.util;

import java.util.ArrayList;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import seedu.address.model.entity.Score;
import seedu.address.model.entity.Team;

/**
 * Utility class for deriving the leaderboard from the sorted list of teams.
 */
public class LeaderboardUtil {

    /**
     * Gets the top {@param k} teams in the hackathon based on the current standing
     * as per the input list {@param currentStanding}. This method does not discriminate between
     * teams with same score and places them in the same position.
     *
     * @return an ObservableList object containing the current top K teams.
     */
    public static ObservableList<Team> topKWithTie(ObservableList<Team> currentStanding, int k) {
        ObservableList<Team> teams = FXCollections.observableArrayList(currentStanding.get(0));
        Score currentScore = currentStanding.get(0).getScore();
        int currentTeamIndex = 1;
        int distinctTeams = 1;

        while (distinctTeams != k && currentTeamIndex < currentStanding.size()) {
            Team currentTeam = currentStanding.get(currentTeamIndex);
            if (isScoreEqual(currentTeam, currentScore)) {
                teams.add(currentTeam);
            } else {
                teams.add(currentTeam);
                currentScore = currentTeam.getScore();
                distinctTeams++;
            }
            currentTeamIndex++;
        }
        return teams;
    }

    /**
     * Gets the top {@param k} teams in the hackathon based on the current standing
     * as per the input list {@param currentStanding}. This method discriminates between teams
     * with the same score by placing teams with lower ID higher.
     *
     * @return an ObservableList object containing the current top K teams.
     */
    public static ObservableList<Team> topKAbsolute(ObservableList<Team> currentStanding, int k) {
        int listSize = currentStanding.size();
        currentStanding.remove(k, listSize);
        return currentStanding;
    }

    private static boolean isScoreEqual(Team team1, Score currentScore) {
        return team1.getScore().equals(currentScore);
    }

    /**
     * Generates random {@param k} winners in order from the {@param currentStanding} to determine
     * the winners of the hackathon on a random basis.
     *
     * @return a new ObservableList object containing the randomly generated winners in order.
     */
    public static ObservableList<Team> randomWinnerGenerator(ObservableList<Team> currentStanding, int k) {
        ObservableList<Team> finalTeams = FXCollections.observableArrayList();
        ArrayList<Team> temp = new ArrayList<>();
        Score currentScore = currentStanding.get(0).getScore();

        for (int i = 0; i < currentStanding.size(); i++) {
            Team currentTeam = currentStanding.get(i);
            if (isScoreEqual(currentTeam, currentScore)) {
                temp.add(currentTeam);
            } else {
                shuffleAndAdd(finalTeams, temp);
                currentScore = currentTeam.getScore();
                temp.add(currentTeam);
            }
        }
        return topKAbsolute(finalTeams, k);
    }

    private static void shuffleAndAdd(ObservableList<Team> teamStandings, ArrayList<Team> teams) {
        Collections.shuffle(teams);
        teamStandings.addAll(teams);
        teams.clear();
    }

}
