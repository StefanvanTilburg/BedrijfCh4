package controller;

import database.AfdelingDAO;
import database.DBaccess;
import database.MedewerkerDAO;
import model.*;


import java.util.ArrayList;

/**
 * @author Stefan van Tilburg
 * <p>
 * Opdracht Bedrijf (Rode draad document)
 * <p>
 * Doel     Toepassen van OOP programmeer principes, waarbij een Bedrijf centraal staat.
 */
public class BedrijfLauncher {
    public static void main(String[] args) {
        DBaccess dBaccess = new DBaccess();
        dBaccess.openConnection();

        AfdelingDAO afdelingDAO = new AfdelingDAO(dBaccess);
        //afdelingDAO.slaAfdelingOp(new Afdeling("HR", "Hilversum"));

        ArrayList<Afdeling> getHilversumAfdelingen = afdelingDAO.geefAfdelingenMetPlaats("Hilversum");
        for (Afdeling afdeling : getHilversumAfdelingen) {
            System.out.println(afdeling);
        }

        // TODO resetting auto_increment? Misschien niet nodig, maar kan het (vast)
        // TODO Is de doorlus van MedewerkerDOA naar PersoonDOA acceptabel?
        MedewerkerDAO medewerkerDAO = new MedewerkerDAO(dBaccess);
        medewerkerDAO.slaMedewerkerOp(new Werknemer("Lodewijk", "Zaandam",
                new Afdeling("Support", "Amsterdam"), 2500));

        dBaccess.closeConnection();
    }
}
