package vue;

import modele.Chronologie;

import javax.swing.*;
import java.awt.*;

public class PanelAffichage extends JPanel {

    public PanelAffichage(Chronologie frise) {
        setLayout(new BorderLayout());

        JLabel labelIntitule = new JLabel(frise.getIntitule(), JLabel.CENTER);
        labelIntitule.setFont(new Font("Calibri", Font.BOLD, 20));
        add(labelIntitule, BorderLayout.NORTH);
        labelIntitule.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10,0,0,0),labelIntitule.getBorder()));

        PanelAffichageEvenement affichageEvent = new PanelAffichageEvenement(frise);
        add(affichageEvent, BorderLayout.CENTER);

        PanelAffichageTable affichageTable = new PanelAffichageTable(frise, affichageEvent);
        add(affichageTable, BorderLayout.SOUTH);

        JButton precedent = new JButton("<");
        JButton suivant = new JButton(">");

        precedent.addActionListener(affichageEvent);
        suivant.addActionListener(affichageEvent);

        precedent.setPreferredSize(new Dimension(40,115));
        suivant.setPreferredSize(new Dimension(40,115));

        precedent.setActionCommand("precedent");
        suivant.setActionCommand("suivant");

        precedent.setBackground(getBackground());
        suivant.setBackground(getBackground());

        precedent.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0,20,0,0),precedent.getBorder()));
        suivant.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0,0,0,20),suivant.getBorder()));

        add(precedent, BorderLayout.WEST);
        add(suivant, BorderLayout.EAST);

        affichageEvent.setAffichageTable(affichageTable);
    }
}
