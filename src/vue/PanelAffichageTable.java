package vue;

import modele.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <b>Panel s'occupant de l'affichage de la table.<br>
 * Panel fils de PanelAffichage.<br>
 * Appartiens au package vue.</b>
 *
 * @see JPanel
 *
 * @Author Antoine Limerutti
 *
 * @version 1.0
 */
public class PanelAffichageTable extends JPanel {
    /**
     * JTable contenant la Chronologie.
     *
     * @see JTable
     */
    JTable tableFrise;

    /**
     * Modele de la table tableFrise.
     *
     * @see ModeleTableFrise
     */
    ModeleTableFrise modele;

    /**
     * Constructeur de la classe PanelAffichageTable.
     *
     * @param frise Chronologie dont on souhaite afficher le contenu.
     * @param affichageEvent PanelAffichageEvenement synchronisé avec le PanelAffichageTable.
     *
     * @see Chronologie
     * @see PanelAffichageEvenement
     *
     * @Author Antoine Limerutti
     */
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
                if(model.getValueAt(rowIndex,colIndex)!=null)
                    affichageEvent.reinitEvent(frise.getIndice((Evenement) model.getValueAt(rowIndex,colIndex)));
            }
        });

        JScrollPane scrollPane = new JScrollPane(tableFrise,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(650,440));
        add(scrollPane);
    }

    /**
     * Permet de faire scroller la table à l'évènement en cours de visionnage dans le panel PanelAffichageEvenement.
     *
     * @Author Antoine Limerutti
     */
    public void setCol(){
        tableFrise.scrollRectToVisible(tableFrise.getCellRect(1, modele.getNbCol(),false));
    }
}
