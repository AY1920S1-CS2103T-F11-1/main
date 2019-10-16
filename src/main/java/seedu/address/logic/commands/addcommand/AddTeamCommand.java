package seedu.address.logic.commands.addcommand;

import static java.util.Objects.requireNonNull;

import java.util.logging.Logger;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.AlfredException;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.CliSyntax;
import seedu.address.model.Model;
import seedu.address.model.entity.Team;

/**
 * Adds a {@link Team} to Alfred.
 */
public class AddTeamCommand extends AddCommand {

    private final Logger logger = LogsCenter.getLogger(AddTeamCommand.class);
    public static final String COMMAND_WORD = "addTeam";
    public static final String MESSAGE_SUCCESS = "New team added: %s";
    public static final String MESSAGE_DUPLICATE_TEAM = "This team already exists in this Hackathon";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a team to Alfred.\n"
            + "Format: " + COMMAND_WORD + " "
            + CliSyntax.PREFIX_NAME + "NAME "
            + CliSyntax.PREFIX_SUBJECT_NAME + "SUBJECT_NAME "
            + CliSyntax.PREFIX_PROJECT_NAME + "PROJECT_NAME(what the team wish to call their project) "
            + CliSyntax.PREFIX_PROJECT_TYPE + "PROJECT_TYPE"
            + CliSyntax.PREFIX_LOCATION + "TABLE_NUMBER \n"
            + "Example: " + COMMAND_WORD + " "
            + CliSyntax.PREFIX_NAME + "Justice League "
            + CliSyntax.PREFIX_SUBJECT_NAME + "Software Engineering "
            + CliSyntax.PREFIX_PROJECT_NAME + "Catwoman Dating App "
            + CliSyntax.PREFIX_PROJECT_TYPE + "Public welfare "
            + CliSyntax.PREFIX_LOCATION + "1 ";

    private Team team;

    public AddTeamCommand(Team team) {
        requireNonNull(team);
        this.team = team;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        logger.info("Adding a new team to Model");
        requireNonNull(model);

        try {
            model.addTeam(this.team);
        } catch (AlfredException e) {
            logger.severe("The same team already exist in model");
            throw new CommandException(MESSAGE_DUPLICATE_TEAM);
        }

        return new CommandResult(String.format(MESSAGE_SUCCESS, this.team.toString()));
    }

}
