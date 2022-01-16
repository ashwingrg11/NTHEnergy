module application.nthenergy {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires eu.hansolo.tilesfx;
    requires itextpdf;
    requires java.logging;
    requires java.mail;
    requires activation;

    opens application.nthenergy to javafx.fxml;
    exports application.nthenergy;
    exports application.nthenergy.controllers;
    opens application.nthenergy.controllers to javafx.fxml;
}