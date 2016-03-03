
import parent.*;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class VoyageReduit extends Voyage {

    private final static double TAUX_MIN = 0.01;
    private final static double TAUX_MAX = 0.99;
    private ReelContraint tauxPromotion;

    public VoyageReduit(String villeDep, String villeArr, int longueur, double prixKm, double tauxPromotion) throws IllegalArgumentException {
        super(villeDep, villeArr, longueur, prixKm);
        this.tauxPromotion = new ReelContraint(TAUX_MIN, TAUX_MAX, tauxPromotion);
    }

    @Override
    public double getPrix() {
        return super.getPrix() * (1 - this.tauxPromotion.getVal());
    }

}
