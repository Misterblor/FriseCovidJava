package modele;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class RendererTableFrise extends JLabel implements TableCellRenderer {

    public RendererTableFrise(){
        super("",JLabel.CENTER);
        setOpaque(true);
    }

    @Override
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
