package promiennam.co.simplemvp;

/**
 * Created by Phuong on 26-May-17.
 */

public interface LoginInteractor {

    void login(String username, String password, OnLoginFinishedListener listener);

    // facebook
    void loginWithFacebook(OnLoginFacebookFinishedListener listener);
}
