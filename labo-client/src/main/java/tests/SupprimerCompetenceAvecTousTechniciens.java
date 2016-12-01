package tests;

import javax.naming.NamingException;

import tn.esprit.perso.labo.services.GestionLaboRemote;

public class SupprimerCompetenceAvecTousTechniciens {
	public static void main(String[] args) throws NamingException {
		GestionLaboRemote proxy = InvoquerProxy.returnProxy();
		
		proxy.supprimerComptAvecTousTech(1);
	
	}
}
