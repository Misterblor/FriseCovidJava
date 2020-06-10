package vue;

import controleur.Controleur;

import javax.swing.JFrame;
import java.awt.Color;

public class FenetreAccueil extends JFrame {

    public FenetreAccueil(){
        super("Frise Creator");

        com.formdev.flatlaf.FlatLightLaf.install();

        Controleur controleur = new Controleur(this);

        PanelChoixFrise panelFils = new PanelChoixFrise(controleur);
        panelFils.setBackground (Color.WHITE);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(700,700);
        setVisible(true);
        setLocation(100,100);
        setBackground (Color.WHITE);

        setContentPane(panelFils);
    }
}
