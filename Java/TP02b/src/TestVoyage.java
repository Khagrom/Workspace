import java.util.ArrayList;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class TestVoyage {

    public static void main(String[] args) {
        Voyage v1 = new Voyage("Lyon", "Turin", 303, 1.6);
        Voyage v2 = new Voyage("Lyon", "Turin", 351, 1.1);
        Voyage v3 = new Voyage("Lyon", "Turin", 700, 0.2);
        Voyage v4 = new Voyage("Paris", "Lyon", 465, 1.3);
        Voyage v5 = new Voyage("Paris", "Lyon", 480, 1.4);
        Voyage v6 = new Voyage("Bourges", "Nantes", 190, 2);
        ArrayList<Voyage> liste = new ArrayList<>();
        liste.add(v1);
        liste.add(v2);
        liste.add(v3);
        liste.add(v4);
        liste.add(v5);
        liste.add(v6);

        System.out.println("Ville de départ ? ");
        String dep = Clavier.lireString();
        System.out.println("Ville d'arrivée ? ");
        String arr = Clavier.lireString();
        System.out.println();

        ArrayList<Voyage> listeResultats = trouverVoyage(liste, dep, arr);
        printListeVoyages(listeResultats);

        if (listeResultats.isEmpty()) {
            System.out.println("Aucun voyage correspondant trouvé.\nVeuillez revoir vos critères et essayer à nouveau.");
        } else {
            Voyage leMoinsCher = voyageLeMoinsCher(listeResultats);
            Voyage lePlusCourt = voyageLePlusCourt(listeResultats);

            if (!leMoinsCher.equals(lePlusCourt)) {
                System.out.println("Le voyage le moins cher correspondant à vos critères est :");
                System.out.println(leMoinsCher);
                System.out.println("Le voyage le plus court correspondant à vos critères est :");
                System.out.println(lePlusCourt);
            } else {
                System.out.println("Le voyage le moins cher et le plus court correspondant à vos critères est ");
                System.out.println(leMoinsCher);
            }
        }

    }

    /**
     * Trouve tous les voyages avec les villes de départ et d'arrivée données.
     *
     * @param listeVoyages La liste des voyages à examiner.
     * @param dep La ville de départ.
     * @param arr La ville d'arrivée.
     * @return Une liste contenant tous les voyages correspondant aux critères.
     */
    public static ArrayList<Voyage> trouverVoyage(ArrayList<Voyage> listeVoyages, String dep, String arr) {
        ArrayList<Voyage> returnList = new ArrayList<>();
        for (Voyage v : listeVoyages) {
            if (v.getVilleDep().toLowerCase().equals(dep.toLowerCase())
                    && v.getVilleArr().toLowerCase().equals(arr.toLowerCase())) {
                returnList.add(v);
            }
        }

        return returnList;
    }

    /**
     * Affiche une liste de voyages.
     *
     * @param listeVoyages La liste à afficher.
     */
    public static void printListeVoyages(ArrayList<Voyage> listeVoyages) {
        System.out.println("==== LISTE DES VOYAGES ====");
        if (listeVoyages.size() > 0) {
            for (int i = 0; i < listeVoyages.size(); i++) {
                System.out.printf("%d. ", i + 1);
                System.out.println(listeVoyages.get(i));
            }
        } else {
            System.out.println("Rien ici...");
        }
        System.out.println();
    }

    /**
     * Cette méthode compare tous les voyages d'une liste et donne le moins
     * cher. Cette méthode est faite pour être utilisée avec une liste de
     * voyages qui ont tous les mêmes villes de départ et d'arrivée.
     *
     * @param listeVoyages Les voyages à comparer. Ils doivent avoir les mêmes
     * villes de départ et d'arrivée.
     * @return Le moins cher des voyages.
     * @throws IllegalArgumentException Quand au moins l'un des voyages n'a pas
     * la même ville de départ ou d'arrivée que les autres.
     */
    public static Voyage voyageLeMoinsCher(ArrayList<Voyage> listeVoyages) throws IllegalArgumentException {
        Voyage leMoinsCher = listeVoyages.get(0);
        for (Voyage v : listeVoyages) {
            if (v.comparerPrix(leMoinsCher) < 0) {
                leMoinsCher = v;
            }
        }

        return leMoinsCher;
    }

    /**
     * Cette méthode compare tous les voyages d'une liste et donne le plus
     * court. Cette méthode est faite pour être utilisée avec une liste de
     * voyages qui ont tous les mêmes villes de départ et d'arrivée.
     *
     * @param listeVoyages Les voyages à comparer. Ils doivent avoir les mêmes
     * villes de départ et d'arrivée.
     * @return Le plus court des voyages.
     * @throws IllegalArgumentException Quand au moins l'un des voyages n'a pas
     * la même ville de départ ou d'arrivée que les autres.
     */
    public static Voyage voyageLePlusCourt(ArrayList<Voyage> listeVoyages) throws IllegalArgumentException {
        Voyage lePlusCourt = listeVoyages.get(0);
        for (Voyage v : listeVoyages) {
            if (v.comparerLongueur(lePlusCourt) < 0) {
                lePlusCourt = v;
            }
        }

        return lePlusCourt;
    }
}
