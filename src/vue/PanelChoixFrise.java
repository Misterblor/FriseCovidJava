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

    JButton[] tableauFrise;

    /**
     * Creates new form PanelChoixFrise
     */
    public PanelChoixFrise() {
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

        for (int i = 0; i < listeSave.size(); i++) {
            System.out.println(listeSave.get(i));
        }

        tableauFrise = new JButton[listeSave.size() + 1];
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
                    tableauFrise[indice].setIcon(resizeImage(frise.getImage()));
                else
                    tableauFrise[indice].setText(frise.getIntitule());

                tableauFrise[indice].setActionCommand("Charger>" + fichier);
            } else {
                tableauFrise[indice].setText("<html>Nouvelle<br>frise</html>");
                tableauFrise[indice].setFont(new Font("Calibri", Font.PLAIN, 10));
                tableauFrise[indice].setActionCommand("Créer");
            }
            add(tableauFrise[indice]);
        }

        for(;indice<7*7; indice++){
            add((new JLabel()));
        }

    }

    public void enregistreEcouteur(Controleur controleur){
        for (int i = 0; i < tableauFrise.length; i++) {
            tableauFrise[i].addActionListener(controleur);
        }
    }

    private ImageIcon resizeImage(ImageIcon icon){
        int largeurOrigine = icon.getIconWidth();
        int hauteurOrigine = icon.getIconHeight();
        float ratio;
        if (largeurOrigine - 80 > hauteurOrigine - 80){
            ratio = (float) 80 / largeurOrigine;
        } else {
            ratio = (float) 80 / hauteurOrigine;
        }
        return new ImageIcon(icon.getImage().getScaledInstance((int)(largeurOrigine * ratio),(int)(hauteurOrigine * ratio), Image.SCALE_REPLICATE));
    }
}
