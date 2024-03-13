package mvc.view;

import mvc.controller.util.Util;
import mvc.model.dao.DaoExeption;
import mvc.model.dao.implementation.RuteDAOimpl;
import mvc.model.entity.Rute;

import javax.swing.*;

public class ActualizeazaCalatori extends JFrame{
    private JPanel mainPanel;
    private JTextField codCursa_TF;
    private JButton updateAll_Btn;
    private JButton clearAll_Btn;
    private JTextField popLocEc1_TF;
    private JTextField elibLocEc1_TF;
    private JButton updateEc1_btn;
    private JTable rute_Tbl;
    private JTextField locLibEc1_TF;
    private JLabel codCursa_ErrLbl;
    private JTextField locOcpEc1_TF;
    private JLabel popLocEc1_ErrLbl;
    private JLabel elibLocEc1_ErrLbl;
    private JButton clearEc1_Btn;
    private JTextField locLibCm1_TF;
    private JTextField locOcpCm1_TF;
    private JTextField popLocCm1_TF;
    private JTextField elibLocCm1_TF;
    private JLabel popLocCm1_ErrLbl;
    private JLabel elibLocCm1_ErrLbl;
    private JButton clearCm1_Btn;
    private JButton updateCm1_btn;

    public ActualizeazaCalatori() {
        setContentPane(mainPanel);
        Util.resetRuteTBL(rute_Tbl);
    }
}
