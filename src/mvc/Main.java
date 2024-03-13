package mvc;

import mvc.controller.AdaugaCursaPanelController;
import mvc.controller.CautaCurseDupaPornireSiDestPaneController;
import mvc.controller.StergeCursaPanelController;
import mvc.controller.StergeCurseAnulatePanelController;
import mvc.view.CautaCurseDupaPornireSiDestPanel;
import mvc.view.MainView;
import java.awt.*;
import java.sql.SQLException;

//TODO: E:\JavaPrograms\Labs\Weeb6\GaraFeroviara\src\dao

public class Main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(() -> {
            MainView frame = new MainView();
            AdaugaCursaPanelController adaugaCursaPanelController = new AdaugaCursaPanelController(frame.getAdaugaCursaPanelView());
            StergeCursaPanelController stergeCursaPanelController = new StergeCursaPanelController(frame.getStergeCurseView());
            StergeCurseAnulatePanelController stergeCurseAnulatePanelController = new StergeCurseAnulatePanelController(frame.getStergeCurseAnulateView());
            CautaCurseDupaPornireSiDestPaneController cautaCurseDupaPornireSiDestPanel = new CautaCurseDupaPornireSiDestPaneController(frame.getCautaCurseDupaPornireSiDestPanelView());
            frame.setVisible(true);
        });


    }
}
