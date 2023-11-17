package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Plan_Subscript extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_subscript);

        /* --- Widgets --- */
        ConstraintLayout background = findViewById(R.id.plan_contact_background);

        Button contactBttn = findViewById(R.id.plan_contact_bttn);

        /* --- Navigation --- */
        //Plan->Space_Info
        background.setOnClickListener(v -> {
            finish();
        });

        //Plan->Space_Info
        contactBttn.setOnClickListener(v -> {
            finish();
        });

    }
}
