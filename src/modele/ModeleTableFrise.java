package modele;

import javax.swing.table.DefaultTableModel;

public class ModeleTableFrise extends DefaultTableModel {
    public ModeleTableFrise(Chronologie frise) {
        setRowCount(4);
        int nbColonne = nbCol(frise.getDateDebut(), frise.getDateFin(), frise.getPeriode());
        setColumnCount(nbColonne);
        System.out.println(nbColonne);

        setColumnIdentifiers(getIdentifieur(frise.getPeriode(), nbColonne, frise.getDateDebut()));
    }

    /*private String[] getIdentifieur(Chronologie frise, int nbColonne) {
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
    }*/

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

    private String[] getIdentifieur(int periode, int nbColonne, Date debut) {
        String[]id = new String[nbColonne];

        if(periode==0 || periode==1) {
            Date dateTemp = new Date(debut.getJour(), debut.getMois(), debut.getAnnee());

            if (periode == 1)
                dateTemp = dateTemp.datePremierJourSemaine();

            id[0] = dateTemp.toString();

            for(int i=1; i<nbColonne; i++){
                dateTemp = dateTemp.dateDuLendemain();

                if(periode==7)
                    for(int j=0; j<6; j++)
                        dateTemp = dateTemp.dateDuLendemain();

                if(i%3==0 || i+1==nbColonne)
                    id[i]=dateTemp.toString();
                else
                    id[i]="";
            }
        }

        if(periode==2){
            int mois = debut.getMois();
            int annee = debut.getAnnee();

            for(int indice=0; indice<id.length; indice++){
                if(indice%3==0 || indice+1==nbColonne) {
                    switch (mois) {
                        case 1 -> id[indice] = "Jan. " + annee;
                        case 2 -> id[indice] = "Fev. " + annee;
                        case 3 -> id[indice] = "Mars " + annee;
                        case 4 -> id[indice] = "Avr. " + annee;
                        case 5 -> id[indice] = "Mai " + annee;
                        case 6 -> id[indice] = "Juin " + annee;
                        case 7 -> id[indice] = "Juil. " + annee;
                        case 8 -> id[indice] = "Aout " + annee;
                        case 9 -> id[indice] = "Sept. " + annee;
                        case 10 -> id[indice] = "Oct. " + annee;
                        case 11 -> id[indice] = "Nov. " + annee;
                        case 12 -> id[indice] = "Dec. " + annee;
                    }
                }
                else
                    id[indice]="";

                mois++;
                if(mois>12) {
                    mois = 1;
                    annee++;
                }
            }
        }

        else if(periode==3 || periode==4 || periode==5 || periode==6){
            int annee;
            switch(periode){
                case 3 -> annee = debut.getAnnee();
                case 4 -> annee = (debut.getAnnee()/5)*5;
                case 5 -> annee = (debut.getAnnee()/10)*10;
                default -> annee = (debut.getAnnee()/100)*100;
            }

            for(int indice=0; indice<id.length; indice++){
                if(indice%3==0 || indice+1==nbColonne)
                    id[indice] = "" + annee;
                else
                    id[indice]="";

                switch(periode){
                    case 3 -> annee++;
                    case 4 -> annee+=5;
                    case 5 -> annee+=10;
                    default -> annee+=100;
                }
            }
        }
        return id;
    }
}
