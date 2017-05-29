package promiennam.co.simplemvp;

/**
 * Created by Phuong on 26-May-17.
 */

public interface LoginPresenter {

    void validateCredentials(String username, String password);

    // facebook
    void validateFacebook();
}
