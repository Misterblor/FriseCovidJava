package modele;

import javax.swing.table.DefaultTableModel;

/**
 * <b>Modèle de la JTable du panel PanelAffichageTable.<br>
 * Appartient au package modele.</b>
 *
 * @see javax.swing.table.DefaultTableModel
 * @see vue.PanelAffichageTable
 *
 * @author Antoine Limerutti
 *
 * @version 1.0
 */
public class ModeleTableFrise extends DefaultTableModel {

    /**
     * Constructeur de la classe ModeleTableFrise.
     *
     * @param frise Chronologie de la table dont il vas falloir réaliser le modèle.
     *
     * @author Antoine Limerutti
     *
     * @see Chronologie
     */
    public ModeleTableFrise(Chronologie frise) {
        setRowCount(4);
        setColumnCount(nbCol(frise.getDateDebut(), frise.getDateFin(), frise.getPeriode()));

        Evenement event = frise.get(0);

        for(int i = 1; event!=null; i++){
            if(frise.getPeriode()==0)
                setValueAt(event, event.getPoids(), frise.getDateDebut().nbJourEntre(event.getDate()));

            else if(frise.getPeriode()==1)
                setValueAt(event, event.getPoids(), frise.getDateDebut().nbSemaineEntre(event.getDate()) - 2);

            else if(frise.getPeriode()==2)
                setValueAt(event, event.getPoids(), frise.getDateDebut().nbMoisEntre(event.getDate()));

            else if (frise.getPeriode()==3)
                setValueAt(event, event.getPoids(), event.getDate().getAnnee()-frise.getDateDebut().getAnnee());

            else if(frise.getPeriode()==4)
                setValueAt(event, event.getPoids(), frise.getDateDebut().nbAnneeEntre(event.getDate())/5);

            else if(frise.getPeriode()==5)
                setValueAt(event, event.getPoids(), frise.getDateDebut().nbAnneeEntre(event.getDate())/10);

            else if(frise.getPeriode()==6)
                setValueAt(event, event.getPoids(), frise.getDateDebut().nbAnneeEntre(event.getDate())/100);

            event = frise.get(i);
        }
        setId(frise.getPeriode(), getColumnCount(), frise.getDateDebut());
    }

    /**
     * Détermine le nombre de colonne nécéssaires dans le modèle en fonction de la periode et des dates de bébut et de fin de la chronologie.
     *
     * @param debut Date de début de la chronologie.
     * @param fin Date de fin de la chronologie.
     * @param periode Entier correspondant à la periode de la chronologie
     *
     * @return Nombre de colonne dans la table.
     *
     * @see Date
     *
     * @author Antoine Limerutti
     */
    public int nbCol(Date debut, Date fin, int periode){
        int nbColonne=0;

        if(periode==0)
            nbColonne = debut.nbJourEntre(fin) + 1;
        else if(periode==1)
            nbColonne = debut.nbSemaineEntre(fin)-1;
        else if(periode==2)
            nbColonne = debut.nbMoisEntre(fin)+1;
        else if(periode==3)
            nbColonne = debut.nbAnneeEntre(fin)+1;
        else if(periode==4)
            nbColonne = debut.nbAnneeEntre(fin)%5==0 ? (debut.nbAnneeEntre(fin)+1)/5 : ((debut.nbAnneeEntre(fin)+1)/5)+1;
        else if(periode==5)
            nbColonne = debut.nbAnneeEntre(fin)%10==0 ? (debut.nbAnneeEntre(fin)+1)/10 : ((debut.nbAnneeEntre(fin)+1)/10)+1;
        else if(periode==6)
            nbColonne = debut.nbAnneeEntre(fin)%100==0 ? (debut.nbAnneeEntre(fin)+1)/100 : ((debut.nbAnneeEntre(fin)+1)/100)+1;

        return nbColonne;
    }

    /**
     * Définit les identifieurs de chaque colonne de la table.
     *
     * @param periode Entier correspondant à la periode de la Chronologie.
     * @param nbColonne Entier correspondant au nombre de colonnes dans le modèle.
     * @param debut Date de debut de la frise.
     *
     * @author Antoine Limerutti.
     *
     * @see Date
     */
    private void setId(int periode, int nbColonne, Date debut) {
        String[]id = new String[nbColonne];

        if(periode==0 || periode==1) {
            Date dateTemp = new Date(debut.getJour(), debut.getMois(), debut.getAnnee());

            if (periode == 1)
                dateTemp = dateTemp.datePremierJourSemaine();

            id[0] = dateTemp.toString();

            for(int i=1; i<nbColonne; i++){
                dateTemp = dateTemp.dateDuLendemain();

                if(periode==1)
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
        setColumnIdentifiers(id);
    }

    /**
     * Vérifie et retourne le type de donnée dans une colonne.
     *
     * @param col Entier qui indique le numéro de colonne dont il vas falloir vérifier le type.
     *
     * @return Retourne la classe de la colonne sélectionnée.
     *
     * @author Antoine Limerutti
     */
    public Class<Evenement> getColumnClass(int col) {
        return Evenement.class;
    }
}
