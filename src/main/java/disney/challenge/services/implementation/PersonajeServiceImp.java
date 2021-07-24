package disney.challenge.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import disney.challenge.records.PersonajeRecord;
import disney.challenge.repositories.IPersonajeRepository;
import disney.challenge.services.IPersonajeService;

@Service
public class PersonajeServiceImp implements IPersonajeService{

	@Autowired
	private IPersonajeRepository iPersonajeRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<PersonajeRecord> getAllCharacters() {
		return this.iPersonajeRepository.getAllCharacters();
		
	}
	
	
}
