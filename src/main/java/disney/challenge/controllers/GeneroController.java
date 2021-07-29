package disney.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import disney.challenge.entities.Genero;
import disney.challenge.services.IGeneroService;

@RestController
@RequestMapping("/genero")
public class GeneroController {

	@Autowired
	IGeneroService iGeneroService;
	
	@PostMapping("/create")
	public void create(@RequestBody Genero g) {
		this.iGeneroService.create(g);
	}
}
