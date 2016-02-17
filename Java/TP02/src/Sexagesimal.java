
/**
 * @author Vincent Poirier
 */
public abstract class Sexagesimal {

    public abstract double getDec();

    public abstract int getH();

    public abstract int getM();

    public abstract int getS();

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.getH(), this.getM(), this.getS());
    }
}
