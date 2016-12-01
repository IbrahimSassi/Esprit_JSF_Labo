package tests;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import tn.esprit.perso.labo.persistence.Competence;
import tn.esprit.perso.labo.persistence.Technicien;
import tn.esprit.perso.labo.services.GestionLaboRemote;

public class AjouterTechnicienAvecCompetences {
	public static void main(String[] args) throws NamingException {
		GestionLaboRemote proxy = InvoquerProxy.returnProxy();
		
		Technicien technicien = new Technicien();
		technicien.setCin("44");
		technicien.setLogin("mp");
		technicien.setPassword("pk");
		List<Competence> competences = new ArrayList<Competence>();
		Competence competence = new Competence();
		competence.setLibelle("reseau");
		Competence competence2 = new Competence();
		competence2.setLibelle("info");
		competences.add(competence);
		competences.add(competence2);
		technicien.setCompetences(competences);

		proxy.ajouterEmploye(technicien);

	}
}
