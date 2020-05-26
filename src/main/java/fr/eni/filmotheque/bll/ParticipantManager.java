package fr.eni.filmotheque.bll;

import java.util.List;

import fr.eni.filmotheque.bo.Participant;

public interface ParticipantManager {
	
	void ajouterParticipant(Participant participant);
	
	void modifierParticipant(Participant participant);
	
	void supprimerParticipant(Participant participant);
	
	List<Participant>selectAllParticipant();
	
	Participant selectParticipant(int id);
	
;
}
