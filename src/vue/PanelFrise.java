package vue;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFrise extends JPanel implements ActionListener {
    CardLayout card;
    JMenuItem selectedMenuItem;
    FenetreAccueil fenetreMere;
    PanelFormulaireChronologie panelFormulaireChronologie = new PanelFormulaireChronologie();
    PanelFormulaireEvenement panelFormulaireEvenement = new PanelFormulaireEvenement();

    public PanelFrise(FenetreAccueil parFenetreMere){
        card = new CardLayout();
        setLayout(card);

        fenetreMere = parFenetreMere;

        Controleur controleur = new Controleur(this, panelFormulaireChronologie, panelFormulaireEvenement);

        add(new PanelChoixFrise(controleur), 0);
        add(new PanelAffichage(), 1);
        add(panelFormulaireEvenement, 2);
        add(panelFormulaireChronologie, 3);

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
        if(event.getActionCommand().compareTo("Fermer")!=0 && event.getActionCommand().compareTo("?")!=0) {
            if (selectedMenuItem != null)
                selectedMenuItem.setForeground(Color.BLACK);
            selectedMenuItem = (JMenuItem) event.getSource();
            selectedMenuItem.setForeground(Color.GRAY);
        }

        if(event.getActionCommand().compareTo("Affichage Frise")==0){
            fenetreMere.setSize(new Dimension(700,700));
            fenetreMere.setLocationRelativeTo(null);
            card.first(this);
            card.next(this);
        }

        else if(event.getActionCommand().compareTo("Choix Frise")==0){
            fenetreMere.setSize(new Dimension(700,700));
            fenetreMere.setLocationRelativeTo(null);
            card.first(this);
        }

        else if(event.getActionCommand().compareTo("Création")==0){
            fenetreMere.setSize(new Dimension(1280,740));
            fenetreMere.setLocationRelativeTo(null);
            card.last(this);
            card.previous(this);
        }

        else if(event.getActionCommand().compareTo("Fermer")==0) {
            int quitter = JOptionPane.showConfirmDialog(null, "Etes-vous sûr de vouloir quitter l'application ?", "Fermer", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(quitter==JOptionPane.OK_OPTION)
                fenetreMere.dispose();
        }

        else if(event.getActionCommand().compareTo("?")==0){
            JOptionPane.showMessageDialog(this,
                    "<html>Utilité des différents onglets :<ul><li>Choix frise : Permet de séléctionner une frise à visionner ou d'en créer une nouvelle frise.</li><li>Affichage Frise : Affiche la frise précédemment sélectionnée dans l'onglet \"Choix Frise\".</li><li>Création : Permet d'ajouter un évènement à la frise en cours de visionnage.</li></ul><br>Assistance par e-mail : antoine.limerug@gmail.com</html>",
                    "Aide",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void setAffichage(PanelAffichage affichage){
        remove(1);
        add(affichage, 1);

        card.first(this);
        card.next(this);

        selectedMenuItem.setForeground(Color.BLACK);
        selectedMenuItem = (JMenuItem) fenetreMere.getMenuItem().getComponent(1);
        selectedMenuItem.setForeground(Color.GRAY);
    }

    public void enableFormulaireChronologie() {
        fenetreMere.setSize(new Dimension(1280,740));
        fenetreMere.setLocationRelativeTo(null);
        card.last(this);
    }

    public void disableFormulaireChronologie() {
        card.first(this);
    }
}
