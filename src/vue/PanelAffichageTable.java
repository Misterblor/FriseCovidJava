package vue;

import modele.Chronologie;
import modele.Evenement;
import modele.ModeleTableFrise;
import modele.RendererTableFrise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelAffichageTable extends JPanel {
    public PanelAffichageTable(Chronologie frise, PanelAffichageEvenement affichageEvent) {
        JTable tableFrise = new JTable();

        tableFrise.setDefaultRenderer(Evenement.class, new RendererTableFrise());
        tableFrise.setModel(new ModeleTableFrise(frise));

        tableFrise.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableFrise.getTableHeader().setReorderingAllowed(false);
        tableFrise.setRowHeight(100);

        for (int i = 0; i < tableFrise.getColumnCount(); i++)
            tableFrise.getColumnModel().getColumn(i).setPreferredWidth(100);

        tableFrise.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                JTable table = (JTable) event.getSource();
                ModeleTableFrise model =(ModeleTableFrise) table.getModel();
                Point point = event.getPoint();
                int rowIndex = table.rowAtPoint (point);
                int colIndex = table.columnAtPoint (point);
                affichageEvent.reinitEvent(frise.getIndice((Evenement) model.getValueAt(rowIndex,colIndex)));
            }
        });

        JScrollPane scrollPane = new JScrollPane(tableFrise,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(650,440));
        add(scrollPane);
    }
}
