package disney.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import disney.challenge.entities.PeliSerie;

@Repository
public interface IPeliSerieRepository extends JpaRepository<PeliSerie,Long>{

}
