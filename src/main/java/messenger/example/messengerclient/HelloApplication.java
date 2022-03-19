package messenger.example.messengerclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import messenger.example.messengerclient.controllers.HelloController;
import messenger.example.messengerclient.servers.AuthToken;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AuthToken authToken = new AuthToken();


        FXMLLoader AuthFxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(AuthFxmlLoader.load(), 320, 240);

        FXMLLoader MainPageFxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-page.fxml"));
        Scene mainPageScene = new Scene(MainPageFxmlLoader.load(), 500, 400);

        // injecting first scene into the controller of the second scene
        HelloController secondPaneController = (HelloController) AuthFxmlLoader.getController();
        secondPaneController.setMainScene(mainPageScene);
        System.out.println(AuthToken.hasToken());

        if (AuthToken.hasToken()) {
            stage.setScene(mainPageScene);
        } else {
            stage.setScene(scene);
        };

        stage.setTitle("Messenger App!");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}