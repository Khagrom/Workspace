
/**
 * Cinquième exercice du TD1
 *
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Exercice5 {

    public static void main(String[] args) {
        boolean visible = true;
        System.out.println("Entrez le montant total en euros :");
        int total = Clavier.lireInt();

        total *= 100;
        for (int eu = 0; eu <= total / 100 && visible; eu++) {
            int totalMoinsEu = total - eu * 100;

            for (int cqte = 0; cqte <= totalMoinsEu / 50 && visible; cqte++) {
                int totalMoinsEuCqte = totalMoinsEu - cqte * 50;

                for (int vgt = 0; vgt <= totalMoinsEuCqte / 20 && visible; vgt++) {
                    int totalMoinsEuCqteVgt = totalMoinsEuCqte - vgt * 20;

                    for (int dix = 0; dix <= totalMoinsEuCqteVgt / 10 && visible; dix++) {
                        int cq = totalMoinsEuCqteVgt - dix * 10;
                        cq /= 5;

                        if (visible) {
                            System.out.println("1e\t50c\t20c\t10c\t5c\tpour faire " + total / 100 + "e");
                            System.out.println(eu + "\t" + cqte + "\t" + vgt + "\t" + dix + "\t" + cq);
                            System.out.println("Voulez-vous voir la combinaison suivante ? (o/n)");
                            char cont = Clavier.lireChar();
                            if (Character.toLowerCase(cont) == 'n') {
                                visible = false;
                            }
                        }
                    }
                }
            }
        }
    }
}
