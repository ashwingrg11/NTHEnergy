module application.nthenergy {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires eu.hansolo.tilesfx;

    opens application.nthenergy to javafx.fxml;
    exports application.nthenergy;
    exports application.nthenergy.controllers;
    opens application.nthenergy.controllers to javafx.fxml;
}