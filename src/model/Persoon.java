package model;

/**
 * @author Stefan van Tilburg
 * <p>
 * Opdracht
 * <p>
 * Doel
 */
public class Persoon {
    private final double GRENSWAARDE_BONUS = 4500.00;
    public static int aantalPersonen = 0;
    private int personeelsNummer;
    private String naam;
    private String woonplaats;
    private double maandSalaris;

    public Persoon(String naam, String woonplaats, double maandSalaris) {
        this.setNaam(naam);
        this.setWoonplaats(woonplaats);
        this.setMaandSalaris(maandSalaris);
        this.setPersoneelsNummer(++aantalPersonen);
    }

    public Persoon(String naam) {
        this(naam, "Onbekend", 0);
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
}
