package com.DA0;


import java.util.List;

import com.DA0.exceptions.DAOException;
import com.beans.Note;

public interface NoteDAOI {
	List<Note> trouverNotesProfesseur( int num ) throws DAOException;
	List<Note> trouverNotesEtudiant( int num ) throws DAOException;
}
