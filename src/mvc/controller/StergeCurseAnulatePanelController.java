package mvc.controller;

import mvc.controller.util.Util;
import mvc.model.dao.implementation.RuteAnulateDAOimpl;
import mvc.model.dao.implementation.RuteDAOimpl;
import mvc.model.entity.Rute;
import mvc.view.StergeCurseAnulate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StergeCurseAnulatePanelController {
    StergeCurseAnulate view;

    public StergeCurseAnulatePanelController(StergeCurseAnulate view) {
        this.view = view;

        view.getDelete_Btn().addActionListener(new StergeBtnActionListener());
        view.getRestore_Btn().addActionListener(new RestabilesteBtnActionListener());
    }

    class StergeBtnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                RuteAnulateDAOimpl ruteAnulateDAOimpl = new RuteAnulateDAOimpl();

                int id = Integer.parseInt(view.getCodCursa_TF().getText());
                Rute rutaToDelete = ruteAnulateDAOimpl.findEntityById(id);
                ruteAnulateDAOimpl.delete(rutaToDelete);

                Util.resetRuteAnulareTBL(view.getRute_Tbl());
                view.getCodCursa_TF().setText("");
                view.showMsg("Ruta stearsa!");
            }catch (Exception ex){
                view.showMsg("Eroare:\n" + ex.toString());
            }

        }
    }

    class RestabilesteBtnActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                RuteAnulateDAOimpl ruteAnulateDAOimpl = new RuteAnulateDAOimpl();
                RuteDAOimpl ruteDAOimpl = new RuteDAOimpl();

                int id = Integer.parseInt(view.getCodCursa_TF().getText());
                Rute ruteToUplift = ruteAnulateDAOimpl.findEntityById(id);
                ruteDAOimpl.create(ruteToUplift);
                ruteAnulateDAOimpl.delete(ruteToUplift);

                Util.resetRuteAnulareTBL(view.getRute_Tbl());
                view.getCodCursa_TF().setText("");
                view.showMsg("Ruta restabilita!");
            }catch (Exception ex){
                view.showMsg("Eroare:\n" + ex.toString());
            }

        }
    }
}
