package fr.eni.filmotheque.bll;

import java.util.List;

import fr.eni.filmotheque.bo.Membre;

public interface MembreManager {
	public Membre findById(long id) throws MembreNonTrouveException;

	public void enregistrerMembre(Membre membre);

	public void supprimerMembre(Long id) throws MembreNonTrouveException;

	public List<Membre> findAllMembres();

	public Membre findByName(String name) throws MembreNonTrouveException;

}
