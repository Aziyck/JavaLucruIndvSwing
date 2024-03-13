package mvc.model.entity;

import mvc.controller.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Rute extends Entity{
    private int persID;
    private int codCursa;
    private String dataPlecarii;
    private String oraPlecarii;
    private int locatieInitiala;
    private String dataSosirii;
    private String oraSosirii;
    private int destinatie;
    private long durata;
    private int nrSaptamanii;
    private int locDisponConfort;
    private int locConfort;
    private float pretConfort;
    private int locDisponEco;
    private int locEco;
    private float pretEco;
    private int idZiua;

    public Rute() {
    }

    public Rute(int PersID, int codCursa, String dataPlecarii, String oraPlecarii, int locatieInitiala, String dataSosirii, String oraSosirii, int destinatie, long durata, int nrSaptamanii, int locDisponConfort, int locConfort, float pretConfort, int locDisponEco, int locEco, float pretEco, int idZiua) {
        this.persID = PersID;
        this.codCursa = codCursa;
        this.dataPlecarii = dataPlecarii;
        this.oraPlecarii = oraPlecarii;
        this.locatieInitiala = locatieInitiala;
        this.dataSosirii = dataSosirii;
        this.oraSosirii = oraSosirii;
        this.destinatie = destinatie;
        this.durata = durata;
        this.nrSaptamanii = nrSaptamanii;
        this.locDisponConfort = locDisponConfort;
        this.locConfort = locConfort;
        this.pretConfort = pretConfort;
        this.locDisponEco = locDisponEco;
        this.locEco = locEco;
        this.pretEco = pretEco;
        this.idZiua = idZiua;
    }

    public int getPersID() {
        return persID;
    }

    public void setPersID(int persID) {
        this.persID = persID;
    }

    public int getCodCursa() {
        return codCursa;
    }

    public void setCodCursa(int codCursa) {
        this.codCursa = codCursa;
    }

    public String getDataPlecarii() {
        return dataPlecarii;
    }

    public void setDataPlecarii(String dataPlecarii) {
        this.dataPlecarii = dataPlecarii;
    }

    public String getOraPlecarii() {
        return oraPlecarii;
    }

    public void setOraPlecarii(String oraPlecarii) {
        this.oraPlecarii = oraPlecarii;
    }

    public int getLocatieInitiala() {
        return locatieInitiala;
    }

    public void setLocatieInitiala(int locatieInitiala) {
        this.locatieInitiala = locatieInitiala;
    }

    public String getDataSosirii() {
        return dataSosirii;
    }

    public void setDataSosirii(String dataSosirii) {
        this.dataSosirii = dataSosirii;
    }

    public String getOraSosirii() {
        return oraSosirii;
    }

    public void setOraSosirii(String oraSosirii) {
        this.oraSosirii = oraSosirii;
    }

    public int getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(int destinatie) {
        this.destinatie = destinatie;
    }

    public long getDurata() {
        return durata;
    }

    public void setDurata(long durata) {
        this.durata = durata;
    }

    public int getNrSaptamanii() {
        return nrSaptamanii;
    }

    public void setNrSaptamanii(int nrSaptamanii) {
        this.nrSaptamanii = nrSaptamanii;
    }

    public int getLocDisponConfort() {
        return locDisponConfort;
    }

    public void setLocDisponConfort(int locDisponConfort) {
        this.locDisponConfort = locDisponConfort;
    }

    public int getLocConfort() {
        return locConfort;
    }

    public void setLocConfort(int locConfort) {
        this.locConfort = locConfort;
    }

    public float getPretConfort() {
        return pretConfort;
    }

    public void setPretConfort(float pretConfort) {
        this.pretConfort = pretConfort;
    }

    public int getLocDisponEco() {
        return locDisponEco;
    }

    public void setLocDisponEco(int locDisponEco) {
        this.locDisponEco = locDisponEco;
    }

    public int getLocEco() {
        return locEco;
    }

    public void setLocEco(int locEco) {
        this.locEco = locEco;
    }

    public float getPretEco() {
        return pretEco;
    }

    public void setPretEco(float pretEco) {
        this.pretEco = pretEco;
    }

    public int getIdZiua() {
        return idZiua;
    }

    public void setIdZiua(int idZiua) {
        this.idZiua = idZiua;
    }

    @Override
    public String toString() {
        return "Rute{" +
                "persID=" + persID +
                ", codCursa=" + codCursa +
                ", dataPlecarii='" + dataPlecarii + '\'' +
                ", oraPlecarii='" + oraPlecarii + '\'' +
                ", locatieInitiala=" + locatieInitiala +
                ", dataSosirii='" + dataSosirii + '\'' +
                ", oraSosirii='" + oraSosirii + '\'' +
                ", destinatie=" + destinatie +
                ", durata=" + durata +
                ", nrSaptamanii=" + nrSaptamanii +
                ", locDisponConfort=" + locDisponConfort +
                ", locConfort=" + locConfort +
                ", pretConfort=" + pretConfort +
                ", locDisponEco=" + locDisponEco +
                ", locEco=" + locEco +
                ", pretEco=" + pretEco +
                ", idZiua=" + idZiua +
                '}';
    }

    @Override
    public ArrayList<String> toStringArr() {
        return new ArrayList<String>(List.of(
                Integer.toString(persID),
                Integer.toString(codCursa),
                dataPlecarii,
                oraPlecarii,
                Integer.toString(locatieInitiala),
                dataSosirii,
                oraSosirii,
                Integer.toString(destinatie),
                Util.makeDurataForStringArr(durata),
                Integer.toString(nrSaptamanii),
                Integer.toString(locDisponConfort),
                Integer.toString(locConfort),
                Float.toString(pretConfort),
                Integer.toString(locDisponEco),
                Integer.toString(locEco),
                Float.toString(pretEco),
                Integer.toString(idZiua)
        ));
    }
}
