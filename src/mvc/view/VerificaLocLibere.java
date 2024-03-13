package mvc.view;

import mvc.controller.util.Util;
import mvc.model.dao.DaoExeption;
import mvc.model.dao.implementation.RuteDAOimpl;
import mvc.model.entity.Rute;

import javax.swing.*;

public class VerificaLocLibere extends JFrame {
    private JPanel mainPanel;
    private JTextField codCursa_TF;
    private JButton clear_Btn;
    private JTable rute_Tbl;
    private JLabel codCursa_ErrTbl;
    private JTextField locLibEc1_TF;
    private JTextField locLibEc2_TF;
    private JTextField locOcupEc1_TF;
    private JTextField locOcupEc2_TF;
    private JTextField locLibCm1_TF;
    private JTextField locOcupCm1_TF;
    private JTextField locLibCm2_TF;
    private JTextField locOcupCm2_TF;

    public VerificaLocLibere() {
        setContentPane(mainPanel);

        Util.resetRuteTBL(rute_Tbl);
    }


}
