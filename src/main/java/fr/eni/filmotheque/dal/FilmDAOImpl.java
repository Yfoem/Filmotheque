package fr.eni.filmotheque.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.eni.filmotheque.bo.Film;

@Repository
public class FilmDAOImpl implements FilmDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void Ajouter(Film f) {
		em.persist(f);
		
	}

	@Override
	public void Supprimer(Film f) {
		if(!em.contains(f)) {
			em.merge(f);
		}
		
		em.remove(f);
	}
	
	@Override
	public void Supprimer(Long id) {
		// TODO Auto-generated method stub
		
		Film f = SelectById(id);
		Supprimer(f);
		
	}

	@Override
	public void Modifier(Film f) {
		if(!em.contains(f)) {
			em.merge(f);
		}
		em.flush();
		
	}

	@Override
	public Film SelectById(Long id) {
		
		return em.find(Film.class, id);
		
	}

	@Override
	public List<Film> SelectAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select f From Film f",Film.class).getResultList();
	}

	
}
