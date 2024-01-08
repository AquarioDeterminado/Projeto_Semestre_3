package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.CoworkSpace;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Subscription;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.Tag;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.adapters.SubscriptionListAdapter;

public class Space_Info extends AppCompatActivity {

    private static CoworkSpace coworkSpace;
    private static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_info);
        Intent thisIntent = getIntent();

        /* --- Get Space --- */
        coworkSpace = thisIntent.getParcelableExtra("space");
        ArrayList<Subscription> subs = thisIntent.getParcelableArrayListExtra("subscriptions");
        coworkSpace.setSubscriptions(subs);
        ArrayList<Tag> tagArrayList = thisIntent.getParcelableArrayListExtra("tags");
        coworkSpace.setTags(tagArrayList);

        /* --- Widgets --- */
        TextView spaceTitle = findViewById(R.id.space_info_title);
        TextView spaceDescrip = findViewById(R.id.space_info_descrip);
        TextView spaceLocation = findViewById(R.id.space_info_local);

        ChipGroup spaceTagGroup = findViewById(R.id.space_info_tags);


        spaceTitle.setText(coworkSpace.getName());
        spaceLocation.setText(coworkSpace.getLocation());

        /* --- Load/Show Tags --- */
        ArrayList<Tag> tags = coworkSpace.getTags();
        ArrayList<View> chips = turnIntoChips(tags);
        chips.forEach(chip -> spaceTagGroup.addView(chip));

        /* --- Navigation --- */
        //Space_Info->Plan_Subscript
        ActivityResultLauncher<Intent> planSubscriptLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        String message = data.getStringExtra("message");
                        Snackbar confirmation = Snackbar.make(spaceLocation, message, Snackbar.LENGTH_LONG);
                        confirmation.show();
                    }
                }
        );

        setSubscriptionsRecyclerView(subs, planSubscriptLauncher);
    }

    private void setSubscriptionsRecyclerView(ArrayList<Subscription> subscriptions, ActivityResultLauncher<Intent> planSubscriptLauncher) {
        RecyclerView recyclerView = findViewById(R.id.space_info_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SubscriptionListAdapter adapter = new SubscriptionListAdapter(subscriptions, planSubscriptLauncher);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<View> turnIntoChips(ArrayList<Tag> tags) {
        ArrayList<View> chips = new ArrayList<>();
        for (Tag tag : tags) {
            Chip chip = new Chip(this);
            chip.setText(tag.getName());
            chip.setLayoutParams(ChipStyle());
            chips.add(chip);
        }

        return chips;
    }


    private RelativeLayout.LayoutParams ChipStyle (){
        return new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
    }
}