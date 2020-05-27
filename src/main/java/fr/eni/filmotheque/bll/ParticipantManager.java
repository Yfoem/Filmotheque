package fr.eni.filmotheque.bll;

import java.util.List;

import fr.eni.filmotheque.bo.Participant;

public interface ParticipantManager {
	
	void ajouterParticipant(Participant participant);
	
	void modifierParticipant(Participant participant);
	
	void supprimerParticipant(Participant participant);
	
	void supprimerParticipant(Long id);
	
	List<Participant>selectAllParticipant();
	
	Participant selectParticipant(Long id);
	
;
}
