
/**
 * Cette classe permet de tester la classe EntierContraint.
 *
 * @author Vincent Poirier
 */
public class TestSexagesimal {

    public static void main(String[] args) {

        int h, m, s;
        double t;
        
        System.out.println("Saisir un nombre d'heures :");
        h = Clavier.lireInt();
        System.out.println("Saisir un nombre de minutes :");
        m = Clavier.lireInt();
        System.out.println("Saisir un nombre de secondes :");
        s = Clavier.lireInt();
        System.out.println();
        
        Sexagesimal sF1 = new SexagesimalF(h, m, s);
        Sexagesimal sHMS1 = new SexagesimalHMS(h, m, s);
        
        System.out.println("Usage de la classe SexagesimalF, Temps : " + sF1.toString() + "\nDécimal : " + sF1.getDec() + " / Heures : " + sF1.getH() + " / Minutes : " + sF1.getM() + " / Secondes : " + sF1.getS() + "\n");
        System.out.println("Usage de la classe SexagesimalHMS, Temps : " + sHMS1.toString() + "\nDécimal : " + sHMS1.getDec() + " / Heures : " + sHMS1.getH() + " / Minutes : " + sHMS1.getM() + " / Secondes : " + sHMS1.getS() + "\n");
        
        System.out.println("Saisir un temps décimal en considérant l'heure comme unité :");
        t = Clavier.lireDouble();
        System.out.println();
        
        Sexagesimal sF2 = new SexagesimalF(t);
        Sexagesimal sHMS2 = new SexagesimalHMS(t);
        System.out.println("Usage de la classe SexagesimalF, Temps : " + sF2.toString() + "\nDécimal : " + sF2.getDec() + " / Heures : " + sF2.getH() + " / Minutes : " + sF2.getM() + " / Secondes : " + sF2.getS() + "\n");
        System.out.println("Usage de la classe SexagesimalHMS, Temps : " + sHMS2.toString() + "\nDécimal : " + sHMS2.getDec() + " / Heures : " + sHMS2.getH() + " / Minutes : " + sHMS2.getM() + " / Secondes : " + sHMS2.getS() + "\n");
       
    }
}
