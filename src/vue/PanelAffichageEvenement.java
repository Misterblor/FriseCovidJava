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
    private Evenement eventEnCours;
    private Chronologie frise;
    private JLabel labelDesc;
    private JLabel labelImage;

    public PanelAffichageEvenement(Chronologie parFrise) {
        setLayout(new FlowLayout());

        frise = parFrise;

        Iterator<Evenement> iterateur = frise.getListeEvt().iterator();

        labelImage = new JLabel();
        labelDesc = new JLabel();
        reinitEvent(iterateur.next());

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
        if(event.getSource()==precedent){
            Iterator<Evenement> iterateurCourant = frise.getListeEvt().iterator();

            for(Iterator<Evenement> iterateurPrevision = frise.getListeEvt().iterator(); iterateurPrevision.hasNext() && iterateurPrevision.next()!=eventEnCours;)
                iterateurCourant=iterateurPrevision;

            reinitEvent((Evenement) iterateurCourant);
        }

        else if(event.getSource()==suivant){
            Iterator<Evenement> iterateur = frise.getListeEvt().iterator();
            while(iterateur.hasNext() && iterateur!=eventEnCours){
                iterateur.next();
            }
            reinitEvent(iterateur.next());
        }
    }

    private void reinitEvent(Evenement event){
        eventEnCours=event;

        labelImage.setIcon(event.getImage());

        String description;
        if(event.getTexteDescriptif().split("\n").length > 1) {
            description = "<html>";
            String[] temp = event.getTexteDescriptif().split("\n");
            for (int indice = 0; indice < temp.length - 1; indice++)
                description += temp[indice] + "<br>";
            description += temp[temp.length - 1] + "</html>";
        }

        else
            description = event.getTexteDescriptif();

        labelDesc.setText(description);

        validate();
        repaint();
    }
}
