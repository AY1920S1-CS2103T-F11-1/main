package seedu.address.ui;

import java.awt.FlowLayout;
import java.util.Comparator;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.logic.parser.Prefix;
import seedu.address.model.entity.Entity;
import seedu.address.model.entity.Mentor;
import seedu.address.model.entity.Participant;
import seedu.address.model.entity.PrefixType;
import seedu.address.model.entity.Team;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class EntityCard extends UiPart<Region> {

    //The FXML file will be based on Entity type.
    private static final String FXML = "EntityCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Entity entity;

    private PrefixType type;


    @FXML
    private HBox cardPane;
    @FXML
    private VBox cards;

    @FXML
    private Label name; //can be team name, mentor name or participant name



    @FXML
    private Label id;


    public EntityCard(Entity entity, int displayedIndex) {
        super(FXML);

        this.entity = entity;
        id.setText(displayedIndex + ". ");
        name.setText(entity.getName().toString());

        if(entity instanceof  Participant) {
            Participant participant = (Participant) entity;
            cards.getChildren().add(new Label(participant.getPhone().value));
            cards.getChildren().add(new Label(participant.getEmail().value));
            this.type = PrefixType.P;
        } else if(entity instanceof  Mentor) {
            Mentor mentor = (Mentor) entity;
            cards.getChildren().add(new Label(mentor.getOrganization().toString()));
            cards.getChildren().add(new Label(mentor.getSubject().toString()));
            this.type = PrefixType.M;
        } else {
            Team team = (Team) entity;
            FlowPane participantPane = new FlowPane();
            team.getParticipants().stream()
                    .sorted(Comparator.comparing(pt -> pt.getName().toString()))
                    .forEach(p -> participantPane.getChildren().add(new Label(p.getName().toString())));
            Optional<Mentor> teamMentor = team.getMentor();
            cards.getChildren().add(new Label(teamMentor.isEmpty()? "Mentor not assigned": teamMentor.get().getName().toString()));
            cards.getChildren().add(new Label(team.getSubject().toString()));
            cards.getChildren().add(new Label(team.getProjectName().toString()));
            cards.getChildren().add(new Label(team.getProjectType().toString()));
            cards.getChildren().add(new Label(team.getLocation().toString()));
            cards.getChildren().add(new Label(team.getScore().toString()));
            this.type = PrefixType.T;

    }
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EntityCard)) {
            return false;
        }

        // state check(if two EntityCard are equal)
        EntityCard card = (EntityCard) other;
        return id.getText().equals(card.id.getText())
                && entity.equals(card.entity)
                && name.getText().equals(card.name.getText());
    }
}
