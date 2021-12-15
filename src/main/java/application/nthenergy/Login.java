package application.nthenergy;

import application.nthenergy.core.Helper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Login extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Helper.setScene(stage, "vies/login-view.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}