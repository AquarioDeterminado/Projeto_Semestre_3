package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;
import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Space.CoworkSpaces;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.Tag;

public class Space_Info extends AppCompatActivity {

    private static String spaceID;
    private static String spaceName;

    public static String getId() { return spaceID; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_info);

        /* --- Get Space --- */
        spaceID = getIntent().getStringExtra("spaceID");
        CoworkSpaces coworkSpaces = new CoworkSpaces(spaceID, spaceName);

        /* --- Widgets --- */
        //TextView spaceTitle = findViewById(R.id.space_info_title);

        ChipGroup spaceTagGroup = findViewById(R.id.space_info_tags);

        Button contactBttn = findViewById(R.id.space_info_plan_1_bttn);

        /* --- Load/Show Tags --- */
        ArrayList<Tag> tags = coworkSpaces.getTags();
        ArrayList<View> chips = turnIntoChips(tags);
        chips.forEach(chip -> spaceTagGroup.addView(chip));

        /* --- Navigation --- */
        //Space_Info->Plan_Subscript
        ActivityResultLauncher<Intent> planSubscriptLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        String message = data.getStringExtra("message");
                        Snackbar confirmation = Snackbar.make(contactBttn, message, Snackbar.LENGTH_LONG);
                        confirmation.show();
                    }
                }
        );
        contactBttn.setOnClickListener(v -> {
            Intent intent = new Intent(this, Plan_Subscript.class);
            planSubscriptLauncher.launch(intent);
        });
    }

    private ArrayList<View> turnIntoChips(List<Tag> tags) {
        ArrayList<View> chips = new ArrayList<>();
        tags.forEach(tag -> {
            Chip chip = new Chip(this);
            chip.setText(tag.getDescrip());
            chip.setLayoutParams(ChipStyle());
            chips.add(chip);
        });
        return chips;
    }


    private RelativeLayout.LayoutParams ChipStyle (){
        return new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
    }
}