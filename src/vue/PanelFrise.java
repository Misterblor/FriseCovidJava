package vue;

import controleur.Controleur;
import modele.LectureEcriture;
import modele.SavesChronologie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <b>Panel qui vas contenir et coordonner les différents panels de ce programme.<br>
 * Appartiens au package vue.</b>
 *
 * @see JPanel
 *
 * @version 1.0
 */
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
            setPanelChoixFrise(new PanelChoixFrise());
            fenetreMere.setSize(new Dimension(700,700));
            card.show(this, "Panel Choix Frise");
            fenetreMere.setLocationRelativeTo(null);
        }

        else if(event.getActionCommand().compareTo("Création")==0){
            panelFormulaireEvenement.reset();
            SavesChronologie listeChronologie = (SavesChronologie) LectureEcriture.lecture(SavesChronologie.FILE);
            listeChronologie.verification();
            panelFormulaireEvenement.updateModelComboBoxSelectionFrise(listeChronologie);
            fenetreMere.setSize(new Dimension(1280,740));
            card.show(this, "Panel Formulaire Evenement");
            fenetreMere.setLocationRelativeTo(null);
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
        panelAffichage.enregistreEcouteur(controleur);
        add(affichage, "Panel Affichage");
    }

    public void resetPanelAffichage(){
        remove(panelAffichage);
        panelAffichage = new PanelAffichage();
        add(panelAffichage, "Panel Affichage");

        if(selectedMenuItem!= null)
            selectedMenuItem.setForeground(Color.BLACK);
        selectedMenuItem = (JMenuItem) fenetreMere.getMenuItem().getComponent(0);
        selectedMenuItem.setForeground(Color.GRAY);

        card.show(this, "Panel Choix Frise");
    }

    public void enableFormulaireChronologie() {
        panelFormulaireChronologie.reset();
        fenetreMere.setSize(new Dimension(1280,740));
        card.show(this, "Panel Formulaire Chronologie");
        fenetreMere.setLocationRelativeTo(null);
    }

    public void disableFormulaireChronologie() {
        panelFormulaireChronologie.reset();
        fenetreMere.setSize(new Dimension(700,700));
        card.show(this, "Panel Choix Frise");
        fenetreMere.setLocationRelativeTo(null);
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
