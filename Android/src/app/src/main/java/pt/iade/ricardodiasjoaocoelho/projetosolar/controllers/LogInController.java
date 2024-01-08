package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import static android.content.Context.MODE_PRIVATE;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.gson.Gson;
import java.net.URL;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.UserInfo;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.Id;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.LogInInfo;
import pt.iade.ricardodiasjoaocoelho.projetosolar.utils.WebRequest;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.LogIn;

public class LogInController {

    private static final String BASE_URL = WebRequest.LOCALHOST + "/login";

    String error = "";
    UserInfo user;

    /* --- Getters --- */
    public String getError() { return error; }
    public UserInfo getUser() { return user; }

    /* --- Methods --- */
    public void CheckCredentials(Context context, String inputUsername, String inputPassword, ReturnId returnId)
    {
        LogInInfo logInInfo = new LogInInfo(inputUsername, inputPassword);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        // This is a brand new object and must be a INSERT in the database.
                        WebRequest req = new WebRequest(new URL(
                                BASE_URL + "/checkCredentials"));
                        Log.i("WebRequest", "Post made to API: Events for user");
                        String response = req.performPostRequest(logInInfo);

                        // Get the new ID from the server's response.
                        Id userId = new Gson().fromJson(response, Id.class);
                        returnId.response(userId);

                    } catch (Exception e) {
                        Log.e("LogIn", e.toString());
                        Intent intent = new Intent(context, LogIn.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent intent = new Intent(context, LogIn.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
        thread.start();
    }

    public void saveLogInInfo(Context context, String username, String password){
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    public static void deleteLogInInfo(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("username");
        editor.remove("password");
        editor.apply();
    }



    public static void newAutoLogInController(Context context, ReturnId returnId){
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        LogInController logInController = new LogInController();
        logInController.CheckCredentials(context, username, password, returnId);
    }

    public boolean readyToLogIn(){
        return user != null && error.isEmpty();
    }

    public interface ReturnId {
        void response(Id id);
    }
}
