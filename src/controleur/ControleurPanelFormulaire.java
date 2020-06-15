/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vue.*;
import modele.*;

/**
 *
 * @author miste
 */
public class ControleurPanelFormulaire implements ActionListener{

    private PanelFormulaireChronologie panelFormulaireChronologie;

    public ControleurPanelFormulaire(PanelFormulaireChronologie panelFormulaireChronologie){
        this.panelFormulaireChronologie = panelFormulaireChronologie;
        this.panelFormulaireChronologie.getPanelCalendrierDateDebut().enregistreEcouteur(this);
        this.panelFormulaireChronologie.getPanelCalendrierDateFin().enregistreEcouteur(this);
    }

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
