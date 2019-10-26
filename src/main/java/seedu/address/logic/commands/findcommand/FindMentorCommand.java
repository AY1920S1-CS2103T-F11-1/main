package seedu.address.logic.commands.findcommand;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.function.Predicate;

import seedu.address.commons.Predicates;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.entity.Mentor;
import seedu.address.model.entity.PrefixType;

/**
 * Implements the find command for mentors.
 */
public class FindMentorCommand extends FindCommand {
    public static final String COMMAND_WORD = "find mentor";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds the mentor by the name "
            + "given. Parameters: name to search for "
            + "Example: " + COMMAND_WORD + " n/John Doe";
    public static final String MESSAGE_SUCCESS = "Successfully ran the find command.";

    private Predicate<Mentor> findPredicate;

    public FindMentorCommand(
            Optional<String> name,
            Optional<String> phone,
            Optional<String> email,
            Optional<String> organization
    ) {
        List<Predicate<Mentor>> filterPredicates = new ArrayList<>();
        if (name.isPresent()) {
            filterPredicates.add(Predicates.getPredicateFindMentorByName(name.get()));
        }

        if (phone.isPresent()) {
            filterPredicates.add(Predicates.getPredicateFindMentorByPhone(phone.get()));
        }

        if (email.isPresent()) {
            filterPredicates.add(Predicates.getPredicateFindMentorByEmail(email.get()));
        }

        if (organization.isPresent()) {
            filterPredicates.add(
                    Predicates.getPredicateFindMentorByOrganization(organization.get()));
        }

        this.findPredicate = Predicates.predicateReducer(filterPredicates);
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        List<Mentor> results = model.findMentor(this.findPredicate);
        listResults(results, PrefixType.P);
        model.updateHistory(this);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
