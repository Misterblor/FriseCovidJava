package modele;

import javax.swing.*;
import java.io.Serializable;

/**
 * <b>Abstraction d'un Evenement ayant une date, un titre, un poids, un texte descriptif et une image.<br>
 * Appartient au package modeles.<br>
 * Cette classe est serializable.</b>
 *
 * @author Antoine Limerutti
 *
 * @see java.io.Serializable
 *
 * @version 1.0
 */
public class Evenement implements Comparable<Evenement>, Serializable {
    /**
     * Date de l'évènement
     *
     * @see modele.Date
     */
    private Date date;

    /**
     * Titre de l'évènement
     */
    private String titre;

    /**
     * Poids de l'évènement (son importance)
     */
    private int poids;


    /**
     * Texte descriptif de l'évènement
     */
    private String texteDescriptif;


    /**
     * Image représentant l'évènement
     *
     * @see javax.swing.ImageIcon
     */
    private ImageIcon image;

    /**
     * Constructeur de la classe Evenement qui renseigne les champs transmits.
     *
     * @param parDate Date à assigner au champ date.
     * @param parTitre String à assigner au champ titre.
     * @param parPoids Entier à assigner au champ poids.
     * @param parTexteDescriptif String à assigner au champ texteDescriptif.
     * @param imageChemin String qui vas permetre de construire l'ImageIcon du champ image.
     *
     * @see modele.Date
     *
     * @author Antoine Limerutti
     */
    public Evenement(Date parDate, String parTitre, int parPoids, String parTexteDescriptif, String imageChemin){
        date = parDate;
        titre = parTitre;
        poids = parPoids;
        texteDescriptif = parTexteDescriptif;
        image = new ImageIcon(imageChemin);
    }

    /**
     * Compare l'objet Evenement appellant et l'objet Evenement fourni en paramètre.
     *
     * @param event Evenement à comparer à l'objet appellant
     *
     * @return Entier :<ul><li>positif (appellant sup. argument)</li><li>negatif (appellant inf. argument)</li><li>nul (appellant égal argument)</li></ul>
     *
     * @author Antoine Limerutti
     */
    public int compareTo(Evenement event){
        int resultat = date.compareTo(event.getDate());
        if(resultat!=0)
            return resultat;

        resultat=titre.compareTo(event.getTitre());
        if(resultat!=0)
            return resultat;

        resultat=poids-event.getPoids();
        if(resultat!=0)
            return resultat;

        resultat=texteDescriptif.compareTo(event.getTexteDescriptif());
        return resultat;
    }

    /**
     * Crée une chaine de charactère précisant les champs de l'objet appellant.
     *
     * @return String correspondant aux champs de l'objet appellant.
     *
     * @author Antoine Limerutti
     */
    public String toString(){
        return "Evenement du " + date.toString() + " : " + titre + "\nDe poids : " + poids + "\n" + texteDescriptif;
    }

    /**
     * Accesseur du champ date.
     *
     * @return Date qui correspond à la valeur du champ date.
     *
     * @see modele.Date
     *
     * @author Antoine Limerutti
     */
    public Date getDate() {
        return date;
    }

    /**
     * Accesseur du champ image.
     *
     * @return ImageIcon qui correspond à la valeur du champ image.
     *
     * @see ImageIcon
     *
     * @author Antoine Limerutti
     */
    public ImageIcon getImage() {
        return image;
    }

    /**
     * Modifieur du champ image.
     *
     * @param image valeur que l'on veut donner au champ image.
     *
     * @see ImageIcon
     *
     * @author Antoine Limerutti
     */
    public void setImage(ImageIcon image) {
        this.image = image;
    }

    /**
     * Modifieur du champ date.
     *
     * @param date valeur que l'on veut donner au champ date.
     *
     * @see modele.Date
     *
     * @author Antoine Limerutti
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Accesseur du champ titre.
     *
     * @return String qui correspond à la valeur du champ titre.
     *
     * @author Antoine Limerutti
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Modifieur du champ titre.
     *
     * @param titre Valeur que l'on veut donner au champ titre.
     *
     * @author Antoine Limerutti
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Accesseur du champ poids.
     *
     * @return String qui correspond à la valeur du champ poids.
     *
     * @author Antoine Limerutti
     */
    public int getPoids() {
        return poids;
    }

    /**
     * modifieur du champ poids.
     *
     * @param poids Valeur que l'on veut donner au champ poids.
     *
     * @author Antoine Limerutti
     */
    public void setPoids(int poids) {
        this.poids = poids;
    }

    /**
     * Accesseur du champ texteDescriptif.
     *
     * @return String qui correspond à la valeur du champ texteDescriptif.
     *
     * @author Antoine Limerutti
     */
    public String getTexteDescriptif() {
        return texteDescriptif;
    }

    /**
     * modifieur du champ texteDescriptif.
     *
     * @param texteDescriptif Valeur que l'on veut donner au champ texteDescriptif.
     *
     * @author Antoine Limerutti
     */
    public void setTexteDescriptif(String texteDescriptif) {
        this.texteDescriptif = texteDescriptif;
    }
}
