package disney.challenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import disney.challenge.entities.Personaje;
import disney.challenge.records.PersonajeRecord;

@Repository
public interface IPersonajeRepository extends CrudRepository<Personaje, Long> {
	
	@Query(value = "SELECT nombre, imagen FROM personaje", nativeQuery = true)
	public List<PersonajeRecord> getAllCharacters();
}
