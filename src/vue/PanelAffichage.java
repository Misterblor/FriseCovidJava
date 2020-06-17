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

        PanelAffichageEvenement affichageEvent = new PanelAffichageEvenement(frise);
        add(affichageEvent, BorderLayout.CENTER);

        PanelAffichageTable affichageTable = new PanelAffichageTable(frise, affichageEvent);
        add(affichageTable, BorderLayout.SOUTH);

        affichageEvent.setAffichageTable(affichageTable);
    }
}
