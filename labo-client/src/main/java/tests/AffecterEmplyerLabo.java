package tests;

import javax.naming.NamingException;

import tn.esprit.perso.labo.persistence.Employe;
import tn.esprit.perso.labo.persistence.Labo;
import tn.esprit.perso.labo.services.GestionLaboRemote;

public class AffecterEmplyerLabo {

	public static void main(String[] args) throws NamingException {
		GestionLaboRemote proxy = InvoquerProxy.returnProxy();
		Labo labo = new Labo();
		labo.setId(1);
		Employe employe = new Employe();
		employe.setCin("2");
		employe.setLogin("l");
		employe.setPassword("p");
		proxy.affectLaboEmploye(labo, employe);
		
	}

}
