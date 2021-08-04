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

import disney.challenge.entities.Personaje;
import disney.challenge.records.PersonajeRecord;
import disney.challenge.services.IPersonajeService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/characters")
public class PersonajeController {

	@Autowired
	private IPersonajeService iPersonajeService;

	@ApiOperation("Muestra la lista con los campos imagen y nombre")
	@GetMapping
	public ResponseEntity<List<PersonajeRecord>> getAllRecord() {
		List<PersonajeRecord> personajes = this.iPersonajeService.getAllRecords();
		return new ResponseEntity<List<PersonajeRecord>>(personajes, HttpStatus.OK);
	}

	@ApiOperation("Muestra un personaje con sus peliculas/series relacionadas")
	@GetMapping("/detail/{id}")
	public Personaje getAllDetail(@PathVariable Long id) {
		return this.iPersonajeService.getAllDetail(id);

	}

	@ApiOperation("Muestra un/unos personaje/s al buscarlo por su nombre")
	@GetMapping("/nombre")
	public ResponseEntity<List<Personaje>> getAllByNombre(@RequestParam String nombre) {
		List<Personaje> personajes = this.iPersonajeService.getAllByNombre(nombre);
		return new ResponseEntity<List<Personaje>>(personajes, HttpStatus.OK);
	}

	@ApiOperation("Muestra un/unos personaje/s al buscarlo por su edad")
	@GetMapping("/edad")
	public ResponseEntity<List<Personaje>> getAllByEdad(@RequestParam int edad) {
		List<Personaje> personajes = this.iPersonajeService.getAllByEdad(edad);
		return new ResponseEntity<List<Personaje>>(personajes, HttpStatus.OK);
	}

	@ApiOperation("Muestra un/unos personaje/s al buscarlo por su peso")
	@GetMapping("/peso")
	public ResponseEntity<List<Personaje>> getAllByPeso(@RequestParam double peso) {
		List<Personaje> personajes = this.iPersonajeService.getAllByPeso(peso);
		return new ResponseEntity<List<Personaje>>(personajes, HttpStatus.OK);
	}

	@ApiOperation("Muestra un/unos personaje/s al buscarlo por una pelicula/serie relacionada")
	@GetMapping("/peliserie")
	public ResponseEntity<List<Personaje>> getAllByPeliSerie(@RequestParam Long idPeliSerie) {
		List<Personaje> personajes = this.iPersonajeService.getAllByPeliSerie(idPeliSerie);
		return new ResponseEntity<List<Personaje>>(personajes, HttpStatus.OK);
	}

	@ApiOperation("Creacion de personaje")
	@PostMapping("/create")
	public ResponseEntity<Personaje> create(@Valid @RequestBody Personaje p) {
		this.iPersonajeService.create(p);
		return new ResponseEntity<Personaje>(p, HttpStatus.CREATED);
	}

	@ApiOperation("Edicion de personaje")
	@PutMapping("/update/{id}")
	public void update(@PathVariable Long id, @Valid @RequestBody Personaje p) {
		this.iPersonajeService.update(id, p);
	}

	@ApiOperation("Le asignamos una pelicula/serie relacionada al personaje")
	@PutMapping("/addPeliSerie/{id}/{idPeliSerie}")
	public void addPeliSerie(@PathVariable Long id, @PathVariable Long idPeliSerie) {
		this.iPersonajeService.addPeliSerie(id, idPeliSerie);
	}

	@ApiOperation("Eliminacion de personaje")
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		this.iPersonajeService.delete(id);
	}

}
