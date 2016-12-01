package tn.esprit.perso.labo.util;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class DBPopulator {

	@PostConstruct
	public void init(){}
}
