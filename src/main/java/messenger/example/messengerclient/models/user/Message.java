package messenger.example.messengerclient.models.user;

public class Message {
    int id;
    String text;
    String sendDateTime;
    int talkId;
    int userId;

    @Override
    public String toString() {
        return text;
    }
}
