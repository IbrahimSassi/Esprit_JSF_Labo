package tn.esprit.perso.labo.presentation.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.perso.labo.persistence.Admin;
import tn.esprit.perso.labo.persistence.Employe;
import tn.esprit.perso.labo.persistence.Technicien;
import tn.esprit.perso.labo.services.GestionLaboLocal;

@ManagedBean
@RequestScoped
public class RegistrationBean implements Serializable{

	/**
	 * 
	 */
	
	@EJB
	GestionLaboLocal gestionLaboLocal;
	
	private static final long serialVersionUID = 1L;
	private List<String> typesEmployes;
	private String selectedEmployee;
	private Employe employee;
	
	
	
	@PostConstruct
	public void init(){
		typesEmployes = new ArrayList<String>();
		typesEmployes.add("Employee");
		typesEmployes.add("Administrateur");
		typesEmployes.add("Technicien");
		employee = new Employe();
	}
	
	
	public List<String> getTypesEmployes() {
		return typesEmployes;
	}
	public void setTypesEmployes(List<String> typesEmployes) {
		this.typesEmployes = typesEmployes;
	}


	public String getSelectedEmployee() {
		return selectedEmployee;
	}


	public void setSelectedEmployee(String selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}


	public Employe getEmployee() {
		return employee;
	}


	public void setEmployee(Employe employee) {
		this.employee = employee;
	}
	
	
	public String register(){
		
		System.err.println("************************" + selectedEmployee);
		
		if(selectedEmployee.equals("Employee"))
		{
			gestionLaboLocal.ajouterEmploye(employee);
			return "/public/login?face-redirect=true";
		}
		else if (selectedEmployee.equals("Administrateur")) {
			
			Employe admin = new Admin();
			admin.setCin(employee.getCin());
			admin.setNom(employee.getNom());
			admin.setPrenom(employee.getPrenom());
			admin.setDateNaissance(employee.getDateNaissance());
			admin.setLogin(employee.getLogin());
			admin.setEmail(employee.getEmail());
			admin.setPassword(employee.getPassword());
			gestionLaboLocal.ajouterEmploye(admin);
			return "/public/login?face-redirect=true";

		}
		else{
			Employe technicien = new Technicien();
			technicien.setCin(employee.getCin());
			technicien.setNom(employee.getNom());
			technicien.setPrenom(employee.getPrenom());
			technicien.setDateNaissance(employee.getDateNaissance());
			technicien.setLogin(employee.getLogin());
			technicien.setEmail(employee.getEmail());
			technicien.setPassword(employee.getPassword());
			gestionLaboLocal.ajouterEmploye(technicien);
			return "/public/login?face-redirect=true";

		}


		
	}
	
	
}
