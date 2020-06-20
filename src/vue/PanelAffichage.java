package vue;

import modele.Chronologie;

import javax.swing.*;
import java.awt.*;

public class PanelAffichage extends JPanel {

    public PanelAffichage(Chronologie frise) {
        setLayout(new GridBagLayout());
        GridBagConstraints contrainte = new GridBagConstraints();

        JLabel labelIntitule = new JLabel(frise.getIntitule(), JLabel.CENTER);
        labelIntitule.setFont(new Font("Calibri", Font.BOLD, 20));
        contrainte.gridx=0;
        contrainte.gridy=0;
        contrainte.gridwidth=3;
        contrainte.anchor=GridBagConstraints.CENTER;
        add(labelIntitule, contrainte);

        contrainte.insets=new Insets(0,0,10,0);
        contrainte.gridx=1;
        contrainte.gridy=1;
        contrainte.gridheight=10;
        contrainte.gridwidth=1;
        contrainte.anchor=GridBagConstraints.CENTER;
        PanelAffichageEvenement affichageEvent = new PanelAffichageEvenement(frise);
        add(affichageEvent, contrainte);

        JButton precedent = new JButton("<");
        JButton suivant = new JButton(">");

        precedent.addActionListener(affichageEvent);
        suivant.addActionListener(affichageEvent);

        precedent.setPreferredSize(new Dimension(20,135));
        suivant.setPreferredSize(new Dimension(20,135));

        precedent.setActionCommand("precedent");
        suivant.setActionCommand("suivant");

        precedent.setBackground(getBackground());
        suivant.setBackground(getBackground());

        contrainte.gridx=0;
        contrainte.anchor=GridBagConstraints.LINE_START;
        contrainte.insets=new Insets(0,20,10,0);
        add(precedent, contrainte);

        contrainte.gridx=2;
        contrainte.anchor=GridBagConstraints.LINE_END;
        contrainte.insets=new Insets(0,0,10,20);
        add(suivant, contrainte);

        contrainte.gridwidth=3;
        contrainte.gridheight=20;
        contrainte.gridx=0;
        contrainte.gridy=11;
        contrainte.anchor=GridBagConstraints.CENTER;
        contrainte.insets=new Insets(0,0,0,0);
        PanelAffichageTable affichageTable = new PanelAffichageTable(frise, affichageEvent);
        add(affichageTable, contrainte);

        affichageEvent.setAffichageTable(affichageTable);
    }
}
