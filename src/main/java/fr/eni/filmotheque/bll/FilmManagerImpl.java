package fr.eni.filmotheque.bll;


import java.util.List;	
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.dal.FilmDAO;
import fr.eni.filmotheque.dal.FilmDAOImpl;

@Service
public class FilmManagerImpl implements FilmManager{
	
	@Autowired
	private FilmDAO dao;

	@Override
	public void Ajouter(Film f) {
		// TODO Auto-generated method stub
		if(f.getId() == null) {
			dao.Ajouter(f);
		}else {
			dao.Modifier(f);
		}
	}

	@Override
	public void Supprimer(Film f) {
		// TODO Auto-generated method stub
		dao.Supprimer(f);
	}

	@Override
	public void Supprimer(Long id) {
		// TODO Auto-generated method stub
		dao.Supprimer(id);
	}

	@Override
	public void Modifier(Film f) {
		// TODO Auto-generated method stub
		dao.Modifier(f);
	}

	@Override
	public Film SelectById(Long id) {
		// TODO Auto-generated method stub
		
		return dao.SelectById(id);
	}

	@Override
	public List<Film> SelectAll() {
		// TODO Auto-generated method stub
		return dao.SelectAll();
	}
	
	
	
	
	
	
}
