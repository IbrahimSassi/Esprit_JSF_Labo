package tn.esprit.perso.labo.persistence;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Adresse implements Serializable{

	
	private String cite;
	private String ville;
	private String balass;
	private Integer codePostal;
	
	public String getCite() {
		return cite;
	}
	public void setCite(String cite) {
		this.cite = cite;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getBalass() {
		return balass;
	}
	public void setBalass(String balass) {
		this.balass = balass;
	}
	public Integer getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
	
}
