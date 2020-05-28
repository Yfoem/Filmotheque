package fr.eni.filmotheque.dal;

import java.util.List;

import fr.eni.filmotheque.bll.CategorieNonTrouveException;
import fr.eni.filmotheque.bo.Categorie;

public interface CategorieDAO {
	public void add(Categorie categorie);

	public void update(Categorie categorie);

	public void delete(Categorie categorie);

	public void delete(Long id);

	public Categorie findById(long id);

	public List<Categorie> findAll() throws CategorieNonTrouveException;

	public Categorie findByLabel(String name) throws CategorieNonTrouveException;
}
