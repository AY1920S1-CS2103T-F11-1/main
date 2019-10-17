package seedu.address.logic.commands.undocommand;

import seedu.address.commons.exceptions.AlfredException;
import seedu.address.commons.exceptions.AlfredModelHistoryException;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.CliSyntax;
import seedu.address.model.Model;

public class UndoCommand {
    public static final String COMMAND_WORD = "undo";
    public static final String MESSAGE_SUCCESS = "Undid 1 command";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Undoes the previous command";

    public CommandResult execute(Model model) throws CommandException {
        try {
            model.undo();
            return new CommandResult(String.format(MESSAGE_SUCCESS));
        } catch (AlfredModelHistoryException e) {
            throw new CommandException(e.getMessage());
        }
    }
}
