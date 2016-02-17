package interfaces;

/**
 *
 * @author Diane Lakestani
 * @author Vincent Poirier
 */
public interface ITriangle extends IForme {

    /**
     * Effectue une rotation de 90 degrés dans le sens inverse des aiguilles
     * d'une montre par rapport à l'origine.
     */
    public void rotation();

    /**
     * Effectue une rotation du point d'un angle donné par rapport à l'origine.
     *
     * @param angleEnRadians L'angle en radians sur lequel faire la rotation.
     */
    public void rotation(float angleEnRadians);
}
