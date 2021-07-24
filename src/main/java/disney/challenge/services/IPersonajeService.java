package disney.challenge.services;

import java.util.List;
 
import disney.challenge.entities.Personaje;
import disney.challenge.records.PersonajeRecord;


public interface IPersonajeService {
	
	public List<PersonajeRecord> getAllRecord();
		
	public Personaje updateOrCreate(Personaje p);
		
	public void delete(Long id);
	
	
}
