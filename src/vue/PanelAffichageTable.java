package vue;

import modele.Chronologie;
import modele.ModeleTableFrise;

import javax.swing.*;
import java.awt.*;

public class PanelAffichageTable extends JPanel {
    public PanelAffichageTable(Chronologie frise) {
        JTable tableFrise = new JTable();
        tableFrise.setModel(new ModeleTableFrise(frise));

        JScrollPane scrollPane = new JScrollPane(tableFrise,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(650,500));
        add(scrollPane);
    }
}
