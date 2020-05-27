package fr.eni.filmotheque.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Membre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "pseudo", length = 50, nullable = false)
	private String pseudo;

	@Column(name = "mdp", length = 50, nullable = false)
	private String mdp;

	@Column(name = "email", length = 100, nullable = false)
	private String email;

	@Column(name = "estCreateur", nullable = false)
	private Boolean estCreateur;

	public Membre() {

		pseudo = null;
		mdp = null;
		email = null;
		estCreateur = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long i) {
		this.id = i;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean EstCreateur() {
		return estCreateur;
	}

	public void setEstCreateur(Boolean estCreateur) {
		this.estCreateur = estCreateur;
	}

}
