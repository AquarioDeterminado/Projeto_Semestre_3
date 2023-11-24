package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Subscription_Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription_info);

        /* --- Widgets --- */
        TextView subTitle = findViewById(R.id.sub_info_title);
        TextView spaceName = findViewById(R.id.sub_info_space_name);
        TextView nextRenewalDate = findViewById(R.id.sub_info_next_renewal);
        TextView suId = findViewById(R.id.sub_info_id);
        TextView subValue = findViewById(R.id.sub_info_value);
        TextView subCancelBttn = findViewById(R.id.sub_info_delete_bttn);
    }
}