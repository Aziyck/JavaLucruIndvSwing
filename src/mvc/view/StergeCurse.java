package mvc.view;

import mvc.controller.util.Util;
import mvc.model.dao.DaoExeption;
import mvc.model.dao.implementation.RuteAnulateDAOimpl;
import mvc.model.dao.implementation.RuteDAOimpl;
import mvc.model.entity.Rute;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StergeCurse extends JFrame{
    private JPanel mainPanel;
    private JTable rute_Tbl;
    private JButton delete_Btn;
    private JTextField codCursa_TF;

    public StergeCurse() throws HeadlessException {
        setContentPane(mainPanel);

        Util.resetRuteTBL(rute_Tbl);
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

    public JButton getDelete_Btn() {
        return delete_Btn;
    }

    public void setDelete_Btn(JButton delete_Btn) {
        this.delete_Btn = delete_Btn;
    }

    public JTextField getCodCursa_TF() {
        return codCursa_TF;
    }

    public void setCodCursa_TF(JTextField codCursa_TF) {
        this.codCursa_TF = codCursa_TF;
    }

    public void showMsg(String errMesage){
        JOptionPane.showMessageDialog(this, errMesage);
    }
}
