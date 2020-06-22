package vue;

import controleur.ControleurPanelFormulaireChronologie;
import java.awt.Color;

import controleur.ControleurPanelFormulaireEvenement;
import modele.BoutonDate;
import modele.Date;

import javax.swing.*;

/**
 * <b>
 *     Cette classe permet d'afficher un calendrier permettant de saisir une date à l'aide de boutons.<br>
 *     Appartient au package vue.
 * </b>
 *
 * @author Pablo RICAN
 *
 * @see javax.swing.JPanel
 *
 * @version 1.0
 */
public class PanelCalendrierDate extends javax.swing.JPanel {

    /**
     * Liste des boutons qui contiennent les jours du calendrier
     * @see BoutonDate
     */
    private BoutonDate[] listeBoutonDate = new BoutonDate[42];

    /**
     * Date qui est sélectionnée dans le calendrier
     * @see Date
     */
    private Date dateSelectionnee;

    /**
     * Date permettant de se repérer dans le calendrier
     * pour pouvoir défiler entre les mois
     * @see Date
     */
    private Date dateReperage;

    /**
     * Bouton permettant de naviguer entre les mois (précédents)
     * @see javax.swing.JButton
     */
    private javax.swing.JButton boutonMoisPrecedent;

    /**
     * Bouton permettant de naviguer entre les mois (suivants)
     * @see javax.swing.JButton
     */
    private javax.swing.JButton boutonMoisSuivant;

    /**
     * Label permettant d'afficher le moi actuel
     * @see javax.swing.JLabel
     */
    private javax.swing.JLabel labelIndicationMois;

    /**
     * Panel permettant d'organiser les boutons
     * qui contiennent les jours du calendrier
     * @see javax.swing.JPanel
     */
    private javax.swing.JPanel panelCalendrier;

    /**
     * Panel permettant d'organiser les boutons
     * qui permettant de naviguer entre les mois
     * et le label permettant d'afficher le moi actuel
     * @see javax.swing.JPanel
     */
    private javax.swing.JPanel panelNavigation;

    /**
     * Constructeur de la classe PanelCalendrierDate,
     * permet d'initialiser et de placer tout les composants graphiques.
     * Initialise le panel à la date du jour.
     */
    public PanelCalendrierDate() {
        initComponents();
        initPanelCalendrier(new Date());
    }

    /**
     * Cette methode a été généré par le logiciel NetBeans et complété par Pablo Rican.
     * Elle permet de placer tous les composants graphiques sur le panel de manière précise.
     * Elle permet aussi de déclarer les methodes gérant les événements pour les composants s'ils en ont besoin.
     *
     * @see GroupLayout
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        panelNavigation = new javax.swing.JPanel();
        labelIndicationMois = new javax.swing.JLabel();
        boutonMoisPrecedent = new javax.swing.JButton();
        boutonMoisSuivant = new javax.swing.JButton();
        panelCalendrier = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 120, 215));
        setPreferredSize(new java.awt.Dimension(100, 100));

        panelNavigation.setBackground(java.awt.Color.white);
        panelNavigation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 120, 215)));

        labelIndicationMois.setFont(new java.awt.Font("Open Sans", 1, 11)); // NOI18N

        boutonMoisPrecedent.setBackground(java.awt.Color.white);
        boutonMoisPrecedent.setFont(new java.awt.Font("Open Sans", 1, 11)); // NOI18N
        boutonMoisPrecedent.setText("<");
        boutonMoisPrecedent.setBorder(null);
        boutonMoisPrecedent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonMoisPrecedentActionPerformed(evt);
            }
        });

        boutonMoisSuivant.setBackground(java.awt.Color.white);
        boutonMoisSuivant.setFont(new java.awt.Font("Open Sans", 1, 11)); // NOI18N
        boutonMoisSuivant.setText(">");
        boutonMoisSuivant.setBorder(null);
        boutonMoisSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonMoisSuivantActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNavigationLayout = new javax.swing.GroupLayout(panelNavigation);
        panelNavigation.setLayout(panelNavigationLayout);
        panelNavigationLayout.setHorizontalGroup(
                panelNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelNavigationLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelIndicationMois)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 551, Short.MAX_VALUE)
                                .addComponent(boutonMoisPrecedent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boutonMoisSuivant)
                                .addContainerGap())
        );
        panelNavigationLayout.setVerticalGroup(
                panelNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelNavigationLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelIndicationMois)
                                        .addComponent(boutonMoisSuivant)
                                        .addComponent(boutonMoisPrecedent))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        String[] JOUR_DE_LA_SEMAINE = {"lu.", "ma.", "me.", "je.", "ve.", "sa.", "di."};
        javax.swing.JLabel[] labelJourSemaine = new javax.swing.JLabel[JOUR_DE_LA_SEMAINE.length];
        for (int i = 0; i < labelJourSemaine.length; i++) {
            labelJourSemaine[i] = new javax.swing.JLabel(JOUR_DE_LA_SEMAINE[i]);
            labelJourSemaine[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            panelCalendrier.add(labelJourSemaine[i]);
        }
        for (int i = 0; i < listeBoutonDate.length; i++){
            listeBoutonDate[i] = new BoutonDate(new Date());
            listeBoutonDate[i].setBorder(null);
            listeBoutonDate[i].setFocusPainted(false);
            panelCalendrier.add(listeBoutonDate[i]);
        }
        panelCalendrier.setBackground(java.awt.Color.white);
        panelCalendrier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 120, 215)));
        panelCalendrier.setLayout(new java.awt.GridLayout(7, 7));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelNavigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelCalendrier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelNavigation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelCalendrier, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
        );
    }

    /**
     * Cette methode permet d'initialiser et de rafraichir le PanelCalendrierDate.
     * Elle colorie les bouton de différentes manière pour une meilleur compréhension
     * de la part de l'utilisateur.
     *
     * @param date Date à laquelle on initialise le PanelCalendrierDate
     *
     * @see Date
     */
    private void initPanelCalendrier(Date date){
        Date dateTemp = date;
        dateReperage = date;
        labelIndicationMois.setText(date.toStringMoisAnnee());
        while(dateTemp.getJour() != 1){
            dateTemp = dateTemp.dateDeLaVeille();
        }
        while(dateTemp.getJourSemaine() != 2){
            dateTemp = dateTemp.dateDeLaVeille();
        }

        for (int i = 0; i < listeBoutonDate.length; i++){
            listeBoutonDate[i].setText(dateTemp.toStringJour());
            listeBoutonDate[i].setDate(dateTemp);
            listeBoutonDate[i].setBackground(Color.WHITE);
            listeBoutonDate[i].setForeground(Color.BLACK);
            listeBoutonDate[i].setBorder(null);
            if (dateTemp.getMois() != date.getMois()){
                listeBoutonDate[i].setForeground(Color.LIGHT_GRAY);
            }
            if (dateTemp.compareTo(new Date()) == 0){
                listeBoutonDate[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 120, 215)));
            }
            if (dateSelectionnee == null){
                dateSelectionnee = new Date();
            }
            if (dateTemp.compareTo(dateSelectionnee) == 0){
                listeBoutonDate[i].setForeground(Color.WHITE);
                listeBoutonDate[i].setBackground(new Color(0,120,215));
            }
            dateTemp = dateTemp.dateDuLendemain();
        }
    }

    /**
     * Methode permettant de gérer les événements du boutonMoisPrecedent.
     * Quand le bouton est appuyé, le PanelCalendrierDate se rafraîchit
     * pour afficher le PanelCalendrierDate au mois précédent.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.ActionEvent
     */
    private void boutonMoisPrecedentActionPerformed(java.awt.event.ActionEvent evt) {
        initPanelCalendrier(dateReperage.moisPrecedent());
    }

    /**
     * Methode permettant de gérer les événements du boutonMoisSuivant.
     * Quand le bouton est appuyé, le PanelCalendrierDate se rafraîchit
     * pour afficher le PanelCalendrierDate au mois suivant.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.ActionEvent
     */
    private void boutonMoisSuivantActionPerformed(java.awt.event.ActionEvent evt) {
        initPanelCalendrier(dateReperage.moisSuivant());
    }

    /**
     * Methode permettant d'enregistrer les écouteurs pour pouvoir utiliser
     * les boutons dans un controleur.
     *
     * @param controleurPanelFormulaireChronologie le controleur dans lequel vont être utilisés les boutons
     *
     * @see ControleurPanelFormulaireChronologie
     */
    public void enregistreEcouteurChronologie(ControleurPanelFormulaireChronologie controleurPanelFormulaireChronologie){
        for (int i = 0; i < listeBoutonDate.length; i++){
            listeBoutonDate[i].addActionListener(controleurPanelFormulaireChronologie);
        }
    }

    /**
     * Methode permettant d'enregistrer les écouteurs pour pouvoir utiliser
     * les boutons dans un controleur.
     *
     * @param controleurPanelFormulaireEvenement le controleur dans lequel vont être utilisés les boutons
     *
     * @see ControleurPanelFormulaireEvenement
     */
    public void enregistreEcouteurEvenement(ControleurPanelFormulaireEvenement controleurPanelFormulaireEvenement){
        for (int i = 0; i < listeBoutonDate.length; i++){
            listeBoutonDate[i].addActionListener(controleurPanelFormulaireEvenement);
        }
    }

    /**
     * Methode permettant d'enregistrer une date quand on la sélectionne.
     * Rafraîchit le PanelCalendrierDate pour changer la couleur des boutons.
     *
     * @param date la date à laquelle on rafraîchit et
     * on enregistre la date dans le PanelCalendrierDate.
     */
    public void setDate(Date date){
        dateSelectionnee = date;
        initPanelCalendrier(date);
    }

    /**
     * Getter de dateSelectionnee.
     *
     * @return la dateSelectionnee
     */
    public Date getDateSelectionnee(){
        return dateSelectionnee;
    }
}
