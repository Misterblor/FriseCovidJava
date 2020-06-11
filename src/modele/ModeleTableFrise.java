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
            return nbJourEcart+1;
        else if(periode==1)
            return nbJourEcart%7==0 ? nbJourEcart/7 : (nbJourEcart/7)+1;
        else if(periode==2)
            return nbJourEcart%30==0 ? nbJourEcart/30 : (nbJourEcart/30)+1;
        else if(periode==3)
            return nbJourEcart%365==0 ? nbJourEcart/365 : (nbJourEcart/365)+1;
        else if(periode==4)
            return nbJourEcart%1826==0 ? nbJourEcart/1826 : (nbJourEcart/1826)+1;
        else if(periode==5)
            return nbJourEcart%3653==0 ? nbJourEcart/3653 : (nbJourEcart/3653)+1;
        else if(periode==6)
            return nbJourEcart%3653==0 ? nbJourEcart/3653 : (nbJourEcart/3653)+1;

        return 0;
    }
}
