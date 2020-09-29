package controller;

import model.*;

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
        String naamMedewerker;
        String plaatsMedewerker;
        String naamAfdeling;
        String plaatsAfdeling;
        double maandSalaris;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Geef de naam: ");
        naamMedewerker = keyboard.next();

        System.out.print("Geef de woonplaats: ");
        plaatsMedewerker = keyboard.next();

        System.out.print("Geef de naam van de afdeling: ");
        naamAfdeling = keyboard.next();

        System.out.print("Geef de plaats van de afdeling: ");
        plaatsAfdeling = keyboard.next();

        boolean invoerIsFout = true;
        while (invoerIsFout){
            try {
                System.out.print("Geef het maandsalaris: ");
                maandSalaris = keyboard.nextDouble();

                Werknemer werknemer = new Werknemer(naamMedewerker, plaatsMedewerker,
                                    new Afdeling(naamAfdeling, plaatsAfdeling), maandSalaris);

                System.out.println(werknemer.toString());

                invoerIsFout = false;
            } catch (IllegalArgumentException foutMelding) {
                System.out.println(foutMelding.getMessage());
            } finally {
                System.out.println("Je invoer is op de juiste wijze afgehandeld.");
            }
        }
    }

    public static void toonJaarInkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar.\n", persoon.getNaam(), persoon.berekenJaarInkomen());
    }
}
