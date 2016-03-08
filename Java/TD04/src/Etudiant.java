
import java.util.Objects;


/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Etudiant {

    /**
     * Compteur incrémentiel de numéro d'étudiant
     */
    private static int compteur = 1;

    /**
     * Numero d'étudiant
     */
    private final int noEtu;
    /**
     * Prénom de l'étudiant
     */
    private String prenom;
    /**
     * Nom de l'étudiant
     */
    private String nom;

    /**
     * Construit un étudiant à partir de son nom et de son prénom.
     *
     * @param nom Nom de l'étudiant
     * @param prenom Prénom de l'étudiant
     */
    public Etudiant(String nom, String prenom) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.noEtu = compteur++;
    }

    /**
     * Renvoie la valeur actuelle du compteur de numéro d'étudiant.
     *
     * @return Valeur actuelle du compteur de numéro d'étudiant
     */
    public static int getCompteur() {
        return compteur;
    }

    /**
     * @return Numéro d'étudiant
     */
    public int getNoEtu() {
        return noEtu;
    }

    /**
     * @return Prénom de l'étudiant
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Remplace le prénom de l'étudiant.
     *
     * @param prenom Nouveau prénom
     * @throws IllegalArgumentException Si chaîne vide ou nulle
     */
    public void setPrenom(String prenom) throws IllegalArgumentException {
        if (prenom == null || prenom.equals("")) {
            throw new IllegalArgumentException("Erreur : chaîne non vide requise.");
        } else {
            this.prenom = prenom;
        }
    }

    /**
     * @return Nom de l'étudiant
     */
    public String getNom() {
        return nom;
    }

    /**
     * Remplace le nom de l'étudiant.
     *
     * @param nom Nouveau nom
     * @throws IllegalArgumentException Si chaîne vide ou nulle
     */
    public void setNom(String nom) throws IllegalArgumentException {
        if (nom == null || nom.equals("")) {
            throw new IllegalArgumentException("Erreur : chaîne non vide requise.");
        } else {
            this.nom = nom;
        }
    }

    /**
     * Renvoie une chaîne décrivant l'étudiant.
     *
     * @return Chaîne descriptive
     */
    @Override
    public String toString() {
        return "Etudiant[Numero : " + this.noEtu + " ; Nom : " + this.nom + " ; Prenom : " + this.prenom + "]";
    }
    
    /**
     * Vérifie l'égalité par rapport à un autre objet
     *
     * @param o Objet à tester
     * @return Résultat
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Etudiant etudiant = (Etudiant) o;

        if (noEtu != etudiant.noEtu) {
            return false;
        }
        if (!nom.equals(etudiant.nom)) {
            return false;
        }
        return prenom.equals(etudiant.prenom);
    }
}
