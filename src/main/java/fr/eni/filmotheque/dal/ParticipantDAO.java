package fr.eni.filmotheque.dal;

import java.util.List;


import fr.eni.filmotheque.bo.Participant;

public interface ParticipantDAO {
	
	void insert(Participant participant);
	
	void update(Participant participant);
	
	void delete(Participant participant);
	
	void delete(Long id);
	
	Participant getParticipant(Long id);
	
	List<Participant>getAllParticipant();
	
	
	
	
	
	

}
