package pt.iade.ricardodiasjoaocoelho.projetosolar.views.SignUp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

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

        TextView password = view.findViewById(R.id.signup_usr_password);
        TextView confirm =view.findViewById(R.id.signup_usr_password_confirm);

        ArrayList<TextView> textViews = new ArrayList<>();
        textViews.add(password);
        textViews.add(confirm);

        /* ---  Widgets --- */
        Button finishbttn = view.findViewById(R.id.signup_finish_bttn);

        finishbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (oneFieldIsEmpty(textViews)) return;
                if(password.getText().toString().equals(confirm.getText().toString())){
                    finishSignup();
                } else {
                    confirm.setError("Passwords don't match!");
                }
            }
        });
        return view;
    }

    private boolean oneFieldIsEmpty (ArrayList<TextView> textViews){
        boolean isEmpty = false;
        for (TextView textView : textViews) {
            if (textView.getText().toString().isEmpty()) {
                textView.setError("This field is required!");
                isEmpty = true;
            }
        }
        return isEmpty;
    }

    private void finishSignup(){
        Activity activity = getActivity();
        Intent intent = new Intent();
        intent.putExtra("message", "User created successfully!");
        activity.setResult(Activity.RESULT_OK, intent);
        activity.finish();
    }

}
