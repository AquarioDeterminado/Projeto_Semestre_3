package pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils;

import java.io.Serializable;

public class AuthChangeUserString implements Serializable {
private int userID;
private String password;
private String newValue;

    public AuthChangeUserString(int userID, String password, String newValue){
        this.userID = userID;
        this.password = password;
        this.newValue = newValue;
    }

    public int getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getNewValue() {
        return newValue;
    }
}
