package fr.eni.filmotheque.ihm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParticipantController {
	
	@RequestMapping(path="/gestionParticipant", method=RequestMethod.GET)
	public String afficherParticipants() {
		
		return "gestionParticipant";
	}

}
