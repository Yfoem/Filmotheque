package fr.eni.filmotheque.dal;

import java.util.List;

import fr.eni.filmotheque.bo.Membre;

public interface MembreDAO {
	public void add(Membre membre);

	public void update(Membre membre);

	public void delete(Membre membre);

	public void delete(Long id);

	public Membre findById(long id);

	public List<Membre> findAll();
}
