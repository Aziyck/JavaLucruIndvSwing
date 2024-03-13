package mvc.controller;

import mvc.model.dao.implementation.RuteDAOimpl;
import mvc.model.entity.Locatii;
import mvc.model.entity.Rute;
import mvc.view.CautaCurseDupaPornireSiDestPanel;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class CautaCurseDupaPornireSiDestPaneController {
    CautaCurseDupaPornireSiDestPanel view;

    public CautaCurseDupaPornireSiDestPaneController(CautaCurseDupaPornireSiDestPanel cautaCurseDupaPornireSiDestPanel) {
        this.view = cautaCurseDupaPornireSiDestPanel;

        LocatieCBItemListener locatieCBItemListener = new LocatieCBItemListener();
        view.getLocFinal_CB().addItemListener(locatieCBItemListener);
        view.getLocInit_CB().addItemListener(locatieCBItemListener);
    }

    class LocatieCBItemListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            view.getRute_Tbl().setModel(findBySelectedLocations());
        }
    }

    public TableModel findBySelectedLocations(){
        try{
            String[] columNames = new String[] {"persID", "codCursa", "dataPlecarii", "oraPlecarii", "locatieInitiala", "dataSosirii", "oraSosirii", "destinatie", "durata", "nrSaptamanii", "locDisponConfort", "locConfort", "pretConfort", "locDisponEco", "locEco", "pretEco", "idZiua"};

            DefaultTableModel tableModel = new DefaultTableModel();
            for(String column : columNames){
                tableModel.addColumn(column);
            }

            RuteDAOimpl ruteDAOimpl = new RuteDAOimpl();
            List<Rute> rows = ruteDAOimpl.findEntityByLocInitAndDest(view.getLocInit_CB().getSelectedIndex()+1, view.getLocFinal_CB().getSelectedIndex()+1);

            for(Rute row : rows){
                tableModel.addRow(row.toStringArr().toArray());
            }

            return tableModel;
        }catch (Exception ex){
            view.showMsg("Eroare:\n" + ex.toString());
        };
        return null;
    }
}
