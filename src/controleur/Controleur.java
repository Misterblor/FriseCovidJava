package controleur;

import modele.Chronologie;
import modele.Date;
import modele.LectureEcriture;
import modele.SavesChronologie;
import vue.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Controleur implements ActionListener {
    PanelFrise panelFrise;
    PanelFormulaireChronologie panelFormulaireChronologie;
    PanelFormulaireEvenement panelFormulaireEvenement;

    public Controleur(PanelFrise parPanelFrise, PanelFormulaireChronologie parPanelFormulaireChronologie, PanelFormulaireEvenement parPanelFormulaireEvenement){
    panelFrise = parPanelFrise;
    panelFormulaireChronologie = parPanelFormulaireChronologie;
    panelFormulaireChronologie.getButtonAjouter().addActionListener(this);
    panelFormulaireEvenement = parPanelFormulaireEvenement;
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().compareTo("Créer")==0){
            panelFrise.enableFormulaireChronologie();
        }

        else if((event.getActionCommand().split("'"))[0].compareTo("Charger")==0){
            panelFrise.setAffichage(new PanelAffichage((Chronologie) LectureEcriture.lecture(new File(event.getActionCommand().split("'")[1]))));
        }

        if (event.getSource() == panelFormulaireChronologie.getButtonAjouter()){
            if (panelFormulaireChronologie.estValide()){
                SavesChronologie listeChronologie = (SavesChronologie) LectureEcriture.lecture(SavesChronologie.FILE);
                Chronologie chronologie = panelFormulaireChronologie.enregistreChronologie();
                listeChronologie.add(chronologie.getAdresseFichierSauvegarde() + File.separator + chronologie.getIntitule());
                LectureEcriture.ecriture(new File(chronologie.getAdresseFichierSauvegarde() + File.separator + chronologie.getIntitule()), chronologie);
                panelFrise.setPanelChoixFrise(new PanelChoixFrise(this));
                panelFrise.getFenetreMere().setSize(new Dimension(700,700));
                panelFrise.getFenetreMere().setLocationRelativeTo(null);
                panelFrise.getCard().first(panelFrise);
            }
        }
    }
}
