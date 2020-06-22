package vue;

import controleur.ControleurPanelFormulaireEvenement;
import modele.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Iterator;
import java.util.Timer;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * <b>
 *     Cette classe permet d'afficher un formulaire permettant d'ajouter un événement à une frise chronologique.<br>
 *     Appartient au package vue.
 * </b>
 *
 * @author Pablo RICAN
 *
 * @see JPanel
 *
 * @version 1.0
 */
public class PanelFormulaireEvenement extends JPanel {

    /**
     * Champ de saisie de l'intitule de l'événement
     * @see JTextField
     */
    private JTextField textFieldIntitule;

    /**
     * ProgressBar permettant de créer un effet de style
     * quand le champ de saisie de l'intitule a le focus
     * @see JProgressBar
     */
    private JProgressBar styleSaisieIntitule;

    /**
     * Champ de saisie de la date de l'événement
     * @see JTextField
     */
    private JTextField textFieldDate;

    /**
     * PanelCalendrierDate permettant de saisir la date de l'événement
     * @see PanelCalendrierDate
     */
    private PanelCalendrierDate panelCalendrierDate;

    /**
     * ProgressBar permettant de créer un effet de style
     * quand le champ de saisie de la date a le focus
     * @see JProgressBar
     */
    private JProgressBar styleSaisieDate;

    /**
     * ComboBox permettant de sélectionner le poids de l'événement
     * @see JComboBox
     */
    private JComboBox<String> comboBoxPoids;

    /**
     * ProgressBar permettant de créer un effet de style
     * quand le champ de saisie du poids a le focus
     * @see JProgressBar
     */
    private JProgressBar styleSaisiePoids;

    /**
     * Champ de saisie de l'image de l'événement'
     * @see JTextField
     */
    private JTextField textFieldImage;

    /**
     * ProgressBar permettant de créer un effet de style
     * quand le champ de saisie de l'image a le focus
     * @see JProgressBar
     */
    private JProgressBar styleSaisieImage;

    /**
     * Label permettant d'afficher l'icon de la description
     * @see JLabel
     */
    private JLabel labelDescription;

    /**
     * ScrollPane contenant le textArea description
     * @see JScrollPane
     */
    private JScrollPane scrollPaneTextAreaDescription;

    /**
     * TextArea permettant de saisir la description de l'événement
     * @see JTextArea
     */
    private JTextArea textAreaDescription;

    /**
     * Label permettant d'afficher l'image choisie par l'utilisateur
     * @see JLabel
     */
    private JLabel labelAffichageImage;

    /**
     * Bouton permettant d'enregistrer un nouvel événement
     * @see JButton
     */
    private JButton buttonAjouter;

    /**
     * ComboBox permettant de sélectionner la frise dans laquelle
     * on souhaite enregistrer l'événement
     * @see JComboBox
     */
    private JComboBox<String> comboBoxSelectionFrise;

    /**
     * Timer permettant d'utiliser la ProgressBar styleSaisieIntitule
     * @see java.util.Timer
     */
    private Timer timerStyleSaisieIntitule = new Timer();

    /**
     * Timer permettant d'utiliser la ProgressBar styleSaisieDate
     * @see java.util.Timer
     */
    private Timer timerStyleSaisieDate = new Timer();

    /**
     * Timer permettant d'utiliser la ProgressBar styleSaisiePoids
     * @see java.util.Timer
     */
    private Timer timerStyleSaisiePoids = new Timer();

    /**
     * Timer permettant d'utiliser la ProgressBar styleSaisieImage
     * @see java.util.Timer
     */
    private Timer timerStyleSaisieImage = new Timer();

    /**
     * Constructeur de la classe PanelFormulaireEvenement,
     * permet d'initialiser et de placer tout les composants graphiques.
     * Instancie un controleur permettant de gérer les dates avec le PanelCalendrierDate
     * et le textFieldDate
     *
     * @see ControleurPanelFormulaireEvenement
     */
    public PanelFormulaireEvenement() {
        initComponents();
        new ControleurPanelFormulaireEvenement(this);
        requestFocus();
    }

    /**
     * Cette methode a été généré par le logiciel IntelliJ IDEA grâce au plugin JFormDesigner
     * et permet de placer tous les composants graphiques sur le panel de manière précise.
     * Elle permet aussi de déclarer les methodes gérant les événements pour les composant s'ils en ont besoin.
     *
     * @see GroupLayout
     */
    private void initComponents() {
        JLabel labelIntitule = new JLabel();
        textFieldIntitule = new JTextField();
        styleSaisieIntitule = new JProgressBar();
        JLabel labelDate = new JLabel();
        textFieldDate = new JTextField();
        panelCalendrierDate = new PanelCalendrierDate();
        styleSaisieDate = new JProgressBar();
        JLabel labelPoids = new JLabel();
        comboBoxPoids = new JComboBox<>();
        styleSaisiePoids = new JProgressBar();
        JLabel labelImage = new JLabel();
        textFieldImage = new JTextField();
        styleSaisieImage = new JProgressBar();
        JButton buttonParcourirImage = new JButton();
        labelDescription = new JLabel();
        scrollPaneTextAreaDescription = new JScrollPane();
        textAreaDescription = new JTextArea();
        labelAffichageImage = new JLabel();
        buttonAjouter = new JButton();
        comboBoxSelectionFrise = new JComboBox<>();

        //======== this ========
        setBorder(null);
        setBackground(Color.white);
        setPreferredSize(new Dimension(1280, 720));
        setFont(UIManager.getFont("Panel.font"));
        setForeground(Color.lightGray);

        //---- labelIntitule ----
        labelIntitule.setIcon(new ImageIcon("ressources\\iconLabelIntitule.jpg"));
        labelIntitule.setBackground(Color.white);

        //---- textFieldIntitule ----
        textFieldIntitule.setBackground(Color.white);
        textFieldIntitule.setBorder(null);
        textFieldIntitule.setForeground(Color.lightGray);
        textFieldIntitule.setText("Saisir le nom de l'\u00e9v\u00e9nement");
        textFieldIntitule.setFont(new Font("Open Sans", Font.PLAIN, 24));
        textFieldIntitule.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textFieldIntituleFocusGained(e);
            }
            @Override
            public void focusLost(FocusEvent e) {
                textFieldIntituleFocusLost(e);
            }
        });
        textFieldIntitule.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                textFieldIntituleMousePressed(e);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                textFieldIntituleMouseReleased(e);
            }
        });
        textFieldIntitule.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                textFieldIntituleKeyTyped(e);
            }
        });

        //---- styleSaisieIntitule ----
        styleSaisieIntitule.setBackground(Color.lightGray);
        styleSaisieIntitule.setForeground(new Color(0, 120, 215));
        styleSaisieIntitule.setBorder(null);

        //---- labelDate ----
        labelDate.setIcon(new ImageIcon("ressources\\iconLabelSaisieDate.png"));

        //---- textFieldDate ----
        textFieldDate.setBackground(Color.white);
        textFieldDate.setForeground(Color.lightGray);
        textFieldDate.setFont(new Font("Open Sans", Font.PLAIN, 14));
        textFieldDate.setBorder(null);
        textFieldDate.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldDate.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textFieldDateFocusGained(e);
            }
            @Override
            public void focusLost(FocusEvent e) {
                textFieldDateFocusLost(e);
            }
        });
        textFieldDate.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                textFieldDateMousePressed(e);
            }
        });
        textFieldDate.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                textFieldDateKeyTyped(e);
            }
        });
        textFieldDate.setText(panelCalendrierDate.getDateSelectionnee().toStringJourMoisAnnee());

        //---- panelCalendrierDate ----
        panelCalendrierDate.setVisible(false);

        //---- styleSaisieDate ----
        styleSaisieDate.setBackground(Color.lightGray);
        styleSaisieDate.setForeground(new Color(0, 120, 215));
        styleSaisieDate.setBorder(null);

        //---- labelPoids ----
        labelPoids.setIcon(new ImageIcon("ressources\\iconLabelPoids.png"));

        //---- comboBoxPoids ----
        comboBoxPoids.setBackground(Color.white);
        comboBoxPoids.setForeground(Color.black);
        comboBoxPoids.setFont(new Font("Open Sans", Font.PLAIN, 12));
        comboBoxPoids.setModel(new DefaultComboBoxModel<>(new String[] {
            "--S\u00e9lectionner un poids--",
            "1 - Tr\u00e8s Important",
            "2 - Important",
            "3 - Secondaire",
            "4 - Peu d'int\u00e9r\u00eat"
        }));
        comboBoxPoids.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                comboBoxPoidsFocusGained(e);
            }
            @Override
            public void focusLost(FocusEvent e) {
                comboBoxPoidsFocusLost(e);
            }
        });

        //---- styleSaisiePoids ----
        styleSaisiePoids.setOrientation(SwingConstants.VERTICAL);
        styleSaisiePoids.setBackground(Color.lightGray);
        styleSaisiePoids.setForeground(new Color(0, 120, 215));
        styleSaisiePoids.setBorder(null);

        //---- labelImage ----
        labelImage.setIcon(new ImageIcon("ressources\\iconImage.png"));

        //---- textFieldImage ----
        textFieldImage.setForeground(Color.lightGray);
        textFieldImage.setBackground(Color.white);
        textFieldImage.setBorder(null);
        textFieldImage.setText("Saisir le chemin de l'image");
        textFieldImage.setFont(new Font("Open Sans", Font.PLAIN, 24));
        textFieldImage.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textFieldImageFocusGained(e);
            }
            @Override
            public void focusLost(FocusEvent e) {
                textFieldImageFocusLost(e);
            }
        });
        textFieldImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                textFieldImageMousePressed(e);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                textFieldImageMouseReleased(e);
            }
        });
        textFieldImage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                textFieldImageKeyTyped(e);
            }
        });

        //---- styleSaisieImage ----
        styleSaisieImage.setForeground(new Color(0, 120, 215));
        styleSaisieImage.setBackground(Color.lightGray);
        styleSaisieImage.setBorder(null);

        //---- buttonParcourirImage ----
        buttonParcourirImage.setText("Parcourir");
        buttonParcourirImage.setBackground(Color.white);
        buttonParcourirImage.setFont(new Font("Open Sans", Font.PLAIN, 24));
        buttonParcourirImage.addActionListener(e -> buttonParcourirImageActionPerformed(e));

        //---- labelDescription ----
        labelDescription.setIcon(new ImageIcon("ressources\\iconLabelDescription.png"));

        //======== scrollPaneTextAreaDescription ========
        {
            scrollPaneTextAreaDescription.setBorder(new TitledBorder(new LineBorder(Color.lightGray, 2, true), "Description", TitledBorder.LEADING, TitledBorder.TOP,
                new Font("Open Sans", Font.PLAIN, 18), Color.lightGray));

            //---- textAreaDescription ----
            textAreaDescription.setBackground(Color.white);
            textAreaDescription.setForeground(Color.black);
            textAreaDescription.setLineWrap(true);
            textAreaDescription.setWrapStyleWord(true);
            textAreaDescription.setBorder(null);
            textAreaDescription.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    textAreaDescriptionFocusGained(e);
                }
                @Override
                public void focusLost(FocusEvent e) {
                    textAreaDescriptionFocusLost(e);
                }
            });
            scrollPaneTextAreaDescription.setViewportView(textAreaDescription);
        }

        //---- labelAffichageImage ----
        labelAffichageImage.setIcon(new ImageIcon("ressources\\iconImageAffiche.png"));
        labelAffichageImage.setHorizontalAlignment(SwingConstants.CENTER);

        //---- buttonAjouter ----
        buttonAjouter.setIcon(new ImageIcon("ressources\\iconBoutonAjouter.png"));
        buttonAjouter.setBorder(null);

        //---- comboBoxSelectionFrise ----
        comboBoxSelectionFrise.setBackground(Color.white);
        comboBoxSelectionFrise.setFont(new Font("Open Sans", Font.PLAIN, 14));

        SavesChronologie frises = (SavesChronologie) LectureEcriture.lecture(SavesChronologie.FILE);
        frises.verification();
        String[] intituleFrises = new String[frises.size()+1];
        intituleFrises[0]="--Sélectionner une frise--";

        Iterator<String> iterateur = frises.iterator();
        for(int i = 1; i<intituleFrises.length && iterateur.hasNext(); i++){
            intituleFrises[i] = ((Chronologie) LectureEcriture.lecture(new File(iterateur.next()))).getIntitule();
        }

        comboBoxSelectionFrise.setModel(new DefaultComboBoxModel<String>(intituleFrises));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(182, 182, 182)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(labelIntitule, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelDate, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelPoids, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelImage, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelDescription, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                    .addGap(65, 65, 65)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(scrollPaneTextAreaDescription, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelCalendrierDate, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldIntitule, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
                        .addComponent(styleSaisieIntitule, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textFieldDate, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(styleSaisieDate, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(comboBoxPoids, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(styleSaisiePoids, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(textFieldImage, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
                        .addComponent(styleSaisieImage, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonAjouter, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                            .addGap(93, 93, 93))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(comboBoxSelectionFrise, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(buttonParcourirImage, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(labelAffichageImage, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)))
                            .addGap(71, 71, 71))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(labelIntitule, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldIntitule, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxSelectionFrise, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(styleSaisieIntitule, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(labelDate, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldDate, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(styleSaisieDate, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(panelCalendrierDate, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(styleSaisiePoids, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelPoids, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBoxPoids, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelImage, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldImage, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonParcourirImage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(buttonAjouter, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelAffichageImage, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(styleSaisieImage, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(labelDescription, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPaneTextAreaDescription, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );
    }

    /**
     * Methode permettant de gérer le focus du textFieldIntitule.
     * Quand le composant gagne le focus, on fait un effet de style
     * avec la ProgressBar et on met le cusreur au début du composant.
     *
     * @param e l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textFieldIntituleFocusGained(FocusEvent e) {
        avanceStyleSaisieIntitule();
        if (textFieldIntitule.getText().equals("Saisir le nom de l'événement")){
            textFieldIntitule.setCaretPosition(0);
        }
    }

    /**
     * Methode permettant de gérer le focus du textFieldIntitule.
     * Quand le composant pert le focus, on regarde la validité de la saisie,
     * et on fait un effet de style avec la ProgressBar.
     *
     * @param e l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textFieldIntituleFocusLost(FocusEvent e) {
        if (textFieldIntitule.getText().equals("")) {
            textFieldIntitule.setForeground(Color.RED);
            styleSaisieIntitule.setForeground(Color.RED);
        } else {
            if (textFieldIntitule.getText().equals("Saisir le nom de l'événement")){
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
     * @param e l'événement en question
     *
     * @see java.awt.event.MouseEvent
     */
    private void textFieldIntituleMousePressed(MouseEvent e) {
        if (textFieldIntitule.getText().equals("Saisir le nom de l'événement")){
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
     * @param e l'événement en question
     *
     * @see java.awt.event.MouseEvent
     */
    private void textFieldIntituleMouseReleased(MouseEvent e) {
        if (textFieldIntitule.getText().equals("Saisir le nom de l'événement")){
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
     * @param e l'événement en question
     *
     * @see java.awt.event.KeyEvent
     */
    private void textFieldIntituleKeyTyped(KeyEvent e) {
        if (textFieldIntitule.getText().equals("Saisir le nom de l'événement") && !((int)e.getKeyChar() == 8 || (int)e.getKeyChar() == 27 || (int)e.getKeyChar() == 1 || (int)e.getKeyChar() == 10)){
            textFieldIntitule.setText("");
            textFieldIntitule.setForeground(Color.BLACK);
        } else if (textFieldIntitule.getText().equals("")){
            textFieldIntitule.setText("Saisir le nom de l'événement");
            textFieldIntitule.setForeground(Color.LIGHT_GRAY);
            textFieldIntitule.setCaretPosition(0);
        } else if (!(textFieldIntitule.getText().equals("")) && !(textFieldIntitule.getText().equals("Saisir le nom de l'événement"))){
            textFieldIntitule.setSelectionColor(new Color(0,120,215));
            textFieldIntitule.setSelectedTextColor(Color.WHITE);
        }
        if ((int)e.getKeyChar() == 127 && textFieldIntitule.getText().equals("aisir le nom de l'événement")){
            textFieldIntitule.setText("Saisir le nom de l'événement");
            textFieldIntitule.setCaretPosition(0);
        }
        if ((int)e.getKeyChar() == 27 || (int)e.getKeyChar() == 10){
            if (textFieldIntitule.getText().equals("")) {
                textFieldIntitule.setForeground(Color.RED);
                styleSaisieIntitule.setForeground(Color.RED);
            } else {
                textFieldIntitule.setForeground(Color.BLACK);
                styleSaisieIntitule.setForeground(new Color(0,120,215));
            }
            requestFocus();
        }
        if ((int)e.getKeyChar() == 1 && textFieldIntitule.getText().equals("Saisir le nom de l'événement")){
            textFieldIntitule.setCaretPosition(0);
        }
    }

    /**
     * Methode permettant de gérer le focus du textFieldDate.
     * Quand le composant gagne le focus, on fait un effet de style
     * avec la ProgressBar, on rend invisible les composants scrollPaneTextAreaDescription
     * et labelDescription, et on rend visible le composant panelCalendrierDate.
     *
     * @param e l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textFieldDateFocusGained(FocusEvent e) {
        avanceStyleSaisieDate();
        labelDescription.setVisible(false);
        scrollPaneTextAreaDescription.setVisible(false);
        panelCalendrierDate.setVisible(true);
    }

    /**
     * Methode permettant de gérer le focus du textFieldDate.
     * Quand le composant pert le focus, on fait un effet de style avec la ProgressBar,
     * on rend visible les composants scrollPaneTextAreaDescription et labelDescription,
     * et on rend invisible le composant panelCalendrierDate.
     *
     * @param e l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textFieldDateFocusLost(FocusEvent e) {
        reculeStyleSaisieDate();
        panelCalendrierDate.setVisible(false);
        labelDescription.setVisible(true);
        scrollPaneTextAreaDescription.setVisible(true);
        textFieldDate.setText(panelCalendrierDate.getDateSelectionnee().toStringJourMoisAnnee());
    }

    /**
     * Methode permettant de gérer les événements de la souris du textFieldDate.
     * Quand la souris est appuyée sur le composant, on surligne le texte.
     *
     * @param e l'événement en question
     *
     * @see java.awt.event.MouseEvent
     */
    private void textFieldDateMousePressed(MouseEvent e) {
        textFieldDate.setSelectionStart(0);
        textFieldDate.setSelectionEnd(textFieldDate.getText().length());
    }

    /**
     * Methode permettant de gérer les événements du clavier du textFieldDate.
     * Quand une touche est tapée sur le composant, on change la couleur de la saisie,
     * et on analyse la saisie pour la transformer en date.
     * Si la touche tapée est Entrée ou Echap, on controle la validité de la saisie,
     * et on sort du composant.
     *
     * @param e l'événement en question
     *
     * @see java.awt.event.KeyEvent
     */
    private void textFieldDateKeyTyped(KeyEvent e) {
        textFieldDate.setForeground(Color.BLACK);

        analyseTextFieldDate();

        if ((int)e.getKeyChar() == 10 || (int)e.getKeyChar() == 27){
            textFieldDate.setText(panelCalendrierDate.getDateSelectionnee().toStringJourMoisAnnee());
            if (comboBoxSelectionFrise.getSelectedIndex() > 0){
                SavesChronologie listeChronologie = (SavesChronologie) LectureEcriture.lecture(SavesChronologie.FILE);
                listeChronologie.verification();
                Chronologie[] chronologies = new Chronologie[listeChronologie.size()];
                for (int i = 0; i < listeChronologie.size(); i++) {
                    chronologies[i] = (Chronologie) LectureEcriture.lecture(new File(listeChronologie.get(i)));
                }
                if (!(panelCalendrierDate.getDateSelectionnee().compareTo(chronologies[comboBoxSelectionFrise.getSelectedIndex()-1].getDateDebut()) >= 0
                        && panelCalendrierDate.getDateSelectionnee().compareTo(chronologies[comboBoxSelectionFrise.getSelectedIndex()-1].getDateFin()) <= 0)){
                    textFieldDate.setForeground(Color.RED);
                    styleSaisieDate.setForeground(Color.RED);
                } else {
                    textFieldDate.setForeground(Color.BLACK);
                    styleSaisieDate.setForeground(new Color(0,120,215));
                }
            }
            requestFocus();
        }
    }

    /**
     * Methode permettant de gérer le focus du comboBoxPoids.
     * Quand le composant gagne le focus, on fait un effet de style avec la ProgressBar.
     *
     * @param e l'événement en question
     *
     * @see FocusEvent
     */
    private void comboBoxPoidsFocusGained(FocusEvent e) {
        avanceStyleSaisiePoids();
    }

    /**
     * Methode permettant de gérer le focus du comboBoxPoids.
     * Quand le composant perd le focus, on regarde la validité de la saisie,
     * et on fait un effet de style avec la ProgressBar.
     *
     * @param e l'événement en question
     *
     * @see FocusEvent
     */
    private void comboBoxPoidsFocusLost(FocusEvent e) {
        if (comboBoxPoids.getSelectedIndex() == 0){
            comboBoxPoids.setForeground(Color.RED);
        } else {
            comboBoxPoids.setForeground(Color.BLACK);
        }
        reculeStyleSaisiePoids();
    }

    /**
     * Methode permettant de gérer le focus du textFieldImage.
     * Quand le composant gagne le focus, on fait un effet de style
     * avec la ProgressBar et on met le cusreur au début du composant.
     *
     * @param e l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textFieldImageFocusGained(FocusEvent e) {
        avanceStyleSaisieImage();
        if (textFieldImage.getText().equals("Saisir le chemin de l'image")){
            textFieldImage.setCaretPosition(0);
        }
    }

    /**
     * Methode permettant de gérer le focus du textFieldImage.
     * Quand le composant pert le focus, on fait un effet de style avec la ProgressBar.
     *
     * @param e l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textFieldImageFocusLost(FocusEvent e) {
        reculeStyleSaisieImage();
    }

    /**
     * Methode permettant de gérer les événements de la souris du textFieldImage.
     * Quand la souris est appuyée sur le composant, on regarde si la saisie est "vide"
     * et on colorie le composant d'une certaine couleur.
     *
     * @param e l'événement en question
     *
     * @see java.awt.event.MouseEvent
     */
    private void textFieldImageMousePressed(MouseEvent e) {
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
     * @param e l'événement en question
     *
     * @see java.awt.event.MouseEvent
     */
    private void textFieldImageMouseReleased(MouseEvent e) {
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
     * @param e l'événement en question
     *
     * @see java.awt.event.KeyEvent
     */
    private void textFieldImageKeyTyped(KeyEvent e) {

        if (!((int)e.getKeyChar() == 8 || (int)e.getKeyChar() == 27 || (int)e.getKeyChar() == 1 || (int)e.getKeyChar() == 10)){
            textFieldImage.setFont(new Font("Open Sans", Font.PLAIN, 14));
        }

        if (textFieldImage.getText().equals("Saisir le chemin de l'image") && !((int)e.getKeyChar() == 8 || (int)e.getKeyChar() == 27 || (int)e.getKeyChar() == 1 || (int)e.getKeyChar() == 10)){
            textFieldImage.setText("");
            textFieldImage.setForeground(Color.BLACK);
        } else if (textFieldImage.getText().equals("")){
            textFieldImage.setText("Saisir le chemin de l'image");
            labelAffichageImage.setIcon(new ImageIcon("ressources\\iconImageAffiche.png"));
            textFieldImage.setFont(new Font("Open Sans", Font.PLAIN, 24));
            textFieldImage.setForeground(Color.LIGHT_GRAY);
            textFieldImage.setCaretPosition(0);
        } else if (!(textFieldImage.getText().equals("")) && !(textFieldImage.getText().equals("Saisir le chemin de l'image"))){
            textFieldImage.setSelectionColor(new Color(0,120,215));
            textFieldImage.setSelectedTextColor(Color.WHITE);
        }
        if ((int)e.getKeyChar() == 127 && textFieldImage.getText().equals("aisir le chemin de l'image")){
            textFieldImage.setText("Saisir le chemin de l'image");
            textFieldImage.setFont(new Font("Open Sans", Font.PLAIN, 24));
            textFieldImage.setCaretPosition(0);
        }
        if ((int)e.getKeyChar() == 27 || (int)e.getKeyChar() == 10){
            File fileImage = new File(textFieldImage.getText());
            if (textFieldImage.getText().equals("Saisir le chemin de l'image") || !(estUneImage(fileImage))){
                textFieldImage.setForeground(Color.RED);
                styleSaisieImage.setForeground(Color.RED);
            } else {
                textFieldImage.setForeground(Color.BLACK);
                styleSaisieImage.setForeground(new Color(0,120,215));
            }
            requestFocus();
        }
        if ((int)e.getKeyChar() == 1 && textFieldImage.getText().equals("Saisir le chemin de l'image")){
            textFieldImage.setCaretPosition(0);
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
            labelAffichageImage.setIcon(icon);
        } else {
            labelAffichageImage.setIcon(new ImageIcon("ressources\\iconImageAffiche.png"));
        }
    }

    /**
     * Methode permettant de gérer les événements du boutonParcourirImage.
     * Quand le bouton est appuyé, on affiche le sélectionneur de fichier
     * et on attend de récupérer le fichier sélectionné. Si le fichier
     * n'est pas null et est une image, on l'affiche dans le textFieldImage
     * et on modifie le labelAffichageImage en lui mettant l'image sélectionné.
     *
     * @param e l'événement en question
     *
     * @see java.awt.event.ActionEvent
     */
    private void buttonParcourirImageActionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();

        if (file != null && estUneImage(file)){
            ImageIcon icon = resizeImage(new ImageIcon(file.getPath()), 180, 100);
            labelAffichageImage.setIcon(icon);
            textFieldImage.setText(fileChooser.getSelectedFile().toString());
            textFieldImage.setForeground(Color.black);
            textFieldImage.setFont(new Font("Open Sans", Font.PLAIN, 14));
        }
    }

    /**
     * Methode permettant de gérer le focus du textAreaDescription.
     * Quand le composant gagne le focus, on met une nouvelle bordure
     * au scrollPaneTextAreaDescription pour avoir un effet de style.
     *
     * @param e l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textAreaDescriptionFocusGained(FocusEvent e) {
        scrollPaneTextAreaDescription.setBorder(new TitledBorder(new LineBorder(new Color(0,120,215), 4, true), "Description", TitledBorder.LEADING, TitledBorder.TOP,
                new Font("Open Sans", Font.PLAIN, 18), new Color(0,120,215)));
    }

    /**
     * Methode permettant de gérer le focus du textAreaDescription.
     * Quand le composant perd le focus, on met une nouvelle bordure
     * au scrollPaneTextAreaDescription pour avoir un effet de style.
     *
     * @param e l'événement en question
     *
     * @see java.awt.event.FocusEvent
     */
    private void textAreaDescriptionFocusLost(FocusEvent e) {
        scrollPaneTextAreaDescription.setBorder(new TitledBorder(new LineBorder(Color.lightGray, 2, true), "Description", TitledBorder.LEADING, TitledBorder.TOP,
                new Font("Open Sans", Font.PLAIN, 18), Color.lightGray));
    }

    /**
     * Methode permettant de mettre à jour le modele de la comboBoxSelectionFrise
     * en reprenant la listes des chronologies sauvegardées sur le PC.
     *
     * @param savesChronologie la liste des chronologies sauvegardées sur le PC
     */
    public void updateModelComboBoxSelectionFrise(SavesChronologie savesChronologie){
        String[] intituleFrises = new String[savesChronologie.size()+1];
        intituleFrises[0]="--Sélectionner une frise--";

        Iterator<String> iterateur = savesChronologie.iterator();
        for(int i = 1; i<intituleFrises.length && iterateur.hasNext(); i++){
            intituleFrises[i] = ((Chronologie) LectureEcriture.lecture(new File(iterateur.next()))).getIntitule();
        }
        comboBoxSelectionFrise.setModel(new DefaultComboBoxModel<>(intituleFrises));
    }

    /**
     * Cette methode fait tous les tests necessaires pour regarder si
     * l'événement saisie est valide ou non.
     * Si des éléments saisie par l'utilisateur ne sont pas valides,
     * un message d'erreur apparait en listant les champs à corriger.
     *
     * @return Si l'événement saisie est valide ou non.
     */
    public boolean estValide(){
        String erreur = "";
        boolean valide = true;
        if (textFieldIntitule.getText().equals("Saisir le nom de l'événement")){
            textFieldIntitule.setForeground(Color.RED);
            styleSaisieIntitule.setForeground(Color.RED);
            erreur += "- Le nom de l'événement est vide\n";
            valide = false;
        }
        if (comboBoxSelectionFrise.getSelectedIndex() > 0){
            comboBoxSelectionFrise.setForeground(Color.BLACK);
            SavesChronologie listeChronologie = (SavesChronologie) LectureEcriture.lecture(SavesChronologie.FILE);
            listeChronologie.verification();
            Chronologie[] chronologies = new Chronologie[listeChronologie.size()];
            for (int i = 0; i < listeChronologie.size(); i++) {
                chronologies[i] = (Chronologie) LectureEcriture.lecture(new File(listeChronologie.get(i)));
            }
            Chronologie chronologieSelectionnee = chronologies[comboBoxSelectionFrise.getSelectedIndex()-1];
            if (!(panelCalendrierDate.getDateSelectionnee().compareTo(chronologieSelectionnee.getDateDebut()) >= 0
                    && panelCalendrierDate.getDateSelectionnee().compareTo(chronologieSelectionnee.getDateFin()) <= 0)){
                textFieldDate.setForeground(Color.RED);
                styleSaisieDate.setForeground(Color.RED);
                erreur += "- La date saisie n'est pas dans les bornes de la frise choisie :\n" +
                        "Date Debut : " + chronologieSelectionnee.getDateDebut().toStringJourMoisAnnee() +
                        "\nDate Fin : " + chronologieSelectionnee.getDateFin().toStringJourMoisAnnee() + "\n";
                valide = false;
            }
            if (chronologieSelectionnee.getPeriode() == 0){
                for (int i = 0; i < chronologieSelectionnee.getListeEvt().size(); i++) {
                    if (panelCalendrierDate.getDateSelectionnee().compareTo(chronologieSelectionnee.get(i).getDate()) == 0
                            && comboBoxPoids.getSelectedIndex()-1 == chronologieSelectionnee.get(i).getPoids()){
                        textFieldDate.setForeground(Color.RED);
                        styleSaisieDate.setForeground(Color.RED);
                        erreur += "- Le poids sélectionné est déjà attribué pour cette date\n";
                        valide = false;
                    }
                }
            } else if (chronologieSelectionnee.getPeriode() == 1){
                for (int i = 0; i < chronologieSelectionnee.getListeEvt().size(); i++) {
                    if (panelCalendrierDate.getDateSelectionnee().estDansLaSemaine(chronologieSelectionnee.get(i).getDate())
                            && comboBoxPoids.getSelectedIndex()-1 == chronologieSelectionnee.get(i).getPoids()){
                        textFieldDate.setForeground(Color.RED);
                        styleSaisieDate.setForeground(Color.RED);
                        erreur += "- Le poids sélectionné est déjà attribué pour cette date\n";
                        valide = false;
                    }
                }
            } else if (chronologieSelectionnee.getPeriode() == 2){
                for (int i = 0; i < chronologieSelectionnee.getListeEvt().size(); i++) {
                    if (panelCalendrierDate.getDateSelectionnee().estDansLeMois(chronologieSelectionnee.get(i).getDate())
                            && comboBoxPoids.getSelectedIndex()-1 == chronologieSelectionnee.get(i).getPoids()){
                        textFieldDate.setForeground(Color.RED);
                        styleSaisieDate.setForeground(Color.RED);
                        erreur += "- Le poids sélectionné est déjà attribué pour cette date\n";
                        valide = false;
                    }
                }
            } else if (chronologieSelectionnee.getPeriode() == 3){
                for (int i = 0; i < chronologieSelectionnee.getListeEvt().size(); i++) {
                    if (panelCalendrierDate.getDateSelectionnee().getAnnee() == chronologieSelectionnee.get(i).getDate().getAnnee()
                            && comboBoxPoids.getSelectedIndex()-1 == chronologieSelectionnee.get(i).getPoids()){
                        textFieldDate.setForeground(Color.RED);
                        styleSaisieDate.setForeground(Color.RED);
                        erreur += "- Le poids sélectionné est déjà attribué pour cette date\n";
                        valide = false;
                    }
                }
            } else if (chronologieSelectionnee.getPeriode() == 4){
                for (int i = 0; i < chronologieSelectionnee.getListeEvt().size(); i++) {
                    if ((panelCalendrierDate.getDateSelectionnee().getAnnee()/5)*5 == (chronologieSelectionnee.get(i).getDate().getAnnee()/5)*5
                            && comboBoxPoids.getSelectedIndex()-1 == chronologieSelectionnee.get(i).getPoids()){
                        textFieldDate.setForeground(Color.RED);
                        styleSaisieDate.setForeground(Color.RED);
                        erreur += "- Le poids sélectionné est déjà attribué pour cette date\n";
                        valide = false;
                    }
                }
            } else if (chronologieSelectionnee.getPeriode() == 5){
                for (int i = 0; i < chronologieSelectionnee.getListeEvt().size(); i++) {
                    if ((panelCalendrierDate.getDateSelectionnee().getAnnee()/10)*10 == (chronologieSelectionnee.get(i).getDate().getAnnee()/10)*10
                            && comboBoxPoids.getSelectedIndex()-1 == chronologieSelectionnee.get(i).getPoids()){
                        textFieldDate.setForeground(Color.RED);
                        styleSaisieDate.setForeground(Color.RED);
                        erreur += "- Le poids sélectionné est déjà attribué pour cette date\n";
                        valide = false;
                    }
                }
            } else if (chronologieSelectionnee.getPeriode() == 6){
                for (int i = 0; i < chronologieSelectionnee.getListeEvt().size(); i++) {
                    if ((panelCalendrierDate.getDateSelectionnee().getAnnee()/100)*100 == (chronologieSelectionnee.get(i).getDate().getAnnee()/100)*100
                            && comboBoxPoids.getSelectedIndex()-1 == chronologieSelectionnee.get(i).getPoids()){
                        textFieldDate.setForeground(Color.RED);
                        styleSaisieDate.setForeground(Color.RED);
                        erreur += "- Le poids sélectionné est déjà attribué pour cette date\n";
                        valide = false;
                    }
                }
            }
        } else {
            comboBoxSelectionFrise.setForeground(Color.RED);
            erreur += "- Aucune frise n'a été choisie\n";
            valide = false;
        }
        if (comboBoxPoids.getSelectedIndex() == 0){
            comboBoxPoids.setForeground(Color.RED);
            erreur += "- Aucun poids n'a été choisi\n";
            valide = false;
        }
        File fileImage = new File(textFieldImage.getText());
        if (textFieldImage.getText().equals("Saisir le chemin de l'image") || !(estUneImage(fileImage))){
            textFieldImage.setForeground(Color.RED);
            styleSaisieImage.setForeground(Color.RED);
            erreur += "- Le chemin donné est vide, n'existe pas ou n'est pas une image\n";
            valide = false;
        }
        if (!valide){
            JOptionPane.showMessageDialog(this, erreur, "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return valide;
    }

    /**
     * Cette methode remet à 0 tous les champs du panel.
     */
    public void reset(){
        textFieldIntitule.setText("Saisir le nom de l'événement");
        textFieldIntitule.setForeground(Color.LIGHT_GRAY);
        textFieldIntitule.setFont(new Font("Open Sans", Font.PLAIN, 24));
        styleSaisieIntitule.setForeground(new Color(0,120,215));

        textFieldDate.setText(new Date().toStringJourMoisAnnee());
        textFieldDate.setForeground(Color.LIGHT_GRAY);
        styleSaisieDate.setForeground(new Color(0,120,215));
        panelCalendrierDate.setDate(new Date());

        comboBoxSelectionFrise.setForeground(Color.BLACK);
        comboBoxSelectionFrise.setSelectedIndex(0);

        comboBoxPoids.setForeground(Color.BLACK);
        comboBoxPoids.setSelectedIndex(0);
        styleSaisiePoids.setForeground(new Color(0,120,215));

        textFieldImage.setText("Saisir le chemin de l'image");
        textFieldImage.setForeground(Color.LIGHT_GRAY);
        textFieldImage.setFont(new Font("Open Sans", Font.PLAIN, 24));
        styleSaisieImage.setForeground(new Color(0,120,215));

        labelAffichageImage.setIcon(new ImageIcon("ressources\\iconImageAffiche.png"));

        textAreaDescription.setText("");
    }

    /**
     * Cette methode permet d'enregistrer un événement avec les champs
     * que l'utilisateur a saisie.
     *
     * @return un événement qui comporte tous les champs
     * que l'utilisateur a renseigné
     */
    public Evenement enregistrerEvenement(){
        return new Evenement(panelCalendrierDate.getDateSelectionnee(), textFieldIntitule.getText(), comboBoxPoids.getSelectedIndex()-1, textAreaDescription.getText(), textFieldImage.getText());
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
        extension = extension.toLowerCase();
        return file.exists() && (extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png") || extension.equals("bmp") || extension.equals("tiff"));
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
        int largeurOrigine = icon.getImage().getWidth(labelAffichageImage);
        int hauteurOrigine = icon.getImage().getHeight(labelAffichageImage);
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
     * Cette methode analyse le contenu du textFieldDate
     * pour comprendre quelle date est saisie par l'utilisateur.
     */
    private void analyseTextFieldDate(){
        String[] texte = textFieldDate.getText().split(" ");

        if (estUnEntier(texte[0]) && Integer.parseInt(texte[0]) <= modele.Date.dernierJourDuMois(panelCalendrierDate.getDateSelectionnee().getMois(), panelCalendrierDate.getDateSelectionnee().getAnnee())){
            panelCalendrierDate.setDate(new modele.Date(Integer.parseInt(texte[0]), panelCalendrierDate.getDateSelectionnee().getMois(), panelCalendrierDate.getDateSelectionnee().getAnnee()));
            if (texte.length >= 2){
                for (int i = 0; i < modele.Date.MOIS_DE_L_ANNEE.length; i++){
                    if (modele.Date.MOIS_DE_L_ANNEE[i].length() >= texte[1].length() && texte[1].equalsIgnoreCase(modele.Date.MOIS_DE_L_ANNEE[i].substring(0, texte[1].length()))){
                        panelCalendrierDate.setDate(new modele.Date(panelCalendrierDate.getDateSelectionnee().getJour(), i+1, panelCalendrierDate.getDateSelectionnee().getAnnee()));
                        break;
                    }
                }
                if (texte.length >= 3 && estUnEntier(texte[2]) && Integer.parseInt(texte[2]) >= 1582){
                    panelCalendrierDate.setDate(new modele.Date(panelCalendrierDate.getDateSelectionnee().getJour(), panelCalendrierDate.getDateSelectionnee().getMois(), Integer.parseInt(texte[2])));
                }
            }
        } else if (estUnEntier(texte[0]) && Integer.parseInt(texte[0]) <= 31){
            modele.Date dateTemp = panelCalendrierDate.getDateSelectionnee();
            while (modele.Date.dernierJourDuMois(dateTemp.getMois(), dateTemp.getAnnee()) < Integer.parseInt(texte[0])){
                dateTemp = dateTemp.moisSuivant();
            }
            panelCalendrierDate.setDate(new modele.Date(Integer.parseInt(texte[0]), dateTemp.getMois(), dateTemp.getAnnee()));
        } else if (!estUnEntier(texte[0])){
            for (int i = 0; i < modele.Date.MOIS_DE_L_ANNEE.length; i++){
                if (modele.Date.MOIS_DE_L_ANNEE[i].length() >= texte[0].length() && texte[0].equalsIgnoreCase(modele.Date.MOIS_DE_L_ANNEE[i].substring(0, texte[0].length()))){
                    panelCalendrierDate.setDate(new modele.Date(1, i+1, panelCalendrierDate.getDateSelectionnee().getAnnee()));
                    break;
                }
            }
            if (texte.length >= 2 && estUnEntier(texte[1]) && Integer.parseInt(texte[1]) >= 1582){
                panelCalendrierDate.setDate(new modele.Date(1, panelCalendrierDate.getDateSelectionnee().getMois(), Integer.parseInt(texte[1])));
            }
        } else if (estUnEntier(texte[0]) && Integer.parseInt(texte[0]) >= 1582){
            panelCalendrierDate.setDate(new Date(1, 1, Integer.parseInt(texte[0])));
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
     * (l'avancement) pour le composant textFieldDate.
     */
    private void avanceStyleSaisieDate(){
        timerStyleSaisieDate.cancel();
        timerStyleSaisieDate.purge();
        java.util.TimerTask timerTask = new java .util.TimerTask() {
            public void run() {
                if (styleSaisieDate.getValue() < 100)
                    styleSaisieDate.setValue(styleSaisieDate.getValue()+1);
                else{
                    timerStyleSaisieDate.cancel();
                    timerStyleSaisieDate.purge();
                }
            }
        };
        timerStyleSaisieDate = new java.util.Timer();
        timerStyleSaisieDate.scheduleAtFixedRate(timerTask, 0, 2);
    }

    /**
     * Cette methode permet de faire l'effet de style avec la ProgressBar
     * (le reculement) pour le composant textFieldDate.
     */
    private void reculeStyleSaisieDate(){
        timerStyleSaisieDate.cancel();
        timerStyleSaisieDate.purge();
        java.util.TimerTask timerTask = new java .util.TimerTask() {
            public void run() {
                if (styleSaisieDate.getValue() > 0)
                    styleSaisieDate.setValue(styleSaisieDate.getValue()-1);
                else {
                    timerStyleSaisieDate.cancel();
                    timerStyleSaisieDate.purge();
                }
            }
        };
        timerStyleSaisieDate = new java.util.Timer();
        timerStyleSaisieDate.scheduleAtFixedRate(timerTask, 0, 2);
    }

    /**
     * Cette methode permet de faire l'effet de style avec la ProgressBar
     * (l'avancement) pour le composant comboBoxPoids.
     */
    private void avanceStyleSaisiePoids(){
        timerStyleSaisiePoids.cancel();
        timerStyleSaisiePoids.purge();
        java.util.TimerTask timerTask = new java .util.TimerTask() {
            public void run() {
                if (styleSaisiePoids.getValue() < 100)
                    styleSaisiePoids.setValue(styleSaisiePoids.getValue()+1);
                else{
                    timerStyleSaisiePoids.cancel();
                    timerStyleSaisiePoids.purge();
                }
            }
        };
        timerStyleSaisiePoids = new java.util.Timer();
        timerStyleSaisiePoids.scheduleAtFixedRate(timerTask, 0, 2);
    }

    /**
     * Cette methode permet de faire l'effet de style avec la ProgressBar
     * (le reculement) pour le composant comboBoxPoids.
     */
    private void reculeStyleSaisiePoids(){
        timerStyleSaisiePoids.cancel();
        timerStyleSaisiePoids.purge();
        java.util.TimerTask timerTask = new java .util.TimerTask() {
            public void run() {
                if (styleSaisiePoids.getValue() > 0)
                    styleSaisiePoids.setValue(styleSaisiePoids.getValue()-1);
                else {
                    timerStyleSaisiePoids.cancel();
                    timerStyleSaisiePoids.purge();
                }
            }
        };
        timerStyleSaisiePoids = new java.util.Timer();
        timerStyleSaisiePoids.scheduleAtFixedRate(timerTask, 0, 2);
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
                else{
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
     * Getter de panelCalendrierDate.
     *
     * @return le panelCalendrierDate
     */
    public PanelCalendrierDate getPanelCalendrierDate() {
        return panelCalendrierDate;
    }

    /**
     * Getter de textFieldDate.
     *
     * @return le textFieldDate
     */
    public JTextField getTextFieldDate() {
        return textFieldDate;
    }

    /**
     * Getter de buttonAjouter.
     *
     * @return le buttonAjouter
     */
    public JButton getButtonAjouter() {
        return buttonAjouter;
    }

    /**
     * Getter de comboBoxSelectionFrise.
     *
     * @return le comboBoxSelectionFrise
     */
    public JComboBox<String> getComboBoxSelectionFrise() {
        return comboBoxSelectionFrise;
    }
}
