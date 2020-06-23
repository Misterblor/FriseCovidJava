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
 *
 * @author Antoine Limerutti / Pablo Rican
 */
public class PanelFrise extends JPanel implements ActionListener {
    /**
     * CardLayout utilisé pour passer d'un panel à l'autre.
     *
     * @see CardLayout
     */
    CardLayout card;

    /**
     * Dernier JMenuItem utilisé pour changer de panel (Utilisé à des fins graphiques).
     *
     * @see JMenuItem
     */
    JMenuItem selectedMenuItem;

    /**
     * FenetreAcceuil du PanelFrise.
     *
     * @see FenetreAccueil
     */
    FenetreAccueil fenetreMere;

    /**
     * PanelChoixFrise qui vas permettre de sélectionner des frises et d'accéder au PanelFormulaireChronologie.
     *
     * @see PanelChoixFrise
     */
    PanelChoixFrise panelChoixFrise;

    /**
     * PanelAffichage qui vas s'occuper de l'affichage de la frise et de ses évènements.
     *
     * @see PanelAffichage
     */
    PanelAffichage panelAffichage;

    /**
     * PanelFormulaireChronologie qui vas permettre de renseigner des Chronologies.
     *
     * @see PanelFormulaireChronologie
     */
    PanelFormulaireChronologie panelFormulaireChronologie;

    /**
     * PanelFormulaireEvenement qui vas permettre de renseigner des Evenements
     *
     * @see PanelFormulaireEvenement
     */
    PanelFormulaireEvenement panelFormulaireEvenement;

    /**
     * Controleur qui vas gérer les actions globales sur le programme.
     *
     * @see Controleur
     */
    Controleur controleur;

    /**
     * Constructeur de la classe PanelFrise. Il vas instancier les différents panels ainsi que le controleur.
     *
     * @param parFenetreMere FenetreAcceuil correspondant à la fenêtre mère.
     *
     * @version 1.0
     *
     * @author Antoine Limerutti / Pablo Rican
     */
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
     * @see ActionEvent
     *
     * @author Antoine Limerutti
     */
    public void actionPerformed(ActionEvent event) {
        if(selectedMenuItem!= null)
            selectedMenuItem.setForeground(Color.BLACK);
        selectedMenuItem = (JMenuItem) event.getSource();
        selectedMenuItem.setForeground(Color.GRAY);

        if(event.getActionCommand().compareTo("Affichage Frise")==0){
            fenetreMere.setSize(800,700);
            fenetreMere.setLocationRelativeTo(null);
            card.show(this, "Panel Affichage");
        }

        else if(event.getActionCommand().compareTo("Choix Frise")==0){
            setPanelChoixFrise(new PanelChoixFrise());
            fenetreMere.setSize(800,700);
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

    /**
     * Modifieur du champ affichage. Définit un nouveau PanelAffichage.
     *
     * @param affichage PanelAffichage à mettre à la place du précédent.
     *
     * @author Antoine Limerutti / Pablo Rican
     *
     * @see PanelAffichage
     */
    public void setAffichage(PanelAffichage affichage){
        updatePanelAffichage(affichage);
        card.show(this, "Panel Affichage");

        selectedMenuItem.setForeground(Color.BLACK);
        selectedMenuItem = (JMenuItem) fenetreMere.getMenuItem().getComponent(1);
        selectedMenuItem.setForeground(Color.GRAY);
    }

    /**
     * Actualise le PanelAffichage dans le CardLayout.
     *
     * @param affichage PanelAffichage à mettre à la place du précédent.
     *
     * @see PanelAffichage
     *
     * @author Antoine Limerutti
     */
    public void updatePanelAffichage(PanelAffichage affichage){
        remove(panelAffichage);
        panelAffichage = affichage;
        panelAffichage.enregistreEcouteur(controleur);
        add(affichage, "Panel Affichage");
    }

    /**
     * Définit un nouveau PanelAffichage sans frise associée.
     *
     * @see PanelAffichage
     *
     * @author Pablo Rican
     */
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

    /**
     * Affiche le PanelFormulaireChronologie.
     *
     * @author Antoie Limerutti
     */
    public void enableFormulaireChronologie() {
        panelFormulaireChronologie.reset();
        fenetreMere.setSize(new Dimension(1280,740));
        card.show(this, "Panel Formulaire Chronologie");
        fenetreMere.setLocationRelativeTo(null);
    }

    /**
     * Sortie du PanelFormulaireChronologie, retour au PanelChoixFrise.
     *
     * @author Antoie Limerutti
     */
    public void disableFormulaireChronologie() {
        panelFormulaireChronologie.reset();
        fenetreMere.setSize(800,700);
        card.show(this, "Panel Choix Frise");
        fenetreMere.setLocationRelativeTo(null);
    }

    /**
     * Accesseur du champ card.
     *
     * @return CardLayout correspondant au champ card.
     *
     * @see CardLayout
     *
     * @author Antoine Limerutti
     */
    public CardLayout getCard() {
        return card;
    }

    /**
     * Accesseur du champ fenetreMere.
     *
     * @return FenetreAccueil correspondant au champ fenetreMere.
     *
     * @see FenetreAccueil
     *
     * @author Antoine Limerutti
     */
    public FenetreAccueil getFenetreMere() {
        return fenetreMere;
    }

    /**
     * Modifieur du champ panelChoixFrise. Remplace et actualise le panelChoixFrise.
     *
     * @param panelChoixFrise PanelChoixFrise à mettre à la place du panelChoixFrise actuel.
     *
     * @author Pablo Rican
     *
     * @see PanelChoixFrise
     */
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
