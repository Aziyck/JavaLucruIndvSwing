package mvc.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Zile extends Entity{
    int persID;
    int idZiua;
    String numeZi;

    public Zile() {
    }

    public Zile(int persID, int idZiua, String numeZi) {
        this.persID = persID;
        this.idZiua = idZiua;
        this.numeZi = numeZi;
    }

    public Zile(int persID, String numeZi) {
        this.persID = persID;
        this.numeZi = numeZi;
    }

    public int getPersID() {
        return persID;
    }

    public void setPersID(int persID) {
        this.persID = persID;
    }

    public int getIdZiua() {
        return idZiua;
    }

    public void setIdZiua(int idZiua) {
        this.idZiua = idZiua;
    }

    public String getNumeZi() {
        return numeZi;
    }

    public void setNumeZi(String numeZi) {
        this.numeZi = numeZi;
    }

    @Override
    public String toString() {
        return "Zile{" +
                "persID=" + persID +
                ", idZiua=" + idZiua +
                ", numeZi='" + numeZi + '\'' +
                '}';
    }

    @Override
    public ArrayList<String> toStringArr() {
        return new ArrayList<>(List.of(
                Integer.toString(persID),
                Integer.toString(idZiua),
                numeZi
        ));
    }
}