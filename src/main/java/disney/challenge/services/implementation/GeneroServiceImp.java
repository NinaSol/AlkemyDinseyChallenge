package disney.challenge.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import disney.challenge.entities.Genero;
import disney.challenge.repositories.IGeneroRepository;
import disney.challenge.services.IGeneroService;

@Service
public class GeneroServiceImp implements IGeneroService{

	@Autowired
	IGeneroRepository iGeneroRepository;
	
	@Override
	public void create(Genero g) {
		this.iGeneroRepository.save(g);
	}
	
}
