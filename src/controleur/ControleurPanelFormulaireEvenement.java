package controleur;

import modele.BoutonDate;
import vue.PanelFormulaireEvenement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurPanelFormulaireEvenement implements ActionListener {

    private PanelFormulaireEvenement panelFormulaireEvenement;

    public ControleurPanelFormulaireEvenement(PanelFormulaireEvenement panelFormulaireEvenement){
        this.panelFormulaireEvenement = panelFormulaireEvenement;
        this.panelFormulaireEvenement.getPanelCalendrierDate().enregistreEcouteurEvenement(this);
    }

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
