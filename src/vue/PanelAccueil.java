package vue;

import javax.swing.*;

import java.awt.*;

public class PanelAccueil extends JPanel {
    private JButton charger;
    private JButton creer;

    public PanelAccueil(Fenetre fenetreMere) {
        setLayout(new BorderLayout(30,30));

        charger= new JButton("Charger une frise existante");
        creer= new JButton("Créer une nouvelle frise");

        JLabel titre = new JLabel("Frise Creator", JLabel.CENTER);
        titre.setFont(new Font("Verdana", Font.BOLD, 20));

        add(charger, BorderLayout.WEST);
        add(creer, BorderLayout.EAST);
        add(titre, BorderLayout.NORTH);
    }
}
