package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Person;

/**
 * An Immutable IssueList that is serializable to JSON format.
 */
@JsonRootName(value = "issuelist")
class JsonSerializableIssueList {

    public static final String MESSAGE_DUPLICATE_ENTITY = "Issue list contains duplicate issue(s).";

    private final List<JsonAdaptedIssue> issues = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableIssueList} with the given issues.
     */
    @JsonCreator
    public JsonSerializableIssueList(@JsonProperty("issues") List<JsonAdaptedIssue> issues) {
        this.issues.addAll(issues);
    }

    /**
     * Converts a given {@code IssueList} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableIssueList}.
     */
    public JsonSerializableIssueList(IssueList source) {
        issues.addAll(source.list().stream().map(JsonAdaptedIssue::new).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code IssueList} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public IssueList toModelType() throws IllegalValueException {
        IssueList issueList = new IssueList();
        for (JsonAdaptedIssue jsonAdaptedIssue : issues) {
            Issue issue = jsonAdaptedIssue.toModelType();
            if (issueList.hasIssue(issue)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_ENTITY);
            }
            issueList.addIssue(issue);
        }
        return issueList;
    }

}