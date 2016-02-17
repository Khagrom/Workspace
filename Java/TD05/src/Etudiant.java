
/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Etudiant extends Personne {

    private final long noEtu;

    public Etudiant(String nom, String prenom, long noEtu) {
        super(nom, prenom);
        this.noEtu = noEtu;
    }

    public Etudiant(Personne p, long noEtu) {
        super(p);
        this.noEtu = noEtu;
    }

    public long getNoEtu() {
        return noEtu;
    }
}
