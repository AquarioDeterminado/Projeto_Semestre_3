package pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils;


import java.io.Serializable;

public class Id implements Serializable {
    int id;

    public Id(int id) {
        this.id = id;
    }

    public int getId() { return id; }
}

