package seedu.address.logic.commands.removecommand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIds.ID_FIRST_MENTOR;
import static seedu.address.testutil.TypicalIds.ID_FIRST_TEAM;

import org.junit.jupiter.api.Test;
import seedu.address.commons.exceptions.AlfredException;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.assigncommand.AssignMentorCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.entity.Mentor;
import seedu.address.model.entity.Team;
import seedu.address.stub.ModelManagerStub;
import seedu.address.testutil.MentorBuilder;
import seedu.address.testutil.TeamBuilder;


public class RemoveMentorCommandTest {

    @Test
    public void constructor_nullTeam_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RemoveMentorCommand(ID_FIRST_MENTOR, null));
    }

    @Test
    public void constructor_nullMentor_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RemoveMentorCommand(null, ID_FIRST_TEAM));
    }

    @Test
    public void constructor_nullBoth_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RemoveMentorCommand(null, null));
    }

    @Test
    public void execute_MentorNotFound_throwsCommandException() throws Exception {
        ModelManagerStub modelStub = new ModelManagerStub();
        Mentor validMentor = new MentorBuilder().build();
        Team validTeam = new TeamBuilder().build();

        modelStub.addTeam(validTeam);


        RemoveMentorCommand command = new RemoveMentorCommand(validMentor.getId(), validTeam.getId());

        assertThrows(CommandException.class, RemoveMentorCommand.MESSAGE_INVALID_MENTOR_DISPLAYED_INDEX, () -> command.execute(modelStub));
    }

    @Test
    public void execute_teamNotFound_throwsCommandException() throws Exception {
        ModelManagerStub modelStub = new ModelManagerStub();
        Mentor validMentor = new MentorBuilder().build();
        Team validTeam = new TeamBuilder().build();

        modelStub.addMentor(validMentor);


        RemoveMentorCommand command = new RemoveMentorCommand(validMentor.getId(), validTeam.getId());

        assertThrows(CommandException.class, RemoveMentorCommand.MESSAGE_INVALID_TEAM_DISPLAYED_INDEX, () -> command.execute(modelStub));

    }

    @Test
    public void execute_removeMentorFromTeam_RemoveSuccessful() throws Exception {
        ModelManagerStub modelStub = new ModelManagerStub();
        Mentor validMentor = new MentorBuilder().build();
        Team validTeam = new TeamBuilder().build();

        modelStub.addTeam(validTeam);
        modelStub.addMentor(validMentor);

        //add mentor to team
        AssignMentorCommand assignMentorCommand = new AssignMentorCommand(validMentor.getId(), validTeam.getId());
        assignMentorCommand.execute(modelStub);

        CommandResult commandResult = new RemoveMentorCommand(validMentor.getId(), validTeam.getId()).execute(modelStub);

        assertEquals(String.format(RemoveMentorCommand.MESSAGE_REMOVE_MENTOR_SUCCESS, validMentor.getName(), validMentor.getId(), validTeam.getName(), validTeam.getId()),
                commandResult.getFeedbackToUser());
    }

    @Test
    public void execute_mentorNotAssignedToTeam_throwsCommandException() throws AlfredException {
        ModelManagerStub modelStub = new ModelManagerStub();
        Mentor validMentor = new MentorBuilder().build();
        Team validTeam = new TeamBuilder().build();

        modelStub.addTeam(validTeam);
        modelStub.addMentor(validMentor);


        RemoveMentorCommand command = new RemoveMentorCommand(validMentor.getId(), validTeam.getId());


        assertThrows(CommandException.class, RemoveMentorCommand.MESSAGE_TEAM_DOES_NOT_HAVE_MENTOR, () -> command.execute(modelStub));

    }

}
