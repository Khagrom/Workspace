
/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class TestEtudiants {

    public static void main(String[] args) {
        Personne p = new Personne("Ladevie", "Léo");
        Etudiant etu = new Etudiant(p, 1514579);
        EtudiantBoursier etuB = new EtudiantBoursier(etu, etu.getNoEtu());

        p.affiche();
        etu.affiche();
        etuB.affiche();
    }
}
