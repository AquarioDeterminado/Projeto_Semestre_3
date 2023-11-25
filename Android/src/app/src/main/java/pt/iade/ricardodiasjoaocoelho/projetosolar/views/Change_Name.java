package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Change_Name extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_name);




        // Find the change name button by its ID

        Button confirmButton = findViewById(R.id.change_apperance_page_confirm_button);

        // Set a click listener for the change name button
        Context context = this;
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
