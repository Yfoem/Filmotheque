package fr.eni.filmotheque.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.eni.filmotheque.bll.CategorieNonTrouveException;
import fr.eni.filmotheque.bo.Categorie;

@Repository
public class CategorieDAOImpl implements CategorieDAO {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void add(Categorie categorie) {
		em.persist(categorie);

	}

	@Transactional
	@Override
	public void update(Categorie categorie) {
		if (!em.contains(categorie)) {
			em.merge(categorie);
		}
		em.flush();

	}

	@Transactional
	@Override
	public void delete(Categorie categorie) {
		if (!em.contains(categorie)) {
			em.merge(categorie);
		}
		em.remove(categorie);

	}

	@Transactional
	@Override

	public List<Categorie> findAll() throws CategorieNonTrouveException {

		try {
			return em.createQuery("select c from Categorie c", Categorie.class).getResultList();
		} catch (NoResultException e) {
			throw new CategorieNonTrouveException();
		}


	}

	@Transactional
	@Override
	public Categorie findById(long id) {
		return em.find(Categorie.class, id);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Categorie categorie = findById(id);
		delete(categorie);

	}

	@Override
	public Categorie findByLabel(String label) throws CategorieNonTrouveException {
		try {
			return em.createQuery("select c from Categorie c where c.libelle= :label", Categorie.class)
					.setParameter("label", label).getSingleResult();
		} catch (NoResultException e) {
			throw new CategorieNonTrouveException();
		}
	}

}
