package fr.eni.filmotheque.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.dal.FilmDAOImpl;

public class FilmManagerImpl implements FilmManager {

	@Autowired
	private FilmDAOImpl dao;

	@Override
	public Film findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enregistrerFilm(Film film) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerFilm(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Film> findAllFilm() {
		// TODO Auto-generated method stub
		return null;
	}

}
