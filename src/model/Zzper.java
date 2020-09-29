package model;

/**
 * @author Stefan van Tilburg
 * <p>
 * Opdracht
 * <p>
 * Doel     Class om gegevens van werknemer, dat subclass van Persoon is, in op te slaan.
 */
public class Zzper extends Persoon implements Oproepbaar {
    private double uurtarief;
    private int urenGewerkt;

    public Zzper(String naam, String woonplaats, Afdeling afdeling, double uurtarief) {
        super(naam, woonplaats, afdeling);
        this.setUurtarief(uurtarief);
        this.setUrenGewerkt(0);
    }

    @Override
    public void huurIn(int uren) {
        setUrenGewerkt(getUrenGewerkt() + uren);
    }

    @Override
    public double berekenJaarInkomen() {
        return getUurtarief() * getUrenGewerkt();
    }

    @Override
    public String toString() {
        return String.format("%s en is een zzp-er met een uurtarief van %.1f", super.toString(), this.getUurtarief());
    }

    public double getUurtarief() {
        return uurtarief;
    }

    public void setUurtarief(double uurtarief) {
        this.uurtarief = uurtarief;
    }

    public int getUrenGewerkt() {
        return urenGewerkt;
    }

    public void setUrenGewerkt(int urenGewerkt) {
        this.urenGewerkt = urenGewerkt;
    }
}
