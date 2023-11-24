package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

public class LogInController {

    public static String CheckCredentials(String inputUsername, String inputPassword)
    {
        /* Input Errors */
        String error = "";

        String username = inputUsername.trim();
        String password = inputPassword.trim();

        if (username.isEmpty() || password.isEmpty())
        {
            error = "Empty Fields";
        }
        /* Invalid Credential */
        else if (!username.equals("admin") || !password.equals("123"))
        {
            error = "Invalid Credentials";
        }

        return error;
    }

}
