package seedu.address.ui;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * Represents all the enums that can be used as a building block to build suggestion templates.
 */
public class SuggestionLabels {
    //Constants used as instructions
    public Text addParticipantInstruction = new Text("Adds a new Participant");
    public Text addMentorInstruction = new Text("Adds a new Mentor");
    public Text addTeamInstruction = new Text("Adds a new Team");
   public Text editParticipantInstruction = new Text(
            "=Edits existing Participant according to PARAMETERS"
    );
    public Text editMentorInstruction = new Text("=Edits existing Mentor according to PARAMETERS");
    public Text editTeamInstruction = new Text("=Edits existing Team according to PARAMETERS");

    public Text findParticipantInstruction =  new Text("=Finds a new Participant");
    public Text findMentorInstruction = new Text("=Finds a new Mentor");
    public Text findTeamInstruction= new Text("=Finds a new Team");

    public Text deleteParticipantInstruction= new Text("=Deletes an existing Participant");
    public Text deleteMentorInstruction = new Text("=Deletes an existing Mentor");
    public Text deleteTeamInstruction = new Text("=Deletes an existing Team");

    public Text listParticipantInstruction = new Text("=Lists all Participants");
   public Text listMentorInstruction = new Text("=Lists all Mentors");
   public Text listTeamInstruction = new Text("=Lists all Teams");

    public Text scoreAddInstruction = new Text("Adds POINTS to Team with TEAM_ID");
    public Text scoreSubInstruction = new Text("=Subtracts POINTS to Team with TEAM_ID");
    public Text scoreSetInstruction = new Text("=Set Team with TEAM_ID to obtain a SCORE");
    public Text leaderboardInstruction = new Text("=Lists all Teams from highest to lowest Score");
    public Text getTopInstruction = new Text("=Lists the top NUMBER of Teams according to Score");

    public Text importInstruction = new Text("=Adds multiple Participants with details in .csv file");
    public Text exportInstruction = new Text(
            "=Export Entity and their details into .csv file specified by FILE_PATH"
    );


    public Text historyInstruction = new Text("=Gets all past commands you have entered");
    public Text undoInstruction = new Text("=Undoes the most recent command");
    public Text redoInstruction= new Text("=Redoes the most recent command that you have undone");

    public Text helpInstruction = new Text("=Opens a new Help Window");

    //Constants that are used as template=this Text is also indicative of command type)
    public Text addParticipant = new Text("add participant ");
    public Text addMentor = new Text("add mentor ");
    public Text addTeam = new Text("add team ");

    public Text listParticipant = new Text("list participants ");
   public Text listMentor = new Text("list mentors ");
    public Text listTeam= new Text("list teams ");

    public Text editParticipant = new Text("edit participant ");
    public Text editMentor = new Text("edit mentor ");
    public Text editTeam = new Text("edit team ");

    public Text findParticipant new Text("find participant ");
    public Text findMentor= new Text("find mentor ");
    public Text findTeam = new Text("find team ");

    public Text deleteParticipant = new Text("delete participant ");
    public Text deleteMentor = new Text("delete mentor ");
    public Text deleteTeam = new Text("delete team ");

    public Text scoreAdd= new Text("score add ");
    public Text scoreSub = new Text("score sub ");
    public Text scoreSet = new Text("score set ");
    public Text leaderboard = new Text("leaderboard ");
    public Text getTop = new Text("getTop ");

    public Text history= new Text("history ");
    public Text undo = new Text("undo ");
    public Text redo = new Text("redo ");

    public Text importWord = new Text("import ");
    public Text exportWord = new Text("export ");

    public Text help = new Text("help ");

    //Constants that are used as template
    public Text namePrefix = new Text("n/");
    public Text phonePrefix = new Text("p/");
    public Text emailPrefix = new Text("e/");
    public Text organizationPrefix = new Text("o/");
    public Text specialisationPrefix = new Text("s/ ");
    public Text projectNamePrefix = new Text("pn/ ");
    public Text subjectPrefix = new Text("s/ ");
    public Text locationPrefix = new Text("l/ ");
    public Text filepathPrefix = new Text("fp/ ");

    //Constants =that are used are guides)
    public Text name = new Text("NAME ");
    public Text phone = new Text("PHONE_NUMBER ");
    public Text email = new Text("EMAIL_ADDRESS ");
    public Text teamId= new Text("TEAM_ID ");
    public Text participantId= new Text("PARTICIPANT_ID ");
    public Text mentorId= new Text("MENTOR_ID ");
    public Text number = new Text("NUMBER ");
    public Text points = new Text("POINTS ");
    public Text newPoints = new Text("NEW_POINTS ");
    public Text csv_Path= new Text("PATH_TO_CSV_FILE ");
    public Text parameters= new Text("[PARAMETERS] ");
    public Text organization = new Text("ORGANIZATION ");
    public Text specialisation= new Text("SPECIALISATION ");
    public Text projectName = new Text("PROJECT_NAME ");
    public Text subject = new Text("SUBJECT ");
    public Text table =  new Text("TABLE_NUMBER ");
    public Text filepath = new Text("PATH_TO_CSV_FILE ");
    public Text entity = new Text("[{team/mentor/participant}] "));
    


}
