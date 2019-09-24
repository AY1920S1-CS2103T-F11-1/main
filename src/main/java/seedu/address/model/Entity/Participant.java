package seedu.address.model.Entity;

public class Participant extends Entity {
    private Email email;
    private Phone phone;
    // TODO: Add team as a attribute of participant

    public Participant(Name name, Email email, Phone phone, Id id) {
        super(id, name);
        this.email = email;
        this.phone = phone;
    }

    // Getters - Note the return types will be changed from phone and email to the respective types - Just for demo

    /**
     * Gets the email.
     *
     * @return Email
     */
    public Email getEmail() {
        return this.email;
    }

    /**
     * Gets the phone number.
     *
     * @return Phone
     */
    public Phone getPhone() {
        return this.phone;
    }

    // Setters - Argument types will be changed

    /**
     * Sets the phone.
     *
     * @param phone
     */
    public void setPhone(Phone phone) {
       this.phone = phone;
    }

    /**
     * Sets the email.
     *
     * @param email
     */
    public void setEmail(Email email) {
        this.email = email;
    }
}
