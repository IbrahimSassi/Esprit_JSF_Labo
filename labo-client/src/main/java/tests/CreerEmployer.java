package tests;

import javax.naming.NamingException;

import tn.esprit.perso.labo.persistence.Employe;
import tn.esprit.perso.labo.services.GestionLaboRemote;

public class CreerEmployer {
	public static void main(String[] args) throws NamingException {
		GestionLaboRemote proxy = InvoquerProxy.returnProxy();
		Employe employe = new Employe();
		employe.setCin("1");
		employe.setLogin("login");
		employe.setPassword("pass");
		proxy.ajouterEmploye(employe);
	}
}
