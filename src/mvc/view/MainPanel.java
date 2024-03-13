package mvc.view;

import mvc.controller.util.Util;
import mvc.model.dao.DaoExeption;
import mvc.model.dao.implementation.RuteDAOimpl;
import mvc.model.entity.Rute;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JFrame{
    private JPanel mainPanel;
    private JTable rute_Tbl;

    public MainPanel() throws HeadlessException {
        setContentPane(mainPanel);

        Util.resetRuteTBL(rute_Tbl);
    }
}
