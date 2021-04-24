package com.DA0;


import com.DA0.exceptions.DAOException;
import com.beans.Etudiant;


public interface EtudiantDAOI {
	Etudiant trouver( String nom,String prenom ) throws DAOException;
	Etudiant trouverNotes(String nom,String prenom ) throws DAOException;
	
}
