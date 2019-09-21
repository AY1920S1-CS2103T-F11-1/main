package seedu.address.model.Entity;

public class ID {
    private PrefixType prefix;
    private final int number;

    public ID(PrefixType prefix, int number) {
        this.prefix = prefix;
        this.number = number;
    }
}
