package promiennam.co.simplemvp;

/**
 * Created by Phuong on 26-May-17.
 */

public interface OnLoginFinishedListener {

    void onUsernameError();

    void onPasswordError();

    void onSuccess();
}
