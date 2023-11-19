package pt.iade.ricardodiasjoaocoelho.projetosolar.views;


import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.contentcapture.ContentCaptureCondition;
import android.widget.Button;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Signup_User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_user_info);


        Button finishBttn = findViewById(R.id.signup_finish_bttn);


        /* --- CallBacks --- */

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
        nextbttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.signup_user_password);
            }
        });
    }
}

class Signup_User_Password extends Fragment
{
    Signup_User_Password()
    {
        super(R.layout.signup_user_password);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context context = this;

        /* --- Widgetes --- */

        Button nextbttn = findViewById(R.id.signup_next_bttn);
    }
}
class Signup_User_Info extends Fragment
{
    Signup_User_Info()
    {
        super(R.layout.signup_user_info);
    }
}

