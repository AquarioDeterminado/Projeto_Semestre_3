package pt.iade.ricardodiasjoaocoelho.projetosolar.views;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;
import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class MainPage extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    NavigationBarView navBar;

    /* --- Fragments --- */
    Main_Fragment_test mainFragment = new Main_Fragment_test();
    Usr_Spaces usrSpacesFragment = new Usr_Spaces();

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
        } else if (id == R.id.nav_profile) {
                Intent intent = new Intent(this, Profile.class);
                startActivity(intent);
                return true;
        } else {
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
    }
}

