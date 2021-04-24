package com.DA0;



import javax.persistence.EntityManager;
import com.DA0.exceptions.DAOException;
import com.beans.Etudiant;


public class EtudiantDAO implements EtudiantDAOI{
	EntityManager em = null;
	private DAOFactory  daoFactory;

    EtudiantDAO( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	@Override
	public Etudiant trouver(String nom, String prenom) throws DAOException{
		Etudiant et=null;
		
		
		try {
			em=daoFactory.getEntityManager();
			et=em.createNamedQuery("from etudiant",Etudiant.class).setParameter("name",nom).setParameter("sirname",prenom).getSingleResult();
			
		}
		catch(Exception e) {
			System.out.println("Erreur_0901019821: il n'est pas parmi les etudiants");
		}
		return et;

	}
	@Override
	public Etudiant trouverNotes(String nom, String prenom) throws DAOException {
		Etudiant et=null;
		try {
			em=daoFactory.getEntityManager();
			et=(Etudiant) em.createQuery("SELECT Distinct e FROM Etudiant e INNER JOIN e.notes n where e.nom = :name and e.prenom = :sirname").setParameter("name",nom).setParameter("sirname",prenom).getSingleResult();
			
		}
		catch(Exception e) {
			System.out.println("Erreur_0901019821: il n'est pas parmi les etudiants");
		}
		return et;
	}

}
