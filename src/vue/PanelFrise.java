package vue;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFrise extends JPanel implements ActionListener {
    CardLayout card;

    FenetreAccueil fenetreMere;

    public PanelFrise(FenetreAccueil parFenetreMere){
        card = new CardLayout();
        setLayout(card);

        fenetreMere = parFenetreMere;

        Controleur controleur = new Controleur(this);

        add(new PanelChoixFrise(controleur), 0);
        add(new JPanel(), 1);
        add(new PanelFormulaireEvenement(), 2);
        add(new PanelFormulaireChronologie(), 3);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().compareTo("Affichage Frise")==0){
            card.first(this);
            card.next(this);
        }

        else if(event.getActionCommand().compareTo("Choix Frise")==0){
            card.first(this);
        }

        else if(event.getActionCommand().compareTo("Création")==0){
            card.last(this);
            card.previous(this);
        }

        else if(event.getActionCommand().compareTo("Fermer")==0) {
            int quitter = JOptionPane.showConfirmDialog(null, "Etes-vous sûr de vouloir quitter l'application ?", "Fermer", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(quitter==JOptionPane.OK_OPTION)
                fenetreMere.dispose();
        }

        else if(event.getActionCommand().compareTo("?")==0){
            //JOptionPane.showMessageDialog();
        }

    }

    public void setAffichage(PanelAffichage affichage){
        remove(1);
        add(affichage, 1);

        card.first(this);
        card.next(this);
    }

    public void enableFormulaireChronologie() {
        card.last(this);
    }

    public void disableFormulaireChronologie() {
        card.first(this);
    }
}
