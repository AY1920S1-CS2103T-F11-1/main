package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.parser.Prefix;
<<<<<<< HEAD
import seedu.address.model.Entity.PrefixType;
import seedu.address.model.entity.PrefixType;
import seedu.address.model.person.Person;
=======

import seedu.address.model.entity.PrefixType;
>>>>>>> 2da432d0e9545d26af46c9bfe678fa65fb36eaba

public class JsonAdaptedPrefixType {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Prefix field is missing!";

    private final String Participant = "P";

    private final String prefixType;

    @JsonCreator
    public JsonAdaptedPrefixType(@JsonProperty("prefixType") String prefixType){
        this.prefixType = prefixType;
    }

    public JsonAdaptedPrefixType(PrefixType source){
        prefixType = source.toStorageValue();
    }

    public PrefixType toModelType() throws IllegalValueException{
        if (prefixType == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT));
        }
        if (!PrefixType.isValidPrefixType(prefixType)) {
            throw new IllegalValueException(PrefixType.MESSAGE_CONSTRAINTS);
        }

        final PrefixType modelPrefixType = PrefixType.valueOf(prefixType);

        return modelPrefixType;

    }
}
