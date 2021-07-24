package disney.challenge.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import disney.challenge.entities.Personaje;
import disney.challenge.records.PersonajeRecord;
import disney.challenge.repositories.IPersonajeRepository;
import disney.challenge.services.IPersonajeService;

@Service
public class PersonajeServiceImp implements IPersonajeService {

	@Autowired
	private IPersonajeRepository iPersonajeRepository;

	@Override
	//@Transactional(readOnly = true)
	public List<PersonajeRecord> getAllRecord() {
		return this.iPersonajeRepository.getAllCharacters();

	}

	@Override
	public Personaje updateOrCreate(Personaje p) {
		return this.iPersonajeRepository.save(p);
	}

	@Override
	public void delete(Long id) {
		Optional<Personaje> personaje = this.iPersonajeRepository.findById(id);
		if (personaje != null) {
			this.iPersonajeRepository.deleteById(id);
		}
	}
	
	

}
