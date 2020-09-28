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
        Zzper projectleider = new Zzper("Ronald", "Zaandam", afdelingen[0], 80.00);

        assistent.huurIn(160);
        projectleider.huurIn(320);

        Persoon[] personen = new Persoon[4];
        personen[0] = baas;
        personen[1] = medewerker;
        personen[2] = assistent;
        personen[3] = projectleider;

        for (Persoon persoon : personen) {
            toonJaarInkomen(persoon);
        }
    }

    public static void toonJaarInkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar.\n", persoon.getNaam(), persoon.berekenJaarInkomen());
    }
}
