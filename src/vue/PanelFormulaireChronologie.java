package vue;

import controleur.ControleurPanelFormulaireChronologie;
import modele.Chronologie;
import modele.Date;
import utils.LectureEcriture;
import modele.SavesChronologie;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 * <b>
 *     Cette classe permet d'afficher un formulaire permettant de créer une frise chronologique.<br>
 *     Appartient au package vue.
 * </b>
 *
 * @author Pablo RICAN
 *
 * @see JPanel
 *
 * @version 1.0
 */
public class PanelFormulaireChronologie extends javax.swing.JPanel {

    /**
     * Bouton permettant d'ouvrir le sélectionneur de fichier
     * pour choisir le chemin d'enregistrement de la frise
     * @see JButton
     */
    private javax.swing.JButton boutonParcourirDossier;

    /**
     * Bouton permettant d'ouvrir le sélectionneur de fichier
     * pour choisir le chemin de l'image
     * @see JButton
     */
    private javax.swing.JButton boutonParcourirImage;

    /**
     * Bouton permettant d'enregistrer une nouvelle frise
     * @see JButton
     */
    private javax.swing.JButton buttonAjouter;

    /**
     * ComboBox permettant de sélectionner la période de la frise
     * @see JComboBox
     */
    private javax.swing.JComboBox<String> comboBoxPeriode;

    /**
     * Sélectionneur de fichier permettant
     * de choisir le chemin d'enregistrement de la frise
     * @see JFileChooser
     */
    private javax.swing.JFileChooser fileChooserDossier;

    /**
     * Sélectionneur de fichier permettant
     * de choisir le chemin de l'image
     * @see JFileChooser
     */
    private javax.swing.JFileChooser fileChooserImage;

    /**
     * Label permettant d'afficher l'icon de la flèche
     * ou de la flèche barré suivant la validité des dates
     * @see JLabel
     */
    private javax.swing.JLabel labelDateFin;

    /**
     * Label permettant d'afficher l'image choisie par l'utilisateur
     * @see JLabel
     */
    private javax.swing.JLabel labelImageAffiche;

    /**
     * PanelCalendrierDate permettant de saisir la date de début
     * de la chronologie
     * @see PanelCalendrierDate
     */
    private vue.PanelCalendrierDate panelCalendrierDateDebut;

    /**
     * PanelCalendrierDate permettant de saisir la date de fin
     * de la chronologie
     * @see PanelCalendrierDate
     */
    private vue.PanelCalendrierDate panelCalendrierDateFin;

    /**
     * ProgressBar permettant de créer un effet de style
     * quand le champ de saisie de la date du début a le focus
     * @see JProgressBar
     */
    private javax.swing.JProgressBar styleSaisieDateDebut;

    /**
     * ProgressBar permettant de créer un effet de style
     * quand le champ de saisie de la date de fin a le focus
     * @see JProgressBar
     */
    private javax.swing.JProgressBar styleSaisieDateFin;

    /**
     * ProgressBar permettant de créer un effet de style
     * quand le champ de saisie du dossier de sauvegarde a le focus
     * @see JProgressBar
     */
    private javax.swing.JProgressBar styleSaisieDossier;

    /**
     * ProgressBar permettant de créer un effet de style
     * quand le champ de saisie de l'image a le focus
     * @see JProgressBar
     */
    private javax.swing.JProgressBar styleSaisieImage;

    /**
     * ProgressBar permettant de créer un effet de style
     * quand le champ de saisie de l'intitule a le focus
     * @see JProgressBar
     */
    private javax.swing.JProgressBar styleSaisieIntitule;

    /**
     * ProgressBar permettant de créer un effet de style
     * quand le champ de saisie de la periode a le focus
     * @see JProgressBar
     */
    private javax.swing.JProgressBar styleSaisiePeriode;

    /**
     * Champ de saisie de la date de debut de la chronologie
     * @see JTextField
     */
    private javax.swing.JTextField textFieldDateDebut;

    /**
     * Champ de saisie de la date de fin de la chronologie
     * @see JTextField
     */
    private javax.swing.JTextField textFieldDateFin;

    /**
     * Champ de saisie du dossier de sauvegarde de la frise
     * @see JTextField
     */
    private javax.swing.JTextField textFieldDossier;

    /**
     * Champ de saisie de l'image de la frise
     * @see JTextField
     */
    private javax.swing.JTextField textFieldImage;

    /**
     * Champ de saisie de l'intitule de la frise
     * @see JTextField
     */
    private javax.swing.JTextField textFieldIntitule;

    /**
     * Timer permettant d'utiliser la ProgressBar styleSaisieIntitule
     * @see java.util.Timer
     */
    private java.util.Timer timerStyleSaisieIntitule = new java.util.Timer();

    /**
     * Timer permettant d'utiliser la ProgressBar styleSaisieDateDebut
     * @see java.util.Timer
     */
    private java.util.Timer timerStyleSaisieDateDebut = new java.util.Timer();

    /**
     * Timer permettant d'utiliser la ProgressBar styleSaisieDateFin
     * @see java.util.Timer
     */
    private java.util.Timer timerStyleSaisieDateFin = new java.util.Timer();

    /**
     * Timer permettant d'utiliser la ProgressBar styleSaisiePeriode
     * @see java.util.Timer
     */
    private java.util.Timer timerStyleSaisiePeriode = new java.util.Timer();

    /**
     * Timer permettant d'utiliser la ProgressBar styleSaisieDossier
     * @see java.util.Timer
     */
    private java.util.Timer timerStyleSaisieDossier = new java.util.Timer();

    /**
     * Timer permettant d'utiliser la ProgressBar styleSaisieImage
     * @see java.util.Timer
     */
    private java.util.Timer timerStyleSaisieImage = new java.util.Timer();

    /**
     * Constructeur de la classe PanelFormulaireChronologie,
     * permet d'initialiser et de placer tout les composants graphiques.
     * Instancie un controleur permettant de gérer les dates avec les PanelCalendrierDate
     * et les textFieldDate
     *
     * @see ControleurPanelFormulaireChronologie
     */
    public PanelFormulaireChronologie() {
        initComponents();
        new ControleurPanelFormulaireChronologie(this);
        requestFocus();
    }

    /**
     * Cette methode a été généré par le logiciel NetBeans et permet de placer tous les composants
     * graphiques sur le panel de manière précise. Elle permet aussi de déclarer les methodes
     * gérant les événements pour les composants s'ils en ont besoin.
     *
     * @see GroupLayout
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        fileChooserDossier = new javax.swing.JFileChooser();
        fileChooserImage = new javax.swing.JFileChooser();
        JLabel labelIntitule = new javax.swing.JLabel();
        textFieldIntitule = new javax.swing.JTextField();
        styleSaisieIntitule = new javax.swing.JProgressBar();
        JLabel labelDateDebut = new javax.swing.JLabel();
        textFieldDateDebut = new javax.swing.JTextField();
        styleSaisieDateDebut = new javax.swing.JProgressBar();
        panelCalendrierDateDebut = new vue.PanelCalendrierDate();
        labelDateFin = new javax.swing.JLabel();
        textFieldDateFin = new javax.swing.JTextField();
        styleSaisieDateFin = new javax.swing.JProgressBar();
        panelCalendrierDateFin = new vue.PanelCalendrierDate();
        JLabel labelPeriode = new javax.swing.JLabel();
        comboBoxPeriode = new javax.swing.JComboBox<>();
        styleSaisiePeriode = new javax.swing.JProgressBar();
        JLabel labelDossier = new javax.swing.JLabel();
        textFieldDossier = new javax.swing.JTextField();
        boutonParcourirDossier = new javax.swing.JButton();
        styleSaisieDossier = new javax.swing.JProgressBar();
        JLabel labelImage = new javax.swing.JLabel();
        textFieldImage = new javax.swing.JTextField();
        styleSaisieImage = new javax.swing.JProgressBar();
        boutonParcourirImage = new javax.swing.JButton();
        labelImageAffiche = new javax.swing.JLabel();
        buttonAjouter = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(1280, 720));

        labelIntitule.setIcon(new javax.swing.ImageIcon("ressources\\iconLabelIntitule.jpg")); // NOI18N

        textFieldIntitule.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        textFieldIntitule.setForeground(java.awt.Color.lightGray);
        textFieldIntitule.setText("Saisir le nom de la frise");
        textFieldIntitule.setBorder(null);
        textFieldIntitule.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldIntituleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldIntituleFocusLost(evt);
            }
        });
        textFieldIntitule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textFieldIntituleMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                textFieldIntituleMouseReleased(evt);
            }
        });
        textFieldIntitule.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                try {
                    textFieldIntituleKeyTyped(evt);
                } catch (IOException | UnsupportedFlavorException e) {
                    e.printStackTrace();
                }
            }
        });

        styleSaisieIntitule.setBackground(java.awt.Color.lightGray);

        labelDateDebut.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        labelDateDebut.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelDateDebut.setIcon(new javax.swing.ImageIcon("ressources\\iconLabelSaisieDate.png")); // NOI18N

        textFieldDateDebut.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        textFieldDateDebut.setForeground(java.awt.Color.lightGray);
        textFieldDateDebut.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldDateDebut.setBorder(null);
        textFieldDateDebut.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldDateDebutFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldDateDebutFocusLost(evt);
            }
        });
        textFieldDateDebut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textFieldDateDebutMousePressed(evt);
            }
        });
        textFieldDateDebut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldDateDebutKeyTyped(evt);
            }
        });

        styleSaisieDateDebut.setBackground(java.awt.Color.lightGray);

        panelCalendrierDateDebut.setPreferredSize(new java.awt.Dimension(275, 175));
        panelCalendrierDateDebut.setVisible(false);

        labelDateFin.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        labelDateFin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDateFin.setIcon(new javax.swing.ImageIcon("ressources\\iconFleche.png")); // NOI18N

        textFieldDateFin.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        textFieldDateFin.setForeground(java.awt.Color.lightGray);
        textFieldDateFin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldDateFin.setBorder(null);
        textFieldDateFin.setPreferredSize(new java.awt.Dimension(126, 20));
        textFieldDateFin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldDateFinFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldDateFinFocusLost(evt);
            }
        });
        textFieldDateFin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textFieldDateFinMousePressed(evt);
            }
        });
        textFieldDateFin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldDateFinKeyTyped(evt);
            }
        });

        styleSaisieDateFin.setBackground(java.awt.Color.lightGray);

        panelCalendrierDateFin.setPreferredSize(new java.awt.Dimension(275, 175));
        panelCalendrierDateFin.setVisible(false);

        labelPeriode.setIcon(new javax.swing.ImageIcon("ressources\\iconLabelPeriode.png")); // NOI18N

        comboBoxPeriode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Sélectionner une période--", "1 jour" }));
        comboBoxPeriode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboBoxPeriodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboBoxPeriodeFocusLost(evt);
            }
        });

        styleSaisiePeriode.setBackground(java.awt.Color.lightGray);
        styleSaisiePeriode.setOrientation(1);

        labelDossier.setIcon(new javax.swing.ImageIcon("ressources\\iconLabelDossier.jpg")); // NOI18N

        textFieldDossier.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        textFieldDossier.setForeground(java.awt.Color.lightGray);
        textFieldDossier.setText("Saisir le chemin de sauvegarde");
        textFieldDossier.setBorder(null);
        textFieldDossier.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldDossierFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldDossierFocusLost(evt);
            }
        });
        textFieldDossier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textFieldDossierMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                textFieldDossierMouseReleased(evt);
            }
        });
        textFieldDossier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                try {
                    textFieldDossierKeyTyped(evt);
                } catch (IOException | UnsupportedFlavorException e) {
                    e.printStackTrace();
                }
            }
        });

        boutonParcourirDossier.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        boutonParcourirDossier.setText("Parcourir");
        boutonParcourirDossier.setFocusPainted(false);
        boutonParcourirDossier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonParcourirDossierActionPerformed(evt);
            }
        });

        styleSaisieDossier.setBackground(java.awt.Color.lightGray);

        labelImage.setIcon(new javax.swing.ImageIcon("ressources\\iconImage.png")); // NOI18N

        textFieldImage.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        textFieldImage.setForeground(java.awt.Color.lightGray);
        textFieldImage.setText("Saisir le chemin de l'image");
        textFieldImage.setBorder(null);
        textFieldImage.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldImageFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldImageFocusLost(evt);
            }
        });
        textFieldImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textFieldImageMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                textFieldImageMouseReleased(evt);
            }
        });
        textFieldImage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                try {
                    textFieldImageKeyTyped(evt);
                } catch (IOException | UnsupportedFlavorException e) {
                    e.printStackTrace();
                }
            }
        });

        styleSaisieImage.setBackground(java.awt.Color.lightGray);

        boutonParcourirImage.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        boutonParcourirImage.setText("Parcourir");
        boutonParcourirImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonParcourirImageActionPerformed(evt);
            }
        });

        labelImageAffiche.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImageAffiche.setIcon(new javax.swing.ImageIcon("ressources\\iconImageAffiche.png")); // NOI18N

        buttonAjouter.setIcon(new javax.swing.ImageIcon("ressources\\iconBoutonAjouter.png")); // NOI18N
        buttonAjouter.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(182, 182, 182)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelDateDebut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelIntitule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelDossier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelPeriode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(labelImage, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(comboBoxPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(styleSaisiePeriode, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(styleSaisieDateDebut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(textFieldDateDebut))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(labelDateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(panelCalendrierDateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(panelCalendrierDateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(styleSaisieDateFin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(textFieldDateFin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(styleSaisieImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(textFieldImage, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(styleSaisieDossier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(textFieldDossier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(boutonParcourirImage, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                                        .addComponent(boutonParcourirDossier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(styleSaisieIntitule, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                                                                .addComponent(textFieldIntitule)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelImageAffiche, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(buttonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(46, 46, 46)))))
                                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(labelIntitule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(textFieldIntitule))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(styleSaisieIntitule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(labelDateDebut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(textFieldDateFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(textFieldDateDebut)
                                                        .addComponent(labelDateFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(styleSaisieDateFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(styleSaisieDateDebut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(panelCalendrierDateFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(panelCalendrierDateDebut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(labelPeriode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(comboBoxPeriode))
                                                        .addComponent(styleSaisiePeriode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(labelDossier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(textFieldDossier, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(boutonParcourirDossier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(styleSaisieDossier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                        .addComponent(textFieldImage)
                                                        .addComponent(boutonParcourirImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(styleSaisieImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(buttonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelImageAffiche, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textFieldDateDebut.setText(new Date().toStringJourMoisAnnee());
        textFieldDateFin.setText(new Date().toStringJourMoisAnnee());
    }

    /**
     * Methode permettant de gérer le focus du textFieldIntitule.
     * Quand le composant gagne le focus, on fait un effet de style
     * avec la ProgressBar et on met le cusreur au début du composant.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textFieldIntituleFocusGained(java.awt.event.FocusEvent evt) {
        avanceStyleSaisieIntitule();
        if (textFieldIntitule.getText().equals("Saisir le nom de la frise")){
            textFieldIntitule.setCaretPosition(0);
        }
    }

    /**
     * Methode permettant de gérer le focus du textFieldIntitule.
     * Quand le composant pert le focus, on regarde la validité de la saisie,
     * et on fait un effet de style avec la ProgressBar.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textFieldIntituleFocusLost(java.awt.event.FocusEvent evt) {
        if (textFieldIntitule.getText().contains("\"") || textFieldIntitule.getText().contains("\\")
                || textFieldIntitule.getText().contains("/") || textFieldIntitule.getText().contains("<") || textFieldIntitule.getText().contains(">")
                || textFieldIntitule.getText().contains(":") || textFieldIntitule.getText().contains("?") || textFieldIntitule.getText().contains("*")) {
            textFieldIntitule.setForeground(Color.RED);
            styleSaisieIntitule.setForeground(Color.RED);
        } else {
            if (textFieldIntitule.getText().equals("Saisir le nom de la frise")){
                textFieldIntitule.setForeground(Color.LIGHT_GRAY);
            } else {
                textFieldIntitule.setForeground(Color.BLACK);
            }

            styleSaisieIntitule.setForeground(new Color(0,120,215));
        }
        reculeStyleSaisieIntitule();
    }

    /**
     * Methode permettant de gérer les événements de la souris du textFieldIntitule.
     * Quand la souris est appuyée sur le composant, on regarde si la saisie est "vide"
     * et on colorie le composant d'une certaine couleur.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.MouseEvent
     */
    private void textFieldIntituleMousePressed(java.awt.event.MouseEvent evt) {
        if (textFieldIntitule.getText().equals("Saisir le nom de la frise")){
            textFieldIntitule.setCaretPosition(0);
            textFieldIntitule.setSelectionColor(Color.WHITE);
            textFieldIntitule.setSelectedTextColor(Color.LIGHT_GRAY);
        } else {
            textFieldIntitule.setSelectionColor(new Color(0,120,215));
            textFieldIntitule.setSelectedTextColor(Color.WHITE);
        }
    }

    /**
     * Methode permettant de gérer les événements de la souris du textFieldIntitule.
     * Quand la souris est relachée sur le composant, on regarde si la saisie est "vide"
     * et on met le curseur au debut du composant.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.MouseEvent
     */
    private void textFieldIntituleMouseReleased(java.awt.event.MouseEvent evt) {
        if (textFieldIntitule.getText().equals("Saisir le nom de la frise")){
            textFieldIntitule.setCaretPosition(0);
        }
    }

    /**
     * Methode permettant de gérer les événements du clavier du textFieldIntitule.
     * Quand une touche est tapée sur le composant, on regarde si elle a pour but d'écrire
     * (donc pas des touches comme Entrée ou Suppr) et on change la couleur de la saisie.
     * Si la touche tapée est Entrée ou Echap, on controle la validité de la saisie
     * et on sort du composant.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.KeyEvent
     */
    private void textFieldIntituleKeyTyped(java.awt.event.KeyEvent evt) throws IOException, UnsupportedFlavorException {
        if (textFieldIntitule.getText().equals("Saisir le nom de la frise") && !((int)evt.getKeyChar() == 8 || (int)evt.getKeyChar() == 27 || (int)evt.getKeyChar() == 1 || (int)evt.getKeyChar() == 10)){
            textFieldIntitule.setText("");
            textFieldIntitule.setForeground(Color.BLACK);
        } else if (textFieldIntitule.getText().equals("")){
            textFieldIntitule.setText("Saisir le nom de la frise");
            textFieldIntitule.setForeground(Color.LIGHT_GRAY);
            textFieldIntitule.setCaretPosition(0);
        } else if (!(textFieldIntitule.getText().equals("")) && !(textFieldIntitule.getText().equals("Saisir le nom de la frise"))){
            textFieldIntitule.setSelectionColor(new Color(0,120,215));
            textFieldIntitule.setSelectedTextColor(Color.WHITE);
        }
        if ((int)evt.getKeyChar() == 127 && textFieldIntitule.getText().equals("aisir le nom de la frise")){
            textFieldIntitule.setText("Saisir le nom de la frise");
            textFieldIntitule.setCaretPosition(0);
        }
        if ((int)evt.getKeyChar() == 27 || (int)evt.getKeyChar() == 10){
            if (textFieldIntitule.getText().contains("\"") || textFieldIntitule.getText().contains("\\")
                    || textFieldIntitule.getText().contains("/") || textFieldIntitule.getText().contains("<") || textFieldIntitule.getText().contains(">")
                    || textFieldIntitule.getText().contains(":") || textFieldIntitule.getText().contains("?") || textFieldIntitule.getText().contains("*")) {
                textFieldIntitule.setForeground(Color.RED);
                styleSaisieIntitule.setForeground(Color.RED);
            }
            requestFocus();
        }
        if ((int)evt.getKeyChar() == 1 && textFieldIntitule.getText().equals("Saisir le nom de la frise")){
            textFieldIntitule.setCaretPosition(0);
        }
        if ((int)evt.getKeyChar() == 22 && textFieldIntitule.getText().equals((String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor) + "Saisir le nom de la frise")){
            textFieldIntitule.setText("");
            textFieldIntitule.setForeground(Color.BLACK);
            textFieldIntitule.setText((String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
        }
    }

    /**
     * Methode permettant de gérer le focus du textFieldDateDebut.
     * Quand le composant gagne le focus, on fait un effet de style
     * avec la ProgressBar et on rend visible le composant panelCalendrierDateDebut.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textFieldDateDebutFocusGained(java.awt.event.FocusEvent evt) {
        avanceStyleSaisieDateDebut();
        panelCalendrierDateDebut.setVisible(true);

    }

    /**
     * Methode permettant de gérer le focus du textFieldDateDebut.
     * Quand le composant pert le focus, on regarde la validité de la saisie,
     * on met à jour la comboBoxPeriode (suivant l'ecart entre les deux dates),
     * on fait un effet de style avec la ProgressBar et on rend invisible
     * le composant panelCalendrierDateDebut.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textFieldDateDebutFocusLost(java.awt.event.FocusEvent evt) {
        reculeStyleSaisieDateDebut();
        panelCalendrierDateDebut.setVisible(false);
        textFieldDateDebut.setText(panelCalendrierDateDebut.getDateSelectionnee().toStringJourMoisAnnee());
        if (panelCalendrierDateDebut.getDateSelectionnee().compareTo(panelCalendrierDateFin.getDateSelectionnee()) > 0){
            styleSaisieDateDebut.setForeground(Color.RED);
            textFieldDateDebut.setForeground(Color.RED);
            styleSaisieDateFin.setForeground(Color.RED);
            textFieldDateFin.setForeground(Color.RED);
            labelDateFin.setIcon(new ImageIcon("ressources\\iconFlecheBarree.png"));
        } else {
            styleSaisieDateDebut.setForeground(new Color(0,120,215));
            textFieldDateDebut.setForeground(Color.BLACK);
            styleSaisieDateFin.setForeground(new Color(0,120,215));
            textFieldDateFin.setForeground(Color.BLACK);
            labelDateFin.setIcon(new ImageIcon("ressources\\iconFleche.png"));
            int nbJourPeriode = panelCalendrierDateDebut.getDateSelectionnee().nbJourEntre(panelCalendrierDateFin.getDateSelectionnee());
            if (nbJourPeriode < 31){
                comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour"}));
            } else if (nbJourPeriode < 180){
                comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine"}));
            } else if(nbJourPeriode < 1825){
                comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois"}));
            } else if (nbJourPeriode < 7300){
                comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois", "1 année"}));
            } else if (nbJourPeriode < 18250){
                comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois", "1 année", "5 années"}));
            } else if (nbJourPeriode < 182500){
                comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois", "1 année", "5 années", "10 années"}));
            } else {
                comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois", "1 année", "5 années", "10 années", "1 siècle"}));
            }
        }
    }

    /**
     * Methode permettant de gérer les événements de la souris du textFieldDateDebut.
     * Quand la souris est appuyée sur le composant, on surligne le texte.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.MouseEvent
     */
    private void textFieldDateDebutMousePressed(java.awt.event.MouseEvent evt) {
        textFieldDateDebut.setSelectionStart(0);
        textFieldDateDebut.setSelectionEnd(textFieldDateDebut.getText().length());
    }

    /**
     * Methode permettant de gérer les événements du clavier du textFieldDateDebut.
     * Quand une touche est tapée sur le composant, on change la couleur de la saisie,
     * et on analyse la saisie pour la transformer en date.
     * Si la touche tapée est Entrée ou Echap, on controle la validité de la saisie,
     * on met à jour la comboBoxPeriode (suivant l'ecart entre les deux dates),
     * et on sort du composant.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.KeyEvent
     */
    private void textFieldDateDebutKeyTyped(java.awt.event.KeyEvent evt) {
        textFieldDateDebut.setForeground(Color.BLACK);

        analyseTextFieldDateDebut();

        if ((int)evt.getKeyChar() == 10 || (int)evt.getKeyChar() == 27){
            textFieldDateDebut.setText(panelCalendrierDateDebut.getDateSelectionnee().toStringJourMoisAnnee());
            if (panelCalendrierDateDebut.getDateSelectionnee().compareTo(panelCalendrierDateFin.getDateSelectionnee()) > 0){
                styleSaisieDateDebut.setForeground(Color.RED);
                textFieldDateDebut.setForeground(Color.RED);
                styleSaisieDateFin.setForeground(Color.RED);
                textFieldDateFin.setForeground(Color.RED);
                labelDateFin.setIcon(new ImageIcon("ressources\\iconFlecheBarree.png"));
            } else {
                styleSaisieDateDebut.setForeground(new Color(0,120,215));
                textFieldDateDebut.setForeground(Color.BLACK);
                styleSaisieDateFin.setForeground(new Color(0,120,215));
                textFieldDateFin.setForeground(Color.BLACK);
                labelDateFin.setIcon(new ImageIcon("ressources\\iconFleche.png"));
                int nbJourPeriode = panelCalendrierDateDebut.getDateSelectionnee().nbJourEntre(panelCalendrierDateFin.getDateSelectionnee());
                if (nbJourPeriode < 31){
                    comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour"}));
                } else if (nbJourPeriode < 180){
                    comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine"}));
                } else if(nbJourPeriode < 1825){
                    comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois"}));
                } else if (nbJourPeriode < 7300){
                    comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois", "1 année"}));
                } else if (nbJourPeriode < 18250){
                    comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois", "1 année", "5 années"}));
                } else if (nbJourPeriode < 182500){
                    comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois", "1 année", "5 années", "10 années"}));
                } else {
                    comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois", "1 année", "5 années", "10 années", "1 siècle"}));
                }
            }
            requestFocus();
        }
    }

    /**
     * Methode permettant de gérer le focus du textFieldDateFin.
     * Quand le composant gagne le focus, on fait un effet de style
     * avec la ProgressBar et on rend visible le composant panelCalendrierDateFin.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textFieldDateFinFocusGained(java.awt.event.FocusEvent evt) {
        avanceStyleSaisieDateFin();
        panelCalendrierDateFin.setVisible(true);
    }

    /**
     * Methode permettant de gérer le focus du textFieldDateFin.
     * Quand le composant pert le focus, on regarde la validité de la saisie,
     * on met à jour la comboBoxPeriode (suivant l'ecart entre les deux dates),
     * on fait un effet de style avec la ProgressBar et on rend invisible
     * le composant panelCalendrierDateFin.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textFieldDateFinFocusLost(java.awt.event.FocusEvent evt) {
        reculeStyleSaisieDateFin();
        panelCalendrierDateFin.setVisible(false);
        textFieldDateFin.setText(panelCalendrierDateFin.getDateSelectionnee().toStringJourMoisAnnee());
        if (panelCalendrierDateDebut.getDateSelectionnee().compareTo(panelCalendrierDateFin.getDateSelectionnee()) > 0){
            styleSaisieDateDebut.setForeground(Color.RED);
            textFieldDateDebut.setForeground(Color.RED);
            styleSaisieDateFin.setForeground(Color.RED);
            textFieldDateFin.setForeground(Color.RED);
            labelDateFin.setIcon(new ImageIcon("ressources\\iconFlecheBarree.png"));
        } else {
            styleSaisieDateDebut.setForeground(new Color(0,120,215));
            textFieldDateDebut.setForeground(Color.BLACK);
            styleSaisieDateFin.setForeground(new Color(0,120,215));
            textFieldDateFin.setForeground(Color.BLACK);
            labelDateFin.setIcon(new ImageIcon("ressources\\iconFleche.png"));
            int nbJourPeriode = panelCalendrierDateDebut.getDateSelectionnee().nbJourEntre(panelCalendrierDateFin.getDateSelectionnee());
            if (nbJourPeriode < 31){
                comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour"}));
            } else if (nbJourPeriode < 180){
                comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine"}));
            } else if(nbJourPeriode < 1825){
                comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois"}));
            } else if (nbJourPeriode < 7300){
                comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois", "1 année"}));
            } else if (nbJourPeriode < 18250){
                comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois", "1 année", "5 années"}));
            } else if (nbJourPeriode < 182500){
                comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois", "1 année", "5 années", "10 années"}));
            } else {
                comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois", "1 année", "5 années", "10 années", "1 siècle"}));
            }
        }
    }

    /**
     * Methode permettant de gérer les événements de la souris du textFieldDateFin.
     * Quand la souris est appuyée sur le composant, on surligne le texte.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.MouseEvent
     */
    private void textFieldDateFinMousePressed(java.awt.event.MouseEvent evt) {
        textFieldDateFin.setSelectionStart(0);
        textFieldDateFin.setSelectionEnd(textFieldDateFin.getText().length());
    }

    /**
     * Methode permettant de gérer les événements du clavier du textFieldDateFin.
     * Quand une touche est tapée sur le composant, on change la couleur de la saisie,
     * et on analyse la saisie pour la transformer en date.
     * Si la touche tapée est Entrée ou Echap, on controle la validité de la saisie,
     * on met à jour la comboBoxPeriode (suivant l'ecart entre les deux dates),
     * et on sort du composant.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.KeyEvent
     */
    private void textFieldDateFinKeyTyped(java.awt.event.KeyEvent evt) {
        textFieldDateFin.setForeground(Color.BLACK);

        analyseTextFieldDateFin();

        if ((int)evt.getKeyChar() == 10 || (int)evt.getKeyChar() == 27){
            textFieldDateFin.setText(panelCalendrierDateFin.getDateSelectionnee().toStringJourMoisAnnee());
            if (panelCalendrierDateDebut.getDateSelectionnee().compareTo(panelCalendrierDateFin.getDateSelectionnee()) > 0){
                styleSaisieDateDebut.setForeground(Color.RED);
                textFieldDateDebut.setForeground(Color.RED);
                styleSaisieDateFin.setForeground(Color.RED);
                textFieldDateFin.setForeground(Color.RED);
                labelDateFin.setIcon(new ImageIcon("ressources\\iconFlecheBarree.png"));
            } else {
                styleSaisieDateDebut.setForeground(new Color(0,120,215));
                textFieldDateDebut.setForeground(Color.BLACK);
                styleSaisieDateFin.setForeground(new Color(0,120,215));
                textFieldDateFin.setForeground(Color.BLACK);
                labelDateFin.setIcon(new ImageIcon("ressources\\iconFleche.png"));
                int nbJourPeriode = panelCalendrierDateDebut.getDateSelectionnee().nbJourEntre(panelCalendrierDateFin.getDateSelectionnee());
                if (nbJourPeriode < 31){
                    comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour"}));
                } else if (nbJourPeriode < 180){
                    comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine"}));
                } else if(nbJourPeriode < 1825){
                    comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois"}));
                } else if (nbJourPeriode < 7300){
                    comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois", "1 année"}));
                } else if (nbJourPeriode < 18250){
                    comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois", "1 année", "5 années"}));
                } else if (nbJourPeriode < 182500){
                    comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois", "1 année", "5 années", "10 années"}));
                } else {
                    comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour", "1 semaine", "1 mois", "1 année", "5 années", "10 années", "1 siècle"}));
                }
            }
            requestFocus();
        }
    }

    /**
     * Methode permettant de gérer le focus de la comboBoxPeriode.
     * Quand le composant gagne le focus, on fait un effet de style
     * avec la ProgressBar.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void comboBoxPeriodeFocusGained(java.awt.event.FocusEvent evt) {
        avanceStyleSaisiePeriode();
    }

    /**
     * Methode permettant de gérer le focus de la comboBoxPeriode.
     * Quand le composant pert le focus, on regarde la validité de la saisie,
     * et on fait un effet de style avec la ProgressBar.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void comboBoxPeriodeFocusLost(java.awt.event.FocusEvent evt) {
        if (comboBoxPeriode.getSelectedIndex() == 0){
            comboBoxPeriode.setForeground(Color.RED);
            styleSaisiePeriode.setForeground(Color.RED);
        } else {
            comboBoxPeriode.setForeground(Color.BLACK);
            styleSaisiePeriode.setForeground(new Color(0,120,215));
        }
        reculeStyleSaisiePeriode();
    }

    /**
     * Methode permettant de gérer le focus du textFieldDossier.
     * Quand le composant gagne le focus, on fait un effet de style
     * avec la ProgressBar et on met le cusreur au début du composant.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textFieldDossierFocusGained(java.awt.event.FocusEvent evt) {
        avanceStyleSaisieDossier();
        if (textFieldDossier.getText().equals("Saisir chemin de sauvegarde")){
            textFieldDossier.setCaretPosition(0);
        }
    }

    /**
     * Methode permettant de gérer le focus du textFieldDossier.
     * Quand le composant pert le focus, on regarde la validité de la saisie,
     * et on fait un effet de style avec la ProgressBar.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textFieldDossierFocusLost(java.awt.event.FocusEvent evt) {
        File fileDossier = new File(textFieldDossier.getText());
        if ((!(fileDossier.exists()) || !(fileDossier.isDirectory())) && !(textFieldDossier.getText().equals("Saisir le chemin de sauvegarde"))) {
            textFieldDossier.setForeground(Color.RED);
            styleSaisieDossier.setForeground(Color.RED);
        } else {
            if (textFieldDossier.getText().equals("Saisir le chemin de sauvegarde")){
                textFieldDossier.setForeground(Color.LIGHT_GRAY);
            } else {
                textFieldDossier.setForeground(Color.BLACK);
            }
            styleSaisieDossier.setForeground(new Color(0,120,215));
        }
        reculeStyleSaisieDossier();
    }

    /**
     * Methode permettant de gérer les événements de la souris du textFieldDossier.
     * Quand la souris est appuyée sur le composant, on regarde si la saisie est "vide"
     * et on colorie le composant d'une certaine couleur.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.MouseEvent
     */
    private void textFieldDossierMousePressed(java.awt.event.MouseEvent evt) {
        if (textFieldDossier.getText().equals("Saisir le chemin de sauvegarde")){
            textFieldDossier.setCaretPosition(0);
            textFieldDossier.setSelectionColor(Color.WHITE);
            textFieldDossier.setSelectedTextColor(Color.LIGHT_GRAY);
        } else {
            textFieldDossier.setSelectionColor(new Color(0,120,215));
            textFieldDossier.setSelectedTextColor(Color.WHITE);
        }
    }

    /**
     * Methode permettant de gérer les événements de la souris du textFieldDossier.
     * Quand la souris est relachée sur le composant, on regarde si la saisie est "vide"
     * et on met le curseur au debut du composant.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.MouseEvent
     */
    private void textFieldDossierMouseReleased(java.awt.event.MouseEvent evt) {
        if (textFieldDossier.getText().equals("Saisir le chemin de sauvegarde")){
            textFieldDossier.setCaretPosition(0);
        }
    }

    /**
     * Methode permettant de gérer les événements du clavier du textFieldDossier.
     * Quand une touche est tapée sur le composant, on regarde si elle a pour but d'écrire
     * (donc pas des touches comme Entrée ou Suppr) et on change la couleur de la saisie.
     * Si la touche tapée est Entrée ou Echap, on controle la validité de la saisie
     * et on sort du composant.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.KeyEvent
     */
    private void textFieldDossierKeyTyped(java.awt.event.KeyEvent evt) throws IOException, UnsupportedFlavorException {
        if (!((int)evt.getKeyChar() == 8 || (int)evt.getKeyChar() == 27 || (int)evt.getKeyChar() == 1 || (int)evt.getKeyChar() == 10)){
            textFieldDossier.setFont(new Font("Open Sans", Font.PLAIN, 14));
        }

        if (textFieldDossier.getText().equals("Saisir le chemin de sauvegarde") && !((int)evt.getKeyChar() == 8 || (int)evt.getKeyChar() == 27 || (int)evt.getKeyChar() == 1 || (int)evt.getKeyChar() == 10)){
            textFieldDossier.setText("");
            textFieldDossier.setForeground(Color.BLACK);
        } else if (textFieldDossier.getText().equals("")){
            textFieldDossier.setText("Saisir le chemin de sauvegarde");
            textFieldDossier.setFont(new Font("Open Sans", Font.PLAIN, 24));
            textFieldDossier.setForeground(Color.LIGHT_GRAY);
            textFieldDossier.setCaretPosition(0);
        } else if (!(textFieldDossier.getText().equals("")) && !(textFieldDossier.getText().equals("Saisir le chemin de sauvegarde"))){
            textFieldDossier.setSelectionColor(new Color(0,120,215));
            textFieldDossier.setSelectedTextColor(Color.WHITE);
        }
        if ((int)evt.getKeyChar() == 127 && textFieldDossier.getText().equals("aisir le chemin de sauvegarde")){
            textFieldDossier.setText("Saisir le chemin de sauvegarde");
            textFieldDossier.setFont(new Font("Open Sans", Font.PLAIN, 24));
            textFieldDossier.setCaretPosition(0);
        }
        if ((int)evt.getKeyChar() == 27 || (int)evt.getKeyChar() == 10){
            File fileDossier = new File(textFieldDossier.getText());
            if (!(fileDossier.exists()) || !(fileDossier.isDirectory())) {
                textFieldDossier.setForeground(Color.RED);
                styleSaisieDossier.setForeground(Color.RED);
            } else {
                textFieldDossier.setForeground(Color.BLACK);
                styleSaisieDossier.setForeground(new Color(0,120,215));
            }
            requestFocus();
        }
        if ((int)evt.getKeyChar() == 1 && textFieldDossier.getText().equals("Saisir le chemin de sauvegarde")){
            textFieldDossier.setCaretPosition(0);
        }
        if ((int)evt.getKeyChar() == 22 && textFieldDossier.getText().equals((String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor) + "Saisir le chemin de sauvegarde")){
            textFieldDossier.setText("");
            textFieldDossier.setForeground(Color.BLACK);
            textFieldDossier.setText((String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
        }
    }

    /**
     * Methode permettant de gérer les événements du boutonParcourirDossier.
     * Quand le bouton est appuyé, on affiche le sélectionneur de fichier
     * et on attend de récupérer le dossier sélectionné. Si le dossier
     * n'est pas null, on l'affiche dans le textFieldDossier.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.ActionEvent
     */
    private void boutonParcourirDossierActionPerformed(java.awt.event.ActionEvent evt) {
        fileChooserDossier.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooserDossier.setAcceptAllFileFilterUsed(false);
        fileChooserDossier.showOpenDialog(this);
        File file = fileChooserDossier.getSelectedFile();

        if (file != null && file.isDirectory()){
            textFieldDossier.setText(file.toString());
            textFieldDossier.setForeground(Color.black);
            styleSaisieDossier.setForeground(new Color(0,120,215));
            textFieldDossier.setFont(new Font("Open Sans", Font.PLAIN, 14));
        }
    }

    /**
     * Methode permettant de gérer le focus du textFieldImage.
     * Quand le composant gagne le focus, on fait un effet de style
     * avec la ProgressBar et on met le cusreur au début du composant.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textFieldImageFocusGained(java.awt.event.FocusEvent evt) {
        avanceStyleSaisieImage();
        if (textFieldImage.getText().equals("Saisir le chemin de l'image")){
            textFieldImage.setCaretPosition(0);
        }
    }

    /**
     * Methode permettant de gérer le focus du textFieldImage.
     * Quand le composant pert le focus, on regarde la validité de la saisie,
     * et on fait un effet de style avec la ProgressBar.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textFieldImageFocusLost(java.awt.event.FocusEvent evt) {
        File fileImage = new File(textFieldImage.getText());
        if (!(estUneImage(fileImage)) && !(textFieldImage.getText().equals("Saisir le chemin de l'image"))) {
            textFieldImage.setForeground(Color.RED);
            styleSaisieImage.setForeground(Color.RED);
        } else {
            if (textFieldImage.getText().equals("Saisir le chemin de l'image")){
                textFieldImage.setForeground(Color.LIGHT_GRAY);
            } else {
                textFieldImage.setForeground(Color.BLACK);
            }
            styleSaisieImage.setForeground(new Color(0,120,215));
        }
        reculeStyleSaisieImage();
    }

    /**
     * Methode permettant de gérer les événements de la souris du textFieldImage.
     * Quand la souris est appuyée sur le composant, on regarde si la saisie est "vide"
     * et on colorie le composant d'une certaine couleur.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.MouseEvent
     */
    private void textFieldImageMousePressed(java.awt.event.MouseEvent evt) {
        if (textFieldImage.getText().equals("Saisir le chemin de l'image")){
            textFieldImage.setCaretPosition(0);
            textFieldImage.setSelectionColor(Color.WHITE);
            textFieldImage.setSelectedTextColor(Color.LIGHT_GRAY);
        } else {
            textFieldImage.setSelectionColor(new Color(0,120,215));
            textFieldImage.setSelectedTextColor(Color.WHITE);
        }
    }

    /**
     * Methode permettant de gérer les événements de la souris du textFieldImage.
     * Quand la souris est relachée sur le composant, on regarde si la saisie est "vide"
     * et on met le curseur au debut du composant.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.MouseEvent
     */
    private void textFieldImageMouseReleased(java.awt.event.MouseEvent evt) {
        if (textFieldImage.getText().equals("Saisir le chemin de l'image")){
            textFieldImage.setCaretPosition(0);
        }
    }

    /**
     * Methode permettant de gérer les événements du clavier du textFieldImage.
     * Quand une touche est tapée sur le composant, on regarde si elle a pour but d'écrire
     * (donc pas des touches comme Entrée ou Suppr) et on change la couleur de la saisie.
     * Si la touche tapée est Entrée ou Echap, on controle la validité de la saisie
     * et on sort du composant.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.KeyEvent
     */
    private void textFieldImageKeyTyped(java.awt.event.KeyEvent evt) throws IOException, UnsupportedFlavorException {
        if (!((int)evt.getKeyChar() == 8 || (int)evt.getKeyChar() == 27 || (int)evt.getKeyChar() == 1 || (int)evt.getKeyChar() == 10)){
            textFieldImage.setFont(new Font("Open Sans", Font.PLAIN, 14));
        }

        if (textFieldImage.getText().equals("Saisir le chemin de l'image") && !((int)evt.getKeyChar() == 8 || (int)evt.getKeyChar() == 27 || (int)evt.getKeyChar() == 1 || (int)evt.getKeyChar() == 10)){
            textFieldImage.setText("");
            textFieldImage.setForeground(Color.BLACK);
        } else if (textFieldImage.getText().equals("")){
            textFieldImage.setText("Saisir le chemin de l'image");
            labelImageAffiche.setIcon(new ImageIcon("ressources\\iconImageAffiche.png"));
            textFieldImage.setFont(new Font("Open Sans", Font.PLAIN, 24));
            textFieldImage.setForeground(Color.LIGHT_GRAY);
            textFieldImage.setCaretPosition(0);
        } else if (!(textFieldImage.getText().equals("")) && !(textFieldImage.getText().equals("Saisir le chemin de l'image"))){
            textFieldImage.setSelectionColor(new Color(0,120,215));
            textFieldImage.setSelectedTextColor(Color.WHITE);
        }
        if ((int)evt.getKeyChar() == 127 && textFieldImage.getText().equals("aisir le chemin de l'image")){
            textFieldImage.setText("Saisir le chemin de l'image");
            textFieldImage.setFont(new Font("Open Sans", Font.PLAIN, 24));
            textFieldImage.setCaretPosition(0);
        }
        if ((int)evt.getKeyChar() == 27 || (int)evt.getKeyChar() == 10){
            File fileImage = new File(textFieldImage.getText());
            if (!(textFieldImage.getText().equals("Saisir le chemin de l'image")) && !(estUneImage(fileImage))) {
                textFieldImage.setForeground(Color.RED);
                styleSaisieImage.setForeground(Color.RED);
            } else {
                textFieldImage.setForeground(Color.BLACK);
                styleSaisieImage.setForeground(new Color(0,120,215));
            }
            requestFocus();
        }
        if ((int)evt.getKeyChar() == 1 && textFieldImage.getText().equals("Saisir le chemin de l'image")){
            textFieldImage.setCaretPosition(0);
        }
        if ((int)evt.getKeyChar() == 22 && textFieldImage.getText().equals((String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor) + "Saisir le chemin de l'image")){
            textFieldImage.setText("");
            textFieldImage.setForeground(Color.BLACK);
            textFieldImage.setText((String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
        }

        String[] partieChemin = textFieldImage.getText().split("\\\\");
        String chemin = "";
        for (int i = 0; i < partieChemin.length; i++) {
            chemin += partieChemin[i];
            if (i < partieChemin.length - 1){
                chemin += File.separator;
            }
        }
        File file = new File(chemin);
        if (estUneImage(file)){
            ImageIcon icon = resizeImage(new ImageIcon(file.getPath()), 180, 100);
            labelImageAffiche.setIcon(icon);
        } else {
            labelImageAffiche.setIcon(new ImageIcon("ressources\\iconImageAffiche.png"));
        }
    }

    /**
     * Methode permettant de gérer les événements du boutonParcourirImage.
     * Quand le bouton est appuyé, on affiche le sélectionneur de fichier
     * et on attend de récupérer le fichier sélectionné. Si le fichier
     * n'est pas null et est une image, on l'affiche dans le textFieldImage
     * et on modifie le labelImageAffiche en lui mettant l'image sélectionné.
     *
     * @param evt l'événement en question
     *
     * @see java.awt.event.ActionEvent
     */
    private void boutonParcourirImageActionPerformed(java.awt.event.ActionEvent evt) {
        fileChooserImage.showOpenDialog(this);
        File file = fileChooserImage.getSelectedFile();

        if (file != null && estUneImage(file)){
            ImageIcon icon = resizeImage(new ImageIcon(file.getPath()), 180, 100);
            labelImageAffiche.setIcon(icon);
            textFieldImage.setText(fileChooserImage.getSelectedFile().toString());
            textFieldImage.setForeground(Color.black);
            styleSaisieImage.setForeground(new Color(0,120,215));
            textFieldImage.setFont(new Font("Open Sans", Font.PLAIN, 14));
        }
    }

    /**
     * Cette methode fait tous les tests necessaires pour regarder si
     * la chronologie saisie est valide ou non.
     * Si des éléments saisie par l'utilisateur ne sont pas valides,
     * un message d'erreur apparait en listant les champs à corriger.
     *
     * @return Si la chronologie saisie est valide ou non.
     */
    public boolean estValide(){
        String erreur = "";
        boolean valide = true;

        JOptionPane optionPane = new JOptionPane("Vérification en cours...", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, null, null);
        JDialog messageVerification = new JDialog();
        messageVerification.setTitle("Vérification");
        messageVerification.setSize(200,200);
        messageVerification.setResizable(false);
        messageVerification.setLocationRelativeTo(null);
        messageVerification.setContentPane(optionPane);
        messageVerification.pack();
        messageVerification.validate();
        messageVerification.repaint();
        messageVerification.setVisible(true);

        SavesChronologie listeChronologie = (SavesChronologie) LectureEcriture.lecture(SavesChronologie.FILE);
        listeChronologie.verification();
        for (int i = 0; i < listeChronologie.size(); i++) {
            Chronologie chronologie = (Chronologie) LectureEcriture.lecture(new File(listeChronologie.get(i)));
            if (chronologie.getIntitule().equals(textFieldIntitule.getText()) || textFieldIntitule.getText().equals("Saisir le nom de la frise")){
                textFieldIntitule.setForeground(Color.RED);
                styleSaisieIntitule.setForeground(Color.RED);
                erreur += "- Le nom de la frise est vide ou existe déjà\n";
                valide = false;
                break;
            }
        }
        if (textFieldIntitule.getText().contains("\"") || textFieldIntitule.getText().contains("\\")
                || textFieldIntitule.getText().contains("/") || textFieldIntitule.getText().contains("<") || textFieldIntitule.getText().contains(">")
                || textFieldIntitule.getText().contains(":") || textFieldIntitule.getText().contains("?") || textFieldIntitule.getText().contains("*")){
            textFieldIntitule.setForeground(Color.RED);
            styleSaisieIntitule.setForeground(Color.RED);
            erreur  += "- Le nom de la frise ne peut pas contenir les caractères suivants :\n\" \\ / | < > : ? *\n";
            valide = false;
        }
        if (panelCalendrierDateDebut.getDateSelectionnee().compareTo(panelCalendrierDateFin.getDateSelectionnee()) > 0){
            styleSaisieDateDebut.setForeground(Color.RED);
            textFieldDateDebut.setForeground(Color.RED);
            styleSaisieDateFin.setForeground(Color.RED);
            textFieldDateFin.setForeground(Color.RED);
            labelDateFin.setIcon(new ImageIcon("ressources\\iconFlecheBarree.png"));
            erreur += "- Les dates entrées ne sont pas correctes\n";
            valide = false;
        }
        if (comboBoxPeriode.getSelectedIndex() == 0){
            comboBoxPeriode.setForeground(Color.RED);
            styleSaisiePeriode.setForeground(Color.RED);
            erreur += "- Il faut sélectionner une période\n";
            valide = false;
        }
        File fileDossier = new File(textFieldDossier.getText());
        if (textFieldDossier.getText().equals("Saisir le chemin de sauvegarde") || !(fileDossier.exists()) || !(fileDossier.isDirectory())){
            textFieldDossier.setForeground(Color.RED);
            styleSaisieDossier.setForeground(Color.RED);
            erreur += "- Le chemin donné n'existe pas ou n'est pas un dossier\n";
            valide = false;
        }
        File fileImage = new File(textFieldImage.getText());
        if (!(textFieldImage.getText().equals("Saisir le chemin de l'image")) && !(estUneImage(fileImage))){
            textFieldImage.setForeground(Color.RED);
            styleSaisieImage.setForeground(Color.RED);
            erreur += "- Le fichier donné n'existe pas ou n'est pas une image\n";
            valide = false;
        }
        messageVerification.dispose();
        if (!valide){
            JOptionPane.showMessageDialog(this, erreur, "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return valide;
    }

    /**
     * Cette methode remet à 0 tous les champs du panel.
     */
    public void reset(){
        textFieldIntitule.setText("Saisir le nom de la frise");
        textFieldIntitule.setForeground(Color.LIGHT_GRAY);
        textFieldIntitule.setFont(new Font("Open Sans", Font.PLAIN, 24));
        styleSaisieIntitule.setForeground(new Color(0,120,215));

        textFieldDateDebut.setText(new Date().toStringJourMoisAnnee());
        textFieldDateDebut.setForeground(Color.LIGHT_GRAY);
        styleSaisieDateDebut.setForeground(new Color(0,120,215));
        panelCalendrierDateDebut.setDate(new Date());

        labelDateFin.setIcon(new ImageIcon("ressources\\iconFleche.png"));

        textFieldDateFin.setText(new Date().toStringJourMoisAnnee());
        textFieldDateFin.setForeground(Color.LIGHT_GRAY);
        styleSaisieDateFin.setForeground(new Color(0,120,215));
        panelCalendrierDateFin.setDate(new Date());

        comboBoxPeriode.setModel(new DefaultComboBoxModel<>(new String[] {"--Sélectionner une période--", "1 jour"}));
        comboBoxPeriode.setForeground(Color.BLACK);
        styleSaisiePeriode.setForeground(new Color(0,120,215));

        textFieldDossier.setText("Saisir le chemin de sauvegarde");
        textFieldDossier.setForeground(Color.LIGHT_GRAY);
        textFieldDossier.setFont(new Font("Open Sans", Font.PLAIN, 24));
        styleSaisieDossier.setForeground(new Color(0,120,215));

        textFieldImage.setText("Saisir le chemin de l'image");
        textFieldImage.setForeground(Color.LIGHT_GRAY);
        textFieldImage.setFont(new Font("Open Sans", Font.PLAIN, 24));
        styleSaisieImage.setForeground(new Color(0,120,215));

        labelImageAffiche.setIcon(new ImageIcon("ressources\\iconImageAffiche.png"));
    }

    /**
     * Cette methode permet d'enregistrer une chronologie avec les champs
     * que l'utilisateur a saisie.
     *
     * @return une chronologie qui comporte tous les champs
     * que l'utilisateur a renseigné
     */
    public Chronologie enregistreChronologie(){
        if (textFieldImage.getText().equals("Saisir le chemin de l'image")){
            return new Chronologie(textFieldIntitule.getText(), panelCalendrierDateDebut.getDateSelectionnee(), panelCalendrierDateFin.getDateSelectionnee(), comboBoxPeriode.getSelectedIndex()-1, textFieldDossier.getText());

        } else {
            return new Chronologie(textFieldIntitule.getText(), panelCalendrierDateDebut.getDateSelectionnee(), panelCalendrierDateFin.getDateSelectionnee(), comboBoxPeriode.getSelectedIndex()-1, textFieldDossier.getText(), textFieldImage.getText());
        }
    }

    /**
     * Cette methode permet de dire si un fichier est une image ou non.
     *
     * @param file le fichier que l'on souhaite tester
     * @return Si oui ou non le fichier donné en parametre est une image ou pas.
     */
    private static boolean estUneImage(File file){
        String chemin = file.toString();
        String extension = chemin.split("\\.")[chemin.split("\\.").length-1];
        return file.exists() && (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg") || extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("bmp") || extension.equalsIgnoreCase("tiff"));
    }

    /**
     * Cette methode permet de redimensionner une image qu'on donne en paramettre.
     *
     * @param icon l'icon a redimensionner
     * @param largeur la largeur souhaité
     * @param hauteur la hauteur souhaité
     * @return l'icon redimensionnée
     */
    private ImageIcon resizeImage(ImageIcon icon, int largeur, int hauteur){
        int largeurOrigine = icon.getImage().getWidth(labelImageAffiche);
        int hauteurOrigine = icon.getImage().getHeight(labelImageAffiche);
        float ratio;
        if ((float)largeur / largeurOrigine < (float)hauteur / hauteurOrigine){
            ratio = (float) largeur / largeurOrigine;
        } else {
            ratio = (float) hauteur / hauteurOrigine;
        }
        return new ImageIcon(icon.getImage().getScaledInstance((int)(largeurOrigine * ratio),(int)(hauteurOrigine * ratio), Image.SCALE_REPLICATE));
    }

    /**
     * Cette methode permet de dire si un texte (en String) est un entier ou non.
     *
     * @param texte le texte que l'on souhaite tester
     * @return si oui ou non un texte est un entier ou pas
     */
    private static boolean estUnEntier(String texte){
        if (texte == null || texte.length() == 0){
            return false;
        }
        try {
            int nb = Integer.parseInt(texte);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    /**
     * Cette methode analyse le contenu du textFieldDateDebut
     * pour comprendre quelle date est saisie par l'utilisateur.
     */
    private void analyseTextFieldDateDebut(){
        String[] texte = textFieldDateDebut.getText().split(" ");

        if (estUnEntier(texte[0]) && Integer.parseInt(texte[0]) <= Date.dernierJourDuMois(panelCalendrierDateDebut.getDateSelectionnee().getMois(), panelCalendrierDateDebut.getDateSelectionnee().getAnnee())){
            panelCalendrierDateDebut.setDate(new Date(Integer.parseInt(texte[0]), panelCalendrierDateDebut.getDateSelectionnee().getMois(), panelCalendrierDateDebut.getDateSelectionnee().getAnnee()));
            if (texte.length >= 2){
                for (int i = 0; i < Date.MOIS_DE_L_ANNEE.length; i++){
                    if (Date.MOIS_DE_L_ANNEE[i].length() >= texte[1].length() && texte[1].equalsIgnoreCase(Date.MOIS_DE_L_ANNEE[i].substring(0, texte[1].length()))){
                        panelCalendrierDateDebut.setDate(new Date(panelCalendrierDateDebut.getDateSelectionnee().getJour(), i+1, panelCalendrierDateDebut.getDateSelectionnee().getAnnee()));
                        break;
                    }
                }
                if (texte.length >= 3 && estUnEntier(texte[2]) && Integer.parseInt(texte[2]) >= 1582){
                    panelCalendrierDateDebut.setDate(new Date(panelCalendrierDateDebut.getDateSelectionnee().getJour(), panelCalendrierDateDebut.getDateSelectionnee().getMois(), Integer.parseInt(texte[2])));
                }
            }
        } else if (estUnEntier(texte[0]) && Integer.parseInt(texte[0]) <= 31){
            Date dateTemp = panelCalendrierDateDebut.getDateSelectionnee();
            while (Date.dernierJourDuMois(dateTemp.getMois(), dateTemp.getAnnee()) < Integer.parseInt(texte[0])){
                dateTemp = dateTemp.moisSuivant();
            }
            panelCalendrierDateDebut.setDate(new Date(Integer.parseInt(texte[0]), dateTemp.getMois(), dateTemp.getAnnee()));
        } else if (!estUnEntier(texte[0])){
            for (int i = 0; i < Date.MOIS_DE_L_ANNEE.length; i++){
                if (Date.MOIS_DE_L_ANNEE[i].length() >= texte[0].length() && texte[0].equalsIgnoreCase(Date.MOIS_DE_L_ANNEE[i].substring(0, texte[0].length()))){
                    panelCalendrierDateDebut.setDate(new Date(1, i+1, panelCalendrierDateDebut.getDateSelectionnee().getAnnee()));
                    break;
                }
            }
            if (texte.length >= 2 && estUnEntier(texte[1]) && Integer.parseInt(texte[1]) >= 1582){
                panelCalendrierDateDebut.setDate(new Date(1, panelCalendrierDateDebut.getDateSelectionnee().getMois(), Integer.parseInt(texte[1])));
            }
        } else if (estUnEntier(texte[0]) && Integer.parseInt(texte[0]) >= 1582){
            panelCalendrierDateDebut.setDate(new Date(1, 1, Integer.parseInt(texte[0])));
        }
    }

    /**
     * Cette methode analyse le contenu du textFieldDateFin
     * pour comprendre quelle date est saisie par l'utilisateur.
     */
    private void analyseTextFieldDateFin(){
        String[] texte = textFieldDateFin.getText().split(" ");

        if (estUnEntier(texte[0]) && Integer.parseInt(texte[0]) <= Date.dernierJourDuMois(panelCalendrierDateFin.getDateSelectionnee().getMois(), panelCalendrierDateFin.getDateSelectionnee().getAnnee())){
            panelCalendrierDateFin.setDate(new Date(Integer.parseInt(texte[0]), panelCalendrierDateFin.getDateSelectionnee().getMois(), panelCalendrierDateFin.getDateSelectionnee().getAnnee()));
            if (texte.length >= 2){
                for (int i = 0; i < Date.MOIS_DE_L_ANNEE.length; i++){
                    if (Date.MOIS_DE_L_ANNEE[i].length() >= texte[1].length() && texte[1].equalsIgnoreCase(Date.MOIS_DE_L_ANNEE[i].substring(0, texte[1].length()))){
                        panelCalendrierDateFin.setDate(new Date(panelCalendrierDateFin.getDateSelectionnee().getJour(), i+1, panelCalendrierDateFin.getDateSelectionnee().getAnnee()));
                        break;
                    }
                }
                if (texte.length >= 3 && estUnEntier(texte[2]) && Integer.parseInt(texte[2]) >= 1582){
                    panelCalendrierDateFin.setDate(new Date(panelCalendrierDateFin.getDateSelectionnee().getJour(), panelCalendrierDateFin.getDateSelectionnee().getMois(), Integer.parseInt(texte[2])));
                }
            }
        } else if (estUnEntier(texte[0]) && Integer.parseInt(texte[0]) <= 31){
            Date dateTemp = panelCalendrierDateFin.getDateSelectionnee();
            while (Date.dernierJourDuMois(dateTemp.getMois(), dateTemp.getAnnee()) < Integer.parseInt(texte[0])){
                dateTemp = dateTemp.moisSuivant();
            }
            panelCalendrierDateFin.setDate(new Date(Integer.parseInt(texte[0]), dateTemp.getMois(), dateTemp.getAnnee()));
        } else if (!estUnEntier(texte[0])){
            for (int i = 0; i < Date.MOIS_DE_L_ANNEE.length; i++){
                if (Date.MOIS_DE_L_ANNEE[i].length() >= texte[0].length() && texte[0].equalsIgnoreCase(Date.MOIS_DE_L_ANNEE[i].substring(0, texte[0].length()))){
                    panelCalendrierDateFin.setDate(new Date(1, i+1, panelCalendrierDateFin.getDateSelectionnee().getAnnee()));
                    break;
                }
            }
            if (texte.length >= 2 && estUnEntier(texte[1]) && Integer.parseInt(texte[1]) >= 1582){
                panelCalendrierDateFin.setDate(new Date(1, panelCalendrierDateFin.getDateSelectionnee().getMois(), Integer.parseInt(texte[1])));
            }
        } else if (estUnEntier(texte[0]) && Integer.parseInt(texte[0]) >= 1582){
            panelCalendrierDateFin.setDate(new Date(1, 1, Integer.parseInt(texte[0])));
        }
    }

    /**
     * Cette methode permet de faire l'effet de style avec la ProgressBar
     * (l'avancement) pour le composant textFieldIntitule.
     */
    private void avanceStyleSaisieIntitule(){
        timerStyleSaisieIntitule.cancel();
        timerStyleSaisieIntitule.purge();
        java.util.TimerTask timerTask = new java .util.TimerTask() {
            public void run() {
                if (styleSaisieIntitule.getValue() < 100)
                    styleSaisieIntitule.setValue(styleSaisieIntitule.getValue()+1);
                else{
                    timerStyleSaisieIntitule.cancel();
                    timerStyleSaisieIntitule.purge();
                }
            }
        };
        timerStyleSaisieIntitule = new java.util.Timer();
        timerStyleSaisieIntitule.scheduleAtFixedRate(timerTask, 0, 2);
    }

    /**
     * Cette methode permet de faire l'effet de style avec la ProgressBar
     * (le reculement) pour le composant textFieldIntitule.
     */
    private void reculeStyleSaisieIntitule(){
        timerStyleSaisieIntitule.cancel();
        timerStyleSaisieIntitule.purge();
        java.util.TimerTask timerTask = new java .util.TimerTask() {
            public void run() {
                if (styleSaisieIntitule.getValue() > 0)
                    styleSaisieIntitule.setValue(styleSaisieIntitule.getValue()-1);
                else {
                    timerStyleSaisieIntitule.cancel();
                    timerStyleSaisieIntitule.purge();
                }
            }
        };
        timerStyleSaisieIntitule = new java.util.Timer();
        timerStyleSaisieIntitule.scheduleAtFixedRate(timerTask, 0, 2);
    }

    /**
     * Cette methode permet de faire l'effet de style avec la ProgressBar
     * (l'avancement) pour le composant textFieldDateDebut.
     */
    private void avanceStyleSaisieDateDebut(){
        timerStyleSaisieDateDebut.cancel();
        timerStyleSaisieDateDebut.purge();
        java.util.TimerTask timerTask = new java .util.TimerTask() {
            public void run() {
                if (styleSaisieDateDebut.getValue() < 100)
                    styleSaisieDateDebut.setValue(styleSaisieDateDebut.getValue()+1);
                else{
                    timerStyleSaisieDateDebut.cancel();
                    timerStyleSaisieDateDebut.purge();
                }
            }
        };
        timerStyleSaisieDateDebut = new java.util.Timer();
        timerStyleSaisieDateDebut.scheduleAtFixedRate(timerTask, 0, 2);
    }

    /**
     * Cette methode permet de faire l'effet de style avec la ProgressBar
     * (le reculement) pour le composant textFieldDateDebut.
     */
    private void reculeStyleSaisieDateDebut(){
        timerStyleSaisieDateDebut.cancel();
        timerStyleSaisieDateDebut.purge();
        java.util.TimerTask timerTask = new java .util.TimerTask() {
            public void run() {
                if (styleSaisieDateDebut.getValue() > 0)
                    styleSaisieDateDebut.setValue(styleSaisieDateDebut.getValue()-1);
                else {
                    timerStyleSaisieDateDebut.cancel();
                    timerStyleSaisieDateDebut.purge();
                }
            }
        };
        timerStyleSaisieDateDebut = new java.util.Timer();
        timerStyleSaisieDateDebut.scheduleAtFixedRate(timerTask, 0, 2);
    }

    /**
     * Cette methode permet de faire l'effet de style avec la ProgressBar
     * (l'avancement) pour le composant textFieldDateFin.
     */
    private void avanceStyleSaisieDateFin(){
        timerStyleSaisieDateFin.cancel();
        timerStyleSaisieDateFin.purge();
        java.util.TimerTask timerTask = new java .util.TimerTask() {
            public void run() {
                if (styleSaisieDateFin.getValue() < 100)
                    styleSaisieDateFin.setValue(styleSaisieDateFin.getValue()+1);
                else{
                    timerStyleSaisieDateFin.cancel();
                    timerStyleSaisieDateFin.purge();
                }
            }
        };
        timerStyleSaisieDateFin = new java.util.Timer();
        timerStyleSaisieDateFin.scheduleAtFixedRate(timerTask, 0, 2);
    }

    /**
     * Cette methode permet de faire l'effet de style avec la ProgressBar
     * (le reculement) pour le composant textFieldDateFin.
     */
    private void reculeStyleSaisieDateFin(){
        timerStyleSaisieDateFin.cancel();
        timerStyleSaisieDateFin.purge();
        java.util.TimerTask timerTask = new java .util.TimerTask() {
            public void run() {
                if (styleSaisieDateFin.getValue() > 0)
                    styleSaisieDateFin.setValue(styleSaisieDateFin.getValue()-1);
                else {
                    timerStyleSaisieDateFin.cancel();
                    timerStyleSaisieDateFin.purge();
                }
            }
        };
        timerStyleSaisieDateFin = new java.util.Timer();
        timerStyleSaisieDateFin.scheduleAtFixedRate(timerTask, 0, 2);
    }

    /**
     * Cette methode permet de faire l'effet de style avec la ProgressBar
     * (l'avancement) pour le composant comboBoxPeriode.
     */
    private void avanceStyleSaisiePeriode(){
        timerStyleSaisiePeriode.cancel();
        timerStyleSaisiePeriode.purge();
        java.util.TimerTask timerTask = new java .util.TimerTask() {
            public void run() {
                if (styleSaisiePeriode.getValue() < 100)
                    styleSaisiePeriode.setValue(styleSaisiePeriode.getValue()+1);
                else {
                    timerStyleSaisiePeriode.cancel();
                    timerStyleSaisiePeriode.purge();
                }
            }
        };
        timerStyleSaisiePeriode = new java.util.Timer();
        timerStyleSaisiePeriode.scheduleAtFixedRate(timerTask, 0, 2);
    }

    /**
     * Cette methode permet de faire l'effet de style avec la ProgressBar
     * (le reculement) pour le composant comboBoxPeriode.
     */
    private void reculeStyleSaisiePeriode(){
        timerStyleSaisiePeriode.cancel();
        timerStyleSaisiePeriode.purge();
        java.util.TimerTask timerTask = new java .util.TimerTask() {
            public void run() {
                if (styleSaisiePeriode.getValue() > 0)
                    styleSaisiePeriode.setValue(styleSaisiePeriode.getValue()-1);
                else {
                    timerStyleSaisiePeriode.cancel();
                    timerStyleSaisiePeriode.purge();
                }
            }
        };
        timerStyleSaisiePeriode = new java.util.Timer();
        timerStyleSaisiePeriode.scheduleAtFixedRate(timerTask, 0, 2);
    }

    /**
     * Cette methode permet de faire l'effet de style avec la ProgressBar
     * (l'avancement) pour le composant textFieldDossier.
     */
    private void avanceStyleSaisieDossier(){
        timerStyleSaisieDossier.cancel();
        timerStyleSaisieDossier.purge();
        java.util.TimerTask timerTask = new java .util.TimerTask() {
            public void run() {
                if (styleSaisieDossier.getValue() < 100)
                    styleSaisieDossier.setValue(styleSaisieDossier.getValue()+1);
                else {
                    timerStyleSaisieDossier.cancel();
                    timerStyleSaisieDossier.purge();
                }
            }
        };
        timerStyleSaisieDossier = new java.util.Timer();
        timerStyleSaisieDossier.scheduleAtFixedRate(timerTask, 0, 2);
    }

    /**
     * Cette methode permet de faire l'effet de style avec la ProgressBar
     * (le reculement) pour le composant textFieldDossier.
     */
    private void reculeStyleSaisieDossier(){
        timerStyleSaisieDossier.cancel();
        timerStyleSaisieDossier.purge();
        java.util.TimerTask timerTask = new java .util.TimerTask() {
            public void run() {
                if (styleSaisieDossier.getValue() > 0)
                    styleSaisieDossier.setValue(styleSaisieDossier.getValue()-1);
                else {
                    timerStyleSaisieDossier.cancel();
                    timerStyleSaisieDossier.purge();
                }
            }
        };
        timerStyleSaisieDossier = new java.util.Timer();
        timerStyleSaisieDossier.scheduleAtFixedRate(timerTask, 0, 2);
    }

    /**
     * Cette methode permet de faire l'effet de style avec la ProgressBar
     * (l'avancement) pour le composant textFieldImage.
     */
    private void avanceStyleSaisieImage(){
        timerStyleSaisieImage.cancel();
        timerStyleSaisieImage.purge();
        java.util.TimerTask timerTask = new java .util.TimerTask() {
            public void run() {
                if (styleSaisieImage.getValue() < 100)
                    styleSaisieImage.setValue(styleSaisieImage.getValue()+1);
                else {
                    timerStyleSaisieImage.cancel();
                    timerStyleSaisieImage.purge();
                }
            }
        };
        timerStyleSaisieImage = new java.util.Timer();
        timerStyleSaisieImage.scheduleAtFixedRate(timerTask, 0, 2);
    }

    /**
     * Cette methode permet de faire l'effet de style avec la ProgressBar
     * (le reculement) pour le composant textFieldImage.
     */
    private void reculeStyleSaisieImage(){
        timerStyleSaisieImage.cancel();
        timerStyleSaisieImage.purge();
        java.util.TimerTask timerTask = new java .util.TimerTask() {
            public void run() {
                if (styleSaisieImage.getValue() > 0)
                    styleSaisieImage.setValue(styleSaisieImage.getValue()-1);
                else {
                    timerStyleSaisieImage.cancel();
                    timerStyleSaisieImage.purge();
                }
            }
        };
        timerStyleSaisieImage = new java.util.Timer();
        timerStyleSaisieImage.scheduleAtFixedRate(timerTask, 0, 2);
    }

    /**
     * Getter de panelCalendrierDateDebut.
     *
     * @return le panelCalendrierDateDebut
     */
    public PanelCalendrierDate getPanelCalendrierDateDebut(){
        return panelCalendrierDateDebut;
    }

    /**
     * Getter de panelCalendrierDateFin.
     *
     * @return le panelCalendrierDateFin
     */
    public PanelCalendrierDate getPanelCalendrierDateFin(){
        return panelCalendrierDateFin;
    }

    /**
     * Getter de textFieldDateDebut.
     *
     * @return le textFieldDateDebut
     */
    public JTextField getTextFieldDateDebut(){
        return textFieldDateDebut;
    }

    /**
     * Getter de textFieldDateFin.
     *
     * @return le textFieldDateFin
     */
    public JTextField getTextFieldDateFin(){
        return textFieldDateFin;
    }

    /**
     * Getter de buttonAjouter.
     *
     * @return le buttonAjouter
     */
    public JButton getButtonAjouter() {
        return buttonAjouter;
    }
}
