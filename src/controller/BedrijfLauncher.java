package controller;

import model.Afdeling;
import model.Persoon;
import model.Werknemer;
import model.Zzper;

/**
 * @author Stefan van Tilburg
 * <p>
 * Opdracht Bedrijf (Rode draad document)
 * <p>
 * Doel     Toepassen van OOP programmeer principes, waarbij een Bedrijf centraal staat.
 */
public class BedrijfLauncher {
    public static void main(String[] args) {

        Afdeling[] afdelingen = new Afdeling[4];            // elementen zijn null
        afdelingen[0] = new Afdeling("Uitvoering","Hilversum");
        afdelingen[1] = new Afdeling("Support","Amsterdam");
        afdelingen[2] = new Afdeling("Management","Almere");
        afdelingen[3] = new Afdeling("Documentatie","Gouda");

        Werknemer baas = new Werknemer("Mark","Den Haag", afdelingen[2], 10000);
        Werknemer medewerker = new Werknemer("Caroline", "Delft", afdelingen[1],4000);
        Zzper assistent = new Zzper("Klaas", "Diemen", afdelingen[3], 50.00);

        assistent.huurIn(160);

        System.out.printf("Het aantal personen in het bedrijf is %d\n", Persoon.aantalPersonen);
        System.out.println(baas.toString());
        System.out.println(medewerker.toString());
        System.out.println(assistent.toString());

        System.out.printf("%s verdien %f per jaar", baas.getNaam(), baas.berekenJaarinkomen());
        System.out.printf("%s verdien %f per jaar", medewerker.getNaam(), medewerker.berekenJaarinkomen());
        System.out.printf("%s verdien %f per jaar", assistent.getNaam(), assistent.berekenJaarinkomen());
    }
}
