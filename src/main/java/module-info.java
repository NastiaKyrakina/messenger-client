module messenger.example.messengerclient {
    requires javafx.controls;
    requires javafx.fxml;
//    requires javafx.swing;

    //needed for HTTP
    requires unirest.java;

    //needed for JSON
    requires com.google.gson;

    requires org.kordamp.bootstrapfx.core;

    requires java.sql;
    requires org.json;

//    //needed for JavaFX
//    opens com.edencoding.controllers to javafx.fxml;
    //needed for JSON
//    opens com.edencoding.models.openVision to gson;
    opens messenger.example.messengerclient.models.user to com.google.gson;

    opens messenger.example.messengerclient to javafx.fxml;
    exports messenger.example.messengerclient;
    exports messenger.example.messengerclient.controllers;
    opens messenger.example.messengerclient.controllers to javafx.fxml;
    exports messenger.example.messengerclient.servers;
    opens messenger.example.messengerclient.servers to javafx.fxml;
}