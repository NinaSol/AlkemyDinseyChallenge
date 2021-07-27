package disney.challenge.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import disney.challenge.entities.Genero;
import disney.challenge.entities.Personaje;
import disney.challenge.records.PersonajeRecord;
import disney.challenge.services.IPersonajeService;

@RestController
@RequestMapping(value = "/characters")
public class PersonajeController {
	
	@Autowired
	private IPersonajeService iPersonajeService;
	
	@GetMapping
	public ResponseEntity<List<PersonajeRecord>> getAllRecord(){
		List<PersonajeRecord> personajes = this.iPersonajeService.getAllRecords();
		return new ResponseEntity<List<PersonajeRecord>>(personajes,HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public Personaje getAllDetail(@PathVariable Long id){
		return this.iPersonajeService.getAllDetail(id);
		
	}
	
 
	@PostMapping("/create") 
	public ResponseEntity<Personaje> create(@Valid @RequestBody Personaje p) {
		this.iPersonajeService.create(p);
    	return new ResponseEntity<Personaje>(p,HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}") 
	public void update(@PathVariable Long id, @Valid @RequestBody Personaje p) {
		this.iPersonajeService.update(id, p);
	}
	
	@PutMapping("/add/{id}/{idPeliSerie}") 
	public void addPeliSerie(@PathVariable Long id, @PathVariable Long idPeliSerie){
		this.iPersonajeService.addPeliSerie(id, idPeliSerie);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		this.iPersonajeService.delete(id);
	}
	
}
