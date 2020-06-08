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

    public int compareTo(Evenement event){
        int resultat = date.compareTo(event.getDate());
        if(resultat==0)
            return resultat;

        resultat=titre.compareTo(event.getTitre());
        if(resultat==0)
            return resultat;

        resultat=poids-event.getPoids();
        if(resultat==0)
            return resultat;

        resultat=texteDescriptif.compareTo(event.getTexteDescriptif());
        return resultat;
    }

    public String toString(){
        return "Evenement du " + date.toString() + " : " + titre + "\nDe poids : " + poids + "\n" + texteDescriptif;
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
