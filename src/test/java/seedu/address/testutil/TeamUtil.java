package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_LOCATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PROJECT_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SUBJECT_NAME;

import seedu.address.logic.commands.addcommand.AddTeamCommand;
import seedu.address.model.entity.Team;

public class TeamUtil {

    /**
     * Returns an add command string for adding the {@code person}.
     */
    public static String getAddCommand(Team team) {
        return AddTeamCommand.COMMAND_WORD + " " + getPersonDetails(team);
    }

    /**
     * Returns the part of command string for the given {@code person}'s details.
     */
    public static String getPersonDetails(Team team) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + team.getName().fullName + " ");
        sb.append(PREFIX_PROJECT_NAME + team.getProjectName().fullName + " ");
        sb.append(PREFIX_SUBJECT_NAME + team.getSubject().toString() + " ");
        sb.append(PREFIX_LOCATION + "" + team.getLocation().getTableNumber() + " ");

        return sb.toString();
    }

}
