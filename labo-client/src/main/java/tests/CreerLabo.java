package tests;

import javax.naming.NamingException;

import tn.esprit.perso.labo.persistence.Labo;
import tn.esprit.perso.labo.services.GestionLaboRemote;

public class CreerLabo {
	public static void main(String[] args) throws NamingException {
		GestionLaboRemote proxy = InvoquerProxy.returnProxy();
		Labo labo = new Labo();
		labo.setNom("pasteur");
		labo.setPresentation("excellent");
		proxy.creerLabo(labo);
		
	}
}
