package com.DA0;

import javax.persistence.EntityManager;

import com.DA0.exceptions.DAOException;
import com.beans.Professeur;

public class ProfesseurDAO implements ProfesseurDAOI{
	 private DAOFactory  daoFactory;
	 EntityManager em =null;
	    ProfesseurDAO( DAOFactory daoFactory ) {
	        this.daoFactory = daoFactory;
	    }
	@Override
	public Professeur trouver(String nom, String prenom) throws DAOException{
		Professeur p=null;
		try {
			em=daoFactory.getEntityManager();
			p=(Professeur) em.createQuery("SELECT p FROM Professeur p where p.nom = :name and p.prenom = :sirname").setParameter("name",nom).setParameter("sirname",prenom).getSingleResult();
			
		}
		catch(Exception e) {
			System.out.println("Erreur_0901019822: il n'est pas parmi les professeurs");
		}
		return p;

	}
	@Override
	public Professeur trouverNotes(String nom, String prenom) throws DAOException {
		Professeur p=null;
		try {
			em=daoFactory.getEntityManager();
			p=(Professeur) em.createQuery("SELECT Distinct p FROM Professeur p INNER JOIN p.notes n where p.nom = :name and p.prenom = :sirname").setParameter("name",nom).setParameter("sirname",prenom).getSingleResult();
			
		}
		catch(Exception e) {
			System.out.println("Erreur_0901019822: il n'est pas parmi les professeurs");
		}
		return p;
	}

}
