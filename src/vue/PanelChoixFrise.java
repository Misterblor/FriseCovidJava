/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Controleur;
import modele.Chronologie;
import modele.LectureEcriture;
import modele.SavesChronologie;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;


/**
 *
 * @author ifocs
 */
public class PanelChoixFrise extends javax.swing.JPanel {

    /**
     * Creates new form PanelChoixFrise
     */
    public PanelChoixFrise(Controleur controleur) {
        setLayout(new GridLayout(7, 7, 20, 20));

        SavesChronologie listeSave;
        if(SavesChronologie.FILE.exists()) {
            listeSave = (SavesChronologie) LectureEcriture.lecture(SavesChronologie.FILE);
            listeSave.verification();
        }
        else {
            listeSave = new SavesChronologie();
            LectureEcriture.ecriture(SavesChronologie.FILE, listeSave);
        }

        JButton[] tableauFrise = new JButton[listeSave.size() + 1];
        Iterator<String> iterateur = listeSave.iterator();
        int indice;
        File fichier;

        for(indice=0; indice<tableauFrise.length; indice++) {
            tableauFrise[indice] = new JButton();
            tableauFrise[indice].setPreferredSize(new Dimension(80, 80));

            if (iterateur.hasNext()) {
                fichier = new File(iterateur.next());

                Chronologie frise = (Chronologie) LectureEcriture.lecture(fichier);
                if(frise.getImage()!=null)
                    tableauFrise[indice].setIcon(new ImageIcon(new ImageIcon(frise.getImage().toString()).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
                else
                    tableauFrise[indice].setText(frise.getIntitule());

                tableauFrise[indice].setActionCommand("Charger'" + fichier);
            } else {
                tableauFrise[indice].setText("<html>Nouvelle<br>frise</html>");
                tableauFrise[indice].setFont(new Font("Calibri", Font.PLAIN, 10));
                tableauFrise[indice].setActionCommand("Créer");
            }
            add(tableauFrise[indice]);
            tableauFrise[indice].addActionListener(controleur);
        }

        for(;indice<7*7; indice++){
            add((new JLabel()));
        }

    }

}
