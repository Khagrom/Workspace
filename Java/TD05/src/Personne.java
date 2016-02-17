
/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Personne {

    private String nom;
    private String prenom;

    public String getNom() {
        return nom;
    }

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Personne(Personne p) {
        this.nom = p.nom;
        this.prenom = p.prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void affiche() {
        System.out.println(this.getClass().getSimpleName()
                + " {\n\tnom: " + this.getNom()
                + ",\n\tprenom: " + this.getPrenom()
                + "\n}\n");
    }

}
