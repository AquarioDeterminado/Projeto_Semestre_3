package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import pt.iade.ricardodiasjoaocoelho.projetosolar.Utils.Utils;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.LogInController;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.SignUp.Signup_User;

public class LogIn extends AppCompatActivity {

    LogInController logInController = new LogInController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* --- Create --- */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Utils utils = new Utils();

        /* ---  Widgets --- */
        //ImageView logo = (ImageView) findViewById(R.id.login_entry_logo);

        EditText username_edit = findViewById(R.id.login_entry_username_input);
        EditText password_edit = findViewById(R.id.login_entry_password_input);

        Button login_button = findViewById(R.id.login_entry_login_button);

        TextView signupBttn = findViewById(R.id.login_entry_signup_bttn);

        //Button forgot_password_button = findViewById(R.id.login_entry_forgot_credentials);

        /* --- Navigation --- */ //TODO: Can U use the same launcher for multiple intents?
        Context context = this;
        View parentLayout = findViewById(android.R.id.content);

        //LoginEntry -> MainPage
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Check if username and password are correct
                String inputUsername = username_edit.getText().toString();
                String inputPassword = password_edit.getText().toString();

                logInController.CheckCredentials(inputUsername, inputPassword);
                if (!inputUsername.isEmpty() || !inputPassword.isEmpty())
                {
                    LogInError("Empty Fields");
                }
                else if (logInController.getError().isEmpty())
                {
                    Intent mainPage = new Intent(context, MainPage.class);
                    mainPage.putExtra("username", logInController.getUser());
                    logInController.keepLogInInfo(context, inputUsername, inputPassword);
                    startActivity(mainPage);
                }
                else
                {
                    LogInError(logInController.getError());
                }
        });

        //LoginEntry -> EmailRecovery
        /*
        ActivityResultLauncher<Intent> forgotPasswordLauncher = utils.afterLunchSnack(this, parentLayout);
        forgot_password_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Email_Recovery.class);
                forgotPasswordLauncher.launch(intent);
            }
        });
        */


        // LoginEntry -> Signup
        ActivityResultLauncher<Intent> signupLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        String message = data.getStringExtra("message");
                        Snackbar.make(parentLayout, message, Snackbar.LENGTH_LONG).show();
                    }
                }
        );
        signupBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Signup_User.class);
                signupLauncher.launch(intent);
            }
        });
    }

    /* --- Error Handling --- */
    private void LogInError (String errorMessage) {
        //build dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Not Able to log in!")
                .setMessage(errorMessage);

        AlertDialog popUpError = builder.create();
        popUpError.show();
    }
}