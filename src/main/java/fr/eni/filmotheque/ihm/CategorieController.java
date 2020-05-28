package fr.eni.filmotheque.ihm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.filmotheque.bll.CategorieNonTrouveException;
import fr.eni.filmotheque.bo.Categorie;
import fr.eni.filmotheque.dal.CategorieDAO;

@SessionAttributes("sessionCategorie")
@Controller
public class CategorieController {

	@Autowired
	private CategorieDAO dao;

	@RequestMapping(method = RequestMethod.GET, path = { "/vueAjouterCategorie" })
	public String vueAjouterCategorie(ModelMap model) {
		try {
			List<Categorie> cats = new ArrayList<Categorie>();
			cats.addAll(dao.findAll());
			cats.sort(Comparator.comparing(Categorie::getLibelle));
			model.addAttribute("sessionCategorie", cats);
		} catch (CategorieNonTrouveException e) {
			return "ajouterCategorie";
		}
		return "gererCategorie";

	}

	@RequestMapping(method = RequestMethod.GET, path = { "/vueModifierCategorie" })
	public String vueAjouterCategorieEdit(@RequestParam long id, @RequestParam String label, ModelMap model) {
		try {
			List<Categorie> cats = new ArrayList<Categorie>();
			cats.addAll(dao.findAll());
			cats.sort(Comparator.comparing(Categorie::getLibelle));
			model.addAttribute("sessionCategorie", cats);
			Categorie cat = new Categorie(id, label);
			model.addAttribute("cat", cat);
		} catch (CategorieNonTrouveException e) {
			return "ajouterCategorie";
		}
		return "gererCategorie";

	}

	@RequestMapping(method = RequestMethod.GET, path = { "/ajouterCategorie" })
	public String ajouterCategorie(@RequestParam(name = "cat") String label, ModelMap model) {

		if (verificationNonExiste(label)) {
			Categorie cat = new Categorie();
			cat.setLibelle(label);
			dao.add(cat);

			return "acceuil";

		} else {
			model.addAttribute("error", "la catégorie existe déjà");
			return "gererCategorie";
		}

	}

	@RequestMapping(method = RequestMethod.GET, path = { "/modifierCategorie" })
	public String ajouterModifier(@RequestParam(name = "cat") String label, @RequestParam(name = "id") Long id,
			ModelMap model) {

		Categorie cat = new Categorie(id, label);
		dao.update(cat);

		return "acceuil";

	}

	@RequestMapping(method = RequestMethod.GET, path = { "/SupprimerCategorie" })
	public String Supprimer(@RequestParam(name = "id") Long id) {

		dao.delete(id);

		return "acceuil";

	}

	private boolean verificationNonExiste(String label) {
		List<Categorie> categories;
		try {
			categories = dao.findAll();
		} catch (CategorieNonTrouveException e) {
			return true;
		}
		for (Categorie cat : categories) {
			if (cat.getLibelle().equalsIgnoreCase(label)) {
				return false;
			}
		}
		return true;
	}
}
