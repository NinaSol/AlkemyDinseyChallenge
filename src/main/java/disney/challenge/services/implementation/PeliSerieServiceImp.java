package disney.challenge.services.implementation;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import disney.challenge.entities.Genero;
import disney.challenge.entities.PeliSerie;
import disney.challenge.records.PeliSerieRecord;
import disney.challenge.repositories.IGeneroRepository;
import disney.challenge.repositories.IPeliSerieRepository;
import disney.challenge.services.IPeliSerieService;

@Service
public class PeliSerieServiceImp implements IPeliSerieService {

	@Autowired
	IPeliSerieRepository iPeliSerieRepository;

	@Autowired
	IGeneroRepository iGeneroRepository;

	@Override
	public List<PeliSerieRecord> getAllMovies() {
		return this.iPeliSerieRepository.getAllMovies();
	}

	@Override
	public PeliSerie getAllDetail(Long id) {
		PeliSerie peliSerie = null;
		Optional<PeliSerie> optionalPeliSerie = this.iPeliSerieRepository.findById(id);
		if (optionalPeliSerie.isPresent()) {
			peliSerie = optionalPeliSerie.get();
		}
		return peliSerie;
	}

	@Override
	public List<PeliSerie> getAllByTitulo(String titulo) {
		return this.iPeliSerieRepository.getAllByTitulo(titulo);
	}

	@Override
	public List<PeliSerie> getAllByGenero(Long genero_id) {
		List<PeliSerie> pelisSeries = null;
		Optional<Genero> optionalGenero = this.iGeneroRepository.findById(genero_id);
		if (optionalGenero.isPresent()) {
			Genero genero = optionalGenero.get();
			pelisSeries = genero.getPelisSeries();
		}
		return pelisSeries;
	}

	@Override
	public void create(PeliSerie p) {
		this.iPeliSerieRepository.save(p);

	}

	@Override
	public void update(Long id, PeliSerie p) {
		Optional<PeliSerie> optionalPeliSerie = this.iPeliSerieRepository.findById(id);
		if (optionalPeliSerie.isPresent()) {
			PeliSerie peliSerie = optionalPeliSerie.get();
			peliSerie.setCalificacion(p.getCalificacion());
			peliSerie.setFechaCreacion(p.getFechaCreacion());
			peliSerie.setGenero(p.getGenero());
			peliSerie.setImagen(p.getImagen());
			peliSerie.setTitulo(p.getTitulo());
			this.iPeliSerieRepository.save(peliSerie);
		}

	}

	@Override
	public void asignGenero(Long id, Long genero_id) {
		Optional<PeliSerie> optionalPeliSerie = this.iPeliSerieRepository.findById(id);
		Optional<Genero> optionalGenero = this.iGeneroRepository.findById(genero_id);
		if (optionalPeliSerie.isPresent() && optionalGenero.isPresent()) {
			PeliSerie peliSerie = optionalPeliSerie.get();
			Genero genero = optionalGenero.get();
			peliSerie.setGenero(genero);
			this.iPeliSerieRepository.save(peliSerie);
		}

	}

	@Override
	public void delete(Long id) {
		Optional<PeliSerie> optionalPeliSerie = this.iPeliSerieRepository.findById(id);
		if (optionalPeliSerie.isPresent()) {
			PeliSerie peliSerie = optionalPeliSerie.get();
			peliSerie.removePersonajes();
			this.iPeliSerieRepository.delete(peliSerie);
		}
	}

	@Override
	public List<PeliSerie> orderByDate(String orden) {
		List<PeliSerie> pelisSeries = null;
		if (orden.equalsIgnoreCase("asc")) {
			pelisSeries = this.iPeliSerieRepository.orderByAscDate();
		}else if(orden.equalsIgnoreCase("desc")) {
			pelisSeries = this.iPeliSerieRepository.orderByDescDate();
		}
		return pelisSeries;
	}

}
