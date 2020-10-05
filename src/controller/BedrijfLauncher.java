package controller;

import database.AfdelingDAO;
import database.DBaccess;
import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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

        dBaccess.closeConnection();
    }
}
