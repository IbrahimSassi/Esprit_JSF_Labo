package tn.esprit.perso.labo.presentation.mbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.perso.labo.persistence.Admin;
import tn.esprit.perso.labo.persistence.Chercheur;
import tn.esprit.perso.labo.persistence.Employe;
import tn.esprit.perso.labo.services.GestionLaboLocal;

@ManagedBean(name="auth")
@SessionScoped
public class AuthentificationBean implements Serializable {

	@EJB
	GestionLaboLocal gestionLaboLocal;
	
	private Employe employe;
	
	@PostConstruct
	public void init(){
		employe = new Employe();
	}
	
	
	
	public String login(){
		employe = gestionLaboLocal.authentifier(employe.getLogin(), employe.getPassword());
		if (employe instanceof Admin){
			return "/admin/accueil?faces-redirect=true";
		}
		else if (employe instanceof Chercheur){
			return "/chercheur/accueil?faces-redirect=true";

		}
		else {
			return "/public/login";

		}
		
			
	}
	
	
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/public/login";
	}
	
	
	
	public Employe getEmploye() {
		return employe;
	}




	public void setEmploye(Employe employe) {
		this.employe = employe;
	}




	private static final long serialVersionUID = 1L;

}
