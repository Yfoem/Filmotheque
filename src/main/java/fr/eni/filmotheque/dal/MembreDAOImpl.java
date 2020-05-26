package fr.eni.filmotheque.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import fr.eni.filmotheque.bo.Membre;

public class MembreDAOImpl implements MembreDAO {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void add(Membre membre) {
		em.persist(membre);

	}

	@Transactional
	@Override
	public void update(Membre membre) {
		if (!em.contains(membre)) {
			em.merge(membre);
		}
		em.flush();

	}

	@Transactional
	@Override
	public void delete(Membre membre) {
		if (!em.contains(membre)) {
			em.merge(membre);
		}
		em.remove(membre);

	}

	@Transactional
	@Override
	public List<Membre> findAll() {
		return em.createQuery("select m from Membre m", Membre.class).getResultList();
	}

	@Transactional
	@Override
	public Membre findById(long id) {
		return em.find(Membre.class, id);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Membre membre = findById(id);
		delete(membre);

	}

}
