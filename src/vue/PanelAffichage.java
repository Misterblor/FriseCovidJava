package vue;

import modele.Chronologie;

import javax.swing.*;
import java.awt.*;

public class PanelAffichage extends JPanel {

    public PanelAffichage(Chronologie frise) {
        setLayout(new BorderLayout());

        add((new JLabel(frise.getIntitule())), BorderLayout.NORTH);

        PanelAffichageEvenement affichageEvent = new PanelAffichageEvenement(frise);
        add(affichageEvent, BorderLayout.CENTER);

        PanelAffichageTable affichageTable = new PanelAffichageTable();
        add(affichageTable, BorderLayout.SOUTH);
    }
}
