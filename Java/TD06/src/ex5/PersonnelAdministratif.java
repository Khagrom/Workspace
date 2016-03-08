package ex5;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public final class PersonnelAdministratif extends Personnel {

    public PersonnelAdministratif(String nom, String prenom, String titre, long noBureau, double paye) {
        super(nom, prenom, titre, noBureau, paye);
    }
    
    public PersonnelAdministratif(Personne p, String titre, long noBureau, double paye) {
        super(p, titre, noBureau, paye);
    }
    
    public PersonnelAdministratif(Personnel p) {
        super(p.getNom(), p.getPrenom(), p.getTitre(), p.getNoBureau(), p.getPaye());
    }
    
}
