package messenger.example.messengerclient.controllers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;
import messenger.example.messengerclient.servers.AuthToken;

public class HelloController {
    private Scene mainScene;
    public TextField username;
    public TextField password;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(ActionEvent actionEvent) {
        welcomeText.setText("Welcome to JavaFX Application!");
        System.out.println(username.getText());
        System.out.println(password.getText());
        try {
            HttpResponse<JsonNode> jsonResponse
                    = Unirest.post("http://localhost:3000/auth/login")
                    .field("username", username.getText())
                    .field("password", password.getText())
                    .asJson();
            Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            primaryStage.setScene(mainScene);
            AuthToken.setTokenAndName(jsonResponse.getBody().getObject().get("access_token").toString(),
                    jsonResponse.getBody().getObject().getJSONObject("user").get("username").toString());
            System.out.println(AuthToken.getToken());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void onPasswordInput(InputMethodEvent inputMethodEvent) {
        System.out.println(inputMethodEvent.getTarget());
    }

    public void setMainScene(Scene mainPageScene) {
        mainScene = mainPageScene;
    }
}