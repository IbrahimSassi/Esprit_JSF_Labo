package tn.esprit.perso.labo.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.esprit.perso.labo.persistence.Competence;
import tn.esprit.perso.labo.persistence.Employe;
import tn.esprit.perso.labo.persistence.Labo;
import tn.esprit.perso.labo.persistence.Technicien;

@Local
public interface GestionLaboLocal {

	void supprimerEmploye(Employe employe);
	
	public void creerLabo(Labo labo);
	
	public String ajouterEmploye(Employe employe);
	
	public void supprimerComptAvecTousTech(int id);
	
	public void demissionnerEmploye(Employe employe);
	
	public Employe authentifier(String login, String password);
	
	public List<Employe> listerEmployes();
	
	public List<Competence> listerCompTech(String cin);
	
	public void affectLaboEmploye(Labo labo, Employe employe);
	
	public void affecterComptenceTechnicien(Competence competence, Technicien technicien);
	
	public void supprimerLabo(Labo labo);
	
	
	
}
