package pt.iade.ricardodiasjoaocoelho.projetosolar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LogIn_Entry extends AppCompatActivity {

    private Button changeActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_entry);
    }

    private void setUpComponenets() {
        changeActivityButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
            }

        });
    }
}