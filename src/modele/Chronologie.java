package modele;

import javax.swing.*;
import java.io.Serializable;
import java.util.TreeSet;

public class Chronologie implements Serializable {

    private String intitule;
    private TreeSet <Evenement> listeEvt;
    private Date dateDebut;
    private Date dateFin;
    private int periode;
    private String adresseFichierSauvegarde;
    private ImageIcon image;

    public Chronologie(String parIntitule,  Date parDebut, Date parFin, int parPeriode, String sauvegarde, String imageChemin){
        intitule = parIntitule;
        listeEvt = new TreeSet<Evenement>();
        dateDebut=parDebut;
        dateFin=parFin;
        periode=parPeriode;
        adresseFichierSauvegarde=sauvegarde;
        image = new ImageIcon(imageChemin);
    }

    public boolean ajout(Evenement evt){
        if(evt.getDate().compareTo(dateDebut)>=0 && evt.getDate().compareTo(dateFin)<=0){
            listeEvt.add(evt);
            return true;
        }
        return false;
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
}
