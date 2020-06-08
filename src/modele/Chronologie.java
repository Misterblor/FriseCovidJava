package modele;

import java.util.TreeSet;

public class Chronologie {

    private String intitule;
    private TreeSet <Evenement> listeEvt;
    private Date dateDebut;
    private Date dateFin;
    private int periode;
    private String adresseFichierSauvegarde;

    public Chronologie(){

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
