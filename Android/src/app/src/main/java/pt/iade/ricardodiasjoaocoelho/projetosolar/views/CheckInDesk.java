package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.LocationController;

public class CheckInDesk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_island_desk_reserve_page);
        int tableId = getIntent().getIntExtra("tableId", 0);
        int userId = getIntent().getIntExtra("userId", 0);

        Button checkInButton = findViewById(R.id.idrp_check_in_button);

        checkInButton.setOnClickListener(v -> {
            checkIn(tableId, userId, response -> {
                if (response > 0){
                    setResult(RESULT_OK);
                    finish();
                }
            });
        });

    }

    public void checkIn(int tableId, int userId, LocationController.ReturnInt reponse){
        LocationController.reserveDesk(tableId, userId, reponse);
    }
}