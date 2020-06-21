package vue;

import controleur.Controleur;
import modele.LectureEcriture;
import modele.SavesChronologie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFrise extends JPanel implements ActionListener {
    CardLayout card;
    JMenuItem selectedMenuItem;
    FenetreAccueil fenetreMere;
    PanelChoixFrise panelChoixFrise;
    PanelAffichage panelAffichage;
    PanelFormulaireChronologie panelFormulaireChronologie;
    PanelFormulaireEvenement panelFormulaireEvenement;
    Controleur controleur;

    public PanelFrise(FenetreAccueil parFenetreMere){
        card = new CardLayout();
        setLayout(card);

        fenetreMere = parFenetreMere;

        panelChoixFrise = new PanelChoixFrise();
        panelAffichage = new PanelAffichage();
        panelFormulaireChronologie = new PanelFormulaireChronologie();
        panelFormulaireEvenement = new PanelFormulaireEvenement();

        controleur = new Controleur(this, panelChoixFrise, panelFormulaireChronologie, panelFormulaireEvenement);

        add(panelChoixFrise, "Panel Choix Frise");
        add(panelAffichage, "Panel Affichage");
        add(panelFormulaireEvenement, "Panel Formulaire Evenement");
        add(panelFormulaireChronologie, "Panel Formulaire Chronologie");

        selectedMenuItem = (JMenuItem) fenetreMere.getMenuItem().getComponent(0);
        selectedMenuItem.setForeground(Color.GRAY);
    }

    /**
     * Traite les actions provenants des JMenuItem de la barre de menue JMenu.
     *
     * @param event ActionEvent correspondant à une action sur l'un des JMenuItem.
     *
     * @author Antoine Limerutti
     */
    public void actionPerformed(ActionEvent event) {
        if(selectedMenuItem!= null)
            selectedMenuItem.setForeground(Color.BLACK);
        selectedMenuItem = (JMenuItem) event.getSource();
        selectedMenuItem.setForeground(Color.GRAY);

        if(event.getActionCommand().compareTo("Affichage Frise")==0){
            fenetreMere.setSize(new Dimension(700,700));
            fenetreMere.setLocationRelativeTo(null);
            card.show(this, "Panel Affichage");
        }

        else if(event.getActionCommand().compareTo("Choix Frise")==0){
            fenetreMere.setSize(new Dimension(700,700));
            fenetreMere.setLocationRelativeTo(null);
            setPanelChoixFrise(new PanelChoixFrise());
            card.show(this, "Panel Choix Frise");
        }

        else if(event.getActionCommand().compareTo("Création")==0){
            fenetreMere.setSize(new Dimension(1280,740));
            fenetreMere.setLocationRelativeTo(null);
            panelFormulaireEvenement.reset();
            SavesChronologie listeChronologie = (SavesChronologie) LectureEcriture.lecture(SavesChronologie.FILE);
            listeChronologie.verification();
            panelFormulaireEvenement.updateModelComboBoxSelectionFrise(listeChronologie);
            card.show(this, "Panel Formulaire Evenement");
        }

        else if(event.getActionCommand().compareTo("Fermer")==0) {
            int quitter = JOptionPane.showConfirmDialog(null, "Etes-vous sûr de vouloir quitter l'application ?", "Fermer", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(quitter==JOptionPane.OK_OPTION)
                System.exit(0);
        }

        else if(event.getActionCommand().compareTo("?")==0){
            JOptionPane.showMessageDialog(this,
                    "<html>Utilité des différents onglets :<ul><li>Choix frise : Permet de séléctionner une frise à visionner ou d'en créer une nouvelle frise.</li><li>Affichage Frise : Affiche la frise précédemment sélectionnée dans l'onglet \"Choix Frise\".</li><li>Création : Permet d'ajouter un évènement à une frise.</li></ul><br>Assistance par e-mail : antoine.limerug@gmail.com / ricanpablo@gmail.com</html>",
                    "Aide",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void setAffichage(PanelAffichage affichage){
        updatePanelAffichage(affichage);
        card.show(this, "Panel Affichage");

        selectedMenuItem.setForeground(Color.BLACK);
        selectedMenuItem = (JMenuItem) fenetreMere.getMenuItem().getComponent(1);
        selectedMenuItem.setForeground(Color.GRAY);
    }

    public void updatePanelAffichage(PanelAffichage affichage){
        remove(panelAffichage);
        panelAffichage = affichage;
        add(affichage, "Panel Affichage");
    }

    public void enableFormulaireChronologie() {
        fenetreMere.setSize(new Dimension(1280,740));
        fenetreMere.setLocationRelativeTo(null);
        panelFormulaireChronologie.reset();
        card.show(this, "Panel Formulaire Chronologie");
    }

    public void disableFormulaireChronologie() {
        fenetreMere.setSize(new Dimension(700,700));
        fenetreMere.setLocationRelativeTo(null);
        panelFormulaireChronologie.reset();
        card.show(this, "Panel Choix Frise");
    }

    public CardLayout getCard() {
        return card;
    }

    public FenetreAccueil getFenetreMere() {
        return fenetreMere;
    }

    public void setPanelChoixFrise(PanelChoixFrise panelChoixFrise) {
        remove(panelChoixFrise);
        this.panelChoixFrise = panelChoixFrise;
        this.panelChoixFrise.enregistreEcouteur(controleur);
        add(panelChoixFrise, "Panel Choix Frise");
        validate();
        repaint();
        card.show(this, "Panel Choix Frise");
    }
}
