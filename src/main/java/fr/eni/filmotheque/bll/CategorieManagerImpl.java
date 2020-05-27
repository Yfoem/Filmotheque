package fr.eni.filmotheque.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.eni.filmotheque.bo.Categorie;
import fr.eni.filmotheque.dal.CategorieDAO;

@org.springframework.stereotype.Service(value = "CategorieManager")
public class CategorieManagerImpl implements CategorieManager {

	@Autowired
	private CategorieDAO dao;

	public CategorieManagerImpl() {

	}

	public Categorie findById(long id) throws CategorieNonTrouveException {
		Categorie categorie = dao.findById(id);
		if (categorie == null) {
			throw new CategorieNonTrouveException();
		}
		return categorie;
	}

	@Transactional
	public void enregistrerCategorie(Categorie categorie) {
		if (categorie.getId() == null) {
			dao.add(categorie);
		} else {
			dao.update(categorie);
		}
	}

	@Transactional
	public void supprimerCategorie(Long id) throws CategorieNonTrouveException {

		dao.delete(id);

	}

	@Override
	public List<Categorie> findAllCategories() {
		return dao.findAll();
	}

	@Override
	public Categorie findByLabel(String label) throws CategorieNonTrouveException {
		Categorie categorie = dao.findByLabel(label);
		if (categorie == null) {
			throw new CategorieNonTrouveException();
		}
		return categorie;
	}
}
