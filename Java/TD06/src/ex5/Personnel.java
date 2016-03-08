package ex5;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Personnel extends Personne {

    private String titre;
    private long noBureau;
    private double paye;

    public Personnel(String nom, String prenom, String titre, long noBureau, double paye) {
        super(nom, prenom);
        this.titre = titre;
        this.noBureau = noBureau;
        this.paye = paye;
    }

    public Personnel(Personne p, String titre, long noBureau, double paye) {
        super(p);
        this.titre = titre;
        this.noBureau = noBureau;
        this.paye = paye;
    }
    
    public Personnel(Personnel p) {
        this(p.getNom(), p.getPrenom(), p.getTitre(), p.getNoBureau(), p.getPaye());
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public long getNoBureau() {
        return noBureau;
    }

    public void setNoBureau(long noBureau) {
        this.noBureau = noBureau;
    }

    public double getPaye() {
        return paye;
    }

    public void setPaye(double paye) {
        this.paye = paye;
    }
}
