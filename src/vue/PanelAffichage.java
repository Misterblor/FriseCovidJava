package vue;

import controleur.Controleur;
import modele.Chronologie;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.math.RoundingMode;

public class PanelAffichage extends JPanel {
    JButton boutonSupr;
    Chronologie frise;

    public PanelAffichage(){
        setLayout(new BorderLayout());

        JLabel label = new JLabel("<html>Aucune frise sélectionnée !<br>Pour sélectionner une frise, rendez-vous dans l'onglet \"Choix Frise\" afin d'en choisir ou d'en créer une !",JLabel.CENTER);
        label.setFont(new Font("Open Sans", Font.PLAIN, 12));
        add(label, BorderLayout.CENTER);
    }

    public PanelAffichage(Chronologie parFrise) {
        setLayout(new GridBagLayout());
        GridBagConstraints contrainte = new GridBagConstraints();

        frise=parFrise;

        contrainte.gridx=0;
        contrainte.gridy=0;
        JLabel combler = new JLabel();
        combler.setPreferredSize(new Dimension(90,20));
        add(combler, contrainte);

        JLabel labelIntitule = new JLabel(frise.getIntitule(), JLabel.CENTER);
        labelIntitule.setFont(new Font("Calibri", Font.BOLD, 20));
        contrainte.gridx=1;
        contrainte.anchor=GridBagConstraints.CENTER;
        add(labelIntitule, contrainte);

        boutonSupr = new JButton("Supprimer");
        boutonSupr.setPreferredSize(new Dimension(90,20));
        boutonSupr.setFont(new Font("Calibri", Font.PLAIN, 12));
        boutonSupr.setForeground(Color.RED);
        contrainte.gridx=2;
        add(boutonSupr, contrainte);

        contrainte.insets=new Insets(0,0,10,0);
        contrainte.gridx=1;
        contrainte.gridy=1;
        contrainte.gridheight=10;
        contrainte.anchor=GridBagConstraints.CENTER;
        PanelAffichageEvenement affichageEvent = new PanelAffichageEvenement(frise);
        add(affichageEvent, contrainte);

        JButton precedent = new JButton("<");
        JButton suivant = new JButton(">");

        precedent.addActionListener(affichageEvent);
        suivant.addActionListener(affichageEvent);

        precedent.setPreferredSize(new Dimension(20,135));
        suivant.setPreferredSize(new Dimension(20,135));

        precedent.setActionCommand("precedent");
        suivant.setActionCommand("suivant");

        precedent.setBackground(getBackground());
        suivant.setBackground(getBackground());

        contrainte.gridx=0;
        contrainte.anchor=GridBagConstraints.LINE_START;
        contrainte.insets=new Insets(0,20,10,0);
        add(precedent, contrainte);

        contrainte.gridx=2;
        contrainte.anchor=GridBagConstraints.LINE_END;
        contrainte.insets=new Insets(0,0,10,20);
        add(suivant, contrainte);

        contrainte.gridwidth=3;
        contrainte.gridheight=20;
        contrainte.gridx=0;
        contrainte.gridy=11;
        contrainte.anchor=GridBagConstraints.CENTER;
        contrainte.insets=new Insets(0,0,0,0);
        PanelAffichageTable affichageTable = new PanelAffichageTable(frise, affichageEvent);
        add(affichageTable, contrainte);

        affichageEvent.setAffichageTable(affichageTable);
    }

    public void enregistreEcouteur(Controleur controleur){
        boutonSupr.setActionCommand("suprimmerFrise>"+frise.getAdresseFichierSauvegarde());
        boutonSupr.addActionListener(controleur);
    }
}
