package disney.challenge.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import disney.challenge.entities.Personaje;
import disney.challenge.records.PersonajeRecord;
import disney.challenge.services.IPersonajeService;

@RestController
@RequestMapping("/characters")
public class PersonajeController {
	
	@Autowired
	private IPersonajeService iPersonajeService;
	
	@GetMapping
	public ResponseEntity<List<PersonajeRecord>> getAllRecord(){
		List<PersonajeRecord> personajes = this.iPersonajeService.getAllRecord();
		return new ResponseEntity<List<PersonajeRecord>>(personajes,HttpStatus.OK);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<Personaje> createPersonaje(){
		return null;	
	}
}
