package vue;

import modele.Chronologie;
import modele.Evenement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class PanelAffichageEvenement extends JPanel implements ActionListener {
    private int indiceEventUtil;
    private Chronologie frise;
    private JLabel labelDesc;
    private JLabel labelImage;

    public PanelAffichageEvenement(Chronologie parFrise) {
        setLayout(new GridBagLayout());

        frise = parFrise;
        Iterator<Evenement> iterateur = frise.getListeEvt().iterator();

        labelImage = new JLabel();
        labelDesc = new JLabel();
        reinitEvent(0);

        JButton precedent = new JButton("<");
        JButton suivant = new JButton(">");

        precedent.addActionListener(this);
        suivant.addActionListener(this);

        precedent.setPreferredSize(new Dimension(20,115));
        suivant.setPreferredSize(new Dimension(20,115));

        precedent.setActionCommand("precedent");
        suivant.setActionCommand("suivant");

        GridBagConstraints contrainte = new GridBagConstraints();
        contrainte.insets = new Insets(6,6,6,6);

        contrainte.gridx=0;
        contrainte.anchor=GridBagConstraints.WEST;
        add(precedent, contrainte);

        contrainte.anchor=GridBagConstraints.CENTER;
        contrainte.gridx=1;
        add(labelImage, contrainte);

        contrainte.anchor=GridBagConstraints.CENTER;
        contrainte.gridx=2;
        add(labelDesc, contrainte);

        contrainte.gridx=3;
        contrainte.anchor=GridBagConstraints.FIRST_LINE_END;
        add(suivant, contrainte);
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
    }

    public void reinitEvent(int indice){
        System.out.println(indice);
        if(indice != -1) {
            indiceEventUtil = indice;
            Evenement event = frise.get(indice);

            labelImage.setIcon(new ImageIcon(event.getImage().getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));

            String description;
            description = "<html>" + event.getDate().toString() + "<br><br>";
            if (event.getTexteDescriptif().split("\n").length > 1) {
                String[] temp = event.getTexteDescriptif().split("\n");
                for (int i = 0; i < temp.length - 1; i++)
                    description += temp[i] + "<br>";
                description += temp[temp.length - 1] + "</html>";
            } else
                description = event.getTexteDescriptif();

            labelDesc.setText(description);

            validate();
            repaint();
        }
    }
}
