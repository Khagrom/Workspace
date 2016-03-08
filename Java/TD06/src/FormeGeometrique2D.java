/**
 *
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public interface FormeGeometrique2D extends Affichable {

    void deplace(double dx, double dy);

    boolean estIdentique(Object o);
}
