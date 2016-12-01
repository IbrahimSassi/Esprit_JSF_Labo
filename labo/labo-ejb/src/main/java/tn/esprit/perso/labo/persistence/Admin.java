package tn.esprit.perso.labo.persistence;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Admin extends Employe{
	
	
	private Niveau niveau;

	@Enumerated(EnumType.STRING)
	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}



}
