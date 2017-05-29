package promiennam.co.simplemvp;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Phuong on 26-May-17.
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)) {
                    listener.onUsernameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    error = true;
                }
                if (!error) {
                    listener.onSuccess();
                }
            }
        }, 2000);
    }

    // facebook
    @Override
    public void loginWithFacebook(OnLoginFacebookFinishedListener listener) {
        boolean result = false;
        // handle login facebook here, facebook sdk will return the response
        // if login facebook successfully set result = true, else set result = false
        if (result) {
            listener.onFacebookLoginSuccess();
        } else {
            listener.onFacebookLoginError();
        }
    }
}
