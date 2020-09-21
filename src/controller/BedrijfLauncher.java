package controller;

import model.Persoon;

/**
 * @author Stefan van Tilburg
 * <p>
 * Opdracht
 * <p>
 * Doel
 */
public class BedrijfLauncher {
    public static void main(String[] args) {
        System.out.println(Persoon.aantalPersonen);
        Persoon baas = new Persoon("Mark", "Den Haag", 10000);
        System.out.println(Persoon.aantalPersonen);
        System.out.println(baas.getPersoneelsNummer());
        Persoon medewerker = new Persoon("Caroline", "Delft", 4000);
        System.out.println(Persoon.aantalPersonen);
        System.out.println(medewerker.getPersoneelsNummer());

        Persoon assistent = new Persoon ("Klaas");
        Persoon manager = new Persoon();
        System.out.println(Persoon.aantalPersonen);

        String bonusRechtTekst = (baas.heeftRechtOpBonus()) ? "wel" : "geen";
        System.out.printf("%s verdient %.2f en heeft %s recht op een bonus.\n",
                            baas.getNaam(), baas.getMaandSalaris(), bonusRechtTekst);
        bonusRechtTekst = (medewerker.heeftRechtOpBonus()) ? "wel" : "geen";
        System.out.printf("%s verdient %.2f en heeft %s recht op een bonus.\n",
                medewerker.getNaam(), medewerker.getMaandSalaris(), bonusRechtTekst);
    }
}
