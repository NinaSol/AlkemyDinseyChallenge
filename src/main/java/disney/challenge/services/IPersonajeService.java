package disney.challenge.services;

import java.util.List;
 
import disney.challenge.entities.Personaje;
import disney.challenge.records.PersonajeRecord;


public interface IPersonajeService {
	
	public List<PersonajeRecord> getAllRecords();
	
	public Personaje getAllDetail(Long id);
		
	public void create(Personaje p);
	
	public void update(Long id, Personaje p);
		
	public void delete(Long id);
	
	public void addPeliSerie(Long id, Long idPeliSerie);
	
	public List<Personaje> getAllByNombre(String nombre);
	
	public List<Personaje> getAllByEdad(int edad);
	
	public List<Personaje> getAllByPeso(double peso);
	
	public List<Personaje> getAllByPeliSerie(Long idPeliSerie);
		
}
