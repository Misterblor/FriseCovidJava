package modele;

import javax.swing.table.DefaultTableModel;

public class ModeleTableFrise extends DefaultTableModel {
    public ModeleTableFrise(Chronologie frise) {
        setRowCount(4);
        int nbColonne = nbCol(frise);
        setColumnCount(nbColonne);

        setColumnIdentifiers(getIdentifieur(frise, nbColonne));
    }

    private String[] getIdentifieur(Chronologie frise, int nbColonne) {
        String [] identifieur = new String[nbColonne];

        Date dateTemp = new Date(frise.getDateDebut().getJour(), frise.getDateDebut().getMois(), frise.getDateDebut().getAnnee());

        if(frise.getPeriode()!=0)
            dateTemp = dateTemp.datePremierJourSemaine();

        identifieur[0]=dateTemp.toString();

        for(int i=1; i<nbColonne; i++){
            dateTemp = faireAvancerDate(dateTemp, frise.getPeriode());
            if(i%3==0)
                identifieur[i]=dateTemp.toString();
            else
                identifieur[i]="";
        }

        return identifieur;
    }

    private int nbCol(Chronologie frise){
        int compteur=0;

        Date dateTemp = new Date(frise.getDateDebut().getJour(), frise.getDateDebut().getMois(), frise.getDateDebut().getAnnee());

        if(frise.getPeriode()!=0) {
            dateTemp = dateTemp.datePremierJourSemaine();
            compteur=1;
        }

        while(dateTemp.compareTo(frise.getDateFin())<0){
            dateTemp = faireAvancerDate(dateTemp, frise.getPeriode());
            compteur++;
        }

        return compteur;
    }

    private Date faireAvancerDate(Date dateTemp, int periode){
        if(periode==0)
            dateTemp = dateTemp.dateDuLendemain();
        else if(periode==1) {
            for (int decompte = 0; decompte < 7; decompte++)
                dateTemp = dateTemp.dateDuLendemain();
        }
        else if(periode==2){
            dateTemp.setJour(Date.dernierJourDuMois(dateTemp.getMois(), dateTemp.getAnnee()));
            dateTemp=dateTemp.dateDuLendemain();
        }
        else if(periode==3){
            dateTemp = dateTemp.anneeSuivante();
        }
        else if(periode==4){
            for(int decompte=0; decompte<5; decompte++)
                dateTemp = dateTemp.anneeSuivante();
        }
        else if(periode==5){
            for(int decompte=0; decompte<10; decompte++)
                dateTemp = dateTemp.anneeSuivante();
        }
        else{
            for(int decompte=0; decompte<100; decompte++)
                dateTemp = dateTemp.anneeSuivante();
        }
        return dateTemp;
    }
}
