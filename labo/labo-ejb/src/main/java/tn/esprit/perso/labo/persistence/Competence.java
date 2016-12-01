package tn.esprit.perso.labo.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity
public class Competence implements Serializable{

	private int id;
	private String libelle;
	private String description;
	private List<Technicien> Techniciens;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@Lob
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToMany(mappedBy="competences")
	
	public List<Technicien> getTechniciens() {
		return Techniciens;
	}
	public void setTechniciens(List<Technicien> techniciens) {
		Techniciens = techniciens;
	}
	
}
