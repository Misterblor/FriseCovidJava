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
    PanelChoixFrise panelChoixFrise;
    PanelFormulaireChronologie panelFormulaireChronologie;
    PanelFormulaireEvenement panelFormulaireEvenement;

    public Controleur(PanelFrise parPanelFrise, PanelChoixFrise parPanelChoixFrise, PanelFormulaireChronologie parPanelFormulaireChronologie, PanelFormulaireEvenement parPanelFormulaireEvenement){
    panelFrise = parPanelFrise;
    panelChoixFrise = parPanelChoixFrise;
    panelChoixFrise.enregistreEcouteur(this);
    panelFormulaireChronologie = parPanelFormulaireChronologie;
    panelFormulaireChronologie.getButtonAjouter().addActionListener(this);
    panelFormulaireEvenement = parPanelFormulaireEvenement;
    panelFormulaireEvenement.getButtonAjouter().addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().compareTo("Créer")==0){
            panelFrise.enableFormulaireChronologie();
        }

        else if((event.getActionCommand().split("'"))[0].compareTo("Charger")==0){
            SavesChronologie listeChronologie = (SavesChronologie) LectureEcriture.lecture(SavesChronologie.FILE);
            listeChronologie.verification();
            panelFrise.setAffichage(new PanelAffichage((Chronologie) LectureEcriture.lecture(new File(event.getActionCommand().split("'")[1]))));
        }

        if (event.getSource() == panelFormulaireChronologie.getButtonAjouter()){
            if (panelFormulaireChronologie.estValide()){
                SavesChronologie listeChronologie = (SavesChronologie) LectureEcriture.lecture(SavesChronologie.FILE);
                listeChronologie.verification();
                Chronologie chronologie = panelFormulaireChronologie.enregistreChronologie();
                listeChronologie.add(chronologie.getAdresseFichierSauvegarde() + File.separator + chronologie.getIntitule());
                LectureEcriture.ecriture(new File(chronologie.getAdresseFichierSauvegarde() + File.separator + chronologie.getIntitule()), chronologie);
                panelFormulaireEvenement.updateModelComboBoxSelectionFrise(listeChronologie);
                panelFrise.setPanelChoixFrise(new PanelChoixFrise());
                panelFrise.disableFormulaireChronologie();
            }
        }

        if (event.getSource() == panelFormulaireEvenement.getButtonAjouter()){
            if (panelFormulaireEvenement.estValide()){
                SavesChronologie listeChronologie = (SavesChronologie) LectureEcriture.lecture(SavesChronologie.FILE);
                listeChronologie.verification();
                Chronologie[] chronologies = new Chronologie[listeChronologie.size()];
                for (int i = 0; i < listeChronologie.size(); i++) {
                    chronologies[i] = (Chronologie) LectureEcriture.lecture(new File(listeChronologie.get(i)));
                }
                chronologies[panelFormulaireEvenement.getComboBoxSelectionFrise().getSelectedIndex()-1].ajout(panelFormulaireEvenement.enregistrerEvenement());
                LectureEcriture.ecriture(new File(chronologies[panelFormulaireEvenement.getComboBoxSelectionFrise().getSelectedIndex()-1].getAdresseFichierSauvegarde() + File.separator + chronologies[panelFormulaireEvenement.getComboBoxSelectionFrise().getSelectedIndex()-1].getIntitule()), chronologies[panelFormulaireEvenement.getComboBoxSelectionFrise().getSelectedIndex()-1]);
                panelFrise.updatePanelAffichage(new PanelAffichage(chronologies[panelFormulaireEvenement.getComboBoxSelectionFrise().getSelectedIndex()-1]));
                panelFormulaireEvenement.reset();
            }
        }
    }
}
