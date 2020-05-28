package fr.eni.filmotheque.bo;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Film")
public class Film {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "titre", length = 75, nullable = false)
	private String titre;

	@Column(name = "annee", nullable = true)
	@Temporal(value = TemporalType.DATE)
	private Date annee;

	@ManyToOne
	private Categorie categorie;

	@ManyToOne
	private Participant realisteur;

	@ManyToMany
	private Collection<Participant> acteurs;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Participant getRealisteur() {
		return realisteur;
	}

	public void setRealisteur(Participant realisteur) {
		this.realisteur = realisteur;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", titre=" + titre + ", annee=" + annee + ", categorie=" + categorie + ", realisteur="
				+ realisteur + ", acteurs=" + acteurs + "]";
	}

	

	
}
