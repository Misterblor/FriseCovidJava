package vue;

import controleur.Controleur;
import modele.LectureEcriture;
import modele.SavesChronologie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <b>Panel qui vas contenir et coordonner les diff�rents panels de ce programme.<br>
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
     * CardLayout utilis� pour passer d'un panel � l'autre.
     *
     * @see CardLayout
     */
    CardLayout card;

    /**
     * Dernier JMenuItem utilis� pour changer de panel (Utilis� � des fins graphiques).
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
     * PanelChoixFrise qui vas permettre de s�lectionner des frises et d'acc�der au PanelFormulaireChronologie.
     *
     * @see PanelChoixFrise
     */
    PanelChoixFrise panelChoixFrise;

    /**
     * PanelAffichage qui vas s'occuper de l'affichage de la frise et de ses �v�nements.
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
     * Controleur qui vas g�rer les actions globales sur le programme.
     *
     * @see Controleur
     */
    Controleur controleur;

    /**
     * Constructeur de la classe PanelFrise. Il vas instancier les diff�rents panels ainsi que le controleur.
     *
     * @param parFenetreMere FenetreAcceuil correspondant � la fen�tre m�re.
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
     * @param event ActionEvent correspondant � une action sur l'un des JMenuItem.
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

        else if(event.getActionCommand().compareTo("Cr�ation")==0){
            panelFormulaireEvenement.reset();
            SavesChronologie listeChronologie = (SavesChronologie) LectureEcriture.lecture(SavesChronologie.FILE);
            listeChronologie.verification();
            panelFormulaireEvenement.updateModelComboBoxSelectionFrise(listeChronologie);
            fenetreMere.setSize(new Dimension(1280,740));
            card.show(this, "Panel Formulaire Evenement");
            fenetreMere.setLocationRelativeTo(null);
        }

        else if(event.getActionCommand().compareTo("Fermer")==0) {
            int quitter = JOptionPane.showConfirmDialog(null, "Etes-vous s�r de vouloir quitter l'application ?", "Fermer", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(quitter==JOptionPane.OK_OPTION)
                System.exit(0);
        }

        else if(event.getActionCommand().compareTo("?")==0){
            JOptionPane.showMessageDialog(this,
                    "<html>Utilit� des diff�rents onglets :<ul><li>Choix frise : Permet de s�l�ctionner une frise � visionner ou d'en cr�er une nouvelle frise.</li><li>Affichage Frise : Affiche la frise pr�c�demment s�lectionn�e dans l'onglet \"Choix Frise\".</li><li>Cr�ation : Permet d'ajouter un �v�nement � une frise.</li></ul><br>Assistance par e-mail : antoine.limerug@gmail.com / ricanpablo@gmail.com</html>",
                    "Aide",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /**
     * Modifieur du champ affichage. D�finit un nouveau PanelAffichage.
     *
     * @param affichage PanelAffichage � mettre � la place du pr�c�dent.
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
     * @param affichage PanelAffichage � mettre � la place du pr�c�dent.
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
     * D�finit un nouveau PanelAffichage sans frise associ�e.
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
     * @param panelChoixFrise PanelChoixFrise � mettre � la place du panelChoixFrise actuel.
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
