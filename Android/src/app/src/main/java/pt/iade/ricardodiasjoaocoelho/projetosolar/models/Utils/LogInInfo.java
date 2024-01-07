package pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils;

import java.io.Serializable;

public class LogInInfo implements Serializable {
    String username;
    String password;

    public LogInInfo(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }

}
