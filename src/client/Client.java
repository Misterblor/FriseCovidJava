package client;

import modele.Chronologie;
import modele.Date;
import modele.Evenement;
import modele.LectureEcriture;
import vue.FenetreAccueil;

import java.io.File;

public class Client {
    public static void main(String[] args) {

        Chronologie test1 = new Chronologie("GitHub", new Date(10,6,2020), new Date(15,6,2020), 0, "saves" + File.separator + "test.ser", "saves" + File.separator + "github.jpg");
        System.out.print(test1.ajout(new Evenement(new Date(10,6,2020), "test1", 0, "Ceci est un test pour voir si tout foncionne bien\nCa reste à voir...", "saves" + File.separator + "github.jpg")));
        System.out.print(test1.ajout(new Evenement(new Date(11,6,2020), "test2", 0, "Ceci est un test pour voir si tout foncionne bien\nCa reste à voir...", "saves" + File.separator + "github.jpg")));
        System.out.print(test1.ajout(new Evenement(new Date(12,6,2020), "test3", 0, "Ceci est un test pour voir si tout foncionne bien\nCa reste à voir...", "saves" + File.separator + "github.jpg")));
        System.out.print(test1.ajout(new Evenement(new Date(13,6,2020), "test4", 0, "Ceci est un test pour voir si tout foncionne bien\nCa reste à voir...", "saves" + File.separator + "github.jpg")));
        System.out.print(test1.ajout(new Evenement(new Date(14,6,2020), "test5", 0, "Ceci est un test pour voir si tout foncionne bien\nCa reste à voir...", "saves" + File.separator + "github.jpg")));
        System.out.print(test1.ajout(new Evenement(new Date(15,6,2020), "test6", 0, "Ceci est un test pour voir si tout foncionne bien\nCa reste à voir...", "saves" + File.separator + "github.jpg")));
        LectureEcriture.ecriture(new File(test1.getAdresseFichierSauvegarde()),test1);

        new FenetreAccueil();
    }
}
