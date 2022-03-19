package messenger.example.messengerclient.models.user;

public interface ITalk {
    Number id = null;
    String title = null;
    TalkType type = TalkType.privateTalk;
    String imagePath = null;
    String creationDateTime = null;
}
