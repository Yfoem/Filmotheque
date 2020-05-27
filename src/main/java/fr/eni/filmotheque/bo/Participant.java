package fr.eni.filmotheque.bo;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
 

@Entity
public class Participant {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom",length=30,nullable=false)
	private String nom;
	
	@Column(name="prenom",length=30,nullable=false)
	private String prenom;
	
	@Column(name="date_naissance", nullable=false)
	@Temporal(value=TemporalType.DATE)
	private Date dateDeNaissance;
	
	@Column(name="date_mort",nullable=true)
	@Temporal(value=TemporalType.DATE)
	private Date dateDeMort;
	
	public Participant ()  {
		 
	}

	public Participant(int id, String nom, String prenom, Date dateDeNaissance, Date dateDeMort) {
	 
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.dateDeMort = dateDeMort;
	}
	
	public Participant( String nom, String prenom, Date dateDeNaissance,Date dateDeMort) {
		 
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.dateDeMort = dateDeMort;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Date getDateDeMort() {
		return dateDeMort;
	}

	public void setDateDeMort(Date dateDeMort) {
		this.dateDeMort = dateDeMort;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance
				+ ", dateDeMort=" + dateDeMort + "]";
	}
	
	
	
	
	
	
}
