package ex5;

import java.util.Date;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public final class PersonnelEnseignantVacataire extends PersonnelEnseignant {

    private Date debutContrat;
    private Date finContrat;

    public PersonnelEnseignantVacataire(String nom, String prenom, String titre, long noBureau, double paye, String discipline, Date debutContrat, Date finContrat) {
        super(nom, prenom, titre, noBureau, paye, discipline);
        this.debutContrat = debutContrat;
        this.finContrat = finContrat;
    }

    public PersonnelEnseignantVacataire(Personne p, String titre, long noBureau, double paye, String discipline, Date debutContrat, Date finContrat) {
        super(p, titre, noBureau, paye, discipline);
        this.debutContrat = debutContrat;
        this.finContrat = finContrat;
    }

    public PersonnelEnseignantVacataire(Personnel p, String discipline, Date debutContrat, Date finContrat) {
        super(p, discipline);
        this.debutContrat = debutContrat;
        this.finContrat = finContrat;
    }

    public PersonnelEnseignantVacataire(PersonnelEnseignant pe, Date debutContrat, Date finContrat) {
        super(pe);
        this.debutContrat = debutContrat;
        this.finContrat = finContrat;
    }
    
    public PersonnelEnseignantVacataire(PersonnelEnseignantVacataire pev) {
        this(pev.getNom(), pev.getPrenom(), pev.getTitre(), pev.getNoBureau(), pev.getPaye(), pev.getDiscipline(), pev.getDebutContrat(), pev.getFinContrat());
    }

    public Date getDebutContrat() {
        return debutContrat;
    }
    
    public void setDebutContrat(Date debutContrat) {
        this.debutContrat = debutContrat;
    }

    public Date getFinContrat() {
        return finContrat;
    }

    public void setFinContrat(Date finContrat) {
        this.finContrat = finContrat;
    }
    
}
