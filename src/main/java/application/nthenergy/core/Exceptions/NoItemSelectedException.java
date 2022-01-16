package application.nthenergy.core.Exceptions;

import javafx.scene.control.Alert;

/**
 *
 *
 */
public class NoItemSelectedException extends Exception{

    /**
     * This function is used to handle the exception for no item selected item.
     * @param errorMessage
     */
    public NoItemSelectedException(String errorMessage) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(errorMessage);
        a.show();
//        super(errorMessage);
    }

}
