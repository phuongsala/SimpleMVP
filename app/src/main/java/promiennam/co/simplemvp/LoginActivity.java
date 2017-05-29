package promiennam.co.simplemvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText username;
    private EditText password;
    private Button btnLogin;
    private Button btnLoginFacebook;
    private ProgressBar progressBar;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLoginFacebook = (Button) findViewById(R.id.btnLoginFacebook);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        btnLogin.setOnClickListener(this);
        btnLoginFacebook.setOnClickListener(this);
        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                loginPresenter.validateCredentials(username.getText().toString(), password.getText().toString());
                break;
            case R.id.btnLoginFacebook:
                loginPresenter.validateFacebook();
                break;
            default:
                break;
        }
    }

    @Override
    public void onUsernameError() {
        username.setError(getString(R.string.error_username));
    }

    @Override
    public void onPasswordError() {
        password.setError(getString(R.string.error_password));
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    // facebook
    @Override
    public void showFacebookLoginError() {
        Toast.makeText(this, "Facebook login error", Toast.LENGTH_SHORT).show();
    }
}
