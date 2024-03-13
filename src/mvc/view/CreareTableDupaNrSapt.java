package mvc.view;

import mvc.controller.util.Util;
import mvc.model.dao.DaoExeption;
import mvc.model.dao.implementation.RuteDAOimpl;
import mvc.model.dao.implementation.RuteTempDAOimpl;
import mvc.model.entity.Rute;

import javax.swing.*;

public class CreareTableDupaNrSapt extends JFrame{
    private JPanel mainPanel;
    private JTextField codSapt_TF;
    private JButton addData_Btn;
    private JTable rute_Tbl;
    private JTable ruteDupaNrSapt_Tbl;

    public CreareTableDupaNrSapt(){
        setContentPane(mainPanel);

        Util.resetRuteTBL(rute_Tbl);
        Util.resetRuteTempTBL(ruteDupaNrSapt_Tbl);

    }
}
