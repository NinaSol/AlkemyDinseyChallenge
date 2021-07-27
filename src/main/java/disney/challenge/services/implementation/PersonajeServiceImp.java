package disney.challenge.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import disney.challenge.entities.PeliSerie;
import disney.challenge.entities.Personaje;
import disney.challenge.records.PersonajeRecord;
import disney.challenge.repositories.IPeliSerieRepository;
import disney.challenge.repositories.IPersonajeRepository;
import disney.challenge.services.IPersonajeService;

@Service
public class PersonajeServiceImp implements IPersonajeService {

	@Autowired
	private IPersonajeRepository iPersonajeRepository;

	@Autowired
	private IPeliSerieRepository iPeliSerieRepository;

	/* get requests */

	@Override
	// @Transactional(readOnly = true)
	public List<PersonajeRecord> getAllRecords() {
		return this.iPersonajeRepository.getAllCharacters();

	}

	@Override
	public Personaje getAllDetail(Long id) {
		return this.iPersonajeRepository.findById(id).orElse(null);
	}
	
	/* delete requests */

	@Override
	public void delete(Long id) {
		Optional<Personaje> optionalPersonaje = this.iPersonajeRepository.findById(id);
		if (optionalPersonaje.isPresent()) {
			this.iPersonajeRepository.deleteById(id);
		}
	}

	/* post requests */

	@Override
	@Transactional
	public void create(Personaje p) {
			this.iPersonajeRepository.save(p);
	}

	/* put requests */

	@Override
	public void update(Long id, Personaje p) {
		Optional<Personaje> optionalPersonaje = this.iPersonajeRepository.findById(id);

		if (optionalPersonaje.isPresent()) {
			Personaje personaje = optionalPersonaje.get();
			personaje.setNombre(p.getNombre());
			personaje.setEdad(p.getEdad());
			personaje.setHistoria(p.getHistoria());
			personaje.setImagen(p.getImagen());
			personaje.setPeso(p.getPeso());
		}

	}

	@Override
	@Transactional
	public void addPeliSerie(Long id, Long idPeliSerie) {
		Optional<Personaje> optionalPersonaje = this.iPersonajeRepository.findById(id);
		Optional<PeliSerie> optionalPeliSerie = this.iPeliSerieRepository.findById(idPeliSerie);

		if (optionalPersonaje.isPresent() && optionalPeliSerie.isPresent()) {
			PeliSerie peliSerie = optionalPeliSerie.get();
			Personaje personaje = optionalPersonaje.get();
			personaje.addPeliSerie(peliSerie);
		}

	}

}
