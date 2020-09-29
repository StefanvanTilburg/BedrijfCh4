package model;

/**
 * @author Stefan van Tilburg
 * <p>
 * Opdracht
 * <p>
 * Doel
 */
public class Vrijwilliger extends Persoon implements Oproepbaar {
    private int urenGewerkt;

    public Vrijwilliger(String naam, String woonplaats, Afdeling afdeling) {
        super(naam, woonplaats, afdeling);
    }

    @Override
    public void huurIn(int uren) {
        setUrenGewerkt(getUrenGewerkt() + uren);
    }

    @Override
    public double berekenJaarInkomen() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + " en is een vrijwilliger",
                this.getAfdeling().getAfdelingsPlaats());
    }

    public void setUrenGewerkt(int urenGewerkt) {
        this.urenGewerkt = urenGewerkt;
    }

    public int getUrenGewerkt() {
        return urenGewerkt;
    }
}
