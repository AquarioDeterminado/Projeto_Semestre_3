package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.LogInController;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.Id;

public class Entry_Auto_LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_auto_login);

        Context context = this;

        LogInController.newAutoLogInController(getApplicationContext(), new LogInController.ReturnId() {
            @Override
            public void response(Id id) {
                Intent intent;
                if (id.getId() > 0) {
                    intent = new Intent(context, MainPage.class);
                    intent.putExtra("userID", id.getId());
                } else {
                    intent = new Intent(context, LogIn.class);
                }

                context.startActivity(intent);
            }
        });
    }
}
