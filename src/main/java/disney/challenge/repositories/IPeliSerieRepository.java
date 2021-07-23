package disney.challenge.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import disney.challenge.entities.PeliSerie;

@Repository
public interface IPeliSerieRepository extends CrudRepository<PeliSerie,Long>{

}
