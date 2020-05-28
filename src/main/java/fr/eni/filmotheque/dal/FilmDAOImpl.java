package fr.eni.filmotheque.dal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.eni.filmotheque.bo.Film;

@Repository
public class FilmDAOImpl implements FilmDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void add(Film f) {
		em.persist(f);
		em.flush();

	}
}
