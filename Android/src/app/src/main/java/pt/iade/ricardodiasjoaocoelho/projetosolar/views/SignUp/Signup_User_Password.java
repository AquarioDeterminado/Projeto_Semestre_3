package pt.iade.ricardodiasjoaocoelho.projetosolar.views.SignUp;

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
        Button finifshbttn = view.findViewById(R.id.signup_finish_bttn);

        finifshbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return view;
    }

}
