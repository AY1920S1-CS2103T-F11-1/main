package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public abstract class TopTeamsCommand extends Command {

    public static final String COMMAND_WORD = "getTop";
    public static final String INVALID_TIE_BREAK = "The tie-break method specified does not exist or is not "
            + "supported by Alfred.";
    public static final String INVALID_VALUE_WARNING = "The value of K inputted is not a valid integer.";

    protected int numberOfTeams;

    public TopTeamsCommand(int k) {
        this.numberOfTeams = k;
    }

}
