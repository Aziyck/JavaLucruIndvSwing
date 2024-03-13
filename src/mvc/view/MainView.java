package mvc.view;

import mvc.controller.util.Util;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

//    TODO: create class create Menu (Name, MyMenuItems[StringArr])
//    TODO: MyMenuItem (Name, MyMenuItems[StringArr])

    private AdaugaCursaPanel adaugaCursaPanelView;
    private StergeCurse stergeCurseView;
    private StergeCurseAnulate stergeCurseAnulateView;
    private CautaCurseDupaPornireSiDestPanel cautaCurseDupaPornireSiDestPanelView;
    private void initApp(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Java GUI Tutorial App");

        adaugaCursaPanelView = new AdaugaCursaPanel();
        stergeCurseView = new StergeCurse();
        stergeCurseAnulateView = new StergeCurseAnulate();
        cautaCurseDupaPornireSiDestPanelView = new CautaCurseDupaPornireSiDestPanel();
    }

    private void initNewLayoutChange(JPanel panel, String title){
        panel.setBorder(BorderFactory.createTitledBorder(title));
        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().doLayout();
        panel.revalidate();
        pack();
        setLocationRelativeTo(null);
    }

    private void initNewLayoutChange(JPanel panel){
        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().doLayout();
        panel.revalidate();
        pack();
        setLocationRelativeTo(null);
    }
    private JMenu createCurseMenu(){
        JMenu menu = new JMenu("Curse");

//      Adauga Curse Menu (1)
        JMenuItem agaugaCurseMenu = new JMenuItem("Adauga curse"); menu.add(agaugaCurseMenu);

        agaugaCurseMenu.addActionListener(e -> {
                JPanel adaugaCursaJPanel = (JPanel) adaugaCursaPanelView.getContentPane();
                Util.resetRuteTBL(adaugaCursaPanelView.getRute_Tbl());
                initNewLayoutChange(adaugaCursaJPanel, "Adauga curse");
            });

//      Cautare Curse Menu
        JMenu cautaCurseMenu = new JMenu("Cauta curse"); menu.add(cautaCurseMenu);
//          Cauta curse dupa destinatie si ora (7)
        JMenuItem cautaCurseDupaDestSiOra = new JMenuItem("Dupa destinatie si ora de pornire si sosire"); cautaCurseMenu.add(cautaCurseDupaDestSiOra);
        cautaCurseDupaDestSiOra.addActionListener(e -> {
            JPanel cautaCurseDupaDestSiOraPanel = (JPanel) new CautaCurseDupaDestSiOraPanel().getContentPane();
            initNewLayoutChange(cautaCurseDupaDestSiOraPanel, "Cauta curse");
        });
//          Cauta curse dupa punct de pornire si destinatie (6) (5) (3)
        JMenuItem cautaCurseDupaPornireSiDestiantie = new JMenuItem("Dupa punct de pornire si destinatie"); cautaCurseMenu.add(cautaCurseDupaPornireSiDestiantie);
        cautaCurseDupaPornireSiDestiantie.addActionListener(e -> {
            JPanel cautaCurseDupaPornireSiDestPanel = (JPanel) cautaCurseDupaPornireSiDestPanelView.getContentPane();
            Util.resetRuteTBL(cautaCurseDupaPornireSiDestPanelView.getRute_Tbl());
            initNewLayoutChange(cautaCurseDupaPornireSiDestPanel, "Cauta curse");
        });

//      Sterge Curse menu
        JMenu stergeCurseMenu = new JMenu("Sterge curse"); menu.add(stergeCurseMenu);
//          Sterge curse actuale (Anuleaza curse) (2)
        JMenuItem anulezaCurseActuale = new JMenuItem("Anuleaza curse"); stergeCurseMenu.add(anulezaCurseActuale);
        anulezaCurseActuale.addActionListener(e -> {
            JPanel stergeCursePanel = (JPanel) stergeCurseView.getContentPane();
            Util.resetRuteTBL(stergeCurseView.getRute_Tbl());
            initNewLayoutChange(stergeCursePanel, "Anuleaza curse");
        });
//          Sterge curse Anulate (2)
        JMenuItem stergeCurseAnulate = new JMenuItem("Sterge curse anulate"); stergeCurseMenu.add(stergeCurseAnulate);
        stergeCurseAnulate.addActionListener(e -> {
            JPanel stergeCurseAnulatePanel = (JPanel) stergeCurseAnulateView.getContentPane();
            Util.resetRuteAnulareTBL(stergeCurseAnulateView.getRute_Tbl());
            initNewLayoutChange(stergeCurseAnulatePanel, "Sterge curse anulate");
        });

        return menu;
    }

    private JMenu createCalatoriMenu(){
        JMenu menu = new JMenu("Calatori");

//      Actualizeaza Calatori Menu
        JMenuItem agaugaCalatoriMenu = new JMenuItem("Actualizează calatori"); menu.add(agaugaCalatoriMenu);
        agaugaCalatoriMenu.addActionListener(e -> {
            JPanel actualizeazaCalatori = (JPanel) new ActualizeazaCalatori().getContentPane();
            initNewLayoutChange(actualizeazaCalatori, "Actualizeaza calatori");
        });

//      Verifica Locuri Libere (9) (4)
        JMenuItem verifyLocuriLibere = new JMenuItem("Verifica locuri libere"); menu.add(verifyLocuriLibere);
        verifyLocuriLibere.addActionListener(e -> {
            JPanel verificaLocLibere = (JPanel) new VerificaLocLibere().getContentPane();
            initNewLayoutChange(verificaLocLibere, "Verifica Locuri Libere in tren");
        });

        return menu;
    }

    private JMenu createAlteleMenu(){
        JMenu menu = new JMenu("Altele");

//      Crearea tabeleului pentru nr saptamanii introdus de la tastatura (8)
        JMenuItem agaugaCalatoriMenu = new JMenuItem("Tabel nr. saptamani"); menu.add(agaugaCalatoriMenu);
        agaugaCalatoriMenu.addActionListener(e -> {
            JPanel creareTableDupaNrSapt = (JPanel) new CreareTableDupaNrSapt().getContentPane();
            initNewLayoutChange(creareTableDupaNrSapt, "Sorteaza dupa Nr. Saptamanii si insereaza intr-un tabel nou");
        });

//      Pagina principala
        JMenuItem mainPanelMenu = new JMenuItem("Main Panel"); menu.add(mainPanelMenu);
        mainPanelMenu.addActionListener(e -> {
            JPanel mainPanel = (JPanel) new MainPanel().getContentPane();
            initNewLayoutChange(mainPanel);
        });

        return menu;
    }

    private JMenu createLocatiiMenu(){
        JMenu menu = new JMenu("Locatii");

//        Inregisttrarea unui locatii noi
        JMenuItem actualizeazaLocatiile = new JMenuItem("Actualizeaza"); menu.add(actualizeazaLocatiile);
        actualizeazaLocatiile.addActionListener(e -> {
            JPanel actualizeazaLocatii = (JPanel) new ActualizeazaLocatii().getContentPane();
            initNewLayoutChange(actualizeazaLocatii, "Actualizeaza locatii");
        });

        return menu;
    }
    public MainView(){
        initApp();

        //Add Menu Bar
        JMenuBar menuBar = new JMenuBar(); setJMenuBar(menuBar);
        menuBar.add(createCurseMenu());
        menuBar.add(createCalatoriMenu());
        menuBar.add(createLocatiiMenu());
        menuBar.add(createAlteleMenu());

        //Load Main Panel
        getContentPane().add(new MainPanel().getContentPane());
        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public AdaugaCursaPanel getAdaugaCursaPanelView() {
        return adaugaCursaPanelView;
    }

    public void setAdaugaCursaPanelView(AdaugaCursaPanel adaugaCursaPanelView) {
        this.adaugaCursaPanelView = adaugaCursaPanelView;
    }

    public StergeCurse getStergeCurseView() {
        return stergeCurseView;
    }

    public void setStergeCurseView(StergeCurse stergeCurseView) {
        this.stergeCurseView = stergeCurseView;
    }

    public StergeCurseAnulate getStergeCurseAnulateView() {
        return stergeCurseAnulateView;
    }

    public void setStergeCurseAnulateView(StergeCurseAnulate stergeCurseAnulateView) {
        this.stergeCurseAnulateView = stergeCurseAnulateView;
    }

    public CautaCurseDupaPornireSiDestPanel getCautaCurseDupaPornireSiDestPanelView() {
        return cautaCurseDupaPornireSiDestPanelView;
    }

    public void setCautaCurseDupaPornireSiDestPanelView(CautaCurseDupaPornireSiDestPanel cautaCurseDupaPornireSiDestPanelView) {
        this.cautaCurseDupaPornireSiDestPanelView = cautaCurseDupaPornireSiDestPanelView;
    }
}
