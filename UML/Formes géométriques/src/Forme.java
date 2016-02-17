
import interfaces.IForme;

/**
 *
 * @author Diane Lakestani
 * @author Vincent Poirier
 */
public abstract class Forme implements IForme {

    /**
     * Calcule la surface de l'objet.
     *
     * @return La surface de l'objet.
     */
    @Override
    public abstract float calculAire();

    /**
     * Calcule le périmètre de l'objet.
     *
     * @return Le périmètre de l'objet.
     */
    @Override
    public abstract float calculPerimetre();

    /**
     * Renvoie la représentation de l'objet.
     *
     * @return Chaîne représentant l'objet.
     */
    @Override
    public abstract String affiche();

}
