package pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils;

import java.io.Serializable;

public class ChangeUserString implements Serializable {
    int userId;
    String value;

    public ChangeUserString(int userId, String value){
        this.userId = userId;
        this.value = value;
    }

    public int getUserId() {
        return userId;
    }

    public String getValue() {
        return value;
    }
}
