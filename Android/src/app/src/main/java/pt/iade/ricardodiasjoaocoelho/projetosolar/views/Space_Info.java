package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Space.Space;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.Tag;

public class Space_Info extends AppCompatActivity {

    private String spaceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_info);

        /* --- Get Space --- */
        spaceID = getIntent().getStringExtra("spaceID");
        Space space = new Space(spaceID);

        /* --- Widgets --- */
        TextView spaceTitle = findViewById(R.id.space_info_title);

        ChipGroup spaceTagGroup = findViewById(R.id.space_info_tags);

        /* --- Load/Show Tags --- */
        ArrayList<Tag> tags = space.getTags();
        ArrayList<View> chips = turnIntoChips(tags);
        chips.forEach(chip -> spaceTagGroup.addView(chip));
    }

    private ArrayList<View> turnIntoChips(List<Tag> tags) {
        ArrayList<View> chips = new ArrayList<View>();
        tags.forEach(tag -> {
            Chip chip = new Chip(this);
            chip.setText(tag.getDescrip());
            chip.setLayoutParams(ChipStyle());
            chips.add(chip);
        });
        return chips;
    }


    private RelativeLayout.LayoutParams ChipStyle (){
        RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        return layout;
    }
}