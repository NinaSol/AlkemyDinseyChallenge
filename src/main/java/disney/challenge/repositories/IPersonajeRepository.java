package disney.challenge.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import disney.challenge.entities.Personaje;

@Repository
public interface IPersonajeRepository extends CrudRepository<Personaje, Long> {
	
}
