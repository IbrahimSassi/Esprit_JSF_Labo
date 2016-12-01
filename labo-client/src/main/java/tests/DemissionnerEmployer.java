package tests;

import javax.naming.NamingException;

import tn.esprit.perso.labo.persistence.Employe;
import tn.esprit.perso.labo.services.GestionLaboRemote;

public class DemissionnerEmployer {
	public static void main(String[] args) throws NamingException {
		GestionLaboRemote proxy = InvoquerProxy.returnProxy();
		Employe employe = new Employe();
		employe.setCin("1");
		proxy.demissionnerEmploye(employe);

	}
}
