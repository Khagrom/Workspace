
/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class UtilString {

    /**
     * Affiche chaque caractère d'une chaîne.
     *
     * @param in Chaîne concernée.
     */
    public static void affiche(String in) {
        for (int i = 0; i < in.length(); i++) {
            System.out.println(in.charAt(i));
        }
    }

    /**
     * Compte le nombre d'occurences d'une chaîne de caractères dans une autre.
     *
     * @param cible Chaîne dans laquelle la recherche doit s'effectuer.
     * @param recherche Chaîne recherchée.
     * @return Nombre d'occurences.
     */
    public static int nbOccurences(final String cible, final String recherche) {
        String part = new String(cible);
        int occurences = 0, index;
        boolean kg = true;

        do {
            index = part.indexOf(recherche);
            if (index == -1) {
                kg = false;
            } else {
                occurences++;
                part = part.substring(index + recherche.length());
            }
        } while (kg);

        return occurences;
    }
}
