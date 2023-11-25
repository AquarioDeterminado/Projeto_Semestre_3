package pt.iade.ricardodiasjoaocoelho.projetosolar.views;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;
import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class MainPage extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    NavigationBarView navBar;

    /* --- Fragments --- */
    Main_Fragment mainFragment = new Main_Fragment();
    Usr_Subscriptions usrSpacesFragment = new Usr_Subscriptions();
    pt.iade.ricardodiasjoaocoelho.projetosolar.views.Cowork_Id Cowork_Id = new Cowork_Id();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage_events);

        /* --- Widgets --- */

        navBar = findViewById(R.id.mainpage_bottom_navigator);


        /* --- NavBar --- */
        navBar.setOnItemSelectedListener(this);

        navBar.setSelectedItemId(R.id.nav_home);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_home)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.mainpage_fragment_frame, mainFragment).commit();
            return true;
        } else if (id == R.id.nav_spaces) {
            getSupportFragmentManager().beginTransaction().replace(R.id.mainpage_fragment_frame, usrSpacesFragment).commit();
            return true;
        } else if (id == R.id.nav_availability) {
            getSupportFragmentManager().beginTransaction().replace(R.id.mainpage_fragment_frame, usrSpacesFragment).commit();
            return true;
        } else if (id == R.id.nav_id) {
            getSupportFragmentManager().beginTransaction().replace(R.id.mainpage_fragment_frame, Cowork_Id).commit();

            return true;
        } else if (id == R.id.nav_profile) {
            Intent intent = new Intent(this, Profile.class);
            startActivity(intent);
            return true;
        } else {
            throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
    }
}

