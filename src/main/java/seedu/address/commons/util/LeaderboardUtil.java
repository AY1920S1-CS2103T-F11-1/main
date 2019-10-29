package seedu.address.commons.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import seedu.address.commons.Comparators;
import seedu.address.commons.Predicates;
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
        Team currentTeam = currentStanding.get(0);
        int currentTeamIndex = 1;
        int distinctTeams = 1;

        while (distinctTeams <= k && currentTeamIndex < currentStanding.size()) {
            Team team = currentStanding.get(currentTeamIndex);
            if (allMatch(currentTeam, team, Comparators.rankByParticipantsDescending())) {
                teams.add(team);
            } else {
                teams.add(team);
                currentTeam = team;
                distinctTeams++;
            }
            currentTeamIndex++;
        }
        teams.remove(teams.size() - 1); // The above algorithm adds one redundant team at the end of the list.
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

    private static boolean allMatch(Team team1, Team team2, Comparator<Team> ... comparators) {
        return Arrays.stream(comparators)
                .allMatch(comparator -> comparator.compare(team1, team2) == 0);
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
    public static ObservableList<Team> randomWinnersGenerator(ObservableList<Team> currentStanding, int k) {
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
