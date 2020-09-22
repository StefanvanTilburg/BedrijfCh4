package model;

/**
 * @author Stefan van Tilburg
 * <p>
 * Opdracht
 * <p>
 * Doel     Class om gegevens van werknemer, dat subclass van Persoon is, in op te slaan.
 */
public class Werknemer extends Persoon {
    private static final double GRENSWAARDE_BONUS = 4500.00;
    private double maandSalaris;

    public Werknemer(String naam, String woonplaats, Afdeling afdeling, double maandSalaris) {
        super(naam, woonplaats, afdeling);
        this.setMaandSalaris(maandSalaris);
    }

    public Werknemer(String naam, double maandSalaris) {
        super(naam);
        this.setMaandSalaris(maandSalaris);
    }

    public Werknemer() {
        this(DEFAULTWAARDE_NAAM, 0);
    }

    public boolean heeftRechtOpBonus() {
        return getMaandSalaris() >= GRENSWAARDE_BONUS;
    }

    @Override
    public double berekenJaarInkomen() {
        return (heeftRechtOpBonus()) ? 12 * getMaandSalaris() + getMaandSalaris() : 12 * getMaandSalaris();
    }

    @Override
    public String toString() {
        return String.format("%s en is een werknemer %s recht op een bonus.",
                                super.toString(),
                                heeftRechtOpBonus() ? "met" : "zonder");
    }

    public double getMaandSalaris() {
        return maandSalaris;
    }

    public void setMaandSalaris(double maandSalaris) {
        this.maandSalaris = maandSalaris;
    }
}
