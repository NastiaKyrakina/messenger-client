package messenger.example.messengerclient.models.user;

import java.util.Arrays;
import java.util.Date;

public class Talk implements ITalk {
    int id;
    String title = null;
    TalkType type = TalkType.privateTalk;
    String imagePath = null;
    String creationDateTime = null;

    TalkUser[] talkUsers = {};

    @Override
    public String toString() {
        System.out.print(Arrays.toString(talkUsers));
        return title != null ? title : talkUsers[0].toString();
    }

    public int getId() {
        return id;
    }
}
