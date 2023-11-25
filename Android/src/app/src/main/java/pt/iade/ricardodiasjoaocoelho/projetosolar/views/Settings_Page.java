package pt.iade.ricardodiasjoaocoelho.projetosolar.views;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
public class Settings_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        // Find the change name button by its ID

        Button changeNameButton = findViewById(R.id.settings_page_button_1);

        // Set a click listener for the change name button
        Context context = this;
        changeNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the Change_Name activity when the button is clicked
                Intent myIntent = new Intent(context, Change_Name.class);
                startActivity(myIntent);
            }
        });
        Button changePasswordButton = findViewById(R.id.settings_page_button_2);

        // Set a click listener for the change name button
        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the Change_Name activity when the button is clicked
                Intent myIntent = new Intent(context, Change_Password.class);
                startActivity(myIntent);
            }
        });
        Button changeApperanceButton = findViewById(R.id.settings_page_button_3);

        // Set a click listener for the change name button
        changeApperanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the Change_Name activity when the button is clicked
                Intent myIntent = new Intent(context, Change_Apperance.class);
                startActivity(myIntent);
            }
        });
        Button LogOutButton = findViewById(R.id.settings_page_button_4);

        // Set a click listener for the change name button
        LogOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the Change_Name activity when the button is clicked
                finishAffinity();
                Intent myIntent = new Intent(context, LogIn_Entry.class);
                startActivity(myIntent);
            }
        });
    }
}
