
/**
 * @author Vincent Poirier Se reporter à l'énoncé pour connaître le contrat.
 */
public class SexagesimalHMS extends Sexagesimal {

    final int h;
    final int m;
    final int s;

    public SexagesimalHMS(int heures, int minutes, int secondes) {
        this.h = Math.abs(heures);
        this.m = Math.abs(minutes) % 60;
        this.s = Math.abs(secondes) % 60;
    }

    public SexagesimalHMS(double time) {
        int heure = (int) time;
        this.h = heure;
        this.m = (int) ((time - heure) * 60);
        this.s = (int) (((time - heure) * 3600) % 60);
    }

    public int getH() {
        return h;
    }

    public int getM() {
        return m;
    }

    public int getS() {
        return s;
    }

    public double getDec() {
        return (this.h + this.m / 60.0 + this.s / 3600.0);
    }

    @Override
    public String toString() {
        return (String.format("%02d:%02d:%02d", this.getH(), this.getM(), this.getS()));
    }
}
