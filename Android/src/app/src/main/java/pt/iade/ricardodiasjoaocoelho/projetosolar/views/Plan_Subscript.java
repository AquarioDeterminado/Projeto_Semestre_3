package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.appcompat.app.AlertDialog;
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
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Contacto");
            builder.setMessage("Space has been contacted")
                .setCancelable(false)
                .setPositiveButton("OK", (dialog, id) -> {;
                    AlertDialog.Builder jk = new AlertDialog.Builder(this);
                    jk.setTitle("Contacto");
                    jk.setMessage("Space has been contacted")
                            .setCancelable(false)
                            .setPositiveButton("OK", (dialog2, id2) -> {;
                                finish();
                            });
                    AlertDialog alert2 = jk.create();
                    alert2.show();
                });
            AlertDialog alert = builder.create();
            alert.show();
        });

    }
}
