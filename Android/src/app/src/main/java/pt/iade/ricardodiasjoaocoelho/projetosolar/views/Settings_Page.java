package pt.iade.ricardodiasjoaocoelho.projetosolar.views;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

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
        View parentLayout = findViewById(android.R.id.content);


        ActivityResultLauncher<Intent> confirmationLauncher = registerForActivityResult (
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    // There are no request codes
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        String message = data.getStringExtra("confirmation");
                        Snackbar confirmation = Snackbar.make(parentLayout, message, Snackbar.LENGTH_LONG);
                        confirmation.setText(message);
                        confirmation.show();
                    }
                });
        changeNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the Change_Name activity when the button is clicked
                Intent myIntent = new Intent(context, Change_Name.class);
                confirmationLauncher.launch(myIntent);
            }
        });
        Button changePasswordButton = findViewById(R.id.settings_page_button_2);

        // Set a click listener for the change name button
        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the Change_Name activity when the button is clicked
                Intent myIntent = new Intent(context, Change_Password.class);
                confirmationLauncher.launch(myIntent);
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
