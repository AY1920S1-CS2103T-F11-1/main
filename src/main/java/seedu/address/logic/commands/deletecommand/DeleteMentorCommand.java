package seedu.address.logic.commands.deletecommand;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.exceptions.AlfredException;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.Mentor;
import seedu.address.model.entity.Name;
import seedu.address.model.entity.PrefixType;

/**
 * Deletes a {@link Mentor} in Alfred.
 */
public class DeleteMentorCommand extends DeleteCommand {
    public static final String MESSAGE_INVALID_MENTOR_DISPLAYED_INDEX = "The mentor ID provided is "
            + "invalid or does not exist.";
    public static final String MESSAGE_DELETE_MENTOR_SUCCESS = "Deleted Mentor: %1$s";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the mentor by the ID shown in the list of mentors.\n"
            + "Format: " + COMMAND_WORD + " mentor ID\n"
            + "Example: " + COMMAND_WORD + " mentor M-1";

    private Name teamName;

    public DeleteMentorCommand(Id id) {
        super(id);
    }

    public DeleteMentorCommand(Id id, Name teamName) {
        super(id);
        requireNonNull(teamName);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (this.teamName != null) {
            // find team (or throw Exception)
            // delete mentor from team
            // return CommandResult
        }

        Mentor mentorToBeDeleted;
        try {
            mentorToBeDeleted = model.deleteMentor(this.id);
            model.updateHistory();
        } catch (AlfredException e) {
            throw new CommandException(MESSAGE_INVALID_MENTOR_DISPLAYED_INDEX);
        }

        return new CommandResult(String.format(MESSAGE_DELETE_MENTOR_SUCCESS,
                mentorToBeDeleted.toString()), PrefixType.M);
    }

}
