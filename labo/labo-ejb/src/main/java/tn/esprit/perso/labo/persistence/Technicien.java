package tn.esprit.perso.labo.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
//@DiscriminatorValue(value="tech")
public class Technicien extends Employe{

	private String specialite;
	private List<Competence> competences;
	
	
	
	public Technicien() {
		competences = new ArrayList<Competence>();
		
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	@ManyToMany(cascade=CascadeType.PERSIST)
	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	
}
