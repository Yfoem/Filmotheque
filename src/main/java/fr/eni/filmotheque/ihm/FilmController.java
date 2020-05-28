package fr.eni.filmotheque.ihm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.filmotheque.bll.FilmManager;
import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.dal.FilmDAO;

@Controller
public class FilmController {

	@Autowired
	FilmManager filmManager;
	
	List<Film> films = new ArrayList<>();
	Film film = new Film();

	@RequestMapping(path="/gestionFilms", method=RequestMethod.GET)
	public String afficherFilms(ModelMap model) {

		films = filmManager.SelectAll();
		model.addAttribute("films", films);
		
		return "gestionFilms";
	}
	
	@RequestMapping(path="/detailFilm", method=RequestMethod.POST)
	public String detailFilm(@RequestParam(name="id") Long id, ModelMap model) {
		
		film = filmManager.SelectById(id);
		model.addAttribute("film", film);
		
		return "detailFilm";
		
	}
	
	@RequestMapping(path="/modifierFilm", method=RequestMethod.POST)
	public String modifierFilm(@RequestParam(name="id") Long id, ModelMap model) {
		film = filmManager.SelectById(id);
		filmManager.Modifier(film);
		
		return "gestionFilm";
	}
		
	@RequestMapping(path="/supprimerFilm", method=RequestMethod.POST)
	public String supprimerFilm(@RequestParam(name="id") Long id, ModelMap model) {
		return null;
	}
	
	@RequestMapping(path="/ajouterFilm", method=RequestMethod.POST)
	public String ajouterFilm(@RequestParam(name="id") Long id, ModelMap model) {
		return null;
		
	}
}
