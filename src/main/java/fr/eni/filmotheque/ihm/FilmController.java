package fr.eni.filmotheque.ihm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.filmotheque.bll.CategorieManager;
import fr.eni.filmotheque.bll.CategorieNonTrouveException;
import fr.eni.filmotheque.bll.FilmManager;
import fr.eni.filmotheque.bll.ParticipantManager;
import fr.eni.filmotheque.bo.Categorie;
import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.dal.FilmDAO;

@Controller
public class FilmController {

	@Autowired
	FilmManager filmManager;
	@Autowired
	CategorieManager categorieManager;
	@Autowired
	ParticipantManager participantManager;
	
	List<Film> films = new ArrayList<>();
	Film film = null;
	List<Categorie>categories = new ArrayList<>();
	Categorie categorie = new Categorie();
	List<Participant> participants = new ArrayList<>();
	Participant participant = new Participant();

	@RequestMapping(path="/gestionFilms", method=RequestMethod.GET)
	public String afficherFilms(ModelMap model) throws CategorieNonTrouveException {
		
		participants=participantManager.selectAllParticipant();
		model.addAttribute("listeParticipants", participants);
		
		categories = categorieManager.findAllCategories();
		model.addAttribute("listeCategories", categories);

		films = filmManager.SelectAll();
		model.addAttribute("films", films);
		
		return "gestionFilms";
	}
	
	@RequestMapping(path="/detailFilm", method=RequestMethod.POST)
	public String detailFilm(@RequestParam(name="id") Long id, ModelMap model) {
		film=new Film();
		film = filmManager.SelectById(id);
		model.addAttribute("film", film);
		
		return "detailFilm";
		
	}
	
	@RequestMapping(path="/modifierFilm", method=RequestMethod.GET)
	public String vueModifierFilm(@RequestParam(name="id") Long id, ModelMap model) throws CategorieNonTrouveException {
		
		films = filmManager.SelectAll();
		model.addAttribute("films", films);
		participants=participantManager.selectAllParticipant();
		model.addAttribute("listeParticipants", participants);
		categories = categorieManager.findAllCategories();
		model.addAttribute("listeCategories", categories);
		film=new Film();
		film = filmManager.SelectById(id);
		model.addAttribute("film", film);
		
		return "gestionFilms";
	}
	
	@RequestMapping(path="/modifierFilm", method=RequestMethod.POST)
	public String modifierFilm(@RequestParam(name="titre") String titre,@RequestParam(name="categorie") Long categorie1,@RequestParam(name="realisateur") Long realisateur, @RequestParam(name="annee") String annee,@RequestParam(name="id") Long id, ModelMap model) throws CategorieNonTrouveException {
		
		
		participants=participantManager.selectAllParticipant();
		model.addAttribute("listeParticipants", participants);
		categories = categorieManager.findAllCategories();
		model.addAttribute("listeCategories", categories);
		film=new Film();
		film = filmManager.SelectById(id);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
       
        try {

            Date date = formatter.parse(annee);
            film.setAnnee(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		film.setCategorie(categorieManager.findById(categorie1));
		film.setRealisteur(participantManager.selectParticipant(realisateur));
		film.setTitre(titre);
		filmManager.Ajouter(film);
		
		return "redirect:/app/gestionFilms";
	}
		
	@RequestMapping(path="/supprimerFilm", method=RequestMethod.GET)
	public String supprimerFilm(@RequestParam(name="id") Long id, ModelMap model) {
		
		filmManager.Supprimer(id);
		return "redirect:/app/gestionFilms";
	}
	
	@RequestMapping(path="/ajouterFilm", method=RequestMethod.POST)
	public String ajouterFilm(@RequestParam(name="titre") String titre,@RequestParam(name="categorie") Long categorie1,@RequestParam(name="realisateur") Long realisateur, @RequestParam(name="annee") String annee, ModelMap model) throws CategorieNonTrouveException {
		
		participants=participantManager.selectAllParticipant();
		model.addAttribute("listeParticipants", participants);
		categories = categorieManager.findAllCategories();
		model.addAttribute("listeCategories", categories);
		
		participants=participantManager.selectAllParticipant();
		model.addAttribute("listeParticipants", participants);
		film=new Film();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        

        try {

            Date date = formatter.parse(annee);
            film.setAnnee(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		film.setCategorie(categorieManager.findById(categorie1));
		film.setRealisteur(participantManager.selectParticipant(realisateur));
		film.setTitre(titre);
		
		filmManager.Ajouter(film);
		return "redirect:/app/gestionFilms";
		
	}
}
