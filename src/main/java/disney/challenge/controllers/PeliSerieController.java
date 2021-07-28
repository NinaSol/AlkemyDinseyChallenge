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

@RestController
@RequestMapping(value = "/movies")
public class PeliSerieController {
	
	@Autowired
	private IPeliSerieService iPeliSerieService;
	
	@GetMapping
	public ResponseEntity<List<PeliSerieRecord>> getAllMovies(){
		List<PeliSerieRecord> pelisSeries = this.iPeliSerieService.getAllMovies();
		return new ResponseEntity<List<PeliSerieRecord>>(pelisSeries,HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public PeliSerie getAllDetail(@PathVariable Long id) {
		return this.iPeliSerieService.getAllDetail(id);
	}
	
	@GetMapping("/titulo")
	public ResponseEntity<List<PeliSerie>> getAllByNombre(@RequestParam String titulo){
		List<PeliSerie> pelisSeries = this.iPeliSerieService.getAllByTitulo(titulo);
		return new ResponseEntity<List<PeliSerie>>(pelisSeries,HttpStatus.OK);
	}
	
	@PostMapping("/create") 
	public ResponseEntity<PeliSerie> create(@Valid @RequestBody PeliSerie p) {
		this.iPeliSerieService.create(p);
    	return new ResponseEntity<PeliSerie>(p,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}") 
	public void update(@PathVariable Long id, @Valid @RequestBody PeliSerie p) {
		this.iPeliSerieService.update(id, p);
	}
	
	@PutMapping("/asignGenero/{id}/{genero_id}")
	public void agregarGenero(@PathVariable Long id,@PathVariable Long genero_id) {
		this.iPeliSerieService.asignGenero(id, genero_id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		this.iPeliSerieService.delete(id);
	}
	
	
}
