package seedu.address.model;

import java.io.IOException;
import static java.util.Objects.requireNonNull;

import java.util.List;

import java.util.Optional;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.AlfredException;
import seedu.address.commons.exceptions.AlfredModelException;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.entity.Id;
import seedu.address.model.entity.Mentor;
import seedu.address.model.entity.Participant;
import seedu.address.model.entity.PrefixType;
import seedu.address.model.entity.Team;
import seedu.address.model.entitylist.MentorList;
import seedu.address.model.entitylist.ParticipantList;
import seedu.address.model.entitylist.ReadOnlyEntityList;
import seedu.address.model.entitylist.TeamList;
import seedu.address.model.person.Person;
import seedu.address.model.person.UniquePersonList;
import seedu.address.storage.AlfredStorage;

/**
 * Wraps all data at the alfred level
 * Duplicates are not allowed (by .isSamePerson comparison)
 */
public class Alfred implements ReadOnlyAlfred {
    private static final Logger logger = LogsCenter.getLogger(Alfred.class);

    private final ParticipantList participantList;
    private final MentorList mentorList;
    private final TeamList teamList;


    public Alfred() {
        participantList = new ParticipantList();
        teamList = new TeamList();
        mentorList = new MentorList();
    }

    /**
     * Creates an AddressBook using the Persons in the {@code toBeCopied}
     */
    public Alfred(AlfredStorage alfredStorage, ReadOnlyUserPrefs userPrefs) throws AlfredException {

        Optional<ParticipantList> optionalParticipantList;
        Optional<MentorList> optionalMentorList;
        Optional<TeamList> optionalTeamList;

        ReadOnlyEntityList participantList = new ParticipantList();
        ReadOnlyEntityList mentorList = new MentorList();
        ReadOnlyEntityList teamList = new TeamList();
        try {
            optionalParticipantList = alfredStorage.readParticipantList();
            optionalMentorList = alfredStorage.readMentorList();
            optionalTeamList = alfredStorage.readTeamList();
            //If participant list is not present, sample data is used instead.
            //System will be unable to proceed without participantList
            if (!optionalParticipantList.isPresent()) {
                logger.info("Data file of participants is not found. Will be starting with a sample list of entries.");

                //TODO: Create sample entries
                // participantList = optionalParticipantList.orElseGet(SampleDataUtil::getSampleParticipantList);
                //mentorList = optionalParticipantList.orElseGet(SampleDataUtil::getSampleMentorList;
                // teamList = optionalParticipantList.orElseGet(SampleDataUtil::getSampleTeamList;
            } else {
                participantList = optionalParticipantList.get();
                mentorList = optionalMentorList.get();
                teamList = optionalTeamList.get();
            }



        } catch (DataConversionException e) {
            logger.warning("Data file not in the correct format. Will be starting with an empty list of entries.");

        } catch (IOException e) {
            logger.warning("Problem while reading from the file. Will be starting with an empty list of entries.");

        } finally {
            this.participantList = (ParticipantList) participantList;
            this.teamList = (TeamList) teamList;
            this.mentorList = (MentorList) mentorList;
        }
    }


    /* Participant Methods */

    /**
     * Gets the participant by id.
     *
     * @param id
     * @return Participant Object
     * @throws AlfredException if the Participant cannot be found.
     */
    public Participant getParticipant(Id id) throws AlfredException {
        return this.participantList.get(id);
    }

    /**
     * Adds the participant into the list.
     *
     * @param participant
     * @throws AlfredException
     */
    public void addParticipant(Participant participant) throws AlfredException {
        this.participantList.add(participant);

    }

    /**
     * Updates the participant in the list, if any.
     *
     * @param id
     * @param participant
     */
    public void updateParticipant(Id id, Participant participant) throws AlfredException {

            // Update the participant in the team list as well
            Team targetTeam = this.getTeamByParticipantId(id);
            boolean isSuccessful = targetTeam.updateParticipant(participant);
            if (!isSuccessful) {
                logger.warning("The participant is not in the team provided");
                return;
            }

            this.participantList.update(id, participant);

        } catch (AlfredException e) {
            return;
        }
    }

    /**
     * Deletes the participant by id.
     *
     * @param id
     * @return Participant
     */
    public Participant deleteParticipant(Id id) throws AlfredException {
        Team targetTeam = this.getTeamByParticipantId(id);
        Participant participantToDelete = this.getParticipant(id);
        boolean isSuccessful = targetTeam.deleteParticipant(participantToDelete);
        if (!isSuccessful) {
            logger.warning("Participant does not exist");
            throw new AlfredModelException("Participant does not exist");
        }

        Participant deletedParticipant = this.participantList.delete(id);
        return deletedParticipant;
    }

    /* Team Methods */

    /**
     * Gets team by id.
     *
     * @param id
     * @return
     * @throws AlfredException
     */
    public Team getTeam(Id id) throws AlfredException {
        return this.teamList.get(id);
    }

    /**
     * Gets the team by participant id.
     *
     * @param participantId
     * @return Team
     * @throws AlfredException
     */
    public Team getTeamByParticipantId(Id participantId) throws AlfredException {
        for (Team t : teamList) {
            for (Participant p : t.getParticipants()) {
                if (p.getId().equals(participantId)) {
                    return t;
                }
            }
        }
        throw new AlfredModelException("Team with said participant cannot be found.");
    }

    /* OR KIV: this.teamList.setPredicate(t -> {
                   for (Participant p : t.getParticipants()) {
                       if (p.getId().equals(participantId)) {
                           return true;
                       }
                   }
                   return false;
                   }
                   );

   /**
    * Gets the team by mentor id.
    *
    * @param mentorId
    * @return Team
    * @throws AlfredException
    */
    public Team getTeamByMentorId(Id mentorId) throws AlfredException {
        for (Team t : this.teamList.getSpecificTypedList()) {
            Optional<Mentor> mentor = t.getMentor();
            if (mentor.isPresent()) {
                if (mentor.get().getId().equals(mentorId)) {
                    return t;
                }
            }
        }
        throw new AlfredModelException("Team with said mentor cannot be found.");
    }

    /**
     * Updates the team with the given teamID.
     *
     * @param teamId
     * @param updatedTeam
     * @throws AlfredException
     */
    public void updateTeam(Id teamId, Team updatedTeam) throws AlfredException {
        this.teamList.update(teamId, updatedTeam);

    }

    /**
     * Adds the team.
     *
     * @param team
     * @throws AlfredException
     */
    public void addTeam(Team team) throws AlfredException {
        this.teamList.add(team);

    }

    /**
     * Adds the participant to the given team.
     *
     * @param teamId
     * @param participant
     * @throws AlfredException if the team does not exist.
     */
    public void addParticipantToTeam(Id teamId, Participant participant) throws AlfredException {
        // TODO: Check if participant is in ParticipantList before adding.
        // TODO: Throw specific error.
        Team targetTeam = this.getTeam(teamId);
        boolean isSuccessful = targetTeam.addParticipant(participant);
        if (!isSuccessful) {
            logger.severe("Participant is already present in team");
            throw new AlfredModelException("Participant is already present in team");
        }

    }

    /**
     * Adds the participant to the given team.
     *
     * @param teamId
     * @param mentor
     * @throws AlfredException if the team does not exist.
     */
    public void addMentorToTeam(Id teamId, Mentor mentor) throws AlfredException {
        // TODO: Check if Mentor is in MentorList before adding.
        // TODO: Throw specific error.
        Team targetTeam = this.getTeam(teamId);
        boolean isSuccessful = targetTeam.addMentor(mentor);
        if (!isSuccessful) {
            logger.severe("Team already has a mentor");
            throw new AlfredModelException("Team already has a mentor");
        }

    }

    /**
     * Deletes the team.
     *
     * @param id
     * @return Team
     * @throws AlfredException
     */
    public Team deleteTeam(Id id) throws AlfredException {
        Team teamToDelete = this.teamList.delete(id);
        return teamToDelete;
    }

    /* Mentor Methods */

    /**
     * Gets the mentor by id.
     *
     * @param id
     * @return Mentor
     * @throws AlfredException
     */
    public Mentor getMentor(Id id) throws AlfredException {
        return this.mentorList.get(id);
    }

    /**
     * Adds mentor into the list.
     *
     * @param mentor
     * @throws AlfredException
     */
    public void addMentor(Mentor mentor) throws AlfredException {
        this.mentorList.add(mentor);

    }

    /**
     * Updates the mentor.
     *
     * @param id
     * @param updatedMentor
     */
    public void updateMentor(Id id, Mentor updatedMentor) throws AlfredException {
        // TODO: Throw specific exception.
        try {
            Team targetTeam = this.getTeamByMentorId(id);
            boolean isSuccessful = targetTeam.updateMentor(updatedMentor);
            if (!isSuccessful) {
                logger.severe("Unable to update the mentor in team as it is not the " + "same id");
            }

            this.mentorList.update(id, updatedMentor);
        } catch (AlfredException e) {
            return;
        }
        this.mentorList.update(id, updatedMentor);

    }

    /**
     * Deletes the mentor.
     *
     * @param id
     * @return Mentor that is deleted
     * @throws AlfredException
     */
    public Mentor deleteMentor(Id id) throws AlfredException {
        Mentor mentorToDelete = this.mentorList.delete(id);

        return mentorToDelete;
    }
    //// list overwrite operations


    @Override
    public ObservableList<Participant> getParticipantList() {
        return participantList.getSpecificTypedList();
    }

    @Override
    public ObservableList<Team> getTeamList() {
        return teamList.getSpecificTypedList();
    }

    @Override
    public ObservableList<Mentor> getMentorList() {
        return mentorList.getSpecificTypedList();
    }
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AlfredStorage // instanceof handles nulls
                && participantList.equals(((Alfred) other).participantList)
                && teamList.equals(((Alfred) other).teamList)
                && mentorList.equals(((Alfred) other).mentorList));
    }

}
