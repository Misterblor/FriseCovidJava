package vue;

import javax.swing.JFrame;
import java.awt.Color;

public class Fenetre extends JFrame {

    public Fenetre(){
        super("Frise Creator");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(770,700);
        setVisible(true);
        setLocation(100,100);
        setBackground (Color.WHITE);
    }
}
