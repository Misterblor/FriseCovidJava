package vue;

import controleur.Controleur;
import modele.Chronologie;

import javax.swing.*;
import java.awt.*;

/**
 * <b>Panel s'occupant de l'affichage des Evenements et de la table.<br>
 * Appartiens au package vue.</b>
 *
 * @see JPanel
 *
 * @author Antoine Limerutti
 *
 * @version 1.0
 */
public class PanelAffichage extends JPanel {
    /**
     * JButton qui vas permettre de supprimer la Chronologie en cours de visionnage.
     *
     * @see JButton
     */
    JButton boutonSupr;

    /**
     * Chronologie que l'on souhaite visionner.
     *
     * @see Chronologie
     */
    Chronologie frise;

    /**
     * Constructeur du PanelAffichage lorsqu'aucune Chronologie n'est sélectionnée pour visionnage.
     *
     * @author Antoine Limerutti
     */
    public PanelAffichage(){
        setLayout(new BorderLayout());

        JLabel label = new JLabel("<html>Aucune frise sélectionnée !<br>Pour sélectionner une frise, rendez-vous dans l'onglet \"Choix Frise\" afin d'en choisir ou d'en créer une !",JLabel.CENTER);
        label.setFont(new Font("Open Sans", Font.PLAIN, 12));
        add(label, BorderLayout.CENTER);
    }

    /**
     * Constructeur de la classe PanelAffichage lorsqu'une frise est sélectionnée.
     *
     * @param parFrise Chronologie que l'on souhaite visionner.
     *
     * @see Chronologie
     *
     * @author Antoine Limerutti
     */
    public PanelAffichage(Chronologie parFrise) {
        setLayout(new GridBagLayout());
        GridBagConstraints contrainte = new GridBagConstraints();

        frise=parFrise;

        contrainte.gridx=0;
        contrainte.gridy=0;
        JLabel combler = new JLabel();
        combler.setPreferredSize(new Dimension(20,20));
        add(combler, contrainte);

        JLabel labelIntitule = new JLabel(frise.getIntitule(), JLabel.CENTER);
        labelIntitule.setFont(new Font("Calibri", Font.BOLD, 20));
        contrainte.gridx=1;
        contrainte.anchor=GridBagConstraints.CENTER;
        add(labelIntitule, contrainte);

        boutonSupr = new JButton("-");
        boutonSupr.setPreferredSize(new Dimension(20,20));
        boutonSupr.setFont(new Font("Calibri", Font.BOLD, 12));
        boutonSupr.setForeground(Color.RED);
        contrainte.gridx=2;
        contrainte.insets = new Insets(0,0,0,12);
        contrainte.anchor=GridBagConstraints.LINE_END;
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
        contrainte.anchor=GridBagConstraints.WEST;
        contrainte.insets=new Insets(0,20,10,0);
        add(precedent, contrainte);

        contrainte.gridx=2;
        contrainte.anchor=GridBagConstraints.EAST;
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

        if(frise.get(0)!=null) {
            affichageTable.setCol(frise.getDateDebut(), frise.get(0).getDate(), frise.getPeriode(), frise.get(0).getPoids());
        }
    }

    /**
     * Met le controleur passé en paramètre à l'écoute de champ boutonSupr.
     *
     * @param controleur Controleur qui vas être mis à l'écoute du champ boutonSupr.
     *
     * @see Controleur
     *
     * @author Antoine Limerutti
     */
    public void enregistreEcouteur(Controleur controleur){
        boutonSupr.setActionCommand("suprimmerFrise>"+frise.getAdresseFichierSauvegarde());
        boutonSupr.addActionListener(controleur);
    }
}
