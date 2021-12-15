/*
 * Helper.java
 * This class includes all static methods to access helper methods througout the application.
 *
 * @author: Ashwin Gurung
 */

package application.nthenergy.core;

import application.nthenergy.Dashboard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class Helper {

    /**
     * This method is used to set scene based on the received view.
     *
     * @param event
     * @param view
     * @throws IOException
     * @return void
     */
    public static void setScene(MouseEvent event, String view) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Dashboard.class.getResource(view));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("NTH Energy - Customer Data Platform - Login");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method overrides the setSchene method with different type of parameters which is the instance of Stage.
     *
     * @param stage
     * @param view
     * @throws IOException
     */
    public static void setScene(Stage stage, String view) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Dashboard.class.getResource("views/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("NTH Energy - Customer Data Platform - Login");
        stage.setScene(scene);
        stage.show();
    }

}
