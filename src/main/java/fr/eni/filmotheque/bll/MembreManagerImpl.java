package fr.eni.filmotheque.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.eni.filmotheque.bo.Membre;
import fr.eni.filmotheque.dal.MembreDAO;

@org.springframework.stereotype.Service(value = "MembreManager")
public class MembreManagerImpl implements MembreManager {

	@Autowired
	private MembreDAO dao;

	public MembreManagerImpl() {

	}

	public Membre findById(long id) throws MembreNonTrouveException {
		Membre membre = dao.findById(id);
		if (membre == null) {
			throw new MembreNonTrouveException();
		}
		return membre;
	}

	@Transactional
	public void enregistrerMembre(Membre membre) {
		if (membre.getId() == null) {
			dao.add(membre);
		} else {
			dao.update(membre);
		}
	}

	@Transactional
	public void supprimerMembre(Long id) throws MembreNonTrouveException {

		dao.delete(id);

	}

	@Override
	public List<Membre> findAllMembres() {
		return dao.findAll();
	}

	@Override
	public Membre findByName(String name) throws MembreNonTrouveException {
		Membre membre = dao.findByName(name);
		if (membre == null) {
			throw new MembreNonTrouveException();
		}
		return membre;
	}
}
