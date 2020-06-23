package vue;

import modele.Chronologie;
import modele.Evenement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * <b>Panel s'occupant de l'affichage des Evenements.<br>
 * Panel fils de PanelAffichage.<br>
 * Appartiens au package vue.</b>
 *
 * @see JPanel
 *
 * @author Antoine Limerutti
 *
 * @version 1.0
 */
public class PanelAffichageEvenement extends JPanel implements ActionListener {
    /**
     * Entier correspondant � l'indice de l'�v�nement affich�.
     */
    private int indiceEventUtil;

    /**
     * Chronologie dont on tire les �v�nements  � afficher.
     *
     * @see Chronologie
     */
    private Chronologie frise;

    /**
     * JLabel contenant le titre de l'�v�nement.
     *
     * @see JLabel
     */
    private JLabel labelIntitule;

    /**
     * JLabel contenant la date de l'�v�nement.
     *
     * @see JLabel
     */
    private JLabel labelDate;

    /**
     * JLabel contenant l'image de l'�v�nement.
     *
     * @see JLabel
     */
    private JLabel labelImage;

    /**
     * JLabel contenant le texte descriptif de l'�v�nement.
     *
     * @see JLabel
     */
    private JLabel labelDesc;

    /**
     * Panel contenant la table synchronis�e avec le PanelAffichageEvenement.
     *
     * @see PanelAffichageTable
     */
    private PanelAffichageTable affichageTable;

    /**
     * Constructeur du PanelAffichageEvenement.
     *
     * @param parFrise Chronologie dont on veut afficher les �v�nements.
     *
     * @author Antoine Limerutti
     *
     * @see Chronologie
     */
    public PanelAffichageEvenement(Chronologie parFrise) {
        setLayout(new GridBagLayout());

        frise = parFrise;

        Iterator<Evenement> iterateur = frise.getListeEvt().iterator();

        labelImage = new JLabel();
        labelIntitule = new JLabel();
        labelDate = new JLabel();
        labelDesc = new JLabel();
        reinitEvent(0);

        GridBagConstraints contrainte = new GridBagConstraints();
        contrainte.insets = new Insets(0,6,0,6);

        contrainte.anchor=GridBagConstraints.CENTER;
        contrainte.gridx=0;
        contrainte.gridy=0;
        contrainte.gridheight=3;
        add(labelImage, contrainte);

        JScrollPane scrollPaneIntitule = new JScrollPane(labelIntitule, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneIntitule.setPreferredSize(new Dimension(560,40));
        scrollPaneIntitule.setBorder(null);

        contrainte.anchor=GridBagConstraints.LINE_START;
        contrainte.gridx=1;
        contrainte.gridy=0;
        contrainte.gridheight=1;
        add(scrollPaneIntitule, contrainte);

        labelDate.setPreferredSize(new Dimension(560,40));
        contrainte.gridx=1;
        contrainte.gridy=1;
        add(labelDate, contrainte);

        JScrollPane scrollPaneDesc = new JScrollPane(labelDesc, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneDesc.setPreferredSize(new Dimension(560,70));
        scrollPaneDesc.setBorder(null);

        contrainte.gridx=1;
        contrainte.gridy=2;
        add(scrollPaneDesc, contrainte);
    }

    /**
     * Traite les actions internes � la classe PanelAffichageEvenement (changer l'�v�nement affich�).
     *
     * @param event Evenement � traiter.
     *
     * @see ActionEvent
     *
     * @author Antoine Limerutti
     */
    public void actionPerformed(ActionEvent event) {
        if (frise.getNbEvent() != 0) {
            if (event.getActionCommand().equals("precedent")) {
                if (indiceEventUtil == 0) {
                    reinitEvent(frise.getNbEvent() - 1);
                } else {
                    reinitEvent(indiceEventUtil - 1);
                }
            } else if (event.getActionCommand().equals("suivant"))
                reinitEvent((indiceEventUtil + 1) % frise.getNbEvent());
            affichageTable.setCol(frise.getDateDebut(), frise.get(indiceEventUtil).getDate(), frise.getPeriode(), frise.get(indiceEventUtil).getPoids());
        }
    }

    /**
     * R�initialise les labels pour afficher l'�v�nement courant
     *
     * @param indice indice de l'�v�nement � afficher (depuis la TreeSet d'�v�nement de la classe Chronologie).
     */
    public void reinitEvent(int indice){
        if(indice != -1 && indice<frise.getNbEvent()) {
            indiceEventUtil = indice;
            Evenement event = frise.get(indice);

            labelImage.setIcon(resizeImage(event.getImage(), 120, 120));

            String intitule = "<html><h3>" + event.getTitre() + "</h3></html>";
            String date = "<html><h3>" + event.getDate() + "</h3></html>";

            String description = "<html>";

            StringTokenizer stSpace = new StringTokenizer(event.getTexteDescriptif(), " ");
            StringTokenizer stRetourChariot;
            String token;

            for(int i=0; stSpace.hasMoreTokens(); i++){
                token = stSpace.nextToken();

                if(i%11==0 && i!=0)
                    description+=token + "<br>";
                else if(token.contains("\n")){
                    stRetourChariot = new StringTokenizer(token, "\n");
                    if(stRetourChariot.countTokens()==2)
                        description+=stRetourChariot.nextToken() + "<br>" + stRetourChariot.nextToken() + " ";
                    i=0;
                }
                else
                    description+=token + " ";
            }

            description += "</html>";

            labelIntitule.setText(intitule);
            labelIntitule.setFont(new Font("Open Sans", 0, 14));
            labelDate.setText(date);
            labelDate.setFont(new Font("Open Sans", 0, 14));
            labelDesc.setText(description);
            labelDesc.setFont(new Font("Open Sans", 0, 14));

            validate();
            repaint();
        }
    }

    /**
     * Retaille l'objet ImageIcon fournis en param�tre et la retourne.
     *
     * @param icon ImageIcon � retailler.
     * @param largeur taille max en largeur.
     * @param hauteur taille max en heuteur.
     *
     * @return ImageIcon ayant une taille correcte.
     *
     * @author Pablo Rican
     *
     * @see ImageIcon
     */
    private ImageIcon resizeImage(ImageIcon icon, int largeur, int hauteur){
        int largeurOrigine = icon.getImage().getWidth(labelImage);
        int hauteurOrigine = icon.getImage().getHeight(labelImage);
        float ratio;
        if ((float)largeur / largeurOrigine < (float)hauteur / hauteurOrigine){
            ratio = (float) largeur / largeurOrigine;
        } else {
            ratio = (float) hauteur / hauteurOrigine;
        }
        return new ImageIcon(icon.getImage().getScaledInstance((int)(largeurOrigine * ratio),(int)(hauteurOrigine * ratio), Image.SCALE_REPLICATE));
    }

    /**
     * Modifieur du champ affichageTable.
     *
     * @param affichageTable PanelAffichageTable � affecter au champ PanelAffichageTable.
     *
     * @author Antoine Limerutti
     *
     * @see PanelAffichageTable
     */
    public void setAffichageTable(PanelAffichageTable affichageTable) {
        this.affichageTable = affichageTable;
    }
}
