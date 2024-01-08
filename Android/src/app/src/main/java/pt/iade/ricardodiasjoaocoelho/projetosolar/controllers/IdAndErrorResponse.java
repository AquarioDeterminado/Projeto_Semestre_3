package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import java.io.Serializable;

public class IdAndErrorResponse implements Serializable {
    private int id;
    private String error;

    public IdAndErrorResponse(int id, String error) {
        this.id = id;
        this.error = error;
    }
    public int getId() {
        return id;
    }

    public String getError() {
        return error;
    }

}
