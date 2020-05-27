package fr.eni.filmotheque.bll;

import java.util.List;

import fr.eni.filmotheque.bo.Film;


public interface FilmManager {
	
	public Film findById(  long id);

	public void enregistrerFilm( Film film)  ;

	public void supprimerFilm( Long id);
	
	public List<Film> findAllFilm();
}
