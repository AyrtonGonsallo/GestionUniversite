package com.DA0;


import com.DA0.exceptions.DAOException;
import com.beans.Professeur;

public interface ProfesseurDAOI {
	Professeur trouver( String nom,String prenom ) throws DAOException;
	Professeur trouverNotes(String nom,String prenom ) throws DAOException;
}
