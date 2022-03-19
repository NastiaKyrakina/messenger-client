package messenger.example.messengerclient.controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import messenger.example.messengerclient.models.user.Message;
import messenger.example.messengerclient.models.user.Talk;
import messenger.example.messengerclient.servers.AuthToken;
import messenger.example.messengerclient.servers.RestApi;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainPageController {

    RestApi apiService = new RestApi();

    @FXML
    public ListView<Talk> talkListView = new ListView<Talk>();

    @FXML
    public VBox messagesView;
    public ScrollPane messagesPanel;

    protected void onMainPageLoad() {
        System.out.println("onMainPageLoad");
        String token = AuthToken.getToken();
        messagesView.setVisible(false);

        ArrayList<Talk> talkList = apiService.getTalks();
        ObservableList<Talk> items = FXCollections.observableArrayList (talkList);
        talkListView.setItems(items);
    }

    public void onCreateTalkButtonClick(ActionEvent actionEvent) {
        onMainPageLoad();
    }

    public void onListClick(MouseEvent mouseEvent) {
        Talk selectedTalk = talkListView.getSelectionModel().getSelectedItem();
        ArrayList<Message> messageList = apiService.getTalkMessage(selectedTalk);
        messagesView.setVisible(true);
    }
}
