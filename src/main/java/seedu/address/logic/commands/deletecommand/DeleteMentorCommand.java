package seedu.address.logic.commands.deletecommand;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class DeleteMentorCommand extends DeleteCommand {

    /* Possible Fields */

    public static final String ENTITY_TYPE = "mentor";

    public DeleteMentorCommand(Id id) {
        super(id);
    }

    @Override
    public CommandResult execute(EntityList entityList) throws CommandException {
        requireNonNull(entityList);

        // see DeleteIssueCommand

        return new CommandResult("");
    }

}