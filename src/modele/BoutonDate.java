package modele;

import javax.swing.JButton;

/**
 * <b>Abstraction d'un bouton auquel on associe un objet de type Date.<br>
 * Appartient au package modele.</b>
 *
 * @author Antoine Limerutti / Pablo Rican
 *
 * @see modele.Date
 * @see javax.swing.JButton
 *
 * @version 1.0
 */
public class BoutonDate extends JButton {
    /**
     * Date associée au bouton.
     *
     * @see modele.Date
     */
    private Date date;

    /**
     * Construit un objet BoutonDate avec le contructeur de JButton (classe mère) et lui associe un objet Date fourni en paramètre.
     *
     * @param parDate Date à associer à l'objet BoutonDate.
     *
     * @see modele.Date
     *
     * @author Antoine Limerutti / Pablo Rican
     */
    public BoutonDate(Date parDate) {
        super (Integer.toString (parDate.getJour()));
        date = parDate;
    }

    /**
     * Crée une chaine de charactère précisant l'objet Date lié à l'objet appellant.
     *
     * @return String précisant la valeur du champ date.
     *
     * @author Antoine Limerutti / Pablo Rican
     *
     */
    public String toString() {
        return "Date liée au bouton : " + date.toString();
    }

    /**
     * Modifieur du champ date.
     *
     * @param parDate Date ayant la valeur que l'on veut donner au champ date.
     *
     * @author Antoine Limerutti / Pablo Rican
     *
     */
    public void setDate(Date parDate) {
        this.date = parDate;
    }

    /**
     * Acesseur du champ date.
     *
     * @return Date qui correspond à la valeur du champ date.
     *
     * @author Antoine Limerutti / Pablo Rican
     *
     */
    public Date getDate() {
        return date;
    }
}