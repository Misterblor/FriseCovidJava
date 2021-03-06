package modele;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * <b>Abstraction d'un date ayant un jour, un mois et une ann�e.<br>
 * Appartient au package modele.<br>
 * Cette classe est serialisable.</b>
 * 
 * @author Antoine Limerutti / Pablo Rican
 * 
 * @see Serializable
 * 
 * @version 1.0
 */
public class Date implements Comparable<Date>, Serializable {
	/**
	 * Num�ro du jour.
	 */
	private int jour;
	
	/**
	 * Num�ro du mois.
	 */
	private int mois;
	
	/**
	 * Num�ro de l'ann�e.
	 */
  private int annee;
  
	/**
	 * Num�ro du jour de la semaine.
	 */
  private int jourSemaine ;

  public static final String[] MOIS_DE_L_ANNEE = {"Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Decembre"};
  
	/**
	 * Cr�e un objet Date � la date courante.
	 * 
	 * @author Antoine Limerutti / Pablo Rican
	 * 
	 */
  public Date()   {
	  GregorianCalendar dateAuj = new GregorianCalendar();
	  annee = dateAuj.get (Calendar.YEAR);
	  mois = dateAuj.get (Calendar.MONTH)+1; // janvier = 0, fevrier = 1...
	  jour = dateAuj.get (Calendar.DAY_OF_MONTH);
	  jourSemaine = dateAuj.get (Calendar.DAY_OF_WEEK);
  }
  
	/**
	 * Cr�e un objet Date au jour, au mois et � l'ann�e fourni, d�termine �galement le jour de la semaine correspondant.
	 * 
	 * @param parJour jour � donner � la date.
	 * @param parMois mois � donner � la date.
	 * @param parAnnee ann�e � donner � la date.
	 * 
	 * @author Antoine Limerutti / Pablo Rican
	 * 
	 */
	  public Date(int parJour, int parMois, int parAnnee)   {
	  	jour = parJour;
		mois = parMois;
		annee = parAnnee;
		GregorianCalendar date = new GregorianCalendar(annee,mois-1,jour);
		jourSemaine = date.get (Calendar.DAY_OF_WEEK);
	  }
  
 
   
	/**
	 * Compare l'objet Date appellant et l'objet Date fourni en param�tre.
	 * 
	 * @param parDate Date � comparer � l'objet appellant
	 * 
	 * @return Entier :<ul><li>positif (appellant sup. argument)</li><li>negatif (appellant inf. argument)</li><li>nul (appellant �gal argument)</li></ul>
	 *
	 * @author Antoine Limerutti / Pablo Rican
	 */
	public int compareTo (Date parDate) {
		if (annee < parDate.annee)
			return -1;
		if (annee > parDate.annee)
			return 1;
		if (mois < parDate.mois)
			return -1;
		if (mois > parDate.mois)
			return 1;
		if (jour < parDate.jour)
			return -1;
		if (jour > parDate.jour)
			return 1;
		return 0;
	}
  
	/**
	 * D�termine la date du premier jour de la semaine de l'objet appellant.
	 * 
	 * @return Date du premier jour de la semaine de l'objet appellant
	 * 
	 * @author Antoine Limerutti / Pablo Rican
	 * 
	 */
  	public Date datePremierJourSemaine() {
  		Date date = new Date(jour, mois, annee);

		while(date.getJourSemaine()!=2) {
			date = date.dateDeLaVeille();
		}

		return date;
  }
 
	/**
	 * D�termine une date correspondant � la date du lendemain de l'objet appellant.
	 * 
	 * @return Date correspondant � la date du lendemain de l'objet appellant.
	 * 
	 * @author Antoine Limerutti / Pablo Rican
	 */
	public Date dateDuLendemain ()   {
		if (jour < dernierJourDuMois(mois,annee))
				 return  new Date(jour+1,mois,annee);
			else if (mois < 12)
					return new Date(1,mois+1,annee);
				 else return new Date(1,1,annee+1);
  }  
  
	/**
	 * D�termine une date correspondant � la date de la veille de l'objet appellant.
	 * 
	 * @return Date correspondant � la date de la veille de l'objet appellant.
	 * 
	 * @author Antoine Limerutti / Pablo Rican
	 */
	public Date dateDeLaVeille () {
		if (jour > 1)
				return  new Date(jour-1,mois,annee);
		else if (mois > 1)
				   return new Date(Date.dernierJourDuMois(mois-1, annee),mois-1,annee);
			 else return  new Date(31,12,annee-1);
  }	 
  
	/**
	 * D�termine le dernier jour du mois et le renvoi.
	 * 
	 * @param parMois mois dont il faut trouver la dernier jour.
	 * @param parAnnee ann�e du mois dont on cherche le dernier jour.
	 * 
	 * @return Integer qui correspond au dernier jour du mois donn� pour l'ann�e choisie.
	 * 
	 * @author Antoine Limerutti / Pablo Rican
	 * 
	 */
	public static int dernierJourDuMois (int parMois, int parAnnee) {
		switch (parMois) {
			 case 2 : if (estBissextile (parAnnee))  return 29 ; else return 28 ;  
			 case 4 : 	 case 6 : 	 case 9 : 	 case 11 : return 30 ;
			 default : return 31 ;
			}  // switch
	  }

	/**
	 * retourne la date du mois pr�c�dent.
	 *
	 * @author Pablo Rican
	 *
	 * @return Date correspondant � la date du mois pr�c�dent.
	 */
	public Date moisPrecedent(){
		int j = 1;
		int m = mois;
		int a = annee;

		if (mois > 1){
			m--;
			return new Date(j,m,a);
		}
		m = 12;
		a--;
		return new Date(j,m,a);
	}

	/**
	 * retourne la date du mois suivant.
	 *
	 * @author Pablo Rican
	 *
	 * @return Date correspondant � la date du mois suivant.
	 */
	public Date moisSuivant(){
		int j = 1;
		int m = mois;
		int a = annee;

		if (mois < 12){
			m++;
			return new Date(j,m,a);
		}
		m = 1;
		a++;
		return  new Date(j,m,a);
	}

	/**
	 * Methode permettant de savoir si deux dates sont dans la m�me semaine.
	 *
	 * @author Pablo Rican
	 *
	 * @param date Date � laquelle on souhaite savoir si elle est dans la m�me semaine que celle qui appelle la fonction.
	 * @return si oui ou non la date est dans la m�me semaine que la date qui appelle cette methode.
	 */
	public boolean estDansLaSemaine(Date date){
		Date dateTemp = new Date(jour, mois, annee);
		while (dateTemp.dateDeLaVeille().getSemaineDeAnnee() == this.getSemaineDeAnnee()){
			dateTemp = dateTemp.dateDeLaVeille();
		}
		for (int i = 0; i < 7; i++) {
			if (dateTemp.compareTo(date) == 0){
				return true;
			}
			dateTemp = dateTemp.dateDuLendemain();
		}
		return false;
	}

	/**
	 * Methode permettant de savoir si deux dates sont dans le m�me mois.
	 *
	 * @author Pablo Rican
	 *
	 * @param date Date � laquelle on souhaite savoir si elle est dans le m�me mois que celle qui appelle la methode.
	 * @return si oui ou non la date est dans le m�me mois que la date qui appelle cette methode.
	 */
	public boolean estDansLeMois(Date date){
		return mois == date.mois && annee == date.annee;
	}

	/**
	 * Methode permettant de renvoyer la semaine de l'ann�e de la date.
	 *
	 * @author Pablo Rican
	 *
	 * @return la semaine de l'ann�e de la date.
	 */
	public int getSemaineDeAnnee(){
		GregorianCalendar cal = new GregorianCalendar(annee,mois-1,jour);
		return cal.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * Retourne le nombre de jour entre deux dates.
	 *
	 * @param date Date avec laquelle il vas falloir d�terminer le nombre de jour d'�cart.
	 *
	 * @author Antoine Limerutti
	 *
	 * @return Entier correspondant au nombre de jour entre les deux dates.
	 */
	public int nbJourEntre(Date date) {
		int nbJour = 0;
		int[] nbJourMois = new int[12];
		int moisTemp = mois-1;

		for (int indice = 0; indice < 12; indice++)
			nbJourMois[indice] = dernierJourDuMois(indice + 1, 2019);

		int moisEntre = nbMoisEntre(date);

		if(jour>date.getJour())
			moisEntre--;

		for (int indice = 0; indice<moisEntre; indice++) {
			nbJour += nbJourMois[(indice + moisTemp) % 12];
			if((indice + moisTemp) % 12==1 && estBissextile(annee+((indice + moisTemp) / 12)))
				nbJour++;
		}

		if(jour<date.getJour())
			nbJour+=date.getJour()-jour;
		else if(jour>date.getJour())
			nbJour += (dernierJourDuMois(date.getMois() - 1, date.getAnnee()) - jour) + date.getJour();

		return nbJour;
	}

	/**
	 * Retourne le nombre de mois entre deux dates.
	 *
	 * @param date Date avec laquelle il vas falloir d�terminer le nombre de mois d'�cart.
	 *
	 * @author Antoine Limerutti
	 *
	 * @return Entier correspondant au nombre de mois entre les deux dates.
	 */
	public int nbMoisEntre(Date date){
		if(mois<date.getMois())
			return (nbAnneeEntre(date) * 12) + (date.getMois() - mois);
		else if(mois>date.getMois())
			return (nbAnneeEntre(date) * 12) + ((12 - mois) + date.getMois());
		else if(mois==date.getMois() && annee!=date.getAnnee())
			return ((nbAnneeEntre(date)+1) * 12);
		else
			return (nbAnneeEntre(date) * 12);
	}

	/**
	 * Retourne le nombre d'ann�es entre deux dates.
	 *
	 * @param date Date avec laquelle il vas falloir d�terminer le nombre d'ann�e d'�cart.
	 *
	 * @author Antoine Limerutti
	 *
	 * @return Entier correspondant au nombre d'ann�e entre les deux dates.
	 */
	public int nbAnneeEntre(Date date){
		if(annee==date.getAnnee())
			return 0;
		else if(mois<date.getMois() || mois==date.getMois() && jour<=date.getJour())
			return date.getAnnee()-annee;
		else
			return date.getAnnee()-annee-1;
	}

	/**
	 * Retourne le nombre de semaine entre deux dates.
	 *
	 * @param date Date avec laquelle il vas falloir d�terminer le nombre de semaine d'�cart.
	 *
	 * @author Antoine Limerutti
	 *
	 * @return Entier correspondant au nombre de semaine entre les deux dates.
	 */
	public int nbSemaineEntre(Date date){
		return nbJourEntre(date)/7;
	}

	/**
	 * V�rifie si l'ann�e de l'objet appellant est bisextile.
	 * 
	 * @param parAnnee ann�e dont la m�thode vas v�rifier si elle est bisextile.
	 * 
	 * @return booleen qui indique si l'ann�e est bisextile.
	 * 
	 * @author Antoine Limerutti / Pablo Rican
	 */
  	private static boolean estBissextile(int parAnnee) {
  		return parAnnee % 4 == 0 && (parAnnee % 100 != 0 || parAnnee % 400 == 0);
  	}
  
	/**
	 * Cr�e une chaine de charact�re pr�cisant les champs de l'objet appellant.
	 * 
	 * @return String correspondant au format JourDeLaSemaine Num�roDuJour Mois.
	 * 
	 * @author Antoine Limerutti / Pablo Rican
	 */
	  public String toString () {
		String chaine;

		chaine = "" + jour + " ";
		switch (mois) {
			 case 1: chaine += "janvier"; break;
			 case 2: chaine += "f�vrier"; break;
			 case 3: chaine += "mars"; break;
			 case 4: chaine += "avril"; break;
			 case 5: chaine += "mai"; break;
			 case 6: chaine += "juin"; break;
			 case 7: chaine += "juillet"; break;
			 case 8: chaine += "ao�t"; break;
			 case 9: chaine += "septembre"; break;
			 case 10: chaine += "octobre"; break;
			 case 11: chaine += "novembre"; break;
			 case 12: chaine += "d�cembre"; break;
			 default: chaine = "erreurMois"; break;
		}
		return chaine + " " + annee;
	  }

	/**
	 * Cr�e une chaine de charact�re pr�cisant certains champs de l'objet appellant.
	 *
	 * @return String correspondant au format jour moisDeLAnnee Annee.
	 *
	 * @author Pablo Rican
	 */
  public String toStringJourMoisAnnee(){
  	return jour + " " + MOIS_DE_L_ANNEE[mois-1] + " " + annee;
  }

	/**
	 * Cr�e une chaine de charact�re pr�cisant certains champs de l'objet appellant.
	 *
	 * @return String correspondant au format moisDeLAnnee Annee.
	 *
	 * @author Pablo Rican
	 */
  public String toStringMoisAnnee(){
  	return MOIS_DE_L_ANNEE[mois-1] + " " + annee;
  }

	/**
	 * Cr�e une chaine de charact�re pr�cisant certains champs de l'objet appellant.
	 *
	 * @return String correspondant au format jour.
	 *
	 * @author Pablo Rican
	 */
  public String toStringJour(){
  	return Integer.toString(jour);
  }

	/**
	 * Modifieur du champ parJour.
	 *
	 * @param parJour valeur que l'on veut donner au champ jour.
	 * 
	 * @author Antoine Limerutti / Pablo Rican
	 * 
	 */
	public void setJour(int parJour) {
		jour=parJour;
		GregorianCalendar date = new GregorianCalendar(annee,mois-1,jour);
		jourSemaine = date.get (Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * Modifieur du champ parMois.
	 *
	 * @param parMois valeur que l'on veut donner au champ mois.
	 * 
	 * @author Antoine Limerutti / Pablo Rican
	 * 
	 */
	public void setMois(int parMois) {
		mois=parMois;
		GregorianCalendar date = new GregorianCalendar(annee,mois-1,jour);
		jourSemaine = date.get (Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * Modifieur du champ parAnnee.
	 *
	 * @param parAnnee valeur que l'on veut donner au champ annee.
	 * 
	 * @author Antoine Limerutti / Pablo Rican
	 * 
	 */
	public void setAnnee(int parAnnee) {
		annee=parAnnee;
		GregorianCalendar date = new GregorianCalendar(annee,mois-1,jour);
		jourSemaine = date.get (Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * Accesseur du champ chJour.
	 *
	 * @return Integer qui correspond � la valeur du champ jour.
	 * 
	 * @author Antoine Limerutti / Pablo Rican
	 * 
	 */
	public int getJour() {
		return jour;
	}
	
	/**
	 * Accesseur du champ chMois.
	 *
	 * @return Integer qui correspond � la valeur du champ mois.
	 * 
	 * @author Antoine Limerutti / Pablo Rican
	 * 
	 */
	public int getMois() {
		return mois;
	}
	
	/**
	 * Accesseur du champ chAnnee.
	 * 
	 * @return Integer qui correspond � la valeur du champ annee.
	 * 
	 * @author Antoine Limerutti / Pablo Rican
	 * 
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * Accesseur du champ jourSemaine.
	 * 
	 * @return Integer qui correspond � la valeur du champ jourSemaine.
	 * 
	 * @author Antoine Limerutti / Pablo Rican
	 * 
	 */
	public int getJourSemaine () {
		return jourSemaine;
	}
}  // class Date