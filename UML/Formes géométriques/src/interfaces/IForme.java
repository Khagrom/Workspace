package interfaces;

/**
 *
 * @author Diane Lakestani
 * @author Vincent Poirier
 */
public interface IForme {

    /**
     * Calcule la surface de l'objet.
     *
     * @return La surface de l'objet.
     */
    public abstract float calculAire();

    /**
     * Calcule le périmètre de l'objet.
     *
     * @return Le périmètre de l'objet.
     */
    public abstract float calculPerimetre();

    /**
     * Renvoie la représentation de l'objet.
     *
     * @return Chaîne représentant l'objet.
     */
    public abstract String affiche();
}
