
/**
 * @author Vincent Poirier Se reporter à l'énoncé pour connaître le contrat.
 */
public class SexagesimalF extends Sexagesimal {

    private final double time;

    public SexagesimalF(int heures, int minutes, int secondes) {
        time = heures + minutes / 60.0 + secondes / 3600.0;
    }

    public SexagesimalF(double time) {
        this.time = time;
    }

    @Override
    public int getH() {
        return (int) time;
    }

    @Override
    public int getM() {
        return (int) ((time - this.getH()) * 60);
    }

    @Override
    public int getS() {
        return (int) (((time - this.getH()) * 3600) % 60);
    }

    @Override
    public double getDec() {
        return this.time;
    }

    @Override
    public String toString() {
        return (String.format("%02d:%02d:%02d", this.getH(), this.getM(), this.getS()));
    }
}
