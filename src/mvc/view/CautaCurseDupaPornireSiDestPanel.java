package mvc.view;

import mvc.controller.util.Util;
import mvc.model.dao.DaoExeption;
import mvc.model.dao.implementation.RuteDAOimpl;
import mvc.model.entity.Rute;

import javax.swing.*;

public class CautaCurseDupaPornireSiDestPanel extends JFrame{
    private JPanel mainPanel;
    private JTable rute_Tbl;
    private JComboBox locInit_CB;
    private JComboBox locFinal_CB;
    private JButton sorteazaDupaDurataDeDepl_Btn;

    public CautaCurseDupaPornireSiDestPanel(){
        setContentPane(mainPanel);

        Util.resetRuteTBL(rute_Tbl);

        Util.populateComboBoxWithLocation(locInit_CB);
        Util.populateComboBoxWithLocation(locFinal_CB);
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

    public JButton getSorteazaDupaDurataDeDepl_Btn() {
        return sorteazaDupaDurataDeDepl_Btn;
    }

    public void setSorteazaDupaDurataDeDepl_Btn(JButton sorteazaDupaDurataDeDepl_Btn) {
        this.sorteazaDupaDurataDeDepl_Btn = sorteazaDupaDurataDeDepl_Btn;
    }

    public void showMsg(String errMesage){
        JOptionPane.showMessageDialog(this, errMesage);
    }
}
