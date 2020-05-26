package fr.eni.filmotheque.dal;

import java.util.List;

import fr.eni.filmotheque.bo.Participant;

public interface ParticipantDAO {
	
	void insert(Participant participant);
	
	void update(Participant participant);
	
	void delete(Participant participant);
	
	void delete(int id);
	
	Participant getParticipant(int id);
	
	List<Participant>getAllParticipant();
	
	
	
	
	
	

}
