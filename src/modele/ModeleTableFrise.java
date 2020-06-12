package modele;

import javax.swing.table.DefaultTableModel;

public class ModeleTableFrise extends DefaultTableModel {
    public ModeleTableFrise(Chronologie frise) {
        setRowCount(4);
        int nbColonne = nbCol(frise.getDateDebut(), frise.getDateFin(), frise.getPeriode());
        setColumnCount(nbColonne);
        System.out.println(nbColonne);

        setColumnIdentifiers(getIdentifieur(frise, nbColonne));
    }

    private String[] getIdentifieur(Chronologie frise, int nbColonne) {
        String [] identifieur = new String[nbColonne];

        Date dateTemp;
        if(frise.getPeriode()==0 || frise.getPeriode()==1) {
            dateTemp = new Date(frise.getDateDebut().getJour(), frise.getDateDebut().getMois(), frise.getDateDebut().getAnnee());
            if (frise.getPeriode() == 1)
                dateTemp = dateTemp.datePremierJourSemaine();
        }
        else if(frise.getPeriode()==2)
            dateTemp = new Date(1, frise.getDateDebut().getMois(), frise.getDateDebut().getAnnee());
        else
            dateTemp = new Date(1, 1, frise.getDateDebut().getAnnee());

        identifieur[0]=dateTemp.toString();

        for(int i=1; i<nbColonne; i++){
            dateTemp = Date.faireAvancerDate(dateTemp, frise.getPeriode());
            if(i%3==0 || i+1==nbColonne)
                identifieur[i]=dateTemp.toString();
            else
                identifieur[i]="";
        }

        return identifieur;
    }

    private int nbCol(Date debut, Date fin, int periode){
        int nbJourEcart=debut.nbJourEntre(fin);

        if(periode==0)
            return debut.nbJourEntre(fin);
        else if(periode==1)
            return debut.nbJourEntre(fin)%7==0 ? debut.nbJourEntre(fin)/7 : (debut.nbJourEntre(fin)/7)+1;
        else if(periode==2)
            return debut.nbMoisEntre(fin);
        else if(periode==3)
            return debut.nbAnneeEntre(fin);
        else if(periode==4)
            return debut.nbAnneeEntre(fin)%5==0 ? debut.nbAnneeEntre(fin)/5 : (debut.nbAnneeEntre(fin)/5)+1;
        else if(periode==5)
            return debut.nbAnneeEntre(fin)%10==0 ? debut.nbAnneeEntre(fin)/10 : (debut.nbAnneeEntre(fin)/10)+1;
        else if(periode==6)
            return debut.nbAnneeEntre(fin)%100==0 ? debut.nbAnneeEntre(fin)/100 : (debut.nbAnneeEntre(fin)/100)+1;

        return 0;
    }
}
