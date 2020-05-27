package fr.eni.filmotheque.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.dal.FilmDAO;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO dao;
	
	@RequestMapping(method = RequestMethod.GET,path = {"/","/action"})
	public void action() {
		Film f = new Film("Les chats",2017);
		dao.add(f);
	}
}
