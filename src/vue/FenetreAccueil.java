package vue;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;

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
    private JMenuBar menu;

    /**
     * Constructeur de la classe Fenetre Acceuil
     *
     * @author Antoine Limerutti / Pablo Rican
     */
    public FenetreAccueil(){
        super("Frise Creator");

        com.formdev.flatlaf.FlatLightLaf.install();

        JOptionPane optionPane = new JOptionPane("Chargement en cours...", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        JDialog messageChargement = new JDialog();
        messageChargement.setTitle("Chargement");
        messageChargement.setSize(200,200);
        messageChargement.setResizable(false);
        messageChargement.setContentPane(optionPane);
        messageChargement.setLocationRelativeTo(null);
        messageChargement.pack();
        messageChargement.validate();
        messageChargement.repaint();
        messageChargement.setVisible(true);

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
        messageChargement.dispose();
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
