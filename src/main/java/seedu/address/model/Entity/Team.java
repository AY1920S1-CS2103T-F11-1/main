package seedu.address.model.Entity;

import java.util.List;
import java.util.Optional;

public class Team extends Entity {
    private List<Participant> participants;
    private Optional<Mentor> mentor;
    private SubjectName subject;
    private Score score;
    private Name projectName;
    private ProjectType projectType;
    private Location location;

    /**
     * Constructor without mentor.
     *
     * @param teamId
     * @param teamName
     * @param participants
     * @param subject
     * @param score
     * @param projectName
     * @param projectType
     * @param location
     */
    public Team(
            ID teamId,
            Name teamName,
            List<Participant> participants,
            SubjectName subject,
            Score score,
            Name projectName,
            ProjectType projectType,
            Location location
    ) {
        super(teamId, teamName);
        this.participants = participants;
        this.mentor = Optional.empty();
        this.subject = subject;
        this.score = score;
        this.projectName = projectName;
        this.projectType = projectType;
        this.location = location;
    }

    /**
     * Constructor with mentor.
     *
     * @param teamId
     * @param teamName
     * @param participants
     * @param subject
     * @param score
     * @param projectName
     * @param projectType
     * @param location
     */
    public Team(
            ID teamId,
            Name teamName,
            List<Participant> participants,
            Mentor mentor,
            SubjectName subject,
            Score score,
            Name projectName,
            ProjectType projectType,
            Location location
    ) {
        super(teamId, teamName);
        this.participants = participants;
        this.mentor = Optional.of(mentor);
        this.subject = subject;
        this.score = score;
        this.projectName = projectName;
        this.projectType = projectType;
        this.location = location;
    }

    // Getters

    public List<Participant> getParticipants() {
        return this.participants;
    }

    public Optional<Mentor> getMentor() {
        return this.mentor;
    }

    public SubjectName getSubject() {
        return this.subject;
    }

    public Score getScore() {
        return this.score;
    }

    public Name getProjectName() {
        return this.projectName;
    }

    public ProjectType getProjectType() {
        return this.projectType;
    }

    public Location getLocation() {
        return this.location;
    }

    // Setters

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public void setMentor(Optional<Mentor> mentor) {
        this.mentor = mentor;
    }

    public void setSubject(SubjectName subject) {
        this.subject = subject;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void setProjectName(Name projectName) {
        this.projectName = projectName;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
