
/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class RepertoireEtudiants {

    /**
     * Tableau d'étudiants
     */
    private final Etudiant[] tab;

    /**
     * Nombre maximal d'étudiants stockables dans 'tab'
     */
    private final int nbMax;

    /**
     * Nombre actuel d'étudiants stockés dans 'tab'
     */
    private int nbE;

    /**
     * Crée un répertoire d'étudiants.
     */
    public RepertoireEtudiants(int max) {
        nbE = 0;
        nbMax = max;
        tab = new Etudiant[nbMax];
    }

    /**
     * @return Nombre d'étudiants stockés dans le répertoire
     */
    public int getNbEtudiant() {
        return nbE;
    }

    /**
     * Ajoute un étudiant au répertoire
     *
     * @param e Etudiant à ajouter
     * @return Résultat de l'opération (false si répertoire plein)
     * @throws IllegalArgumentException Si null fourni
     */
    public boolean ajouteEtudiant(Etudiant e) throws IllegalArgumentException {
        if (nbE < nbMax) {
            if (e != null) {
                for (int i = 0; i < tab.length; i++) {
                    if (tab[i] == null) {
                        tab[i] = e;
                        nbE++;
                        return true;
                    }
                }
                return false;
            } else {
                throw new IllegalArgumentException("Erreur : null non autorisé.");
            }
        } else {
            return false;
        }
    }

    /**
     * Obtenir le nom d'un étudiant à partir de son numéro
     *
     * @param numeroEtu Numéro de l'étudiant recherché
     * @return Nom (si disponible, null sinon)
     */
    public String getNom(int numeroEtu) {
        for (Etudiant e : tab) {
            if (e != null && e.getNoEtu() == numeroEtu) {
                return e.getNom();
            }
        }
        return null;
    }

    /**
     * Obtenir le numéro d'un étudiant à partir de son nom
     *
     * @param nom Nom de l'étudiant recherché
     * @return Numéro (si disponible, -1 sinon)
     */
    public int getNumero(String nom) {
        for (Etudiant e : tab) {
            if (e != null && e.getNom().equalsIgnoreCase(nom)) {
                return e.getNoEtu();
            }
        }
        return -1;
    }

    /**
     * Retire un étudiant du répertoire
     *
     * @param e Etudiant à retirer
     * @return Résultat de l'opération
     */
    public boolean supprimeEtudiant(Etudiant e) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].equals(e)) {
                nbE--;
                tab[i] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Renvoie une chaîne de caractères décrivant l'objet
     *
     * @return Chaîne descriptive
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Répertoire : " + nbE + " / " + nbMax + '\n' + "-------------------" + '\n');
        for (Etudiant e : tab) {
            if (e != null) {
                sb.append(e.toString() + '\n');
            }
        }
        return sb.toString();
    }
}
