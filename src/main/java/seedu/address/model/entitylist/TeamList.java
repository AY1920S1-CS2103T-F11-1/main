package seedu.address.model.entitylist;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.commons.exceptions.AlfredException;
import seedu.address.commons.exceptions.AlfredModelException;
import seedu.address.model.entity.Entity;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.Participant;
import seedu.address.model.entity.PrefixType;
import seedu.address.model.entity.Team;

/**
 * This interface serves as the new API for the model.
 * {@code TeamList} should behave as a singleton.
 */
public class TeamList extends EntityList {
    private static int lastUsedId = 0;

    private final ObservableList<Team> teamObservableList= FXCollections.observableArrayList();
    private final ObservableList<Team> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(teamObservableList);

    /**
     * Constructor.
     */
    public TeamList() {

    }

    /**
     * Gets team by their ID.
     *
     * @param id
     * @return Team
     * @throws AlfredException
     */
    public Team get(Id id) throws AlfredException {
        requireNonNull(id);
        Optional<Team> resultTeam = teamObservableList.stream().filter(p -> (p.getId()).equals(id)).findFirst();
        return resultTeam.orElseThrow(() -> new AlfredModelException("Participant to get does not exist"));

        /*for (Team t: this.teams) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        throw new AlfredModelException("Team to get does not exist!");

         */
    }

    /**
     * Updates team by ID.
     *
     * @param id
     * @param updatedTeam
     * @return boolean
     */
    public boolean update(Id id, Team updatedTeam) {
        for (int i = 0; i < this.teamObservableList.size(); i++) {
            if (this.teamObservableList.get(i).getId().equals(id)) {
                this.teamObservableList.set(i, updatedTeam);
                return true;
            }
        }
        return false;
    }

    /**
     * Adds the team into the list.
     *
     * @param team
     * @throws AlfredException
     */
    public void add(Team team) throws AlfredException {
        for (Team t: this.teamObservableList) {
            if (t.getId().equals(team.getId())) {
                throw new AlfredModelException("Team to add already exists.");
            }
        }
        this.teams.add(team);
    }

    /**
     * Deletes team by id.
     *
     * @param id
     * @throws AlfredException
     */
    public Team delete(Id id) throws AlfredException {
        for (Team t: this.teamObservableList) {
            if (t.getId().equals(id)) {
                this.teamObservableList.remove(t);
                return t;
            }
        }
        throw new AlfredModelException("Team to delete cannot be found.");
    }

    /**
     * Returns a list but with element type Team.
     *
     * @return List of Teams.
     */
    public ObservableList<Team> getSpecificTypedList() {
        return this.internalUnmodifiableList;
    }

    /**
     * List the teams.
     *
     * @return List of Teams.
     */
    public ObservableList<? extends Entity> list() {
        return this.internalUnmodifiableList;
    }

    /**
     * Checks if a given ID exists.
     *
     * @param id
     * @return boolean
     */
    @Override
    public boolean contains(Id id) {
        for (Team p: this.teamObservableList) {
            if (p.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Generates the ID for the object.
     *
     * @return ID
     */
    public static Id generateId() {
        lastUsedId++;
        return new Id(PrefixType.T, lastUsedId);
    }

    /**
     * Sets the lastUsedId class attribute.
     *
     * @param number
     */
    public static void setLastUsedId(int number) {
        lastUsedId = number;
    }
}
