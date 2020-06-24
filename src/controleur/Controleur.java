package controleur;

import modele.Chronologie;
import utils.LectureEcriture;
import modele.SavesChronologie;
import vue.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * <b>
 *     Cette classe permet de gérer la synchronisation entre les différents Panels avec lesquels l'utilisateur intéragit<br>
 *     Appartient au package controleur.
 * </b>
 *
 * @author Antoine Limerutti / Pablo Rican
 *
 * @see ActionListener
 *
 * @version 1.0
 */
public class Controleur implements ActionListener {

    /**
     * Panel contenant le CardLayout pour naviguer entre les différents panels
     * @see PanelFrise
     */
    private PanelFrise panelFrise;

    /**
     * Panel affichant les firses pouvant être lu
     * et le bouton permettant d'ajouter une nouvelle frise
     * @see PanelChoixFrise
     */
    private PanelChoixFrise panelChoixFrise;

    /**
     * Panel permettant à l'utilisateur de renseigner les différents champs
     * d'une chronologie afin de l'ajouter.
     * @see PanelFormulaireChronologie
     */
    private PanelFormulaireChronologie panelFormulaireChronologie;

    /**
     * Panel permettant à l'utilisateur de renseigner les différents champs
     * d'un événement afin de l'ajouter à une chronologie.
     * @see PanelFormulaireEvenement
     */
    private PanelFormulaireEvenement panelFormulaireEvenement;

    /**
     * Constructeur de la classe Controleur.
     * Ajoute un écouteur aux boutons Ajout des panels
     * PanelFormulaireChronologie et PanelFormulaireEvenement.
     *
     * @param parPanelFrise PanelFrise que l'on a besoin de synchroniser
     * @param parPanelChoixFrise PanelChoixFrise que l'on a besoin de synchroniser
     * @param parPanelFormulaireChronologie PanelFormulaireChronologie que l'on a besoin de synchroniser
     * @param parPanelFormulaireEvenement PanelFormulaireEvenement que l'on a besoin de synchroniser
     */
    public Controleur(PanelFrise parPanelFrise, PanelChoixFrise parPanelChoixFrise, PanelFormulaireChronologie parPanelFormulaireChronologie, PanelFormulaireEvenement parPanelFormulaireEvenement){
        panelFrise = parPanelFrise;

        panelChoixFrise = parPanelChoixFrise;
        panelChoixFrise.enregistreEcouteur(this);

        panelFormulaireChronologie = parPanelFormulaireChronologie;
        panelFormulaireChronologie.getButtonAjouter().addActionListener(this);

        panelFormulaireEvenement = parPanelFormulaireEvenement;
        panelFormulaireEvenement.getButtonAjouter().addActionListener(this);
    }

    /**
     * Methode permettant de gérer les événements.
     *
     * Quand l'utilisateur clique sur le bouton pour créer une frise,
     * le panelFormulaireChronologie s'active.
     *
     * Quand l'utilisateur clique sur une des frises affichées,
     * le panelAffichage s'active et affiche la frise sélectionnée.
     *
     * Quand l'utilisateur clique sur le bouton Ajouter du panelFormulaireChronologie,
     * le controleur vérifie la validité des champs entrés et ajoute la chronologie sur
     * le disque dur de l'utilisateur à l'endroit souhaité.
     *
     * Quand l'utilisateur clique sur le bouton Ajouter du panelFormulaireEvenement,
     * le controleur vérifie la validité des champs entrés et ajoute l'événement
     * à la frise sélectionnée.
     *
     * Quand l'utilisateur clique sur le bouton Supprimer (-) du panelAffichage,
     * le controleur supprime la chronologie du disque dur de l'utilisateur
     * et se remet sur le panelChoixFrise.
     *
     * @param event l'évenement en question
     *
     * @see ActionEvent
     */
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
                JOptionPane optionPane = new JOptionPane("Enregistrement en cours...", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                JDialog messageEnregistrement = new JDialog();
                messageEnregistrement.setTitle("Enregistrement");
                messageEnregistrement.setContentPane(optionPane);
                messageEnregistrement.setLocationRelativeTo(panelFrise.getFenetreMere());
                messageEnregistrement.pack();
                messageEnregistrement.validate();
                messageEnregistrement.repaint();
                messageEnregistrement.setVisible(true);

                SavesChronologie listeChronologie = (SavesChronologie) LectureEcriture.lecture(SavesChronologie.FILE);
                listeChronologie.verification();
                Chronologie chronologie = panelFormulaireChronologie.enregistreChronologie();
                listeChronologie.add(chronologie.getAdresseFichierSauvegarde() + File.separator + chronologie.getIntitule() + ".ser");
                LectureEcriture.ecriture(new File(chronologie.getAdresseFichierSauvegarde() + File.separator + chronologie.getIntitule() + ".ser"), chronologie);

                panelFormulaireEvenement.updateModelComboBoxSelectionFrise(listeChronologie);
                panelFrise.setPanelChoixFrise(new PanelChoixFrise());

                messageEnregistrement.dispose();

                panelFrise.disableFormulaireChronologie();
            }
        }

        else if (event.getSource() == panelFormulaireEvenement.getButtonAjouter()){
            if (panelFormulaireEvenement.estValide()){
                JOptionPane optionPane = new JOptionPane("Enregistrement en cours...", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, null, null);
                JDialog messageEnregistrement = new JDialog();
                messageEnregistrement.setTitle("Enregistrement");
                messageEnregistrement.setContentPane(optionPane);
                messageEnregistrement.setLocationRelativeTo(panelFrise.getFenetreMere());
                messageEnregistrement.pack();
                messageEnregistrement.validate();
                messageEnregistrement.repaint();
                messageEnregistrement.setVisible(true);

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

                messageEnregistrement.dispose();
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
