package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Subscription;

public class Subscription_Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription_info);

        Subscription sub = getIntent().getExtras().getParcelable("subscription");

        /* --- Widgets --- */
        TextView subTitle = findViewById(R.id.sub_info_title);
        TextView spaceName = findViewById(R.id.sub_info_space_name);
        TextView nextRenewalDate = findViewById(R.id.sub_info_next_renewal);
        TextView suId = findViewById(R.id.sub_info_id);
        TextView subValue = findViewById(R.id.sub_info_value);
        TextView subCancelBttn = findViewById(R.id.sub_info_delete_bttn);

        /* --- Set Data --- */
        subTitle.setText(sub.getTitle());
        spaceName.setText(sub.getSpace().getName());
        nextRenewalDate.setText(sub.getNextRenewalDate().toString());
        suId.setText(sub.getId());
        subValue.setText(sub.getPrice() + "€");

        /* --- Set Listeners --- */
        subCancelBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Subscription_Info.this);
                builder.setTitle("Cancel Subscription");
                builder.setMessage("Are you sure you want to cancel this subscription?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.putExtra("subscription", sub);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
                builder.setNegativeButton("No", null);
                builder.show();
            }
        });
    }
}