package vue;

import javax.swing.JFrame;
import java.awt.Color;

public class Fenetre extends JFrame {

    public Fenetre(){
        super("Frise Creator");
        PanelAccueil panelFils = new PanelAccueil(this);
        panelFils.setBackground (Color.WHITE);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(500,200);
        setVisible(true);
        setLocation(100,100);
        setBackground (Color.WHITE);

        setContentPane(panelFils);
    }

    public void sortieAccueil(boolean charger){
        if(charger){}

        else{}
    }
}
