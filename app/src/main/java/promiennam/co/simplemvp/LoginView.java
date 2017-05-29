package promiennam.co.simplemvp;

/**
 * Created by Phuong on 26-May-17.
 */

public interface LoginView {

    void onUsernameError();

    void onPasswordError();

    void showProgressBar();

    void hideProgressBar();

    void navigateToHome();

    // facebook
    void showFacebookLoginError();
}
