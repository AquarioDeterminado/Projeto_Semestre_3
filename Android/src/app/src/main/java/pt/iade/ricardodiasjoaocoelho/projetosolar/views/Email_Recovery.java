package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.IntentSanitizer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Email_Recovery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_recovery);

        /* --- Widgets --- */
        Button sendbttn = findViewById(R.id.email_recovery_send_bttn);

        sendbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("message", "Email Sent; Check your inbox!");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}