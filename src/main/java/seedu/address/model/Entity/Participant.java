package seedu.address.model.Entity;

public class Participant extends Entity {
    // TODO: Use the email and phone classes already provided
    private String email;
    private String phone;
    // TODO: Add team as a attribute of participant

    public Participant(String name, String email, String phone, ID id) {
        super(id, name);
        this.email = email;
        this.phone = phone;
    }

    // Getters - Note the return types will be changed from phone and email to the respective types - Just for demo

    /**
     * Gets the email.
     *
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Gets the phone number.
     *
     * @return String
     */
    public String getPhone() {
        return this.phone;
    }

    // Setters - Argument types will be changed

    /**
     * Sets the phone.
     *
     * @param phone
     */
    public void setPhone(String phone) {
       this.phone = phone;
    }

    /**
     * Sets the email.
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
