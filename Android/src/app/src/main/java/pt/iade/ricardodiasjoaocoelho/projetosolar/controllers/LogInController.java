package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import static android.content.Context.MODE_PRIVATE;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.User_Info;

public class LogInController {

    String error = "";
    User_Info user;

    Executor loginExecutor = Executors.newSingleThreadExecutor();

    /* --- Getters --- */
    public String getError() { return error; }
    public User_Info getUser() { return user; }

    /* --- Methods --- */
    public void CheckCredentials(String inputUsername, String inputPassword)
    {
        String username = inputUsername.trim();
        String password = inputPassword.trim();

        /* Invalid Credential */
        if (!username.equals("admin") || !password.equals("admin"))
        {
            error = "Invalid Credentials";
        }
        else
        {
            user = User_Info.getUserByCredentials(username, password);
        }
    }

    public void keepLogInInfo(Context context, String username, String password){
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    public static LogInController newAutoLogInController(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        LogInController logInController = new LogInController();
        logInController.CheckCredentials(username, password);
        return logInController;
    }

    public boolean readyToLogIn(){
        return user != null && error.isEmpty();
    }
}
