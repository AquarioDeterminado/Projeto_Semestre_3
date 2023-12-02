package pt.iade.ricardodiasjoaocoelho.projetosolar.views.SignUp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Signup_User_Info extends Fragment {
    Signup_User_Info() {
        super(R.layout.signup_user_info);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        /* ---  Widgets --- */
        Button nextbttn = view.findViewById(R.id.signup_next_bttn);


        ArrayList<TextView> textViews = new ArrayList<>();
        textViews.add(view.findViewById(R.id.signup_usr_name));
        textViews.add(view.findViewById(R.id.signup_usr_email));
        textViews.add(view.findViewById(R.id.signup_usr_phone));
        textViews.add(view.findViewById(R.id.signup_usr_bdate));

        /* --- Navigation --- */
        nextbttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AtomicBoolean allFilled = new AtomicBoolean(true);
                textViews.forEach(textView -> {
                    if(textView.getText().toString().isEmpty()){
                        textView.setError("This field is required!");
                        allFilled.set(false);
                    }
                });
                if(allFilled.get()){
                    nextFragment();
                }
            }
        });

        return view;
    }

    private void nextFragment(){
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.signup_usr_frame, new Signup_User_Password())
                .commit();
    }

}
