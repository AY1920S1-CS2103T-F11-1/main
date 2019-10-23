package seedu.address.ui.entitylistpanel;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.model.entity.Entity;
import seedu.address.model.entity.Mentor;
import seedu.address.model.entity.Participant;
import seedu.address.model.entity.PrefixType;
import seedu.address.model.entity.Team;
import seedu.address.ui.EntityCard;
import seedu.address.ui.UiPart;

/**
 * Panel containing the list of persons.
 */
public class EntityListPanel extends UiPart<Region> {
    private static final String FXML = "EntityListPanel.fxml";
    private PrefixType prefix;

    @FXML
    private ListView<Entity> entityListView;
    @FXML
    private VBox panelContainer;

    //TODO: clarify
    //Not sure whether these generics is advisable, please advise
    public EntityListPanel(ObservableList<? extends Entity> entityList) {
        super(FXML);
        entityListView.setItems((ObservableList<Entity>) entityList);
        if (!entityList.isEmpty()) {
            Entity firstItem = entityList.get(0);
            if (firstItem instanceof Participant) {
                prefix = PrefixType.P;
                entityListView.setCellFactory(listView -> new ParticipantListViewCell());
               panelContainer.setStyle("-fx-background-color: #5d6d7e");

            } else if (firstItem instanceof Team) {
                prefix = PrefixType.T;
                entityListView.setCellFactory(listView -> new TeamListViewCell());
               panelContainer.setStyle("-fx-background-color:#abb2b9");
            } else if (firstItem instanceof Mentor) {
                prefix = PrefixType.M;
                entityListView.setCellFactory(listView -> new MentorListViewCell());
                panelContainer.setStyle("-fx-background-color: #17202a");
            }
        }


    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class MentorListViewCell extends ListCell<Entity> {
        @Override
        protected void updateItem(Entity entity, boolean isEmpty) {
            Mentor curr = (Mentor) entity;
            super.updateItem(curr, isEmpty);

            if (isEmpty || curr == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new EntityCard(curr, getIndex() + 1).getRoot());
            }
        }
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class ParticipantListViewCell extends ListCell<Entity> {
        @Override
        protected void updateItem(Entity entity, boolean isEmpty) {
            Participant curr = (Participant) entity;
            super.updateItem(curr, isEmpty);

            if (isEmpty || curr == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new EntityCard(curr, getIndex() + 1).getRoot());
            }
        }
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class TeamListViewCell extends ListCell<Entity> {
        @Override
        protected void updateItem(Entity entity, boolean isEmpty) {
            Team curr = (Team) entity;
            super.updateItem(curr, isEmpty);

            if (isEmpty || curr == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new EntityCard(curr, getIndex() + 1).getRoot());
            }
        }
    }
}

