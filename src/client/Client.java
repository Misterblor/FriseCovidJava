package client;

import modele.Chronologie;
import modele.Date;
import modele.Evenement;
import modele.LectureEcriture;
import vue.FenetreAccueil;

import java.io.File;

public class Client {
    public static void main(String[] args) {

        Chronologie test1 = new Chronologie("GitHub", new Date(1,1,1900), new Date(5,1,1900), 0, "saves" + File.separator + "test1.ser", "saves" + File.separator + "github.jpg");
        System.out.print(test1.ajout(new Evenement(new Date(1,1,1900), "test1", 0, "Ceci est un test pour voir si tout foncionne bien\nCa reste à voir...", "saves" + File.separator + "github.jpg")));
        System.out.print(test1.ajout(new Evenement(new Date(1,1,1900), "test2", 1, "Ceci est un test pour voir si tout foncionne bien\nCa reste à voir...", "saves" + File.separator + "github.jpg")));
        System.out.print(test1.ajout(new Evenement(new Date(2,1,1900), "test3", 0, "Ceci est un test pour voir si tout foncionne bien\nCa restjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjje à voir...", "saves" + File.separator + "github.jpg")));
        System.out.print(test1.ajout(new Evenement(new Date(4,1,1900), "test5", 0, "Ceci est un test pour voir si tout foncionne bien\nCa reste à voir...", "saves" + File.separator + "github.jpg")));
        System.out.print(test1.ajout(new Evenement(new Date(5,1,1900), "test6", 0, "Ceci est un test pour voir si tout foncionne bien\nCa reste à voir...", "saves" + File.separator + "github.jpg")));
        LectureEcriture.ecriture(new File(test1.getAdresseFichierSauvegarde()),test1);

        /*
        Date date1 = new Date(1,6,2000);
        Date date2 = new Date(3,6,2000);
        System.out.println(date1.nbJourEntre(date2));
        */
        new FenetreAccueil();
    }
}
