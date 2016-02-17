
/**
 *
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class CompteurClavier {

    private static int idMax;
    private final int id;

    static {
        do {
            System.out.println("Saisir un numéro initial (positif).");
            idMax = Clavier.lireInt();
        } while (idMax < 0);
    }
    
    public CompteurClavier () {
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
