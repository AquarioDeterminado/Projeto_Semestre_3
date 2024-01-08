package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.LocationController;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Location;

public class Floor_Plan_Availabibity extends AppCompatActivity {

    Location location;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coworking_floor_plant_availabibity);
        Intent intent = getIntent();
        userId = intent.getIntExtra("userId", 0);
        Context context = this;

        /* ---  Get Location --- */
        location = getIntent().getParcelableExtra("location");

        /* ---  Widgets --- */
        TextView floorPlanName = findViewById(R.id.cfpa_home_title);

        WebView floor_image = findViewById(R.id.cfpa_plan_webview);

        floor_image.getSettings().setJavaScriptEnabled(true);
        floor_image.getSettings().setDomStorageEnabled(true);
        ActivityResultLauncher<Intent> launcher = deskReserveActivityResultLauncher(this, location, floor_image);
        WebAppInterface webAppInterface = new WebAppInterface(this, floor_image, location, launcher);
        floor_image.addJavascriptInterface(webAppInterface, "Android");

        LocationController.getFloorPlan(userId, location, html -> {
            runOnUiThread(() -> {
                floor_image.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
            });
        });

        /* --- Set Value --- */
        floorPlanName.setText(location.getName());
    }

    private ActivityResultLauncher<Intent> deskReserveActivityResultLauncher (AppCompatActivity activity, Location location, WebView floor_image){
        return activity.registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        LocationController.getFloorPlan(userId, location, html -> {
                            activity.runOnUiThread(() -> {
                                floor_image.loadDataWithBaseURL(null,  html, "text/html", "utf-8", null);
                            });
                        });
                    }
                });
    }
}

class WebAppInterface {
    AppCompatActivity mContext;
    WebView floor_image;
    Location location;

    ActivityResultLauncher<Intent> launcher;

    WebAppInterface(AppCompatActivity c, WebView floor_image, Location location, ActivityResultLauncher<Intent> launcher) {
        this.mContext = c;
        this.floor_image = floor_image;
        this.location = location;
        this.launcher = launcher;
    }

    @JavascriptInterface
    public void reserveTable(String tableId) {
        Intent intent = new Intent(mContext, CheckInDesk.class);
        int id = Integer.parseInt(tableId.substring(5));
        intent.putExtra("tableId", id);
        intent.putExtra("userId", mContext.getIntent().getIntExtra("userId", 0));

        launcher.launch(intent);
    }


}

