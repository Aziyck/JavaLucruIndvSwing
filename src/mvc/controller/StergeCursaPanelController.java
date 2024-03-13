package mvc.controller;

import mvc.controller.util.Util;
import mvc.model.dao.implementation.RuteAnulateDAOimpl;
import mvc.model.dao.implementation.RuteDAOimpl;
import mvc.model.entity.Rute;
import mvc.view.StergeCurse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StergeCursaPanelController {
    StergeCurse view;

    public StergeCursaPanelController(StergeCurse view) {
        this.view = view;

        view.getDelete_Btn().addActionListener(new StergeBtnActionListener());
    }

    class StergeBtnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                RuteDAOimpl ruteDAOimpl = new RuteDAOimpl();
                RuteAnulateDAOimpl ruteAnulateDAOimpl = new RuteAnulateDAOimpl();

                int id = Integer.parseInt(view.getCodCursa_TF().getText());
                Rute rutaToDelete = ruteDAOimpl.findEntityById(id);
                ruteAnulateDAOimpl.create(rutaToDelete);
                ruteDAOimpl.delete(rutaToDelete);

                Util.resetRuteTBL(view.getRute_Tbl());
                view.getCodCursa_TF().setText("");
                view.showMsg("Ruta anulata!");
            }catch (Exception ex){
                view.showMsg("Eroare:\n" + ex.toString());
            }

        }
    }
}
