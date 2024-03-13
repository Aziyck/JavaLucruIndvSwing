package mvc.controller;

import mvc.controller.util.Util;
import mvc.model.conection.DatabaseManager;
import mvc.model.dao.implementation.RuteDAOimpl;
import mvc.model.entity.Rute;
import mvc.view.AdaugaCursaPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AdaugaCursaPanelController {
    private AdaugaCursaPanel view;

    public AdaugaCursaPanelController(AdaugaCursaPanel adaugaCursaPanel) {
        this.view = adaugaCursaPanel;

        view.getCodCursa_TF().setText(getNextIDVal().toString());

        DateKeyListener dateKeyListener = new DateKeyListener();
        view.getDataPlecarii_TF().addKeyListener(dateKeyListener);
        view.getDataSosirii_TF().addKeyListener(dateKeyListener);
        view.getOraPlecarii_TF().addKeyListener(dateKeyListener);
        view.getOraSosirii_TF().addKeyListener(dateKeyListener);

        LocuriKeyListener locuriKeyListener = new LocuriKeyListener();
        view.getLocEcD_TF().addKeyListener(locuriKeyListener);
        view.getLocEcO_TF().addKeyListener(locuriKeyListener);
        view.getLocCmD_TF().addKeyListener(locuriKeyListener);
        view.getLocCmO_TF().addKeyListener(locuriKeyListener);

        view.getPretCm_TF().addKeyListener(new PretKeyListener(view.getPretCm_TF()));
        view.getPretEc_TF().addKeyListener(new PretKeyListener(view.getPretEc_TF()));

        view.getAdd_Btn().addActionListener(new addBtnActionListener());
        view.getClear_Btn().addActionListener(new clearBtnActionListener());
    }

    public Integer getNextIDVal(){

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            int result = -1;

            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement("Select pg_sequence_last_value( 'public.\"Rute_CodCursa_seq\"' ) as newid;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                result = resultSet.getInt("newid") + 1;
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert connection != null;
                connection.close();
                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class LocuriKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();

            if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||  (c == KeyEvent.VK_DELETE))){
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    class PretKeyListener implements KeyListener{
        private JTextField textField = null;

        public PretKeyListener(JTextField textField) {
            this.textField = textField;
        }

        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();

            if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||  (c == KeyEvent.VK_DELETE) || (c == '.'))){
                e.consume();
            }else if ( c == '.' && textField.getText().contains(".")){
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    class DateKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {


        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            DateFormat tipicalDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            DateFormat hourFormat = new SimpleDateFormat("HH:mm");
            try {
                Date datePlecare = tipicalDateFormat.parse(view.getDataPlecarii_TF().getText());
                if(datePlecare.getYear() < 123) throw new Exception();

                Date dateSosire = tipicalDateFormat.parse(view.getDataSosirii_TF().getText());
                if(dateSosire.getYear() < 123) throw new Exception();

                Date oraPlecare = hourFormat.parse(view.getOraPlecarii_TF().getText());

                Date oraSosirii = hourFormat.parse(view.getOraSosirii_TF().getText());

                Rute rute = new Rute();
                rute.setDataPlecarii(tipicalDateFormat.format(datePlecare));
                rute.setOraPlecarii(hourFormat.format(oraPlecare));
                rute.setDataSosirii(tipicalDateFormat.format(dateSosire));
                rute.setOraSosirii(hourFormat.format(oraSosirii));

                view.getDurata_TF().setText(Util.makeDurataForStringArr(Util.makeDurata(rute)));

                view.getNrSapt_TF().setText(nrSamptamanii(datePlecare).toString());

                DateFormat dayDateFormat = new SimpleDateFormat("EEE");
                view.getZiuaPlecarii_CB().setSelectedIndex(ziuaPlecariiCBIndex(dayDateFormat.format(datePlecare)));


            }catch (Exception ex){
                view.getDurata_TF().setText("");
                view.getNrSapt_TF().setText("");
                view.getZiuaPlecarii_CB().setSelectedIndex(0);
            }
        }
    }

    public Long nrSamptamanii(Date dataPlecarii){
        long diffInMilis = dataPlecarii.getTime() - AdaugaCursaPanel.INITIAL_WEEK.getTime();
        return TimeUnit.DAYS.convert(diffInMilis, TimeUnit.MILLISECONDS) / 7 + 1;
    }

    public int ziuaPlecariiCBIndex(String zi){
        int rez = 0;
        switch (zi){
            case "Lun" -> rez = 1;
            case "Mar" -> rez = 2;
            case "Mie" -> rez = 3;
            case "Joi" -> rez = 4;
            case "Vin" -> rez = 5;
            case "Sâm" -> rez = 6;
            case "Dum" -> rez = 7;
        }
        return rez;
    }

    class addBtnActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Rute ruta = new Rute();

                ruta.setPersID(Integer.parseInt(view.getCodCursa_TF().getText()));
                ruta.setDataPlecarii(view.getDataPlecarii_TF().getText());
                ruta.setOraPlecarii(view.getOraPlecarii_TF().getText());
                ruta.setLocatieInitiala(view.getLocInit_CB().getSelectedIndex()+1);
                ruta.setDataSosirii(view.getDataSosirii_TF().getText());
                ruta.setOraSosirii(view.getOraSosirii_TF().getText());
                ruta.setDestinatie(view.getLocFinal_CB().getSelectedIndex()+1);
                ruta.setDurata(Util.makeDurata(ruta));
                ruta.setNrSaptamanii(Integer.parseInt(view.getNrSapt_TF().getText()));
                ruta.setLocDisponConfort(Integer.parseInt(view.getLocCmD_TF().getText()));
                ruta.setLocConfort(Integer.parseInt(view.getLocCmO_TF().getText()) + Integer.parseInt(view.getLocCmD_TF().getText()));
                ruta.setPretConfort(Float.parseFloat(view.getPretCm_TF().getText()));
                ruta.setLocDisponEco(Integer.parseInt(view.getLocEcD_TF().getText()));
                ruta.setLocEco(Integer.parseInt(view.getLocEcO_TF().getText()) + Integer.parseInt(view.getLocEcD_TF().getText()));
                ruta.setPretEco(Float.parseFloat(view.getPretEc_TF().getText()));
                ruta.setIdZiua(view.getZiuaPlecarii_CB().getSelectedIndex());

                RuteDAOimpl ruteDAOimpl = new RuteDAOimpl();
                ruteDAOimpl.create(ruta);

                view.showMsg("Date aduagate cu succes!");
                view.getClear_Btn().doClick();
                Util.resetRuteTBL(view.getRute_Tbl());
            }catch (Exception ex){
                view.showMsg("Eroare:\n" + ex.toString());
            }
        }
    }

    class clearBtnActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getCodCursa_TF().setText(getNextIDVal().toString());
            view.getDurata_TF().setText("");
            view.getNrSapt_TF().setText("");
            view.getZiuaPlecarii_CB().setSelectedIndex(0);

            view.getDataPlecarii_TF().setText("");
            view.getOraPlecarii_TF().setText("");
            view.getLocInit_CB().setSelectedIndex(0);

            view.getDataSosirii_TF().setText("");
            view.getOraSosirii_TF().setText("");
            view.getLocFinal_CB().setSelectedIndex(0);

            view.getLocEcD_TF().setText("");
            view.getLocEcO_TF().setText("");
            view.getPretEc_TF().setText("");

            view.getLocCmD_TF().setText("");
            view.getLocCmO_TF().setText("");
            view.getPretCm_TF().setText("");

        }
    }

}
