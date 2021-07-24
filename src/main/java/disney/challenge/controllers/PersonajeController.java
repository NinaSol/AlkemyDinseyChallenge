package disney.challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import disney.challenge.records.PersonajeRecord;
import disney.challenge.services.IPersonajeService;

@RestController
public class PersonajeController {
	
	@Autowired
	private IPersonajeService iPersonajeService;
	
	@GetMapping("/characters")
	public ResponseEntity<List<PersonajeRecord>> getAllCharacters(){
		List<PersonajeRecord> personajes = this.iPersonajeService.getAllCharacters();
		return new ResponseEntity<List<PersonajeRecord>>(personajes,HttpStatus.OK);
		
	}
}
