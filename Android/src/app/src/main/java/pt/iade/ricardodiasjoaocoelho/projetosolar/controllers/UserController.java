package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Subscription;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.User_Info;

public class UserController {

    UserController(int userId) {
        User_Info user = User_Info.getUserById(userId, "123");
    }
    public String ChangeName(User_Info user, String newName) {
        String error = "";
        // TODO: Change name in database
        /*
        if (newName.isEmpty()) {
            error = "Empty Name";
        } else {
            user.usr_name = newName;
        }
        */
        return error;
    }
    public String ChangePassword(User_Info user, String newPassword1, String newPassword2) {
        String error = "";
            /*
        if(newPassword1 == newPassword2) {
            if (newPassword.isEmpty()) {
                error = "Empty Password";
            }else if (newPassword.length() > 8) {
                error = "Password too short";
            }else if(newPassword == oldPassword) {
                error = "Password already in use";
            }else {
                user.usr_password = newPassword;
            }
            */
        }
        return error;
    }

}