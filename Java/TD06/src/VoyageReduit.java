
import voyage.*;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class VoyageReduit extends Voyage {

    private static final double MIN_RATE = 0.01;
    private static final double MAX_RATE = 0.99;
    private ReelContraint tauxPromotion;

    public VoyageReduit(String villeDep, String villeArr, int longueur, double prixKm, double txProm) throws IllegalArgumentException {
        super(villeDep, villeArr, longueur, prixKm);
        tauxPromotion = new ReelContraint(MIN_RATE, MAX_RATE, txProm);
    }

    @Override
    public double getPrix() {
        return super.getPrix() * (1 - this.tauxPromotion.getVal());
    }
}
