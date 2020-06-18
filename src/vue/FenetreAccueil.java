package vue;

import controleur.Controleur;

import javax.swing.*;
import java.awt.Color;

public class FenetreAccueil extends JFrame {

    public FenetreAccueil(){
        super("Frise Creator");

        com.formdev.flatlaf.FlatLightLaf.install();

        PanelFrise panelFils = new PanelFrise(this);
        panelFils.setBackground(Color.WHITE);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(700,700);
        setVisible(true);
        setLocation(100,100);
        setBackground (Color.WHITE);

        JMenuItem[] itemsMenu = new JMenuItem[]{new JMenuItem("Choix Frise", 'C'), new JMenuItem("Affichage Frise", 'A'), new JMenuItem("Création", 'R') , new JMenuItem("Fermer",'F'), new JMenuItem("?",'I')};
        JMenuBar menu = new JMenuBar();

        for(int i=0; i<itemsMenu.length; i++) {
            itemsMenu[i].setAccelerator(KeyStroke.getKeyStroke(itemsMenu[i].getMnemonic(),java.awt.Event.CTRL_MASK));
            itemsMenu[i].addActionListener(panelFils);
            itemsMenu[i].setActionCommand(itemsMenu[i].getText());
            menu.add(itemsMenu[i]);
        }

        setJMenuBar(menu);
        setContentPane(panelFils);

        validate();
        repaint();
    }
}
