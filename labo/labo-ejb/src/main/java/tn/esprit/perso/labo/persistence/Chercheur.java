package tn.esprit.perso.labo.persistence;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value="cherch")
public class Chercheur extends Employe{
	
	private String domaineRecherche;

	public String getDomaineRecherche() {
		return domaineRecherche;
	}

	public void setDomaineRecherche(String domaineRecherche) {
		this.domaineRecherche = domaineRecherche;
	}

}
