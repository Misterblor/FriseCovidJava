package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vue.*;
import modele.*;

/**
 *
 * @author miste
 */
public class ControleurPanelFormulaireChronologie implements ActionListener{

    private PanelFormulaireChronologie panelFormulaireChronologie;

    public ControleurPanelFormulaireChronologie(PanelFormulaireChronologie panelFormulaireChronologie){
        this.panelFormulaireChronologie = panelFormulaireChronologie;
        this.panelFormulaireChronologie.getPanelCalendrierDateDebut().enregistreEcouteurChronologie(this);
        this.panelFormulaireChronologie.getPanelCalendrierDateFin().enregistreEcouteurChronologie(this);
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
