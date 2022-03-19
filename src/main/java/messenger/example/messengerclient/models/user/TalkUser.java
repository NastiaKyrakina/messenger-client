package messenger.example.messengerclient.models.user;

public class TalkUser {
    User user;
    UserStatus status;

    @Override
    public String toString() {
        return user.username;
    }
}
