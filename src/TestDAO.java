import mvc.model.dao.DaoExeption;
import mvc.model.dao.LocatiiDAO;
import mvc.model.dao.ZileDAO;
import mvc.model.dao.implementation.LocatiiDAOimpl;
import mvc.model.dao.implementation.RuteDAOimpl;
import mvc.model.dao.implementation.ZileDAOimpl;
import mvc.model.entity.Locatii;
import mvc.model.entity.Rute;
import mvc.model.entity.Zile;

import java.util.ArrayList;

public class TestDAO {


    public static void main(String[] args) throws DaoExeption {
//        InsertData.InsertZileAndLocatii();
//        InsertData.InsertRute();

        RuteDAOimpl ruteDAO = new RuteDAOimpl();
        ZileDAO zileDAO = new ZileDAOimpl();
        LocatiiDAO locatiiDAO = new LocatiiDAOimpl();

        ArrayList<Zile> zileArrayList  = new ArrayList<>(zileDAO.findAll());
        ArrayList<Locatii> locatiiArrayList = new ArrayList<>(locatiiDAO.findAll());
        ArrayList<Rute> ruteArrayList = new ArrayList<>(ruteDAO.findAll());

        // Printing the main tables from the DataBase
        System.out.println(locatiiArrayList);
        System.out.println(zileArrayList);
        System.out.println(ruteArrayList);

//        Print.printLocatii(locatiiArrayList);
//        Print.printZile(zileArrayList);
//        Print.printRute(ruteArrayList);


        //Apelarea Rute Anulate
//        Rute ruta = ruteDAO.findEntityById(2);
//        Print.printRute(ruta);
//        Util.anulateRuta(ruta);
//        ruteDAO = new RuteDAOimpl();
//        RuteDAO ruteDAOanulate = new RuteAnulateDAOimpl();
//        Print.printRute(ruteDAO.findAll());
//        Print.printRute(ruteDAOanulate.findAll());

        //Toate cursele cu destinatia specificate
//        RuteDAOimpl ruteDAOimpl = new RuteDAOimpl();
//        Print.printRute(ruteDAOimpl.findEntityByDest(2)); //Balti

        //Loc libere la cursa specificata
//        Print.printLocLibereInTren(2);

        //Nr de loc Libere cu cursa specificata
//        Print.printLocLibereInFiecareTren();

        //Cursele cu Destinatia si Intervalul specificat
//        Print.printRute(Util.findByDestAndInterval(2, "09:00", "14:00"));

        //Rute;e cu Loc initiala si Destinatia specificta
//        Print.printRute(ruteDAOimpl.findEntityByLocInitAndDest(1,2));

        //Pretul mediu al biletelui cu destinatia specificata
//        System.out.println("Pret mediu spre Balti: " + Util.pretMediuABiletSperDest(2));
//        System.out.println();

        //Inserarea in tabel a rutelor cu nr saptamanii specificata
//        Util.insertIntoNrRuteTempDupaNrSapt(2);
//        RuteTempDAOimpl ruteTempDAOimpl = new RuteTempDAOimpl();
//        Print.printRute(ruteTempDAOimpl.findAll());
    }

}