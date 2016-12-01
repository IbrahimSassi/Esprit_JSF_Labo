package tn.esprit.perso.labo.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="t_labo")
public class Labo implements Serializable{
	
	
	private int id;
	private String nom;
	private String presentation;
	private List<Employe> employes;
	
	@Column(name="t_nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Id
	//@SequenceGenerator(name="gen", initialValue=5)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen")
	//@TableGenerator(name="tabgen", pkColumnValue="se_labo")
	//@GeneratedValue(strategy=GenerationType.TABLE, generator="tabgen")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Lob
	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	@OneToMany(mappedBy="labo", fetch=FetchType.EAGER)
	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

}
