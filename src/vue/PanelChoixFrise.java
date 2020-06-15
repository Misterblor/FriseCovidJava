/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Controleur;
import modele.Chronologie;
import modele.LectureEcriture;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
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
        File all_files[] = (new File("saves")).listFiles();
        ArrayList<File> files = new ArrayList<File>();

        for(int indice=0; indice<all_files.length; indice++){
            String[] extension = all_files[indice].toString().split("\\.");
            if(extension[extension.length-1].compareTo("ser")==0)
                files.add(all_files[indice]);
        }

        setLayout(new GridLayout(7, 7, 20, 20));

        JButton[] tableauFrise = new JButton[files.size() + 1];
        int indice;

        for(indice=0; indice<tableauFrise.length; indice++) {
            tableauFrise[indice] = new JButton();
            tableauFrise[indice].setPreferredSize(new Dimension(80, 80));

            if (tableauFrise.length-1 != indice) {
                tableauFrise[indice].setText("");
                Chronologie frise = (Chronologie) LectureEcriture.lecture(files.get(indice));
                tableauFrise[indice].setIcon(new ImageIcon(new ImageIcon(frise.getImage().toString()).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
                tableauFrise[indice].setActionCommand("Charger'" + files.get(indice));
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
