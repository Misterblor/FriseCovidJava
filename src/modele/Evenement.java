package modele;

public class Evenement {
    private Date date;
    private String titre;
    private int poids;
    private String texteDescriptif;

    public Evenement(Date parDate, String parTitre, int parPoids, String parTexteDescriptif){
        date = parDate;
        titre = parTitre;
        poids = parPoids;
        texteDescriptif = parTexteDescriptif;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public String getTexteDescriptif() {
        return texteDescriptif;
    }

    public void setTexteDescriptif(String texteDescriptif) {
        this.texteDescriptif = texteDescriptif;
    }
}
