package seedu.address.logic.commands.addcommand;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.exceptions.AlfredException;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.CliSyntax;
import seedu.address.model.Model;
import seedu.address.model.entity.Name;
import seedu.address.model.entity.Participant;
import seedu.address.model.entity.PrefixType;

/**
 * Adds a {@link Participant} to Alfred.
 */
public class AddParticipantCommand extends AddCommand {
    public static final String COMMAND_WORD = "addParticipant";
    public static final String MESSAGE_SUCCESS = "New participant added: %s";
    public static final String MESSAGE_DUPLICATE_PARTICIPANT = "This participant already exists in this Hackathon";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a participant to Alfred.\n"
            + "Format: " + COMMAND_WORD + " "
            + CliSyntax.PREFIX_NAME + "NAME "
            + CliSyntax.PREFIX_PHONE + "PHONE"
            + CliSyntax.PREFIX_EMAIL + "EMAIL\n"
            + "Example: " + COMMAND_WORD + " "
            + CliSyntax.PREFIX_NAME + "Arthur Fleck "
            + CliSyntax.PREFIX_EMAIL + "arthurs@joking.com "
            + CliSyntax.PREFIX_PHONE + "+6591239123";

    private Participant participant;
    private Name participantName;
    private Name teamName;

    public AddParticipantCommand(Participant participant) {
        requireNonNull(participant);
        this.participant = participant;
    }

    /*
     * public AddParticipantCommand(Name participantName, Name teamName) {
     *     CollectionUtil.requireAllNonNull(participantName, teamName);
     *     this.participantName = participantName;
     *     this.teamName = teamName;
     * }
     */

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // if (this.teamName != null) {
        //     find participant (or throw Exception) and retrieve ID
        //     find team (or throw Exception)
        //     Add participant to team
        //     Return CommandResult
        // }

        try {
            model.addParticipant(this.participant);
            model.updateHistory();
        } catch (AlfredException e) {
            throw new CommandException(MESSAGE_DUPLICATE_PARTICIPANT);
        }

        return new CommandResult(String.format(MESSAGE_SUCCESS, this.participant.toString()), PrefixType.P);
    }

}
