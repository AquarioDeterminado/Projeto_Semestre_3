package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.LogInController;

public class Entry_Auto_LogIn extends AppCompatActivity {

    private  ExecutorService loginExecutor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_auto_login);

        loginExecutor.execute(new Runnable() {
            @Override
            public void run() {
                LogInController logInController = LogInController.newAutoLogInController(getApplicationContext());
                if (logInController.readyToLogIn()) {
                    Intent intent = new Intent(getApplicationContext(), MainPage.class);
                    intent.putExtra("userID", logInController.getUser().getId());
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), LogIn.class);
                    startActivity(intent);
                }
            }
        });
    }

}
