package promiennam.co.simplemvp;

/**
 * Created by Phuong on 26-May-17.
 */

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener, OnLoginFacebookFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        loginView.showProgressBar();
        loginInteractor.login(username, password, this);
    }

    @Override
    public void validateFacebook() {
        loginView.showProgressBar();
        loginInteractor.loginWithFacebook(this);
    }

    @Override
    public void onUsernameError() {
        loginView.onUsernameError();
        loginView.hideProgressBar();
    }

    @Override
    public void onPasswordError() {
        loginView.onPasswordError();
        loginView.hideProgressBar();
    }

    @Override
    public void onSuccess() {
        loginView.navigateToHome();
    }

    // facebook
    @Override
    public void onFacebookLoginSuccess() {
        loginView.navigateToHome();
    }

    // facebook
    @Override
    public void onFacebookLoginError() {
        loginView.hideProgressBar();
        loginView.showFacebookLoginError();
    }
}
