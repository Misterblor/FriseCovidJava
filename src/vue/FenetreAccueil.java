package vue;

import controleur.Controleur;

import javax.swing.*;
import java.awt.Color;

/**
 * <b>Fenetre qui vas contenir les différents panels.<br>
 * Appartiens au package vue.</b>
 *
 * @author Antoine Limerutti / Pablo Rican
 *
 * @see JFrame
 */
public class FenetreAccueil extends JFrame {
    /**
     * Barre de menu de la fenetre.
     *
     * @see JMenuBar
     */
    JMenuBar menu;

    /**
     * Constructeur de la classe Fenetre Acceuil
     *
     * @author Antoine Limerutti / Pablo Rican
     */
    public FenetreAccueil(){
        super("Frise Creator");

        com.formdev.flatlaf.FlatLightLaf.install();

        JMenuItem[] itemsMenu = new JMenuItem[]{new JMenuItem("Choix Frise", 'C'), new JMenuItem("Affichage Frise", 'A'), new JMenuItem("Création Evenement", 'R') , new JMenuItem("Fermer",'F'), new JMenuItem("?",'I')};
        menu = new JMenuBar();

        for(int i=0; i<itemsMenu.length; i++) {
            itemsMenu[i].setAccelerator(KeyStroke.getKeyStroke(itemsMenu[i].getMnemonic(),java.awt.Event.CTRL_MASK));
            itemsMenu[i].setActionCommand(itemsMenu[i].getText());
            menu.add(itemsMenu[i]);
        }

        PanelFrise panelFils = new PanelFrise(this);
        panelFils.setBackground(Color.WHITE);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(800,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setBackground (Color.WHITE);

        for(int i=0; i<itemsMenu.length; i++)
            itemsMenu[i].addActionListener(panelFils);

        setContentPane(panelFils);
        setJMenuBar(menu);

        validate();
        repaint();
    }

    /**
     * Accesseur du champ menu.
     *
     * @return JMenuBat correspondant au champ menu.
     *
     * @author Antoine Limerutti
     *
     * @see JMenuBar
     */
    public JMenuBar getMenuItem() {
        return menu;
    }
}
