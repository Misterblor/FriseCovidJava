package modele;

import javax.swing.*;
import java.io.File;
import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * <b>Abstraction d'une chronologie contenant une liste d'évènements, un intitulé, une date de début et de fin, une periode, une image et une adresse pour son fichier de sauvegarde.<br>
 * Appartient au package modeles.</b>
 *
 * @author Antoine Limerutti
 *
 * @see modele.Evenement
 * @see modele.Date
 * @see java.util.TreeSet
 *
 * @version 1.0
 */
public class Chronologie implements Serializable {

    /**
     * String correpondant à l'intitulé de la chronologie.
     */
    private String intitule;

    /**
     * TreeSet des évènement contenus dans la chronologie
     */
    private TreeSet <Evenement> listeEvt;

    /**
     * Date de début de la chronologie
     */
    private Date dateDebut;

    /**
     * Date de fin de la chronologie.
     */
    private Date dateFin;

    /**
     * Entier indiquant la periode de la chronologie
     * <ul><li>0 = jour</li><li>1 = semaine</li><li>2 = mois</li><li>3 = année</li><li>4 = 5 années</li><li>5 = décénie</li><li>6 = siècle</li></ul>
     */
    private int periode;

    /**
     * String correspondant au path du fichier de sauvegarde.
     */
    private String adresseFichierSauvegarde;

    /**
     * ImageIcon correspondant à l'image représentative de la frise.
     */
    private ImageIcon image;

    /**
     * Entier correspondant au nombre d'évènements contenus dans le chronologie
     */
    private int nbEvent;

    /**
     * Constructeur de la classe chronologie.
     *
     * @param parIntitule String qui vas être associé au champ intitule.
     * @param parDebut Date qui vas être associé au champ dateDebut.
     * @param parFin Date qui vas être associé au champ dateFin.
     * @param parPeriode Entier qui vas être associé au champ periode.
     * @param sauvegarde String qui vas être associé au champ adresseFichierSauvegarde.
     * @param imageChemin String qui vas être utilisé pour associer une image à la chronologie.
     *
     * @see javax.swing.ImageIcon
     * @see modele.Date
     */
    public Chronologie(String parIntitule,  Date parDebut, Date parFin, int parPeriode, String sauvegarde, String imageChemin){
        intitule = parIntitule;
        listeEvt = new TreeSet<Evenement>();
        dateDebut=parDebut;
        dateFin=parFin;
        periode=parPeriode;
        adresseFichierSauvegarde=sauvegarde;
        System.out.println(imageChemin);
        String extension = imageChemin.split("\\.")[imageChemin.split("\\.").length-1];
        extension = extension.toLowerCase();

        if(extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png")  || extension.equals("psd") || extension.equals("tiff"))
            image = new ImageIcon(imageChemin);
        else
            image = new ImageIcon("ressources" + File.separator + "iconImage.png");

        nbEvent=0;
    }

    /**
     * Constructeur de la classe chronologie (sans préciser la photo).
     *
     * @param parIntitule String qui vas être associé au champ intitule.
     * @param parDebut Date qui vas être associé au champ dateDebut.
     * @param parFin Date qui vas être associé au champ dateFin.
     * @param parPeriode Entier qui vas être associé au champ periode.
     * @param sauvegarde String qui vas être associé au champ adresseFichierSauvegarde.
     *
     * @author Antoine Limerutti
     *
     * @see javax.swing.ImageIcon
     * @see modele.Date
     */
    public Chronologie(String parIntitule,  Date parDebut, Date parFin, int parPeriode, String sauvegarde){
        intitule = parIntitule;
        listeEvt = new TreeSet<Evenement>();
        dateDebut=parDebut;
        dateFin=parFin;
        periode=parPeriode;
        adresseFichierSauvegarde=sauvegarde;
        image = null;
        nbEvent=0;
    }

    /**
     * Ajoute un évènement à la chronologie.
     *
     * @param evt Evenement à ajouter à la chronologie.
     *
     * @see modele.Evenement
     *
     * @author Antoine Limerutti
     *
     * @return booleen qui indique si l'ajout s'est bien passé (true si oui, false sinon).
     */
    public boolean ajout(Evenement evt){
        if(evt.getDate().compareTo(dateDebut)>=0 && evt.getDate().compareTo(dateFin)<=0){
            listeEvt.add(evt);
            nbEvent++;
            return true;
        }
        return false;
    }

    /**
     * Retourne l'évènement à la position indice dans le TreeSet listeEvt
     *
     * @param indice Entier correspondant à l'indice de l'évènement que l'on souhaite retourner.
     *
     * @see modele.Evenement
     *
     * @author Antoine Limerutti
     *
     * @return Evenement à l'indice indice dans le TreeSet listeEvt.
     */
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

    /**
     * Retourne l'indice correspondant à la place de l'évènement dans le TreeSet listeEvt ou -1 si l'évènement n'est pas compris dedans.
     *
     * @param event Evenement dont on cherche l'indice.
     *
     * @see modele.Evenement
     *
     * @author Antoine Limerutti
     *
     * @return Entier correspondant à l'ndice de l'évènement fournis en paramètre ou -1 si l'évènement n'est pas contenu dans le TreeSet listeEvt.
     */
    public int getIndice(Evenement event) {
        int i;

        for(i=0; i<nbEvent && get(i).compareTo(event)!=0; i++){}

        if(get(i).compareTo(event)==0)
            return i;
        else
            return -1;
    }

    /**
     * Supprime l'èvènement fournis en paramètre du TreeSet listeEvt.
     *
     * @author Antoine Limerutti
     *
     * @param evt Evenement que l'on souhaite supprimer du TreeSet listeEvt.
     *
     * @see modele.Evenement
     */
    public void supprimer(Evenement evt){
        if(listeEvt.contains(evt))
            listeEvt.remove(evt);
    }

    /**
     * Accesseur du champ image.
     *
     * @Author Antoine Limerutti
     *
     * @see javax.swing.ImageIcon
     *
     * @return ImageIcon correspondant au champ image.
     */
    public ImageIcon getImage() {
        return image;
    }

    /**
     * Accesseur du champ intitule.
     *
     * @author Antoine Limerutti
     *
     * @return String correspondant au champ intitule.
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * Modifieur du champ intitule.
     *
     * @author Antoine Limerutti
     *
     * @param intitule String à associer au champ intitule.
     */
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    /**
     * Accesseur du champ dateDebut.
     *
     * @see modele.Date
     *
     * @author Antoine Limerutti
     *
     * @return Date correspondant au champ dateDebut.
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * Accesseur du champ listeEvt.
     *
     * @see modele.Evenement
     * @see java.util.TreeSet
     *
     * @author Antoine Limerutti
     *
     * @return TreeSet correspondant au champ listeEvt.
     */
    public TreeSet<Evenement> getListeEvt() {
        return listeEvt;
    }

    /**
     * Modifieur du champ dateDebut.
     *
     * @see modele.Date
     *
     * @author Antoine Limerutti
     *
     * @param dateDebut Date à associer au champ dateDebut.
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Accesseur du champ dateFin.
     *
     * @see modele.Date
     *
     * @author Antoine Limerutti
     *
     * @return Date correspondant au champ dateFin.
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * Modifieur du champ dateFin.
     *
     * @see modele.Date
     *
     * @author Antoine Limerutti
     *
     * @param dateFin Date à associer au champ dateFin.
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Accesseur du champ periode.
     *
     * @author Antoine Limerutti
     *
     * @return String correspondant au champ periode.
     */
    public int getPeriode() {
        return periode;
    }

    /**
     * Modifieur du champ periode.
     *
     * @author Antoine Limerutti
     *
     * @param periode String à associer au champ periode.
     */
    public void setPeriode(int periode) {
        this.periode = periode;
    }

    /**
     * accesseur du champ adresseFichierSauvegarde.
     *
     * @author Antoine Limerutti
     *
     * @return String correspondant au champ adresseFichierSauvegarde.
     */
    public String getAdresseFichierSauvegarde() {
        return adresseFichierSauvegarde;
    }

    /**
     * Modifieur du champ adresseFichierSauvegarde.
     *
     * @author Antoine Limerutti
     *
     * @param adresseFichierSauvegarde String à associer au champ adresseFichierSauvegarde.
     */
    public void setAdresseFichierSauvegarde(String adresseFichierSauvegarde) {
        this.adresseFichierSauvegarde = adresseFichierSauvegarde;
    }

    /**
     * accesseur du champ nbEvent.
     *
     * @author Antoine Limerutti
     *
     * @return Entier correspondant au champ nbEvent.
     */
    public int getNbEvent() {
        return nbEvent;
    }
}
