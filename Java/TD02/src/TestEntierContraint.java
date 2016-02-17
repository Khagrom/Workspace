
/**
 * Cette classe permet de tester la classe EntierContraint.
 *
 * @author Vincent Poirier
 */
public class TestEntierContraint {

    public static void main(String[] args) {
        EntierContraint ent = new EntierContraint(1, 100, 25);
        testAffiche(ent);
        testGetMin(ent);
        testGetMax(ent);
        testGetVal(ent);
        testIncr(ent, 25);
        testSetVal(ent, 50);
        testSaisie(ent);
    }

    public static void testAffiche(EntierContraint ent) {
        ent.affiche();
    }

    public static void testGetMin(EntierContraint ent) {
        System.out.println("Le minimum vaut : " + ent.getMin());
    }

    public static void testGetMax(EntierContraint ent) {
        System.out.println("Le maximum vaut : " + ent.getMax());
    }

    public static void testGetVal(EntierContraint ent) {
        System.out.println("La valeur vaut : " + ent.getVal());
    }

    public static void testIncr(EntierContraint ent, int i) {
        System.out.println("On incrémente de " + i + " :");
        ent.incr(i);
        testAffiche(ent);
    }

    public static void testSetVal(EntierContraint ent, int n) {
        System.out.println("On actualise une nouvelle valeur de " + n + " :");
        ent.setVal(n);
        testAffiche(ent);
    }
    
    public static void testSaisie(EntierContraint ent) {
        System.out.println("Saisie d'une nouvelle valeur :");
        ent.saisie();
        testAffiche(ent);
    }
}
