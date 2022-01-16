package application.nthenergy.core.Exceptions;

import javafx.scene.control.Alert;

public class ItemNotDeletedException extends Exception {

    /**
     * This function is used to handle the exception for item not being deleted because the item is being used by other modules.
     * @param errorMessage
     */
    public ItemNotDeletedException(String errorMessage) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(errorMessage);
        a.show();
    }
}
