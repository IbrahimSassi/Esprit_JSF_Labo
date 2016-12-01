package tn.esprit.perso.labo.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.perso.labo.persistence.Competence;
import tn.esprit.perso.labo.persistence.Employe;
import tn.esprit.perso.labo.persistence.Labo;
import tn.esprit.perso.labo.persistence.Technicien;

@Stateless
public class GestionLaboService implements GestionLaboRemote,GestionLaboLocal {

	@PersistenceContext(unitName = "labo-ejb")
	EntityManager em;

	@Override
	public Employe authentifier(String login, String password) {
		try {
			TypedQuery<Employe> query = em.createNamedQuery("auth", Employe.class);
			query.setParameter("log", login);
			query.setParameter("pass", password);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public String ajouterEmploye(Employe employe) {
		em.persist(employe);
		return "sucess";

	}

	@Override
	public void demissionnerEmploye(Employe employe) {
		employe = em.find(Employe.class, employe.getCin());
		employe.setLabo(null);
	}

	@Override
	public List<Employe> listerEmployes() {

		return em.createNamedQuery("lister", Employe.class).getResultList();
	}

	@Override
	public List<Competence> listerCompTech(String cin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void affectLaboEmploye(Labo labo, Employe employe) {
		labo = em.merge(labo);

		Employe employe2 = em.find(Employe.class, employe.getCin());

		if (employe2 == null) {
			em.persist(employe);
			employe.setLabo(labo);
		} else {
			employe2.setLabo(labo);
		}

	}

	@Override
	public void affecterComptenceTechnicien(Competence competence, Technicien technicien) {
		// Bout slave --> l'affectation n'a pas lieu
		// competence= em.find(Competence.class, competence.getId());
		// em.persist(technicien);
		// competence.getTechniciens().add(technicien);

		// bout master, l'affectation se fait
		technicien = em.find(Technicien.class, technicien.getCin());
		System.out.println(technicien.getCompetences());
		technicien.getCompetences().add(competence);
		em.merge(technicien);

	}

	@Override
	public void supprimerLabo(Labo labo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerComptAvecTousTech(int id) {
		// em.remove(em.find(Competence.class, id));

	}

	@Override
	public void creerLabo(Labo labo) {
		em.persist(labo);

	}

	@Override
	public void supprimerEmploye(Employe employe) {
		em.remove(em.merge(employe));

	}

}
