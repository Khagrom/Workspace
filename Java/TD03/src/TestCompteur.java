
/**
 *
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class TestCompteur {

    public static void main(String[] args) {

        // Compteur
        Compteur c1 = new Compteur();
        Compteur c2 = new Compteur();
        Compteur c3 = new Compteur();
        Compteur c4 = c1;

        System.out.println("Compteur.getIdMax() = " + Compteur.getIdMax());
        System.out.println("c1.getId() = " + c1.getId());
        System.out.println("c2.getId() = " + c2.getId());
        System.out.println("c3.getId() = " + c3.getId());
        System.out.println("c4.getId() = " + c4.getId() + "\n");

        // CompteurClavier
        CompteurClavier cc1 = new CompteurClavier();
        CompteurClavier cc2 = new CompteurClavier();
        CompteurClavier cc3 = new CompteurClavier();
        CompteurClavier cc4 = cc1;

        System.out.println("\nCompteurClavier.getIdMax() = " + CompteurClavier.getIdMax());
        System.out.println("cc1.getId() = " + cc1.getId());
        System.out.println("cc2.getId() = " + cc2.getId());
        System.out.println("cc3.getId() = " + cc3.getId());
        System.out.println("cc4.getId() = " + cc4.getId());
    }
}
