package seedu.address.ui.EntityListPanel;

import javafx.scene.layout.Region;
import seedu.address.model.entity.Entity;
import seedu.address.ui.UiPart;

/**
 * Panel containing the list of persons.
 */
public abstract class EntityListPanel extends UiPart<Region>{

    public EntityListPanel(String fxml) {
        super(fxml);
    }
}