package vue;

import modele.Chronologie;
import modele.Evenement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.StringTokenizer;

public class PanelAffichageEvenement extends JPanel implements ActionListener {
    private int indiceEventUtil;
    private Chronologie frise;
    private JLabel labelDesc;
    private JLabel labelImage;
    private PanelAffichageTable affichageTable;

    public PanelAffichageEvenement(Chronologie parFrise) {
        setLayout(new GridBagLayout());

        frise = parFrise;

        Iterator<Evenement> iterateur = frise.getListeEvt().iterator();

        labelImage = new JLabel();
        labelDesc = new JLabel();
        reinitEvent(0);

        GridBagConstraints contrainte = new GridBagConstraints();
        contrainte.insets = new Insets(6,6,6,6);

        contrainte.anchor=GridBagConstraints.CENTER;
        contrainte.gridx=1;
        add(labelImage, contrainte);

        contrainte.anchor=GridBagConstraints.CENTER;
        contrainte.gridx=2;
        add(labelDesc, contrainte);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand()=="precedent") {
            if (indiceEventUtil == 0) {
                reinitEvent(frise.getNbEvent()-1);
            } else {
                reinitEvent(indiceEventUtil - 1);
            }
        } else if(event.getActionCommand()=="suivant")
            reinitEvent((indiceEventUtil+1)%frise.getNbEvent());
        affichageTable.setRow(frise.getDateDebut(), frise.get(indiceEventUtil).getDate(), frise.getPeriode());
    }

    public void reinitEvent(int indice){
        if(indice != -1) {
            indiceEventUtil = indice;
            Evenement event = frise.get(indice);

            labelImage.setIcon(new ImageIcon(event.getImage().getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));

            String description = "<html><h2>" + event.getTitre() + "</h2><h4>" + event.getDate().toString() + "</h4>";

            StringTokenizer stSpace = new StringTokenizer(event.getTexteDescriptif(), " ");
            StringTokenizer stRetourChariot;
            String token;

            for(int i=0; stSpace.hasMoreTokens(); i++){
                token = stSpace.nextToken();

                if(i%11==0 && i!=0)
                    description+=token + "<br>";
                else if(token.contains("\n")){
                    stRetourChariot = new StringTokenizer(token, "\n");
                    description+=stRetourChariot.nextToken() + "<br>" + stRetourChariot.nextToken() + " ";
                    i=0;
                }
                else
                    description+=token + " ";
            }

            description += "</html>";

            labelDesc.setText(description);

            validate();
            repaint();
        }
    }


    public void setAffichageTable(PanelAffichageTable affichageTable) {
        this.affichageTable = affichageTable;
    }
}
