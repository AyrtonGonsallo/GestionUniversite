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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="professeur")
public class Professeur {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="idprofesseur")
	private long id;
	private String nom;
	private String prenom;
	private String matiere;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
		    name = "professeur_note",
		    joinColumns = @JoinColumn(name = "idnote"),
		    inverseJoinColumns = @JoinColumn(name = "idprofesseur")
		)
	@JoinColumn(name = "idprofesseur")
	private List<Note> notes;
	public String getNom() {
		return nom;
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
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
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	
	
}
