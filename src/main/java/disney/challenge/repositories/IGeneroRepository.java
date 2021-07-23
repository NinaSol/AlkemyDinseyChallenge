package disney.challenge.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import disney.challenge.entities.Genero;

@Repository
public interface IGeneroRepository extends CrudRepository<Genero,Long>{
	
}
