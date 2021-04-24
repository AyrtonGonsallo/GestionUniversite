package com.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="note")
public class Note {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="idnote")
	private long id;
	private String matiere;
	private int valeur;
	@ManyToOne
	@JoinColumn(name="idetudiant")
	private Etudiant etudiant;
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getIdprofesseur() {
		return idprofesseur;
	}
	public void setIdprofesseur(int idprofesseur) {
		this.idprofesseur = idprofesseur;
	}
	private int idprofesseur;
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
}
