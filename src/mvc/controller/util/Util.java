package mvc.controller.util;

import mvc.model.dao.BaseDAO;
import mvc.model.dao.DaoExeption;
import mvc.model.dao.implementation.*;
import mvc.model.entity.Entity;
import mvc.model.entity.Locatii;
import mvc.model.entity.Rute;
import mvc.model.entity.Zile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class Util {
    public static <K extends Entity, T extends BaseDAO<Integer, K>> TableModel getDefaultTableModelSelectAll(T impl, Class entityClass) throws DaoExeption {
        String[] columNames = {};
        if(entityClass == Rute.class){
            columNames = new String[] {"persID", "codCursa", "dataPlecarii", "oraPlecarii", "locatieInitiala", "dataSosirii", "oraSosirii", "destinatie", "durata", "nrSaptamanii", "locDisponConfort", "locConfort", "pretConfort", "locDisponEco", "locEco", "pretEco", "idZiua"};
        } else if(entityClass == Locatii.class){
            columNames = new String[] {"persID", "idLocatie", "numeLocatie"};
        }

        DefaultTableModel tableModel = new DefaultTableModel();
        for(String column : columNames){
            tableModel.addColumn(column);
        }

        List<K> rows = impl.findAll();

        for(K row : rows){
            tableModel.addRow(row.toStringArr().toArray());
        }

        return tableModel;
    }

    public static void resetRuteTBL(JTable jTable){
        RuteDAOimpl ruteDAOimpl = new RuteDAOimpl();
        try {
            jTable.setModel(Util.getDefaultTableModelSelectAll(ruteDAOimpl, Rute.class));
        } catch (DaoExeption e) {
            throw new RuntimeException(e);
        }
    }

    public static void resetLocatiiTBL(JTable jTable){
        LocatiiDAOimpl locatiiDAOimpl = new LocatiiDAOimpl();
        try {
            jTable.setModel(Util.getDefaultTableModelSelectAll(locatiiDAOimpl, Locatii.class));
        } catch (DaoExeption e) {
            throw new RuntimeException(e);
        }
    }

    public static void resetRuteTempTBL(JTable jTable){
        RuteTempDAOimpl ruteTempDAOimpl = new RuteTempDAOimpl();
        try {
            jTable.setModel(Util.getDefaultTableModelSelectAll(ruteTempDAOimpl, Rute.class));
        } catch (DaoExeption e) {
            throw new RuntimeException(e);
        }
    }

    public static void resetRuteAnulareTBL(JTable jTable){
        RuteAnulateDAOimpl ruteAnulateDAOimpl = new RuteAnulateDAOimpl();
        try {
            jTable.setModel(Util.getDefaultTableModelSelectAll(ruteAnulateDAOimpl, Rute.class));
        } catch (DaoExeption e) {
            throw new RuntimeException(e);
        }
    }

    public static String makeDurataForStringArr(long durata){
        long diffMin = durata / (60 * 1000);
        long diffHours = (long) diffMin / 60;
        diffMin = diffMin % 60;

        return String.format("%02d:%02d", diffHours, diffMin);
    }

    public static void populateComboBoxWithLocation(JComboBox comboBox){
        LocatiiDAOimpl locatiiDAOimpl = new LocatiiDAOimpl();

        try {
            List<Locatii> locatii = locatiiDAOimpl.findAll();
            for(Locatii loc : locatii){
                comboBox.addItem(loc.getNumeLocatie());
            }

        } catch (DaoExeption e) {
            throw new RuntimeException(e);
        }
    }

    public static void populateComboBoxWithZile(JComboBox comboBox){
        ZileDAOimpl zileDAOimpl = new ZileDAOimpl();
        comboBox.addItem("");

        try{
            List<Zile> zile = zileDAOimpl.findAll();
            for(Zile ziua : zile){
                comboBox.addItem(ziua.getNumeZi());
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static Long makeDurata(Rute rute){
        String plecare = rute.getDataPlecarii() + "." + rute.getOraPlecarii().replace(":", ".");
        StringTokenizer st = new StringTokenizer(plecare, ".");

        int data = Integer.parseInt(st.nextToken());
        int luna = Integer.parseInt(st.nextToken())-1;
        int anul = Integer.parseInt(st.nextToken());
        int ora = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        Date datePornire = new Date(anul, luna, data, ora, min);

        String sosire = rute.getDataSosirii() + "." + rute.getOraSosirii().replace(":", ".");
        st = new StringTokenizer(sosire, ".");

        data = Integer.parseInt(st.nextToken());
        luna = Integer.parseInt(st.nextToken())-1;
        anul = Integer.parseInt(st.nextToken());
        ora = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());

        Date dateSosite = new Date(anul, luna, data, ora, min);

        return (long) dateSosite.getTime() - datePornire.getTime();
    }
}
