package fr.eni.filmotheque.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.dal.ParticipantDAO;
import fr.eni.filmotheque.dal.ParticipantDAOImpl;
 

@Service
public class ParticipantManagerImpl implements ParticipantManager {
	
	@Autowired
	private ParticipantDAO  dao;
	
	public ParticipantManagerImpl(){
		
	}

	@Transactional
	public void ajouterParticipant(Participant participant) {
		if(participant.getId()==null) {
			dao.insert(participant);
		}else {
			dao.update(participant);
		}
		
	}

	@Transactional
	public void modifierParticipant(Participant participant) {
		dao.update(participant);
		
	}

	@Transactional
	public void supprimerParticipant(Participant participant) throws ParticipantNonTrouveException {
		dao.delete(participant);
		
	}

	@Override
	public List<Participant> selectAllParticipant() {
		
		return dao.getAllParticipant();
	}

	@Override
	public Participant selectParticipant(Long id) throws ParticipantNonTrouveException {
		Participant participant = dao.getParticipant(id);
		if(participant==null) {
			throw new ParticipantNonTrouveException();
		}
		return participant;
	}

	@Transactional
	public void supprimerParticipant(Long id) throws ParticipantNonTrouveException {
		dao.delete(id);
		
	}

}
