package modele;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class RendererTableFrise extends JLabel implements TableCellRenderer {

    public RendererTableFrise(){
        super();
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object cellValue, boolean isSelected, boolean hasFocus, int row, int column) {
        if (cellValue!=null) {
            Evenement event = (Evenement) cellValue;
            setIcon(new ImageIcon(new ImageIcon(event.getImage().toString()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
            setText(null);
            setToolTipText(null);
            return this;
        }

        else{
            return null;
        }

    }
}
