package mvc.view;

import mvc.controller.util.Util;
import mvc.model.dao.DaoExeption;
import mvc.model.dao.implementation.RuteDAOimpl;
import mvc.model.entity.Rute;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class AdaugaCursaPanel extends JFrame {
    public static final Date INITIAL_WEEK = new Date(124, Calendar.MARCH,4);
    private JPanel mainPanel;
    private JTextField dataPlecarii_TF;
    private JTextField oraPlecarii_TF;
    private JTextField codCursa_TF;
    private JTextField durata_TF;
    private JTextField nrSapt_TF;
    private JButton add_Btn;
    private JButton clear_Btn;
    private JTable rute_Tbl;
    private JLabel dataPlecarii_ErrLbl;
    private JPanel oraPlecarii_ErrLbl;
    private JComboBox locInit_CB;
    private JComboBox locFinal_CB;
    private JTextField dataSosirii_TF;
    private JTextField oraSosirii_TF;
    private JLabel durata_ErrLbl;
    private JLabel nrSapt_ErrLbl;
    private JLabel ziuaPlecarii_ErrLbl;
    private JTextField locEcD_TF;
    private JTextField locEcO_TF;
    private JTextField pretEc_TF;
    private JTextField locCmD_TF;
    private JTextField locCmO_TF;
    private JTextField pretCm_TF;
    private JComboBox ziuaPlecarii_CB;

    public AdaugaCursaPanel() {
        setContentPane(mainPanel);

        Util.resetRuteTBL(rute_Tbl);

        Util.populateComboBoxWithLocation(locInit_CB);
        Util.populateComboBoxWithLocation(locFinal_CB);
        Util.populateComboBoxWithZile(ziuaPlecarii_CB);
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTextField getDataPlecarii_TF() {
        return dataPlecarii_TF;
    }

    public void setDataPlecarii_TF(JTextField dataPlecarii_TF) {
        this.dataPlecarii_TF = dataPlecarii_TF;
    }

    public JTextField getOraPlecarii_TF() {
        return oraPlecarii_TF;
    }

    public void setOraPlecarii_TF(JTextField oraPlecarii_TF) {
        this.oraPlecarii_TF = oraPlecarii_TF;
    }

    public JTextField getCodCursa_TF() {
        return codCursa_TF;
    }

    public void setCodCursa_TF(JTextField codCursa_TF) {
        this.codCursa_TF = codCursa_TF;
    }

    public JTextField getDurata_TF() {
        return durata_TF;
    }

    public void setDurata_TF(JTextField durata_TF) {
        this.durata_TF = durata_TF;
    }

    public JTextField getNrSapt_TF() {
        return nrSapt_TF;
    }

    public void setNrSapt_TF(JTextField nrSapt_TF) {
        this.nrSapt_TF = nrSapt_TF;
    }

    public JButton getAdd_Btn() {
        return add_Btn;
    }

    public void setAdd_Btn(JButton add_Btn) {
        this.add_Btn = add_Btn;
    }

    public JButton getClear_Btn() {
        return clear_Btn;
    }

    public void setClear_Btn(JButton clear_Btn) {
        this.clear_Btn = clear_Btn;
    }

    public JTable getRute_Tbl() {
        return rute_Tbl;
    }

    public void setRute_Tbl(JTable rute_Tbl) {
        this.rute_Tbl = rute_Tbl;
    }

    public JLabel getDataPlecarii_ErrLbl() {
        return dataPlecarii_ErrLbl;
    }

    public void setDataPlecarii_ErrLbl(JLabel dataPlecarii_ErrLbl) {
        this.dataPlecarii_ErrLbl = dataPlecarii_ErrLbl;
    }

    public JPanel getOraPlecarii_ErrLbl() {
        return oraPlecarii_ErrLbl;
    }

    public void setOraPlecarii_ErrLbl(JPanel oraPlecarii_ErrLbl) {
        this.oraPlecarii_ErrLbl = oraPlecarii_ErrLbl;
    }

    public JComboBox getLocInit_CB() {
        return locInit_CB;
    }

    public void setLocInit_CB(JComboBox locInit_CB) {
        this.locInit_CB = locInit_CB;
    }

    public JComboBox getLocFinal_CB() {
        return locFinal_CB;
    }

    public void setLocFinal_CB(JComboBox locFinal_CB) {
        this.locFinal_CB = locFinal_CB;
    }

    public JTextField getDataSosirii_TF() {
        return dataSosirii_TF;
    }

    public void setDataSosirii_TF(JTextField dataSosirii_TF) {
        this.dataSosirii_TF = dataSosirii_TF;
    }

    public JTextField getOraSosirii_TF() {
        return oraSosirii_TF;
    }

    public void setOraSosirii_TF(JTextField oraSosirii_TF) {
        this.oraSosirii_TF = oraSosirii_TF;
    }

    public JLabel getDurata_ErrLbl() {
        return durata_ErrLbl;
    }

    public void setDurata_ErrLbl(JLabel durata_ErrLbl) {
        this.durata_ErrLbl = durata_ErrLbl;
    }

    public JLabel getNrSapt_ErrLbl() {
        return nrSapt_ErrLbl;
    }

    public void setNrSapt_ErrLbl(JLabel nrSapt_ErrLbl) {
        this.nrSapt_ErrLbl = nrSapt_ErrLbl;
    }

    public JLabel getZiuaPlecarii_ErrLbl() {
        return ziuaPlecarii_ErrLbl;
    }

    public void setZiuaPlecarii_ErrLbl(JLabel ziuaPlecarii_ErrLbl) {
        this.ziuaPlecarii_ErrLbl = ziuaPlecarii_ErrLbl;
    }

    public JTextField getLocEcD_TF() {
        return locEcD_TF;
    }

    public void setLocEcD_TF(JTextField locEc1_TF) {
        this.locEcD_TF = locEc1_TF;
    }

    public JTextField getLocEcO_TF() {
        return locEcO_TF;
    }

    public void setLocEcO_TF(JTextField locEc2_TF) {
        this.locEcO_TF = locEc2_TF;
    }

    public JTextField getPretEc_TF() {
        return pretEc_TF;
    }

    public void setPretEc_TF(JTextField pretEc_TF) {
        this.pretEc_TF = pretEc_TF;
    }

    public JTextField getLocCmD_TF() {
        return locCmD_TF;
    }

    public void setLocCmD_TF(JTextField locCm1_TF) {
        this.locCmD_TF = locCm1_TF;
    }

    public JTextField getLocCmO_TF() {
        return locCmO_TF;
    }

    public void setLocCmO_TF(JTextField locCm2_TF) {
        this.locCmO_TF = locCm2_TF;
    }

    public JTextField getPretCm_TF() {
        return pretCm_TF;
    }

    public void setPretCm_TF(JTextField pretCm_TF) {
        this.pretCm_TF = pretCm_TF;
    }

    public JComboBox getZiuaPlecarii_CB() {
        return ziuaPlecarii_CB;
    }

    public void setZiuaPlecarii_CB(JComboBox ziuaPlecarii_CB) {
        this.ziuaPlecarii_CB = ziuaPlecarii_CB;
    }

    public void showMsg(String errMesage){
        JOptionPane.showMessageDialog(this, errMesage);
    }
}
