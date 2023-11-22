package pt.iade.ricardodiasjoaocoelho.projetosolar.views.SignUp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Signup_User_Password extends Fragment {
    Signup_User_Password() {
        super(R.layout.signup_user_password);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        assert view != null;

        /* ---  Widgets --- */
        Button finishbttn = view.findViewById(R.id.signup_finish_bttn);

        finishbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity();
                Intent intent = new Intent();
                intent.putExtra("message", "User created successfully!");
                activity.setResult(Activity.RESULT_OK, intent);
                activity.finish();
            }
        });

        return view;
    }

}
