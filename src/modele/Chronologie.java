package modele;

import javax.swing.*;
import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

public class Chronologie implements Serializable {

    private String intitule;
    private TreeSet <Evenement> listeEvt;
    private Date dateDebut;
    private Date dateFin;
    private int periode;
    private String adresseFichierSauvegarde;
    private ImageIcon image;

    private int nbEvent;

    public Chronologie(String parIntitule,  Date parDebut, Date parFin, int parPeriode, String sauvegarde, String imageChemin){
        intitule = parIntitule;
        listeEvt = new TreeSet<Evenement>();
        dateDebut=parDebut;
        dateFin=parFin;
        periode=parPeriode;
        adresseFichierSauvegarde=sauvegarde;
        image = new ImageIcon(imageChemin);
        nbEvent=0;
    }

    public boolean ajout(Evenement evt){
        if(evt.getDate().compareTo(dateDebut)>=0 && evt.getDate().compareTo(dateFin)<=0){
            listeEvt.add(evt);
            nbEvent++;
            return true;
        }
        return false;
    }

    public Evenement get(int indice){
        if(indice<0 || indice>=nbEvent)
            return null;

        Iterator<Evenement> iterateur = listeEvt.iterator();

        while(indice!=0 && iterateur.hasNext()){
            indice--;
            iterateur.next();
        }

        return iterateur.next();
    }

    public void supprimer(Evenement evt){
        listeEvt.remove(evt);
    }

    public ImageIcon getImage() {
        return image;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public TreeSet<Evenement> getListeEvt() {
        return listeEvt;
    }

    public void setListeEvt(TreeSet<Evenement> listeEvt) {
        this.listeEvt = listeEvt;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public String getAdresseFichierSauvegarde() {
        return adresseFichierSauvegarde;
    }

    public void setAdresseFichierSauvegarde(String adresseFichierSauvegarde) {
        this.adresseFichierSauvegarde = adresseFichierSauvegarde;
    }

    public int getNbEvent() {
        return nbEvent;
    }

    public void setNbEvent(int nbEvent) {
        this.nbEvent = nbEvent;
    }

    public int getIndice(Evenement event) {
        int i;
        for(i=0; i<nbEvent && get(i)!=event; i++){}

        if(get(i)==event)
            return i;
        else
            return -1;
    }
}
