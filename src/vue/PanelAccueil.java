package vue;

import controleur.Controleur;

import javax.swing.*;

import java.awt.*;

public class PanelAccueil extends JPanel {
    private JButton charger;
    private JButton creer;

    public PanelAccueil(FenetreAccueil fenetreMere) {
        setLayout(new GridBagLayout());

        charger= new JButton("Charger une frise existante");
        creer= new JButton("Créer une nouvelle frise");

        JLabel titre = new JLabel("Frise Creator", JLabel.CENTER);
        titre.setFont(new Font("Verdana", Font.BOLD, 20));

        GridBagConstraints contrainte = new GridBagConstraints();

        contrainte.anchor=GridBagConstraints.CENTER;
        contrainte.insets=new Insets(10,10,10,10);
        contrainte.fill=GridBagConstraints.BOTH;

        contrainte.gridx=0;
        contrainte.gridy=0;
        add(titre, contrainte);

        contrainte.gridy=1;
        add(charger, contrainte);

        contrainte.gridy=2;
        add(creer, contrainte);

        Controleur controleur = new Controleur();

        charger.setActionCommand("Charger");
        creer.setActionCommand("Créer");

        charger.addActionListener(controleur);
        creer.addActionListener(controleur);
    }
}
