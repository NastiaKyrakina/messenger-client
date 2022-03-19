package messenger.example.messengerclient.models.user;

public class User {
    Number id;
    String username;
    String lastLoginDateTime;

    @Override
    public String toString() {
        return username;
    }
}
