package controleur;

import modele.Chronologie;
import modele.LectureEcriture;
import vue.FenetreAccueil;
import vue.PanelAffichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Controleur implements ActionListener {
    FenetreAccueil fenetreMere;

    public Controleur(FenetreAccueil fenetre){
    fenetreMere = fenetre;
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println((event.getActionCommand().split("'"))[0] + "\nCharger");

        if(event.getActionCommand().compareTo("Créer")==0){

        }

        else if((event.getActionCommand().split("'"))[0].compareTo("Charger")==0){
            System.out.println("Chargement de " + (event.getActionCommand().split("'"))[1]);
            fenetreMere.setContentPane(new PanelAffichage((Chronologie) LectureEcriture.lecture(new File(event.getActionCommand().split("'")[1]))));
            fenetreMere.validate();
            fenetreMere.repaint();
        }
    }
}
