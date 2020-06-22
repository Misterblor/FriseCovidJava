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
 * @author Antoine Limerutti
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
     * @author Antoine Limerutti
     */
    public PanelAffichageTable(Chronologie frise, PanelAffichageEvenement affichageEvent) {
        tableFrise = new JTable();
        modele = new ModeleTableFrise(frise);

        tableFrise.setModel(modele);
        tableFrise.setDefaultRenderer(Evenement.class, new RendererTableFrise());

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
     * @param dateDebut Date du debut de la frise.
     * @param dateEvent Date de la colonne souhaitée.
     * @param periode Entier correspondant à la periode de la frise.
     * @param poids Entier correspondant au poids de l'évènement (et donc à la ligne dans la table).
     *
     * @author Antoine Limerutti
     */
    public void setCol(Date dateDebut, Date dateEvent, int periode, int poids){
        double col = modele.nbCol(dateDebut, dateEvent, periode)-1;
        double row = poids;

        Rectangle rect = new Rectangle();
        rect.setRect(col*100.0, row*100.0, 100.0, 100.0);
        
        tableFrise.scrollRectToVisible(rect);
    }
}
