package disney.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import disney.challenge.entities.Genero;

@Repository
public interface IGeneroRepository extends JpaRepository<Genero,Long>{
	
}
