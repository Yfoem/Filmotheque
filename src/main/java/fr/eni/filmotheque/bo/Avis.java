package fr.eni.filmotheque.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Membre membre;

	@ManyToOne
	private Film film;

	@Column(name = "note", nullable = false)
	private int note;

	@Column(name = "commentaire", length = 1000, nullable = false)
	private String commentaire;

	public Avis() {
		// TODO Auto-generated constructor stub
	}

}
