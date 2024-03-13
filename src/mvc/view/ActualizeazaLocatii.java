package mvc.view;

import mvc.controller.util.Util;
import mvc.model.dao.DaoExeption;
import mvc.model.dao.implementation.LocatiiDAOimpl;
import mvc.model.dao.implementation.RuteDAOimpl;
import mvc.model.entity.Locatii;

import javax.swing.*;

public class ActualizeazaLocatii extends JFrame{
    private JPanel mainPanel;
    private JTable locatii_Tbl;
    private JTextField numeLocatie_TF;
    private JButton addLocatie_Btn;
    private JButton deleteLocatie_Btn;

    public ActualizeazaLocatii(){
        setContentPane(mainPanel);

        Util.resetLocatiiTBL(locatii_Tbl);
    }
}
