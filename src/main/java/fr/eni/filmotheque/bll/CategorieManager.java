package fr.eni.filmotheque.bll;

import java.util.List;

import fr.eni.filmotheque.bo.Categorie;

public interface CategorieManager {
	public Categorie findById(long id) throws CategorieNonTrouveException;

	public void enregistrerCategorie(Categorie categorie);

	public void supprimerCategorie(Long id) throws CategorieNonTrouveException;

	public List<Categorie> findAllCategories() throws CategorieNonTrouveException;

	public Categorie findByLabel(String label) throws CategorieNonTrouveException;

}
