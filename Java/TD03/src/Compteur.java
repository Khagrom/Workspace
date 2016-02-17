
/**
 *
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Compteur {
    
    private static int idMax = 0;
    private final int id;
    
    public Compteur () {
        idMax++;
        this.id = idMax;
    }
    
    public int getId() {
        return id;
    }
    
    public static int getIdMax() {
        return idMax;
    }
}
