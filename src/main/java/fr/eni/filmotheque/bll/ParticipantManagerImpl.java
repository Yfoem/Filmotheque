package fr.eni.filmotheque.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.dal.ParticipantDAO;

@Service
public class ParticipantManagerImpl implements ParticipantManager {
	
	@Autowired
	private ParticipantDAO dao;

	@Override
	public void ajouterParticipant(Participant participant) {
		dao.insert(participant);
		
	}

	@Override
	public void modifierParticipant(Participant participant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerParticipant(Participant participant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Participant> selectAllParticipant() {
		
		return dao.getAllParticipant();
	}

	@Override
	public Participant selectParticipant(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
