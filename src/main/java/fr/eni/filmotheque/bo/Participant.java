package fr.eni.filmotheque.bo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Participant {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom",length=30,nullable=false)
	private String nom;
	
	@Column(name="prenom",length=30,nullable=false)
	private String prenom;
	
	@Column(name="date_naissance",nullable=false)
	private LocalDate dateDeNaissance;
	
	@Column(name="date_mort",nullable=true)
	private LocalDate dateDeMort;
	
	
}
