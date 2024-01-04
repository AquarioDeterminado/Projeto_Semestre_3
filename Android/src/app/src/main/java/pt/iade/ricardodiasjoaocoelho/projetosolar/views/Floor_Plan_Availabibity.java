package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
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
        TextView floorPlanName = findViewById(R.id.cfpa_home_title);

        WebView floor_image = new WebView(this);
        setContentView(floor_image);
        floor_image.loadUrl("./app/src/main/res/html/mapa_teste_Coworking.html");
        /* --- Set Value --- */
        floorPlanName.setText(location.getName());

        /* --- Navigation --- */
        View.OnClickListener islandBttnListener;

        Context context = this;
        /*
        islandBttns.forEach(islandBttn -> islandBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Island_Reserve_Desk.class);
                intent.putExtra("location", location);
                intent.putExtra("island", v.getId());
                startActivity(intent);
                }
            })
        );
        */
    }
}