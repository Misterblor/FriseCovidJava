package modele;

import utils.LectureEcriture;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * <b>Abstraction d'un répertoire ayant une liste de chemin de sauvegarde ainsi que le lieu de sauvegarde de ce répartoire.<br>
 * Appartient au package modele.<br>
 * Cette classe est serialisable.</b>
 *
 * @author Antoine Limerutti
 *
 * @see Serializable
 *
 * @version 1.0
 */
public class SavesChronologie implements Serializable {
    /**
     * ArrayList contenant les chemins de sauvegardes utiles.
     *
     * @see ArrayList
     */
    private ArrayList<String> listeSave;

    /**
     * File construit avec le chemin de sauvegarde du répertoire.<br>
     *     Champ Statique.
     * @see File
     */
    public static final File FILE = new File("saves" + File.separator + "listeSaves");

    /**
     * Constructeur de la classe SaveChronologie.
     *
     * @author Antoine Limerutti
     */
    public SavesChronologie(){
        listeSave = new ArrayList<String>();
    }

    /**
     * Ajoute au champ listeSave le chemin de sauvegarde fournis en paramètre.
     *
     * @param save String du chemin de sauvegarde à ajouter dans la liste des sauvegardes.
     *
     * @author Antoine Limerutti
     */
    public void add(String save){
        if(!listeSave.contains(save)) {
            listeSave.add(save);
            LectureEcriture.ecriture(SavesChronologie.FILE,this);
        }
    }

    /**
     * Retire du champ listeSave le chemin de sauvegarde fournis en paramètre.
     *
     * @param save String du chemin de sauvegarde à retirer de la liste des sauvegardes.
     *
     * @author Antoine Limerutti
     */
    public void remove(String save){
        Iterator<String> iterator = listeSave.iterator();
        int indice;

        for(indice=0; iterator.hasNext() && !iterator.next().equals(save); indice++) { }

        new File(listeSave.get(indice)).delete();
        listeSave.remove(indice);
        LectureEcriture.ecriture(SavesChronologie.FILE, this);
    }

    /**
     * Retourne la sauvegarde contenue à l'indice i dans l'ArrayList listesave.
     *
     * @param i Entier qui correspond à l'indice.
     *
     * @return String du chemin de sauvegarde à l'indice i.
     *
     * @author Antoine Limerutti
     */
    public String get(int i){
        return listeSave.get(i);
    }

    /**
     * Retourne la taille du champ listeSave.
     *
     * @return Entier correspondant à la taille du champ listeSave.
     *
     * @author Antoine Limerutti
     */
    public int size() {
        return listeSave.size();
    }

    /**
     * Retourne l'itérateur du champ listeSave.
     *
     * @return Iterator du champ listeSave.
     *
     * @author Antoine Limerutti
     *
     * @see Iterator
     */
    public Iterator<String> iterator() {
        return listeSave.iterator();
    }

    /**
     * Percours les chemins de sauvegarde et recherche les chemins qui ne pointent plus vers un fichier de sauvegarde afin de les retirer de la liste.
     *
     * @author Antoine Limerutti
     */
    public void verification(){
        ArrayList<String> supr = new ArrayList<>();

        Iterator<String> iterateur = listeSave.iterator();
        File save;
        while(iterateur.hasNext()){
            save = new File(iterateur.next());
            if(!save.exists())
                supr.add(save.toString());
        }

        iterateur = supr.iterator();
        while(iterateur.hasNext())
            listeSave.remove(iterateur.next());

        LectureEcriture.ecriture(FILE, this);
    }
}
