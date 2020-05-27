package fr.eni.filmotheque.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.eni.filmotheque.bo.Participant;


@Repository
public class ParticipantDAOImpl implements ParticipantDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void insert(Participant participant) {
		em.persist(participant);
		
	}

	@Override
	public void update(Participant participant) {
		if(!em.contains(participant)) {
			em.merge(participant);
		}
		em.flush();
		
	}

	@Override
	public void delete(Participant participant) {
		if(!em.contains(participant)) {
			em.merge(participant);
		}
		em.remove(participant);
	}

	@Override
	public Participant getParticipant(Long id) {
		em.find(Participant.class, id);
		return null;
	}

	@Override
	public List<Participant> getAllParticipant() {
		 
		return em.createQuery("SELECT p FROM  Participant p", Participant.class).getResultList();
	}

	@Override
	public void delete(Long id) {
		Participant participant = getParticipant(id);
		delete(participant);
		
	}

}
