package fr.eni.filmotheque.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.filmotheque.bll.MembreManager;
import fr.eni.filmotheque.bll.MembreNonTrouveException;
import fr.eni.filmotheque.bo.Membre;

@Controller
@SessionAttributes("sessionUtilisateur")
public class MembreController {

	@Autowired
	private MembreManager membreMger;

	@SuppressWarnings("finally")
	@RequestMapping(method = RequestMethod.POST, path = { "/login" })
	public String Connexion(@RequestParam(name = "identifiant") String identifiant,
			@RequestParam(name = "motDePasse") String mdp, ModelMap model) {

		if (identifiant != null && mdp != null) {
			try {
				Membre membre = membreMger.findByName(identifiant);
				if (!membre.getMdp().equals(mdp)) {
					model.addAttribute("error", "erreur mdp incorrect");
					return "login";
				}
				model.addAttribute("sessionUtilisateur", membre);
				System.out.println("connextion effecutée");
				return "acceuil";
			} catch (MembreNonTrouveException e) {
				model.addAttribute("error", "erreur pas de compte trouvé");
				return "login";
			}

		}
		return "login";
	}

	@RequestMapping(method = RequestMethod.GET, path = { "/Acceuil" })
	public String Acceuil() {

		return "acceuil";
	}

}
