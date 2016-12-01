package tests;

import javax.naming.NamingException;

import tn.esprit.perso.labo.persistence.Competence;
import tn.esprit.perso.labo.persistence.Technicien;
import tn.esprit.perso.labo.services.GestionLaboRemote;

public class AffectCompetenceTechnicien {
	public static void main(String[] args) throws NamingException {
		GestionLaboRemote proxy = InvoquerProxy.returnProxy();
	
		Technicien technicien = new Technicien();
		technicien.setCin("6");
		technicien.setLogin("pp");
		technicien.setPassword("tt");
		
		Competence competence = new Competence();
		competence.setId(7);
		
		
		proxy.affecterComptenceTechnicien(competence, technicien);
		
	}
}
