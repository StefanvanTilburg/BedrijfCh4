package model;

/**
 * @author Stefan van Tilburg
 * <p>
 * Opdracht Bedrijf (Rode draad document)
 * <p>
 * Doel     Sla informatie op over een persoon in ons bedrijf
 */
public abstract class Persoon {
    protected static final String DEFAULTWAARDE_NAAM = "Onbekend";

    public static int aantalPersonen = 0;

    protected int personeelsNummer;
    protected String naam;
    protected String woonplaats;
    protected Afdeling afdeling;

    public Persoon(String naam, String woonplaats, Afdeling afdeling) {
        this.setNaam(naam);
        this.setWoonplaats(woonplaats);
        this.setPersoneelsNummer(++aantalPersonen);
        this.setAfdeling(afdeling);
    }

    public Persoon(String naam) {
        this(naam, DEFAULTWAARDE_NAAM, new Afdeling());
    }

    public Persoon() {
        this(DEFAULTWAARDE_NAAM);
    }

    public abstract double berekenJaarInkomen();

    @Override
    public String toString() {
        return String.format("%s woont in %s en werkt op %s", getNaam(), getWoonplaats(), getAfdeling().toString());
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

    public Afdeling getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(Afdeling afdeling) {
        this.afdeling = afdeling;
    }
}
