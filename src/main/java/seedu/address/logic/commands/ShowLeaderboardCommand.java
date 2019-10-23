package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.entity.PrefixType;
import seedu.address.model.entity.Team;

public class ShowLeaderboardCommand extends Command {

    public static final String COMMAND_WORD = "leaderboard";
    private static final String MESSAGE_LEADERBOARD_HEADER = "Current Standings of Teams: ";
    public static final String MESSAGE_SUCCESS = "Showing Leaderboard as it Stands.";


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.getLeaderboard();

        System.out.println(MESSAGE_LEADERBOARD_HEADER);
        return new CommandResult(MESSAGE_SUCCESS, PrefixType.L);
    }

    private void listResults(List<Team> results) {
        for (int i = 0; i < results.size(); i++) {
            Team result = results.get(i);
            System.out.println(
                    String.format("%d. Name: %s, ID: %s " + result.getScore().getScore(), i + 1, result.getName(), result.getId()));
        }
    }

}
