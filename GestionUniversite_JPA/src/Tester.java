

import java.util.List;

import com.DA0.DAOFactory;
import com.DA0.EtudiantDAO;
import com.DA0.NoteDAO;
import com.DA0.ProfesseurDAO;
import com.DA0.exceptions.DAOException;
import com.beans.Etudiant;
import com.beans.Note;
import com.beans.Professeur;

public class Tester {

	public static void main(String[] args) throws DAOException{
		NoteDAO ndao=DAOFactory.getInstance().getNoteDAO();
		List<Note> notes =ndao.trouverNotesProfesseur(1);
		System.out.println("-------------------note vers professeur-------------------");
		for (Note n:notes){
			
			System.out.println(n.getMatiere()+" "+n.getValeur()+" "+n.getEtudiant().getNom());
			
		}
		EtudiantDAO edao=DAOFactory.getInstance().getEtudiantDAO();
		Etudiant e =edao.trouver("Allen", "Paul");
		System.out.println("----------------etudiant vers note------- note vers etudiant---------------------");
		for (Note n:e.getNotes()){
			
			System.out.println(n.getMatiere()+" "+n.getValeur()+" "+n.getEtudiant().getNom());
			
		}
		ProfesseurDAO pdao=DAOFactory.getInstance().getProfesseurDAO();
		Professeur p =pdao.trouver("Nebra", "Mathieu");
		System.out.println("-----------------professeur vers note ------note vers etudiant------------");
		for (Note n:p.getNotes()){
			
			System.out.println(n.getMatiere()+" "+n.getValeur()+" "+n.getEtudiant().getNom());
			
		}

	}

}
