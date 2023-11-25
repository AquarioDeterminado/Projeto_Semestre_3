package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Change_Apperance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_apperance);


        Button changeApperanceButtonLight = findViewById(R.id.change_apperance_page_button_lightmode);
        Context context = this;

        // Set a click listener for the change appearance button
        changeApperanceButtonLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the Settings_Page activity when the button is clicked
                Intent myIntent = new Intent(context, Settings_Page.class);
                startActivity(myIntent);
            }
        });


    Button changeApperanceButtonDark = findViewById(R.id.change_apperance_page_button_darkmode);
    // Set a click listener for the change appearance button
        changeApperanceButtonDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                // Start the Settings_Page activity when the button is clicked
                Intent myIntent = new Intent(context, Settings_Page.class);
                startActivity(myIntent);
            }
        });
    }
}