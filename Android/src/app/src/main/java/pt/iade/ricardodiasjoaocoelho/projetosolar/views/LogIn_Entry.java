package pt.iade.ricardodiasjoaocoelho.projetosolar.views;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class LogIn_Entry extends AppCompatActivity {

    private Button changeActivityButton;

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

        Button forgot_password_button = (Button) findViewById(R.id.login_entry_forgot_credentials);

        /* --- Navigation --- */
        Context context = this;

        //LoginEntry -> MainPage
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true)
                {
                    Intent myIntent = new Intent((Context) context, MainPage.class);
                    startActivity(myIntent);
                }
                else
                {

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
    }
}