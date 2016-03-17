
import voyage.*;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class VoyageReduit extends Voyage {

    private static final double MIN_RATE = 0.01;
    private static final double MAX_RATE = 0.99;
    private final ReelContraint tauxPromotion;

    public VoyageReduit(String villeDep, String villeArr, int longueur, double prixKm, double txProm) throws IllegalArgumentException {
        super(villeDep, villeArr, longueur, prixKm);
        tauxPromotion = new ReelContraint(MIN_RATE, MAX_RATE, txProm);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final VoyageReduit other = (VoyageReduit) obj;
        
        return this.tauxPromotion.equals(other.tauxPromotion);
    }
    
    @Override
    public double getPrix() {
        return super.getPrix() * (1 - this.tauxPromotion.getVal());
    }
}
