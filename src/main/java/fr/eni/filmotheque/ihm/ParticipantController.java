package fr.eni.filmotheque.ihm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.filmotheque.bll.ParticipantManager;
import fr.eni.filmotheque.bll.ParticipantManagerImpl;
import fr.eni.filmotheque.bo.Participant;

@Controller
public class ParticipantController {
	
	@Autowired
	private ParticipantManager  manager;
	
	private Participant  participant=null;
	
	@RequestMapping(path="/gestionParticipant", method=RequestMethod.GET)
	public String afficherParticipants(ModelMap model) {
//		participant=new Participant("Miller","Toad",new Date(),new Date());
//		manager.ajouterParticipant(participant);
		List<Participant> participant= new ArrayList<>();
		participant=manager.selectAllParticipant();
		model.addAttribute("participant", participant);
		return "gestionParticipant";
	}
	
	
	@RequestMapping(path="/ajouterParticipant", method=RequestMethod.GET)
	public String vueAjout(ModelMap model) {
		
		List<Participant> participant= new ArrayList<>();
		model.addAttribute("participant", participant);
		return "ajouterParticipant";
	}
	
	@RequestMapping(path="/ajouterParticipant", method=RequestMethod.POST)
	public String ajouterParticipants(@RequestParam(name="nom") String nom,@RequestParam(name="prenom") String prenom,
			@RequestParam(name="naissance") String naissance,@RequestParam(name="mort")  String mort,ModelMap model) {
		System.out.println("date : "+naissance);
		participant=new Participant();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         

        try {

            Date date1 = formatter.parse(naissance);
            Date date2 = formatter.parse(mort); 
            
            participant.setDateDeNaissance(date1);
            participant.setDateDeMort(date2);
            System.out.println(formatter.format(date1));

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
		 
		manager.supprimerParticipant(id);
		return "redirect:/app/gestionParticipant";
	}
	
	@RequestMapping(path="/modifierParticipant", method=RequestMethod.GET)
	public String modification() {
		 
		
		return "modifierParticipant";
	}
	
	
	
	

}