package voyage;


/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Voyage {

    private static final int LONGUEUR_MIN = 1;
    private static final int LONGUEUR_MAX = 30000;
    private static final double PRIX_KIM_MIN = 0.05;
    private static final double PRIX_KIM_MAX = 3.2;

    private String villeDep;
    private String villeArr;
    private EntierContraint longueur;
    private ReelContraint prixKm;

    /**
     * Crée un {@link Voyage} avec un départ, une arrivée, une longueur et un prix au
     * kilomètre. Deux voyages avec les mêmes villes de départ et d'arrivée
     * seront aisément comparables en termes de prix et de longueur.
     *
     * @param villeDep La ville de départ du voyage.
     * @param villeArr La ville d'arrivée du voyage.
     * @param longueur La longueur du voyage.
     * @param prixKm Le prix au kilomètre du voyage.
     */
    public Voyage(String villeDep, String villeArr, int longueur, double prixKm) {
        this.villeDep = villeDep;
        this.villeArr = villeArr;
        this.longueur = new EntierContraint(LONGUEUR_MIN, LONGUEUR_MAX, longueur);
        this.prixKm = new ReelContraint(PRIX_KIM_MIN, PRIX_KIM_MAX, prixKm);
    }

    @Override
    public String toString() {
        return villeDep + " --> " + villeArr + " (" + getLongueur() + " km, " + getPrix() + " €)";
    }

    /**
     * Compare la longueur de deux {@link Voyage} avec les mêmes villes de départ et
     * d'arrivée.
     *
     * @param voyage Le voyage avec lequel comparer.
     * @return un entier négatif, zéro, ou un entier positif si la longueur de
     * ce voyage est inférieur à, égal à, ou supérieur à la longueur du voyage
     * spécifié.
     * @throws IllegalArgumentException si les voyages n'ont pas les mêmes
     * villes de départ et d'arrivée.
     */
    public int comparerLongueur(Voyage voyage) throws IllegalArgumentException {
        if (!this.comparerVilles(voyage)) {
            throw new IllegalArgumentException("Le Voyage spécifié n'a pas les mêmes villes de départ et d'arrivée.");
        }
        int cetteLongueur = getLongueur();
        int autreLongueur = voyage.getLongueur();

        return cetteLongueur < autreLongueur ? -1 : cetteLongueur == autreLongueur ? 0 : 1;
    }

    /**
     * Compare le prix de deux {@link Voyage} avec les mêmes villes de départ et
     * d'arrivée.
     *
     * @param voyage Le voyage avec lequel comparer.
     * @return un entier négatif, zéro, ou un entier positif si le prix de ce
     * voyage est inférieur à, égal à, ou supérieur au prix du voyage spécifié.
     * @throws IllegalArgumentException si les voyages n'ont pas les mêmes
     * villes de départ et d'arrivée.
     */
    public int comparerPrix(Voyage voyage) throws IllegalArgumentException {
        if (!this.comparerVilles(voyage)) {
            throw new IllegalArgumentException("Le Voyage spécifié n'a pas les mêmes villes de départ et d'arrivée.");
        }
        double cePrix = getPrix();
        double autrePrix = voyage.getPrix();

        return cePrix < autrePrix ? -1 : cePrix == autrePrix ? 0 : 1;
    }

    /**
     * Compare ce {@link Voyage} avec un autre pour vérifier les villes de départ et
     * d'arrivée.
     *
     * @param voyage Le voyage avec lequel comparer.
     * @return True si les deux voyages ont les mêmes villes de départ et
     * d'arrivée, sinon False.
     */
    public boolean comparerVilles(Voyage voyage) {
        if (this == voyage) {
            return true;
        }
        if (voyage == null) {
            return false;
        }
        
        if (villeDep != null ? !villeDep.equals(voyage.villeDep) : voyage.villeDep != null) {
            return false;
        }
        if (villeArr != null ? !villeArr.equals(voyage.villeArr) : voyage.villeArr != null) {
            return false;
        }

        return true;
    }

    public String getVilleDep() {
        return villeDep;
    }

    public void setVilleDep(String villeDep) {
        this.villeDep = villeDep;
    }

    public String getVilleArr() {
        return villeArr;
    }

    public void setVilleArr(String villeArr) {
        this.villeArr = villeArr;
    }

    public int getLongueur() {
        return longueur.getVal();
    }

    public void setLongueur(int longueur) {
        this.longueur.setVal(longueur);
    }

    public double getPrixKm() {
        return prixKm.getVal();
    }

    public void setPrixKm(double prixKm) {
        this.prixKm.setVal(prixKm);
    }

    public double getPrix() {
        return getPrixKm() * getLongueur();
    }
}
