package controller;

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
        // Afdelingen inlezen
        File afdelingenBestand = new File("resources/Afdelingen.txt");
        ArrayList<Afdeling> afdelingen = new ArrayList<>();
        try {
            Scanner keyboard = new Scanner(afdelingenBestand);
            while (keyboard.hasNextLine()) {
                // Logica is niet al omvattend. Zal geen tussenliggende waarden "juist" screenen
                // Voorkomt alleen een missende paar gegevens.
                String regelAfdelingTXT = keyboard.nextLine();
                String regelLocatieTXT;
                if (keyboard.hasNextLine()) {
                    // Verwacht locatie op een volgende regel
                    regelLocatieTXT = keyboard.nextLine();
                } else {
                    throw new IndexOutOfBoundsException();
                }

                afdelingen.add(new Afdeling(regelAfdelingTXT, regelLocatieTXT));
                System.out.println(afdelingen.get(afdelingen.size() - 1).toString());
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Het bestand is niet gevonden.");
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Logica verwacht een locatie op een regel na afdeling vermelding!\n" +
                    "check opbouw van .txt bestand.");
        }

        // Personen inlezen
        File personenBestand = new File("resources/Personen.csv");
        ArrayList<Persoon> personen = new ArrayList<>();
        try {
            Scanner keyboard = new Scanner(personenBestand);
            while (keyboard.hasNextLine()) {
                String[] regelPersoon = keyboard.nextLine().split(",");
                String type = regelPersoon[0];
                String naam = regelPersoon[1];
                String woonplaats = regelPersoon[2];
                int indexAfdeling = Integer.parseInt(regelPersoon[3]);
                if (type.equals("Werknemer")) {
                    double salaris = Double.parseDouble(regelPersoon[4]);
                    personen.add(new Werknemer(naam, woonplaats, afdelingen.get(indexAfdeling), salaris));
                } else {
                    double uurtarief = Double.parseDouble(regelPersoon[4]);
                    if (type.equals("Zzper")) {
                        personen.add(new Zzper(naam, woonplaats, afdelingen.get(indexAfdeling), uurtarief));
                    } else {
                        personen.add(new Vrijwilliger(naam, woonplaats, afdelingen.get(indexAfdeling)));
                    }
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Het bestand is niet gevonden.");
        }

        // output scherm personen
        Collections.sort(personen);
        for (Persoon persoon : personen) {
            System.out.println(persoon);
        }

        // output PersonenenPerAfdeling.txt
        File uitvoerBestand = new File("resources/PersonenPerAfdeling.txt");
        try {
            PrintWriter printWriter = new PrintWriter(uitvoerBestand);
            for (Afdeling afdeling : afdelingen) {
                printWriter.printf("Afdeling : %s\n", afdeling.getAfdelingsNaam());
                for (Persoon persoon : personen) {
                    if (persoon.getAfdeling().getAfdelingsNaam() == afdeling.getAfdelingsNaam())
                    printWriter.printf("-- %s\n",persoon);
                }
                printWriter.println();
            }
            printWriter.close();
        } catch (IOException exception) {
            System.out.println("Het bestand kan niet worden aangemaakt");
        }
    }
}
