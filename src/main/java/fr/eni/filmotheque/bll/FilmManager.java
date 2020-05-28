package fr.eni.filmotheque.bll;

import java.util.List;

import fr.eni.filmotheque.bo.Film;


public interface FilmManager {
	
	public void Ajouter(Film f);
	public void Supprimer(Film f);
	public void Supprimer(Long id);
	public void Modifier(Film f);
	public Film SelectById(Long id);
	public List<Film> SelectAll();
}
