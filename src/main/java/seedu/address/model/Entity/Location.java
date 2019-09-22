package seedu.address.model.Entity;

public class Location {
    private final int tableNumber;
    private Team team;

    /**
     * Constructor without team.
     * @param tableNumber
     */
    public Location(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     * Constructor with team.
     *
     * @param tableNumber
     * @param team
     */
    public Location(int tableNumber, Team team) {
        this.tableNumber = tableNumber;
        this.team = team;
    }
}
