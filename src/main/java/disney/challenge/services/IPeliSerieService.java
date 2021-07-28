package disney.challenge.services;

import java.util.List;

import disney.challenge.entities.Genero;
import disney.challenge.entities.PeliSerie;
import disney.challenge.records.PeliSerieRecord;

public interface IPeliSerieService {

	public List<PeliSerieRecord> getAllMovies();
	
	public PeliSerie getAllDetail(Long id);
	
	public void create(PeliSerie p);
	
	public void update(Long id, PeliSerie p);
	
	public void asignGenero(Long id, Long genero_id);
		
	public void delete(Long id);
	
	public List<PeliSerie> getAllByTitulo(String titulo);
	
	public List<PeliSerie> getAllByGenero(Long genero_id);
}
