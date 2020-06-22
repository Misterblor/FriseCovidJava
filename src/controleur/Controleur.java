package controleur;

import modele.Chronologie;
import modele.LectureEcriture;
import modele.SavesChronologie;
import vue.*;

import javax.swing.*;
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

        else if((event.getActionCommand().split(">"))[0].compareTo("Charger")==0){
            File fichier = new File(event.getActionCommand().split(">")[1]);
            if(fichier.exists())
                panelFrise.setAffichage(new PanelAffichage((Chronologie) LectureEcriture.lecture(fichier)));
            else{
                JOptionPane.showMessageDialog(panelChoixFrise, "Le fichier spécifié a été supprimé ou déplacé.", "Erreur de chargement", JOptionPane.ERROR_MESSAGE);
                panelFrise.setPanelChoixFrise(new PanelChoixFrise());
            }
        }

        else if (event.getSource() == panelFormulaireChronologie.getButtonAjouter()){
            if (panelFormulaireChronologie.estValide()){
                SavesChronologie listeChronologie = (SavesChronologie) LectureEcriture.lecture(SavesChronologie.FILE);
                listeChronologie.verification();
                Chronologie chronologie = panelFormulaireChronologie.enregistreChronologie();
                listeChronologie.add(chronologie.getAdresseFichierSauvegarde() + File.separator + chronologie.getIntitule() + ".ser");
                LectureEcriture.ecriture(new File(chronologie.getAdresseFichierSauvegarde() + File.separator + chronologie.getIntitule() + ".ser"), chronologie);
                panelFormulaireEvenement.updateModelComboBoxSelectionFrise(listeChronologie);
                panelFrise.setPanelChoixFrise(new PanelChoixFrise());
                panelFrise.disableFormulaireChronologie();
            }
        }

        else if (event.getSource() == panelFormulaireEvenement.getButtonAjouter()){
            if (panelFormulaireEvenement.estValide()){
                SavesChronologie listeChronologie = (SavesChronologie) LectureEcriture.lecture(SavesChronologie.FILE);
                listeChronologie.verification();
                Chronologie[] chronologies = new Chronologie[listeChronologie.size()];
                for (int i = 0; i < listeChronologie.size(); i++) {
                    chronologies[i] = (Chronologie) LectureEcriture.lecture(new File(listeChronologie.get(i)));
                }
                chronologies[panelFormulaireEvenement.getComboBoxSelectionFrise().getSelectedIndex()-1].ajout(panelFormulaireEvenement.enregistrerEvenement());
                LectureEcriture.ecriture(new File(chronologies[panelFormulaireEvenement.getComboBoxSelectionFrise().getSelectedIndex()-1].getAdresseFichierSauvegarde() + File.separator + chronologies[panelFormulaireEvenement.getComboBoxSelectionFrise().getSelectedIndex()-1].getIntitule() + ".ser"), chronologies[panelFormulaireEvenement.getComboBoxSelectionFrise().getSelectedIndex()-1]);
                panelFrise.updatePanelAffichage(new PanelAffichage(chronologies[panelFormulaireEvenement.getComboBoxSelectionFrise().getSelectedIndex()-1]));
                panelFormulaireEvenement.reset();
                JOptionPane.showMessageDialog(panelFormulaireEvenement, "Votre évènement a bien été ajouté !", "Ajout de l'évènement", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        else if(event.getActionCommand().split(">")[0].equals("suprimmerFrise")){
            if(JOptionPane.showConfirmDialog(panelFrise, "Voulez-vous réellement supprimer cette frise ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.OK_OPTION) {
                SavesChronologie listeSave = (SavesChronologie) LectureEcriture.lecture(SavesChronologie.FILE);
                listeSave.remove(event.getActionCommand().split(">")[1]);

                panelFrise.setPanelChoixFrise(new PanelChoixFrise());
                panelFrise.resetPanelAffichage();
            }
        }
    }
}
