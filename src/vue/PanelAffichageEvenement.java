package vue;

import modele.Chronologie;
import modele.Evenement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.StringTokenizer;

public class PanelAffichageEvenement extends JPanel implements ActionListener {
    private int indiceEventUtil;
    private Chronologie frise;
    private JLabel labelIntituleDate;
    private JLabel labelImage;
    private JLabel labelDesc;
    private PanelAffichageTable affichageTable;

    public PanelAffichageEvenement(Chronologie parFrise) {
        setLayout(new GridBagLayout());

        frise = parFrise;

        Iterator<Evenement> iterateur = frise.getListeEvt().iterator();

        labelImage = new JLabel();
        labelIntituleDate = new JLabel();
        labelDesc = new JLabel();
        reinitEvent(0);

        GridBagConstraints contrainte = new GridBagConstraints();
        contrainte.insets = new Insets(6,6,6,6);

        contrainte.anchor=GridBagConstraints.CENTER;
        contrainte.gridx=0;
        contrainte.gridy=0;
        contrainte.gridheight=2;
        add(labelImage, contrainte);

        contrainte.insets = new Insets(6,6,0,6);
        contrainte.anchor=GridBagConstraints.LINE_START;
        contrainte.gridx=1;
        contrainte.gridy=0;
        contrainte.gridheight=1;
        add(labelIntituleDate, contrainte);

        JScrollPane scrollPane = new JScrollPane(labelDesc, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(460,70));
        scrollPane.setBorder(null);

        contrainte.insets = new Insets(0,6,6,6);
        contrainte.gridx=1;
        contrainte.gridy=1;
        add(scrollPane, contrainte);
    }

    public void actionPerformed(ActionEvent event) {
        if (frise.getNbEvent() != 0) {
            if (event.getActionCommand() == "precedent") {
                if (indiceEventUtil == 0) {
                    reinitEvent(frise.getNbEvent() - 1);
                } else {
                    reinitEvent(indiceEventUtil - 1);
                }
            } else if (event.getActionCommand() == "suivant")
                reinitEvent((indiceEventUtil + 1) % frise.getNbEvent());
            affichageTable.setRow(frise.getDateDebut(), frise.get(indiceEventUtil).getDate(), frise.getPeriode());
        }
    }

    public void reinitEvent(int indice){
        if(indice != -1 && indice<frise.getNbEvent()) {
            indiceEventUtil = indice;
            Evenement event = frise.get(indice);

            labelImage.setIcon(resizeImage(event.getImage(), 120, 120));

            String intituleDate = "<html><h3>" + event.getTitre() + "<br>" + event.getDate().toString() + "</h3></html>";

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
                    description+=stRetourChariot.nextToken() + "<br>" + stRetourChariot.nextToken() + " ";
                    i=0;
                }
                else
                    description+=token + " ";
            }

            description += "</html>";

            labelIntituleDate.setText(intituleDate);
            labelIntituleDate.setFont(new Font("Open Sans", 0, 14));
            labelDesc.setText(description);
            labelDesc.setFont(new Font("Open Sans", 0, 14));

            validate();
            repaint();
        }
    }

    private ImageIcon resizeImage(ImageIcon icon, int largeur, int hauteur){
        int largeurOrigine = icon.getImage().getWidth(labelImage);
        int hauteurOrigine = icon.getImage().getHeight(labelImage);
        float ratio;
        if (largeurOrigine - largeur > hauteurOrigine - hauteur){
            ratio = (float) largeur / largeurOrigine;
        } else {
            ratio = (float) hauteur / hauteurOrigine;
        }
        return new ImageIcon(icon.getImage().getScaledInstance((int)(largeurOrigine * ratio),(int)(hauteurOrigine * ratio), Image.SCALE_REPLICATE));
    }

    public void setAffichageTable(PanelAffichageTable affichageTable) {
        this.affichageTable = affichageTable;
    }
}
