package disney.challenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import disney.challenge.entities.Personaje;
import disney.challenge.records.PersonajeRecord;

@Repository
public interface IPersonajeRepository extends JpaRepository<Personaje, Long> {
	
	@Query(value = "SELECT nombre, imagen FROM personaje", nativeQuery = true)
	public List<PersonajeRecord> getAllCharacters();
	
	@Query(value = "SELECT * FROM personaje  WHERE (nombre = nombre)",nativeQuery = true )
	public List<Personaje> getAllByNombre(@Param("nombre") String nombre);
	
	@Query(value = "SELECT * FROM personaje  WHERE (edad = edad)",nativeQuery = true )
	public List<Personaje> getAllByEdad(@Param("edad") int edad);
	
	@Query(value = "SELECT * FROM personaje  WHERE (peso = peso)",nativeQuery = true )
	public List<Personaje> getAllByPeso(@Param("peso") double peso);
	
	//me trae todas las peli y le asigna la peli id
//	@Query(value = "SELECT * FROM personaje INNER JOIN personaje_peli_serie WHERE (peli_serie_id = peli_serie_id)",nativeQuery = true )
//	public List<Personaje> getAllByPeliSerie(@Param("peli_serie_id") Long peliSerieId);
	
	

}
