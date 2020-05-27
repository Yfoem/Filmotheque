package fr.eni.filmotheque.bo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Film")
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "titre", nullable = false)
	private String titre;
	@Column(name = "annee", nullable = false)
	private Date annee;

	@ManyToOne
	private Categorie categorie;

	@ManyToOne
	@Column(name = "realisateur", nullable = false)
	private Participant realisteur;

	public Film() {

	}

	public Film(String titre, Date annee) {

		this.titre = titre;
		this.annee = annee;
	}

	public Film(String titre, Date annee, Categorie cat) {

		this.titre = titre;
		this.annee = annee;
		this.categorie = cat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getAnnee() {
		return annee;
	}

	public void setAnnee(Date annee) {
		this.annee = annee;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}
