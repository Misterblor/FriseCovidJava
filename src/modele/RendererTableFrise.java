package modele;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * <b>Classe qui vas d�finir les donn�es � mettre dans la JTable de la classe PanelAffichage.<br>
 * Appartient au package modele.</b>
 *
 * @author Antoine Limerutti
 *
 * @see javax.swing.table.TableCellRenderer
 * @see javax.swing.JTable
 * @see vue.PanelAffichageTable
 * @see JLabel
 *
 * @version 1.0
 */
public class RendererTableFrise extends JLabel implements TableCellRenderer {
    /**
     * Contruit un objet RendererTableFrise en appellant le contructeur parent et d�finit ses principales caract�ristiques.
     *
     * @author Antoine Limerutti
     */
    public RendererTableFrise(){
        super("",JLabel.CENTER);
        setOpaque(true);
    }

    /**
     * D�finit la valeur � mettre dans la cellule einsi que certaines de ses caract�ristiques (ToolTipText).
     *
     * @param table JTable � traiter.
     * @param cellValue Objet � mettre dans la cellule.
     * @param isSelected booleen indiquant si la cellule est selectionn�e.
     * @param hasFocus booleen indiquant si la cellule a le focus.
     * @param row Entier indiquant la ligne de la cellule.
     * @param column Entier indiquant la colone de la cellule.
     *
     * @see javax.swing.JTable
     *
     * @author Antoine Limerutti
     */
    public Component getTableCellRendererComponent(JTable table, Object cellValue, boolean isSelected, boolean hasFocus, int row, int column) {
        if (cellValue!=null) {
            Evenement event = (Evenement) cellValue;
            setIcon(resizeImage(event.getImage()));
            setText(null);
            setToolTipText(null);
            setBackground(Color.WHITE);
            return this;
        }

        else{
            return null;
        }

    }

    /**
     * Retaille l'objet ImageIcon fournis en param�tre et la retourne.
     *
     * @param icon ImageIcon � retailler.
     *
     * @return ImageIcon ayant une taille correcte.
     *
     * @author Pablo Rican
     *
     * @see ImageIcon
     */
    private ImageIcon resizeImage(ImageIcon icon){
        int largeurOrigine = icon.getIconWidth();
        int hauteurOrigine = icon.getIconHeight();
        float ratio;
        if ((float)100 / largeurOrigine < (float)100 / hauteurOrigine){
            ratio = (float) 100 / largeurOrigine;
        } else {
            ratio = (float) 100 / hauteurOrigine;
        }
        return new ImageIcon(icon.getImage().getScaledInstance((int)(largeurOrigine * ratio),(int)(hauteurOrigine * ratio), Image.SCALE_REPLICATE));
    }
}
