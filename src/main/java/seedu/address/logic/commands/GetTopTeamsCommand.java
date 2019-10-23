package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.entity.PrefixType;

public class GetTopTeamsCommand extends Command {

    public static final String COMMAND_WORD = "getTop";
    private static final String MESSAGE_LEADERBOARD_HEADER = "Current Top %1$s";
    public static final String MESSAGE_SUCCESS = "Showing Current Top %1$s";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": shows the top K teams as the leaderboard stands"
            + " where K is an integer value you type in. \n"
            + "Format: " + COMMAND_WORD + " K"
            + "For example: " + COMMAND_WORD + " 5";

    private int topTeams;

    public GetTopTeamsCommand(int k) {
        this.topTeams = k;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.getTopK(this.topTeams);

        System.out.println(String.format(MESSAGE_LEADERBOARD_HEADER, topTeams));
        return new CommandResult(String.format(MESSAGE_SUCCESS, topTeams), PrefixType.K);
    }

}
