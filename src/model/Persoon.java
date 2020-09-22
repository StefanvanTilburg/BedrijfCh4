package model;

/**
 * @author Stefan van Tilburg
 * <p>
 * Opdracht
 * <p>
 * Doel
 */
public class Persoon {
    private static final double GRENSWAARDE_BONUS = 4500.00;
    public static int aantalPersonen = 0;
    private int personeelsNummer;
    private String naam;
    private String woonplaats;
    private double maandSalaris;
    private Afdeling afdeling;

    public Persoon(String naam, String woonplaats, double maandSalaris, Afdeling afdeling) {
        this.setNaam(naam);
        this.setWoonplaats(woonplaats);
        this.setMaandSalaris(maandSalaris);
        this.setPersoneelsNummer(++aantalPersonen);
        this.setAfdeling(afdeling);
    }

    public Persoon(String naam) {
        this(naam, "Onbekend", 0, new Afdeling());
    }

    public Persoon() {
        this("DefaultName");
    }

    public double berekenJaarInkomen() {
        return 12 * getMaandSalaris();
    }

    public boolean heeftRechtOpBonus() {
        return this.maandSalaris >= GRENSWAARDE_BONUS;
    }

    public int getPersoneelsNummer() {
        return personeelsNummer;
    }

    public void setPersoneelsNummer(int personeelsNummer) {
        this.personeelsNummer = personeelsNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public double getMaandSalaris() {
        return maandSalaris;
    }

    public void setMaandSalaris(double maandSalaris) {
        this.maandSalaris = maandSalaris;
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(Afdeling afdeling) {
        this.afdeling = afdeling;
    }
}
