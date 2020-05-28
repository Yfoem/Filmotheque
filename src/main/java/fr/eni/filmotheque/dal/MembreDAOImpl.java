package fr.eni.filmotheque.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.eni.filmotheque.bll.MembreNonTrouveException;
import fr.eni.filmotheque.bo.Membre;

@Repository
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

	@Override
	public Membre findByName(String name) throws MembreNonTrouveException {
		try {
			return em.createQuery("select m from Membre m where m.pseudo= :name", Membre.class)
					.setParameter("name", name).getSingleResult();
		} catch (NoResultException e) {
			throw new MembreNonTrouveException();
		}
	}

}
