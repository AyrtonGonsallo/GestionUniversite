package com.DA0;


import java.util.List;
import javax.persistence.EntityManager;
import com.DA0.exceptions.DAOException;
import com.beans.Note;


public class NoteDAO implements NoteDAOI{
	private DAOFactory  daoFactory;
	EntityManager em =null;
    NoteDAO( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	@SuppressWarnings("unchecked")
	@Override
	public List<Note> trouverNotesProfesseur(int num) throws DAOException{
		List<Note> notes =null;
		try {
			em=daoFactory.getEntityManager();
			notes=(List<Note>) em.createQuery("SELECT Distinct n FROM Note n INNER JOIN n.etudiant e where n.idprofesseur = :num").setParameter("num",num).getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return notes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Note> trouverNotesEtudiant(int num) throws DAOException{
		List<Note>notes=null;
		try{
			em=daoFactory.getEntityManager();
			notes=(List<Note>) em.createQuery("SELECT Distinct n FROM Note n where n.idetudiant = :num").setParameter("num",num).getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return notes;
	}

}
