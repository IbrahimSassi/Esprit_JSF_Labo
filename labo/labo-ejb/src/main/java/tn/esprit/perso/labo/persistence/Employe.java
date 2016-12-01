package tn.esprit.perso.labo.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
// @DiscriminatorColumn(name="grade")
// @Inheritance(strategy=InheritanceType.SINGLE_TABLE)

// @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)


@NamedQueries({
	@NamedQuery(name="auth",query="select e from Employe e where e.login=:log and e.password=:pass"),
	@NamedQuery(name="lister", query="select e from Employe e")
})
public class Employe implements Serializable{

	private String login;
	private String password;
	private String cin;
	private String nom;
	private String prenom;
	private Labo labo;
	private Adresse adrese;
	private String email;
	private Date dateNaissance;
	

	public Employe() {
		// TODO Auto-generated constructor stub
	}
	
	@Column(nullable=false, unique=true)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(nullable=false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	@Id
	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@ManyToOne
	public Labo getLabo() {
		return labo;
	}

	public void setLabo(Labo labo) {
		this.labo = labo;
	}

	@Embedded
	public Adresse getAdrese() {
		return adrese;
	}

	public void setAdrese(Adresse adrese) {
		this.adrese = adrese;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	

}
