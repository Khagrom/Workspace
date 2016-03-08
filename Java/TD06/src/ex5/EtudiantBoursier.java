
package ex5;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public final class EtudiantBoursier extends Etudiant {
    
    private double montantBourse;
    
    public EtudiantBoursier(String nom, String prenom, long noEtu, double montantBourse) {
        super(nom, prenom, noEtu);
        this.montantBourse = montantBourse;
    }
    
    public EtudiantBoursier(Personne p, long noEtu, double montantBourse) {
        super(p, noEtu);
        this.montantBourse = montantBourse;
    }

    public EtudiantBoursier(Etudiant e, double montantBourse) {
        super(e);
        this.montantBourse = montantBourse;
    }
    
    public EtudiantBoursier(EtudiantBoursier eb) {
        this(eb.getNom(), eb.getPrenom(), eb.getNoEtu(), eb.getMontantBourse());
    }

    public double getMontantBourse() {
        return montantBourse;
    }

    public void setMontantBourse(double montantBourse) {
        this.montantBourse = montantBourse;
    }
}
