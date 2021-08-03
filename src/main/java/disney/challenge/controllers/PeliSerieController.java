package disney.challenge.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import disney.challenge.entities.Genero;
import disney.challenge.entities.PeliSerie;
import disney.challenge.entities.Personaje;
import disney.challenge.records.PeliSerieRecord;
import disney.challenge.services.IPeliSerieService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/movies")
public class PeliSerieController {

	@Autowired
	private IPeliSerieService iPeliSerieService;

	@ApiOperation("Muestra la lista con los campos de imagen, titulo y fecha de creacion")
	@GetMapping
	public ResponseEntity<List<PeliSerieRecord>> getAllMovies() {
		List<PeliSerieRecord> pelisSeries = this.iPeliSerieService.getAllMovies();
		return new ResponseEntity<List<PeliSerieRecord>>(pelisSeries, HttpStatus.OK);
	}
	@ApiOperation("Muestra en una pelicula/serie junto a sus personajes asociados")
	@GetMapping("/detail/{id}")
	public PeliSerie getAllDetail(@PathVariable Long id) {
		return this.iPeliSerieService.getAllDetail(id);
	}
	
	@ApiOperation("Muestra una pelicula/serie al buscarla por su titulo")
	@GetMapping("/titulo")
	public ResponseEntity<List<PeliSerie>> getAllByNombre(@RequestParam String titulo) {
		List<PeliSerie> pelisSeries = this.iPeliSerieService.getAllByTitulo(titulo);
		return new ResponseEntity<List<PeliSerie>>(pelisSeries, HttpStatus.OK);
	}

	@ApiOperation("Muestra una pelicula/serie al buscarla por su genero")
	@GetMapping("/genero")
	public ResponseEntity<List<PeliSerie>> getAllByGenero(@RequestParam Long genero_id) {
		List<PeliSerie> pelisSeries = this.iPeliSerieService.getAllByGenero(genero_id);
		return new ResponseEntity<List<PeliSerie>>(pelisSeries, HttpStatus.OK);
	}
	
	@ApiOperation("Muestra la lista en orden ASC,DESC por fecga de creacion")
	@GetMapping("/orden")
	public ResponseEntity<List<PeliSerie>> getAllByDateOrder(@RequestParam String orden){
		return new ResponseEntity<List<PeliSerie>>(this.iPeliSerieService.orderByDate(orden), HttpStatus.OK);
	}

	@ApiOperation("Creacion de pelicula/serie")
	@PostMapping("/create")
	public ResponseEntity<PeliSerie> create(@Valid @RequestBody PeliSerie p) {
		this.iPeliSerieService.create(p);
		return new ResponseEntity<PeliSerie>(p, HttpStatus.CREATED);
	}

	@ApiOperation("Edicion de pelicula/serie")
	@PutMapping("/update/{id}")
	public void update(@PathVariable Long id, @Valid @RequestBody PeliSerie p) {
		this.iPeliSerieService.update(id, p);
	}
	
	@ApiOperation("Le asignamos un genero a una pelicula/serie")
	@PutMapping("/asignGenero/{id}/{genero_id}")
	public void agregarGenero(@PathVariable Long id, @PathVariable Long genero_id) {
		this.iPeliSerieService.asignGenero(id, genero_id);
	}

	@ApiOperation("Eliminacion de pelicula/serie")
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		this.iPeliSerieService.delete(id);
	}

}
