package modele;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class SavesChronologie implements Serializable {
    private ArrayList<String> listeSave;

    public static final File FILE = new File("saves" + File.separator + "listeSaves");

    public SavesChronologie(){
        listeSave = new ArrayList<String>();
    }

    public void add(String save){
        if(!listeSave.contains(save)) {
            listeSave.add(save);
            LectureEcriture.ecriture(SavesChronologie.FILE,this);
        }
    }

    public void remove(String save){
        if(listeSave.contains(save)) {
            listeSave.remove(save);
            if(new File(save).exists() && save.split(".")[save.split(".").length-1].compareTo(".ser")==0)
                new File(save).delete();
            LectureEcriture.ecriture(SavesChronologie.FILE,this);
        }
    }

    public String get(int i){
        return listeSave.get(i);
    }

    public int size() {
        return listeSave.size();
    }

    public Iterator<String> iterator() {
        return listeSave.iterator();
    }

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
    }
}
