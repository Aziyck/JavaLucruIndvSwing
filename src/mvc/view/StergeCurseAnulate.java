package mvc.view;

import mvc.controller.util.Util;
import mvc.model.dao.DaoExeption;
import mvc.model.dao.implementation.RuteAnulateDAOimpl;
import mvc.model.dao.implementation.RuteDAOimpl;
import mvc.model.entity.Rute;

import javax.swing.*;
import java.awt.*;

public class StergeCurseAnulate extends JFrame{
    private JPanel mainPanel;
    private JTable rute_Tbl;
    private JTextField codCursa_TF;
    private JButton restore_Btn;
    private JButton delete_Btn;

    public StergeCurseAnulate() throws HeadlessException {
        setContentPane(mainPanel);

        Util.resetRuteAnulareTBL(rute_Tbl);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTable getRute_Tbl() {
        return rute_Tbl;
    }

    public void setRute_Tbl(JTable rute_Tbl) {
        this.rute_Tbl = rute_Tbl;
    }

    public JTextField getCodCursa_TF() {
        return codCursa_TF;
    }

    public void setCodCursa_TF(JTextField codCursa_TF) {
        this.codCursa_TF = codCursa_TF;
    }

    public JButton getRestore_Btn() {
        return restore_Btn;
    }

    public void setRestore_Btn(JButton restore_Btn) {
        this.restore_Btn = restore_Btn;
    }

    public JButton getDelete_Btn() {
        return delete_Btn;
    }

    public void setDelete_Btn(JButton delete_Btn) {
        this.delete_Btn = delete_Btn;
    }

    public void showMsg(String errMesage){
        JOptionPane.showMessageDialog(this, errMesage);
    }
}
