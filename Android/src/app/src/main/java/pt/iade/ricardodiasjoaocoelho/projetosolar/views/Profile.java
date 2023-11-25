package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Find the settings button by its ID
        Button settingsButton = findViewById(R.id.profile_settings_button);

        // Set a click listener for the settings button
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the SettingsActivity when the button is clicked
                Intent myintent;
                myintent = new Intent(Profile.this, Settings_Page.class);
                startActivity(myintent);
            }
        });
    }

}