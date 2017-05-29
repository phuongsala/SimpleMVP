package promiennam.co.simplemvp;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Phuong on 26-May-17.
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        // This code below is a mock check for login via username, password with delay in 2 seconds
        // You should replace it by your code
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
        // This code below just is a mock, you should remove it
        boolean result = true;
        if (result) {
            listener.onFacebookLoginSuccess();
        } else {
            listener.onFacebookLoginError();
        }

        //------------------------------------------------
        // Todo: PUT YOUR CHECKING LOGIN VIA FACEBOOK CODE HERE
        //------------------------------------------------
        // Facebook API will check login in background and return response through callbacks
        // You should code the logic in each callback function
        // Such as, if on Success: listener.onFacebookLoginSuccess();
        // If on Error: listener.onFacebookLoginError();
        // ...
    }
}
