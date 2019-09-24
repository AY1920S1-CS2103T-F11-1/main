package seedu.address.model.Entity;

public class Id {
    private PrefixType prefix;
    private final int number;

    public Id(PrefixType prefix, int number) {
        this.prefix = prefix;
        this.number = number;
    }
}
