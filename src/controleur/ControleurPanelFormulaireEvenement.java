package controleur;

import modele.BoutonDate;
import vue.PanelFormulaireEvenement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <b>
 *     Cette classe permet de g�rer la synchronisation entre la classe PanelFormulaireEvenement et PanelCalendrier<br>
 *     Appartient au package controleur.
 * </b>
 *
 * @author Pablo Rican
 *
 * @see ActionListener
 *
 * @version 1.0
 */
public class ControleurPanelFormulaireEvenement implements ActionListener {

    /**
     * PanelFormulaireEvenement que l'on a besoin de synchroniser.
     * @see PanelFormulaireEvenement
     */
    private PanelFormulaireEvenement panelFormulaireEvenement;

    /**
     * Constructeur de la classe ControleurPanelFormulaireEvenement.
     * Ajoute un �couteur au PanelCalendrierDate.
     *
     * @param panelFormulaireEvenement PanelFormulaireEvenement que l'on a besoin de synchroniser
     */
    public ControleurPanelFormulaireEvenement(PanelFormulaireEvenement panelFormulaireEvenement){
        this.panelFormulaireEvenement = panelFormulaireEvenement;
        this.panelFormulaireEvenement.getPanelCalendrierDate().enregistreEcouteurEvenement(this);
    }

    /**
     * Methode permettant de g�rer les �v�nements.
     * Quand l'utilisateur clique sur un des jours du PanelCalendrierDate,
     * synchronise la date entre le PanelCalendrierDate et le PanelFormulaireEvenement.
     *
     * @param e l'�v�nement en question
     *
     * @see ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        BoutonDate boutonSelectionnee = null;
        if (e.getSource().getClass() == BoutonDate.class){
            boutonSelectionnee = (BoutonDate) e.getSource();
        }
        panelFormulaireEvenement.getPanelCalendrierDate().setDate(boutonSelectionnee.getDate());
        panelFormulaireEvenement.getTextFieldDate().setText(panelFormulaireEvenement.getPanelCalendrierDate().getDateSelectionnee().toStringJourMoisAnnee());
        panelFormulaireEvenement.getTextFieldDate().setSelectionStart(0);
        panelFormulaireEvenement.getTextFieldDate().setSelectionEnd(panelFormulaireEvenement.getTextFieldDate().getText().length());
    }
}
