package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Location;

public class Floor_Plan_Availabibity extends AppCompatActivity {

    Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coworking_floor_plant_availabibity);
        /* ---  Get Location --- */
        location = getIntent().getParcelableExtra("location");

        /* ---  Widgets --- */
        ImageView floorPlan = findViewById(R.id.cfpa_floor_image);

        TextView floorPlanName = findViewById(R.id.cfpa_home_title);

        ArrayList<Button> islandBttns = new ArrayList<>();

        islandBttns.add(findViewById(R.id.cfpa_island_1));
        islandBttns.add(findViewById(R.id.cfpa_island_2));
        islandBttns.add(findViewById(R.id.cfpa_island_3));
        islandBttns.add(findViewById(R.id.cfpa_island_4));
        islandBttns.add(findViewById(R.id.cfpa_island_5));
        islandBttns.add(findViewById(R.id.cfpa_island_6));
        islandBttns.add(findViewById(R.id.cfpa_island_7));
        islandBttns.add(findViewById(R.id.cfpa_island_8));
        islandBttns.add(findViewById(R.id.cfpa_island_9));

        /* --- Set Value --- */
        floorPlanName.setText(location.getName());

        /* --- Navigation --- */
        //islandBttns.forEach(islandBttn -> islandBttn.setOnClickListener(islandBttnListener));

        floorPlan.setImageResource(location.getFloorPlan());
    }

    /*
    View.OnClickListener islandBttnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Floor_Plan_Availabibity.this, Island_Availability.class);
            intent.putExtra("location", location);
            intent.putExtra("island", v.getId());
            startActivity(intent);
        }
    };
    */
}