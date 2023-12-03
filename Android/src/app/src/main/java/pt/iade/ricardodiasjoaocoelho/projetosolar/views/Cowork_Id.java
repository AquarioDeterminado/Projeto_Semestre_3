package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Cowork_Id extends Fragment {

    Cowork_Id() {
        super(R.layout.activity_cowork_id);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        //Makes sense and Android Studio likes it
        assert view != null;

        ImageButton cameraBttn = view.findViewById(R.id.cowork_id_camera_button);

        Context context = view.getContext();
        cameraBttn.setOnClickListener(v -> {
            Intent intent = new Intent(context, Qr_Camera.class);
            startActivity(intent);
        });

        return view;
    }
}