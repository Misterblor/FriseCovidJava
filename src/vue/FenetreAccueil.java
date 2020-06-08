package vue;

import javax.swing.JFrame;
import java.awt.Color;

public class FenetreAccueil extends JFrame {

    public FenetreAccueil(){
        super("Frise Creator");
        PanelAccueil panelFils = new PanelAccueil(this);
        panelFils.setBackground (Color.WHITE);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(300,200);
        setVisible(true);
        setLocation(100,100);
        setBackground (Color.WHITE);

        setContentPane(panelFils);
    }
}
