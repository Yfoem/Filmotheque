package fr.eni.filmotheque.ihm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.filmotheque.bll.ParticipantManager;

import fr.eni.filmotheque.bll.ParticipantNonTrouveException;

import fr.eni.filmotheque.bo.Participant;

@Controller
public class ParticipantController {

	@Autowired
	private ParticipantManager manager;

	private Participant participant = null;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping(path = "/gestionParticipant", method = RequestMethod.GET)
	public String afficherParticipants(ModelMap model) {


		List<Participant> participant= new ArrayList<>();
		participant=manager.selectAllParticipant();

		participant.sort(Comparator.comparing(Participant::getNom));
		model.addAttribute("participants", participant);
		return "gestionParticipant";
	}

	@RequestMapping(path = "/ajouterParticipant", method = RequestMethod.GET)
	public String vueAjout(ModelMap model) {

		List<Participant> participant = new ArrayList<>();
		participant = manager.selectAllParticipant();
		participant.sort(Comparator.comparing(Participant::getNom));
		model.addAttribute("participants", participant);


		model.addAttribute("participant", null);
		return "gestionParticipant";
	}


	@RequestMapping(path = "/ajouterParticipant", method = RequestMethod.POST)
	public String ajouterParticipants(@RequestParam(name = "nom") String nom,
			@RequestParam(name = "prenom") String prenom, @RequestParam(name = "naissance") String naissance,
			@RequestParam(name = "mort") String mort, ModelMap model) {
		System.out.println("date : " + naissance);
		participant = new Participant();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		try {


            Date date1 = formatter.parse(naissance);
            participant.setDateDeNaissance(date1);
            if(mort!=null) {
            	 Date date2 = formatter.parse(mort); 
                 participant.setDateDeMort(date2);
            }
           

		} catch (ParseException e) {
			e.printStackTrace();
		}

		participant.setNom(nom);
		participant.setPrenom(prenom);

		manager.ajouterParticipant(participant);

		return "redirect:/app/gestionParticipant";
	}

	
	@RequestMapping(path="/supprimerParticipant", method=RequestMethod.GET)
	public String suppression(@RequestParam(name="id") Long id, ModelMap model) {
		 
		try {
			manager.supprimerParticipant(id);
		} catch (ParticipantNonTrouveException e) {
			model.addAttribute("erreur","Le participant est inconnu");
			return "gestionParticipant";
		}
		return "redirect:/app/gestionParticipant";
	}
	
	@RequestMapping(path="/modifierParticipant", method=RequestMethod.GET)
	public String vueModification(@RequestParam(name="id") Long id, ModelMap model) {
		List<Participant> participants= new ArrayList<>();
		participants=manager.selectAllParticipant();
		participants.sort(Comparator.comparing(Participant::getNom));
		model.addAttribute("participants", participants);
		
		try {
			participant=manager.selectParticipant(id);
		} catch (ParticipantNonTrouveException e) {
			model.addAttribute("erreur","Le participant est inconnu");
			return "gestionParticipant";
		}
		
		model.addAttribute("participant", participant);
		return "gestionParticipant";
	}
	
	@RequestMapping(path="/modifierParticipant", method=RequestMethod.POST) 
	public String modification(@RequestParam(name="id") Long id,@RequestParam(name="nom") String nom,@RequestParam(name="prenom") 
	String prenom,@RequestParam(name="naissance") String naissance,@RequestParam(name="mort") String mort, ModelMap model)throws ParticipantNonTrouveException {
		
		try {
			participant=manager.selectParticipant(id);
		} catch (ParticipantNonTrouveException e) {
			model.addAttribute("erreur","Le participant est inconnu");
			return "gestionParticipant";
		}
		
        try {

        	  Date date1 = formatter.parse(naissance);
              participant.setDateDeNaissance(date1);
              if(mort!=null) {
              	 Date date2 = formatter.parse(mort); 
                   participant.setDateDeMort(date2);
              }
             
        } catch (ParseException e) {
            e.printStackTrace();
        }
manager.modifierParticipant(participant);

return "redirect:/app/gestionParticipant";
	}

	@RequestMapping(path = "/supprimerParticipant", method = RequestMethod.GET)
	public String suppression(@RequestParam(name = "id") Long id) throws ParticipantNonTrouveException {

		manager.supprimerParticipant(id);
		return "redirect:/app/gestionParticipant";
	}





}
