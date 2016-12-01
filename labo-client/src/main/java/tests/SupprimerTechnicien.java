package tests;

import javax.naming.NamingException;

import tn.esprit.perso.labo.persistence.Technicien;
import tn.esprit.perso.labo.services.GestionLaboRemote;

public class SupprimerTechnicien {
	public static void main(String[] args) throws NamingException {
		GestionLaboRemote proxy = InvoquerProxy.returnProxy();
	Technicien technicien = new Technicien();
	technicien.setCin("3");
	proxy.supprimerEmploye(technicien);
	
	}
}
