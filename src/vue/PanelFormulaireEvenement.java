/*
 * Created by JFormDesigner on Tue Jun 16 15:52:53 CEST 2020
 */

package vue;

import controleur.ControleurPanelFormulaireEvenement;
import modele.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Blor
 */
public class PanelFormulaireEvenement extends JPanel {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Blor
    private JTextField textFieldIntitule;
    private JProgressBar styleSaisieIntitule;
    private JTextField textFieldDate;
    private PanelCalendrierDate panelCalendrierDate;
    private JProgressBar styleSaisieDate;
    private JComboBox<String> comboBoxPoids;
    private JProgressBar styleSaisiePoids;
    private JTextField textFieldImage;
    private JProgressBar styleSaisieImage;
    private JLabel labelDescription;
    private JScrollPane scrollPaneTextAreaDescription;
    private JTextArea textAreaDescription;
    private JLabel labelAffichageImage;
    private JButton buttonAjouter;
    private JComboBox<String> comboBoxSelectionFrise;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public PanelFormulaireEvenement() {
        initComponents();
        new ControleurPanelFormulaireEvenement(this);
    }

    private void textFieldIntituleFocusGained(FocusEvent e) {
        avanceStyleSaisieIntitule();
        if (textFieldIntitule.getText().equals("Saisir le nom de l'événement")){
            textFieldIntitule.setCaretPosition(0);
        }
    }

    private void textFieldIntituleFocusLost(FocusEvent e) {
        reculeStyleSaisieIntitule();
    }

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

    private void textFieldIntituleMouseReleased(MouseEvent e) {
        if (textFieldIntitule.getText().equals("Saisir le nom de l'événement")){
            textFieldIntitule.setCaretPosition(0);
        }
    }

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
            requestFocus();
        }
        if ((int)e.getKeyChar() == 1 && textFieldIntitule.getText().equals("Saisir le nom de l'événement")){
            textFieldIntitule.setCaretPosition(0);
        }
    }

    private void textFieldDateFocusGained(FocusEvent e) {
        avanceStyleSaisieDate();
        labelDescription.setVisible(false);
        scrollPaneTextAreaDescription.setVisible(false);
        panelCalendrierDate.setVisible(true);
    }

    private void textFieldDateFocusLost(FocusEvent e) {
        reculeStyleSaisieDate();
        panelCalendrierDate.setVisible(false);
        labelDescription.setVisible(true);
        scrollPaneTextAreaDescription.setVisible(true);
        textFieldDate.setText(panelCalendrierDate.getDateSelectionnee().toStringJourMoisAnnee());
    }

    private void textFieldDateMousePressed(MouseEvent e) {
        textFieldDate.setSelectionStart(0);
        textFieldDate.setSelectionEnd(textFieldDate.getText().length());
    }

    private void textFieldDateKeyTyped(KeyEvent e) {
        textFieldDate.setForeground(Color.BLACK);

        analyseTextFieldDate();

        if ((int)e.getKeyChar() == 10 || (int)e.getKeyChar() == 27){
            textFieldDate.setText(panelCalendrierDate.getDateSelectionnee().toStringJourMoisAnnee());
            requestFocus();
        }
    }

    private void comboBoxPoidsFocusGained(FocusEvent e) {
        avanceStyleSaisiePoids();
    }

    private void comboBoxPoidsFocusLost(FocusEvent e) {
        reculeStyleSaisiePoids();
    }

    private void textFieldImageFocusGained(FocusEvent e) {
        avanceStyleSaisieImage();
        if (textFieldImage.getText().equals("Saisir le chemin de l'image")){
            textFieldImage.setCaretPosition(0);
        }
    }

    private void textFieldImageFocusLost(FocusEvent e) {
        reculeStyleSaisieImage();
    }

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

    private void textFieldImageMouseReleased(MouseEvent e) {
        if (textFieldImage.getText().equals("Saisir le chemin de l'image")){
            textFieldImage.setCaretPosition(0);
        }
    }

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

    private void textAreaDescriptionFocusGained(FocusEvent e) {
        scrollPaneTextAreaDescription.setBorder(new TitledBorder(new LineBorder(new Color(0,120,215), 4, true), "Description", TitledBorder.LEADING, TitledBorder.TOP,
                new Font("Open Sans", Font.PLAIN, 18), new Color(0,120,215)));
    }

    private void textAreaDescriptionFocusLost(FocusEvent e) {
        scrollPaneTextAreaDescription.setBorder(new TitledBorder(new LineBorder(Color.lightGray, 2, true), "Description", TitledBorder.LEADING, TitledBorder.TOP,
                new Font("Open Sans", Font.PLAIN, 18), Color.lightGray));
    }

    private static boolean estUneImage(File file){
        String chemin = file.toString();
        String extension = chemin.split("\\.")[chemin.split("\\.").length-1];
        extension = extension.toLowerCase();
        return file.exists() && (extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png") || extension.equals("bmp") || extension.equals("tiff"));
    }

    private ImageIcon resizeImage(ImageIcon icon, int largeur, int hauteur){
        int largeurOrigine = icon.getImage().getWidth(labelAffichageImage);
        int hauteurOrigine = icon.getImage().getHeight(labelAffichageImage);
        float ratio;
        if (largeurOrigine - largeur > hauteurOrigine - hauteur){
            ratio = (float) largeur / largeurOrigine;
        } else {
            ratio = (float) hauteur / hauteurOrigine;
        }
        return new ImageIcon(icon.getImage().getScaledInstance((int)(largeurOrigine * ratio),(int)(hauteurOrigine * ratio), Image.SCALE_REPLICATE));
    }

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

    public PanelCalendrierDate getPanelCalendrierDate() {
        return panelCalendrierDate;
    }

    public JTextField getTextFieldDate() {
        return textFieldDate;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Blor
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
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
        javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax
        . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
        .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans.
        PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .
        equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private Timer timerStyleSaisieIntitule = new Timer();
    private Timer timerStyleSaisieDate = new Timer();
    private Timer timerStyleSaisiePoids = new Timer();
    private Timer timerStyleSaisieImage = new Timer();
}
