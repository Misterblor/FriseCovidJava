package vue;

import modele.Chronologie;
import modele.Evenement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class PanelAffichageEvenement extends JPanel implements ActionListener {
    private JButton precedent;
    private JButton suivant;
    private int indiceEventUtil;
    private Chronologie frise;
    private JLabel labelDesc;
    private JLabel labelImage;

    public PanelAffichageEvenement(Chronologie parFrise) {
        setLayout(new FlowLayout());

        frise = parFrise;
        System.out.print(frise.getListeEvt());
        Iterator<Evenement> iterateur = frise.getListeEvt().iterator();

        labelImage = new JLabel();
        labelDesc = new JLabel();
        reinitEvent(0);

        precedent = new JButton("<");
        suivant = new JButton(">");

        precedent.addActionListener(this);
        suivant.addActionListener(this);

        add(precedent);
        add(labelImage);
        add(labelDesc);
        add(suivant);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.print(indiceEventUtil);
        if(event.getSource()==precedent) {
            if (indiceEventUtil == 0) {
                reinitEvent(frise.getNbEvent()-1);
            } else {
                reinitEvent(indiceEventUtil - 1);
            }
        } else if(event.getSource()==suivant)
            reinitEvent((indiceEventUtil+1)%frise.getNbEvent());
        System.out.println("--->" + indiceEventUtil);
    }

    private void reinitEvent(int indice){
        indiceEventUtil=indice;
        Evenement event = frise.get(indice);

        labelImage.setIcon(event.getImage());

        String description;
        description = "<html>" + event.getDate().toString() + "<br><br>";
        if(event.getTexteDescriptif().split("\n").length > 1) {
            String[] temp = event.getTexteDescriptif().split("\n");
            for (int i = 0; i < temp.length - 1; i++)
                description += temp[i] + "<br>";
            description += temp[temp.length - 1] + "</html>";
        }

        else
            description = event.getTexteDescriptif();

        labelDesc.setText(description);

        validate();
        repaint();
    }
}
