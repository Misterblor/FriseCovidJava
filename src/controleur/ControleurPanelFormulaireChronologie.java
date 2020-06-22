package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vue.*;
import modele.*;

/**
 * <b>
 *     Cette classe permet de gérer la synchronisation entre la classe PanelFormulaireChronologie et PanelCalendrier<br>
 *     Appartient au package controleur.
 * </b>
 *
 * @author Pablo Rican
 *
 * @see ActionListener
 *
 * @version 1.0
 */
public class ControleurPanelFormulaireChronologie implements ActionListener{

    /**
     * PanelFormulaireChronologie que l'on a besoin de synchroniser.
     * @see PanelFormulaireEvenement
     */
    private PanelFormulaireChronologie panelFormulaireChronologie;

    /**
     * Constructeur de la classe ControleurPanelFormulaireChronologie.
     * Ajoute un écouteur aux PanelCalendrierDate.
     *
     * @param panelFormulaireChronologie PanelFormulaireChronologie que l'on a besoin de synchroniser
     */
    public ControleurPanelFormulaireChronologie(PanelFormulaireChronologie panelFormulaireChronologie){
        this.panelFormulaireChronologie = panelFormulaireChronologie;
        this.panelFormulaireChronologie.getPanelCalendrierDateDebut().enregistreEcouteurChronologie(this);
        this.panelFormulaireChronologie.getPanelCalendrierDateFin().enregistreEcouteurChronologie(this);
    }

    /**
     * Methode permettant de gérer les événements.
     * Quand l'utilisateur clique sur un des jours du PanelCalendrierDate,
     * synchronise la date entre le PanelCalendrierDate et le PanelFormulaireChronologie.
     *
     * @param e l'événement en question
     *
     * @see ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        BoutonDate boutonSelectionnee = null;
        if (e.getSource().getClass() == BoutonDate.class){
            boutonSelectionnee = (BoutonDate) e.getSource();
        }
        if (boutonSelectionnee.getParent().getParent() == panelFormulaireChronologie.getPanelCalendrierDateDebut()){
            panelFormulaireChronologie.getPanelCalendrierDateDebut().setDate(boutonSelectionnee.getDate());
            panelFormulaireChronologie.getTextFieldDateDebut().setText(panelFormulaireChronologie.getPanelCalendrierDateDebut().getDateSelectionnee().toStringJourMoisAnnee());
            panelFormulaireChronologie.getTextFieldDateDebut().setSelectionStart(0);
            panelFormulaireChronologie.getTextFieldDateDebut().setSelectionEnd(panelFormulaireChronologie.getTextFieldDateDebut().getText().length());
        }
        if (boutonSelectionnee.getParent().getParent() == panelFormulaireChronologie.getPanelCalendrierDateFin()){
            panelFormulaireChronologie.getPanelCalendrierDateFin().setDate(boutonSelectionnee.getDate());
            panelFormulaireChronologie.getTextFieldDateFin().setText(panelFormulaireChronologie.getPanelCalendrierDateFin().getDateSelectionnee().toStringJourMoisAnnee());
            panelFormulaireChronologie.getTextFieldDateFin().setSelectionStart(0);
            panelFormulaireChronologie.getTextFieldDateFin().setSelectionEnd(panelFormulaireChronologie.getTextFieldDateFin().getText().length());
        }
    }
}
