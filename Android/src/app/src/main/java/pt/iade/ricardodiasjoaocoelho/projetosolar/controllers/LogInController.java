package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.UserInfo;

public class LogInController {

    String error = "";

    UserInfo user;

    public void CheckCredentials(String inputUsername, String inputPassword)
    {
        /* Input Errors */

        String username = inputUsername.trim();
        String password = inputPassword.trim();

        /* Invalid Credential */
        else if (!username.equals("admin") || !password.equals("admin"))
        {
            error = "Invalid Credentials";
        }
        else
        {
            user = new UserInfo(username, password);
        }
    }

    public String getError()
    {
        return error;
    }

    public boolean getUser() {

    }
}
