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

public class Change_Name extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_name);
        Intent intent = getIntent();
        int userId  = intent.getIntExtra("userID", 0);

        // Find the change name button by its ID
        Button confirmButton = findViewById(R.id.change_apperance_page_confirm_button);
        TextView newNameInput = findViewById(R.id.change_name_page_hint);

        // Set a click listener for the change name button
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = newNameInput.getText().toString();
                UserInfoController.changeUserName(userId, newName, new UserInfoController.ReturnErrorAndId() {
                    @Override
                    public void response(IdAndErrorResponse response) {
                        if (!response.getError().isEmpty()) {
                            Snackbar.make(view, response.getError(), Snackbar.LENGTH_LONG).show();
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
