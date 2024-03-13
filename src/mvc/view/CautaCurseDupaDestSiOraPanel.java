package mvc.view;

import mvc.controller.util.Util;
import mvc.model.dao.DaoExeption;
import mvc.model.dao.implementation.RuteDAOimpl;
import mvc.model.entity.Rute;

import javax.swing.*;
import java.awt.*;

public class CautaCurseDupaDestSiOraPanel extends JFrame {

    private JPanel mainPanel;
    private JButton clear_Btn;
    private JButton findByHour_Btn;
    private JComboBox locFinal_CB;
    private JTextField oraPlecarii_TF;
    private JTextField oraSosirii_TF;
    private JTable rute_Tbl;
    private JButton sorteazaInOrdineaCrescatoare_Btn;
    private JTextField pretMedCm_TF;
    private JLabel oraPlecarii_ErrLbl;
    private JLabel oraSosirii_ErrLbl;
    private JTextField pretMedEcTF;
    private JTextField pretMedGeneral_TF;

    public CautaCurseDupaDestSiOraPanel() throws HeadlessException {
        setContentPane(mainPanel);

       Util.resetRuteTBL(rute_Tbl);

        Util.populateComboBoxWithLocation(locFinal_CB);
    }
}
