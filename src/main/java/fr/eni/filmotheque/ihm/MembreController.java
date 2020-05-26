package fr.eni.filmotheque.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.eni.filmotheque.bll.MembreManager;

@Controller
public class MembreController {

	@Autowired
	private MembreManager membreMger;

}
