package pt.iade.ricardodiasjoaocoelho.projetosolar.views.MainPage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.CircleMenuView;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.Profile_Fragment;

public class MainPage extends AppCompatActivity {

    CircleMenuView circleMenu;

    /* --- Fragments --- */
    Main_Fragment mainFragment = new Main_Fragment();
    Usr_Subscriptions usrSpacesFragment = new Usr_Subscriptions();
    Company_Plan_Selelector_Fragment planSelectorFragment = new Company_Plan_Selelector_Fragment();
    Cowork_Id coworkIdFragment = new Cowork_Id();
    Profile_Fragment profileFragment = new Profile_Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage_events);
        setFragment(R.id.mainpage_fragment_frame, mainFragment);

        circleMenu = findViewById(R.id.circle_menu);
        circleMenu.setEventListener(new CircleMenuView.EventListener() {
            @Override
            public void onButtonLongClickAnimationStart(@NonNull CircleMenuView view, int index) {
                changeFragment(index);
            }
            @Override
            public void onButtonClickAnimationStart(@NonNull CircleMenuView view, int index) {
                changeFragment(index);
            }
        });
    }
    private void changeFragment(int id) {
        if (id == 0) {
            setFragment(R.id.mainpage_fragment_frame, mainFragment);
        } else if (id == 1) {
            setFragment(R.id.mainpage_fragment_frame, usrSpacesFragment);
        } else if (id == 2) {
            setFragment(R.id.mainpage_fragment_frame, planSelectorFragment);
        } else if (id == 3) {
            setFragment(R.id.mainpage_fragment_frame, coworkIdFragment);
        } else if (id == 4) {
            setFragment(R.id.mainpage_fragment_frame, profileFragment);
        } else throw new IllegalStateException("Unexpected value: " + id);
    }
    private void setFragment(int id , Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(id, fragment).commit();
    }
}