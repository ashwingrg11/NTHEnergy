package application.nthenergy;

import application.nthenergy.core.Helper;
import application.nthenergy.core.enums.AccountStatus;
import application.nthenergy.core.enums.UserType;
import application.nthenergy.models.Tariff;
import application.nthenergy.models.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Login extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Helper.setScene(stage, "views/login-view.fxml");
    }

    public static void main(String[] args) {
        createAdminUser();
        launch();
    }

    /**
     * This method is used to create initial admin user.
     *
     * @param
     * @return
     */
    public static void createAdminUser() {
        ArrayList<User> users = new ArrayList<>();
        File f = new File("./data/users.txt");
        if(!f.isFile()) {
            users.add(new User(1, "Ashwin", "", "Gurung", UserType.ADMIN, "admin@admin.com", "ashwingrg", "P@ssw0rd", "98880000", AccountStatus.ACTIVE, "", System.currentTimeMillis(), System.currentTimeMillis()));
            users.add(new User(2, "Howdy", "", "Admin", UserType.ADMIN, "howdy@admin.com", "ashwingrg", "P@ssw0rd", "98880000", AccountStatus.ACTIVE, "", System.currentTimeMillis(), System.currentTimeMillis()));
            users.add(new User(3, "John", "", "Admin", UserType.ADMIN, "john@admin.com", "ashwingrg", "P@ssw0rd", "98880000", AccountStatus.ACTIVE, "", System.currentTimeMillis(), System.currentTimeMillis()));
            // Let's serialize an Object
            try {
                FileOutputStream fileOut = new FileOutputStream("./data/users.txt");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(users);
                out.close();
                fileOut.close();
                System.out.println("\nSerialization Successful initial admin user...\n");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}