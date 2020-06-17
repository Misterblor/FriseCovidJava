package vue;

import modele.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelAffichageTable extends JPanel {
    JTable tableFrise;
    ModeleTableFrise modele;

    public PanelAffichageTable(Chronologie frise, PanelAffichageEvenement affichageEvent) {
        tableFrise = new JTable();
        modele = new ModeleTableFrise(frise);

        tableFrise.setDefaultRenderer(Evenement.class, new RendererTableFrise());
        tableFrise.setModel(modele);

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

    public void setRow(Date dateDebut, Date dateEvent, int periode){
        tableFrise.scrollRectToVisible(tableFrise.getCellRect(1, modele.nbCol(dateDebut, dateEvent, periode)-1,false));
    }
}
