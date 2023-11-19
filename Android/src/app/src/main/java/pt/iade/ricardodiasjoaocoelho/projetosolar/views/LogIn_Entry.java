package pt.iade.ricardodiasjoaocoelho.projetosolar.views;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.LogInController;

public class LogIn_Entry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* --- Create --- */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_entry);

        /* --- Initialize Widgets --- */
        ImageView logo = (ImageView) findViewById(R.id.login_entry_logo);

        EditText username_edit = (EditText) findViewById(R.id.login_entry_username_input);
        EditText password_edit = (EditText) findViewById(R.id.login_entry_password_input);

        Button login_button = (Button) findViewById(R.id.login_entry_login_button);

        TextView signupBttn = (TextView) findViewById(R.id.login_entry_signup_bttn);

        Button forgot_password_button = (Button) findViewById(R.id.login_entry_forgot_credentials);

        /* --- Navigation --- */
        Context context = this;

        //LoginEntry -> MainPage
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Check if username and password are correct
                String inputUsername = username_edit.getText().toString();
                String inputPassword = password_edit.getText().toString();

                String response = LogInController.CheckCredentials(inputUsername, inputPassword);
                if (response.isEmpty())
                {
                    Intent myIntent = new Intent((Context) context, MainPage.class);
                    startActivity(myIntent);
                }
                else
                {
                    LogInError(response);
                }
            }
        });

        //LoginEntry -> EmailRecovery
        forgot_password_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent((Context) context, Email_Recovery.class);
                startActivity(myIntent);
            }
        });

        signupBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent((Context) context, Signup_User.class);
                startActivity(myIntent);
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