package messenger.example.messengerclient.models.user;

public class LoginResponse {
    private final String accessToken;

    public LoginResponse(String access_token) {
        this.accessToken = access_token;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
