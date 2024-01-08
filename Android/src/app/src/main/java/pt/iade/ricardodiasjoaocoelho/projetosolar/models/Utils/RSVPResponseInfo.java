package pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils;

public class RSVPResponseInfo {

    String message;
    boolean success;
    int id;

    public RSVPResponseInfo(String message, boolean success, int id) {
        this.message = message;
        this.success = success;
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getId() {
        return id;
    }
}
