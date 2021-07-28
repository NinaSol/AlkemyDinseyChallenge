package disney.challenge.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Entity
@Table(name="genero")
@Data
public class Genero implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@NotEmpty
	@Column(name = "imagen", nullable = false)
	private String imagen;
	

	@JsonBackReference
	@OneToMany(mappedBy = "genero", cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<PeliSerie> pelisSeries = new ArrayList<PeliSerie>();

	
}
