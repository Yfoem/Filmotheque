package fr.eni.filmotheque.dal;
import java.util.List;

import fr.eni.filmotheque.bo.Film;

public interface FilmDAO {

	public void Ajouter(Film f);
	public void Supprimer(Film f);
	public void Supprimer(Long id);
	public void Modifier(Film id);
	public Film SelectById(Long id);
	public List<Film> SelectAll();
	
}
