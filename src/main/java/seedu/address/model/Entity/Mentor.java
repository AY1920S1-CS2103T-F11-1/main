package seedu.address.model.Entity;

import java.util.List;

public class Mentor extends Entity {
    private Phone phone;
    private Email email;
    private List<Team> teams;
    private Name organization;
    private SubjectName subject;

    /**
     * Constructor.
     *
     * @param name
     * @param id
     * @param phone
     * @param email
     * @param teams
     * @param organization
     * @param subject
     */
    public Mentor(
            Name name,
            ID id,
            Phone phone,
            Email email,
            List<Team> teams,
            Name organization,
            SubjectName subject
    ) {
        super(id, name);
        this.phone = phone;
        this.email = email;
        this.teams = teams;
        this.organization = organization;
        this.subject = subject;
    }

    // Getters

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public Name getOrganization() {
        return organization;
    }

    public SubjectName getSubject() {
        return subject;
    }

    // Setters

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void setOrganization(Name organization) {
        this.organization = organization;
    }

    public void setSubject(SubjectName subject) {
        this.subject = subject;
    }
}
