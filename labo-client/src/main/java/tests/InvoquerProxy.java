package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.perso.labo.services.GestionLaboRemote;

public class InvoquerProxy {
	public static GestionLaboRemote returnProxy() throws NamingException {
		Context context = new InitialContext();
		GestionLaboRemote proxy = (GestionLaboRemote) context
				.lookup("labo-ear/labo-ejb/GestionLaboService!tn.esprit.perso.labo.services.GestionLaboRemote");
		return proxy;
	}
}
