package controleur;

import modele.Chronologie;
import modele.Date;
import modele.LectureEcriture;
import vue.FenetreAccueil;
import vue.PanelAffichage;
import vue.PanelFormulaireChronologie;
import vue.PanelFrise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Controleur implements ActionListener {
    PanelFrise panelFrise;

    public Controleur(PanelFrise parPanelFrise){
    panelFrise = parPanelFrise;
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().compareTo("Créer")==0){
            panelFrise.enableFormulaireChronologie();
        }

        else if((event.getActionCommand().split("'"))[0].compareTo("Charger")==0){
            panelFrise.setAffichage(new PanelAffichage((Chronologie) LectureEcriture.lecture(new File(event.getActionCommand().split("'")[1]))));
        }
    }
}
