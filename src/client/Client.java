package client;

import modele.*;
import vue.FenetreAccueil;

import java.io.File;

public class Client {
    public static void main(String[] args) {

        Chronologie test1 = new Chronologie("GitHub", new Date(1,1,1900), new Date(30,1,1900), 0, "test3.ser", "saves" + File.separator + "github.jpg");
        System.out.print(test1.ajout(new Evenement(new Date(1,1,1900), "test1", 0, "Ceci est un test pour voir si tout foncionne bien. Cela reste à voir...", "saves" + File.separator + "github.jpg")));
        System.out.print(test1.ajout(new Evenement(new Date(1,1,1900), "test2", 1, "Ceci est un test pour voir si tout foncionne bien\nCa reste à voir...", "saves" + File.separator + "github.jpg")));
        System.out.print(test1.ajout(new Evenement(new Date(2,1,1900), "test3", 0, "Ceci est un test pour voir si tout foncionne bien\nCa restjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjje à voir...", "saves" + File.separator + "github.jpg")));
        System.out.print(test1.ajout(new Evenement(new Date(4,1,1900), "test5", 0, "Ceci est un test pour voir si tout foncionne bien\nCa reste à voir...", "saves" + File.separator + "github.jpg")));
        System.out.print(test1.ajout(new Evenement(new Date(30,1,1900), "test6", 0, "Ceci est un test pour voir si tout foncionne bien\nCa reste à voir...", "saves" + File.separator + "github.jpg")));

        SavesChronologie save = new SavesChronologie();
        save.add(test1.getAdresseFichierSauvegarde());
        LectureEcriture.ecriture(new File(test1.getAdresseFichierSauvegarde()),test1);
/*
        SavesChronologie save = new SavesChronologie();
        save.add("test");
        LectureEcriture.ecriture(SavesChronologie.FILE, save);*/

        new FenetreAccueil();
    }
}
