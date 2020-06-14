package vue;

import modele.Chronologie;
import modele.ModeleTableFrise;

import javax.swing.*;
import java.awt.*;

public class PanelAffichageTable extends JPanel {
    public PanelAffichageTable(Chronologie frise) {
        JTable tableFrise = new JTable();
        tableFrise.setModel(new ModeleTableFrise(frise));
        tableFrise.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableFrise.setRowHeight(100);

        for (int i = 0; i < tableFrise.getColumnCount(); i++) {
            System.out.println(i);
            tableFrise.getColumnModel().getColumn(i).setPreferredWidth(100);
        }

        JScrollPane scrollPane = new JScrollPane(tableFrise,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(650,440));
        add(scrollPane);
    }
}
