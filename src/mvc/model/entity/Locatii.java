package mvc.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Locatii extends Entity{
    int persID;
    int idLocatie;
    String numeLocatie;

    public Locatii() {
    }

    public Locatii(int persID, int idLocatie, String numeLocatie) {
        this.persID = persID;
        this.idLocatie = idLocatie;
        this.numeLocatie = numeLocatie;
    }

    public Locatii(int persID, String numeLocatie) {
        this.persID = persID;
        this.numeLocatie = numeLocatie;
    }

    public int getPersID() {
        return persID;
    }

    public void setPersID(int persID) {
        this.persID = persID;
    }

    public int getIdLocatie() {
        return idLocatie;
    }

    public void setIdLocatie(int idLocatie) {
        this.idLocatie = idLocatie;
    }

    public String getNumeLocatie() {
        return numeLocatie;
    }

    public void setNumeLocatie(String numeLocatie) {
        this.numeLocatie = numeLocatie;
    }

    @Override
    public String toString() {
        return "Locatii{" +
                "persID=" + persID +
                ", idLocatie=" + idLocatie +
                ", numeLocatie='" + numeLocatie + '\'' +
                '}';
    }

    @Override
    public ArrayList<String> toStringArr() {
        return new ArrayList<>(List.of(
                Integer.toString(persID),
                Integer.toString(idLocatie),
                numeLocatie
        ));
    }
}

