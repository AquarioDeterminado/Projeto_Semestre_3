package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.IdAndErrorResponse;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.UserInfoController;

public class Change_Password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        Intent intent = getIntent();
        int userId = intent.getIntExtra("userID", 0);

        TextView oldPasswordInput = findViewById(R.id.change_password_page_old_password);
        TextView newPasswordInput = findViewById(R.id.change_password_page_new_password);

        Button confirmBttn = findViewById(R.id.change_password_confirm_bttn);

        confirmBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPassword = oldPasswordInput.getText().toString();
                String newPassword = newPasswordInput.getText().toString();
                UserInfoController.changePassword(userId, oldPassword, newPassword, new UserInfoController.ReturnErrorAndId() {
                    @Override
                    public void response(IdAndErrorResponse userInfo) {
                        if (!userInfo.getError().isEmpty()) {
                            Snackbar.make(v, userInfo.getError(), Snackbar.LENGTH_LONG).show();
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("confirmation", "Password changed successfully!");
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    }
                });
            }
        });
    }
}