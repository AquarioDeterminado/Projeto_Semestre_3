package pt.iade.ricardodiasjoaocoelho.projetosolar.views.SignUp;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Signup_User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_usr);

        /* --- Widgets --- */
        FrameLayout frame = findViewById(R.id.signup_usr_frame);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.signup_usr_frame, new Signup_User_Info())
                .commit();


        /* TODO: Find a way to add a backbttn callback whithout using fragment, or how to invoke a fragment from an activity;
        OnBackPressedCallback backBttnCallBack = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AlertDialog.Builder cancelAlert = new AlertDialog.Builder(context);
                cancelAlert.setTitle("Are U sure U want to cancel signup?")
                        .setMessage("All of progrees will be deleted.")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            finish();
                        })
                        .setNegativeButton("No", (dialog, which) -> {
                            dialog.cancel();
                        });
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, backBttnCallBack);
        */

        /* --- Navigation --- */

    }
}


