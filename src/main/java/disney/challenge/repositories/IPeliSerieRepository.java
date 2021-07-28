package disney.challenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import disney.challenge.entities.PeliSerie;
import disney.challenge.records.PeliSerieRecord;

@Repository
public interface IPeliSerieRepository extends JpaRepository<PeliSerie,Long>{
	
	@Query(value = "SELECT imagen, titulo, fecha_creacion FROM peli_serie", nativeQuery = true)
	public List<PeliSerieRecord> getAllMovies();
	
	@Query(value = "SELECT * FROM peli_Serie WHERE titulo=:titulo",nativeQuery = true )
	public List<PeliSerie> getAllByTitulo(@Param("titulo") String titulo);

}
