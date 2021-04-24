package com.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="etudiant")
@NamedQuery(name="from etudiant", query="select et from Etudiant et where et.nom = :name and et.prenom = :sirname")
public class Etudiant {
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="idetudiant")
	private long id;
	private String nom;
	private String prenom;
	private String filiere;
	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
		    name = "etudiant_note",
		    joinColumns = @JoinColumn(name = "idnote"),
		    inverseJoinColumns = @JoinColumn(name = "idetudiant")
		)
	@JoinColumn(name = "idetudiant")*/
	@OneToMany(mappedBy="etudiant")
	private List<Note> notes;
	public int getLongueur() {
	return notes.size();
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	public List<Note> getNotes() {
		return notes;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	@Override
	public String toString() {
		return "Etudiant d'id " + id + " de nom " + nom + " de prenom " + prenom + " inscrit dans la filiere " + filiere;
	}
	
	
	
	
}
