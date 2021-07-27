package disney.challenge.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;


@Entity
@Table(name="peli_serie")
@Data
public class PeliSerie implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name="imagen", nullable = false)
	private String imagen;
	
	@NotEmpty
	@Column(name="titulo", nullable = false)
	private String titulo;
	
	@NotEmpty
	@Column(name="fecha_creacion", nullable = false)
	private String feachaCreacion;
	
	@NotEmpty
	@Column(name="calificacion")
	@Size(min = 1, max = 5)
	private int calificacion;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="genero_id")
	private Genero genero;
	
	@JsonBackReference
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "pelisSeries", cascade = { CascadeType.ALL}) 
	private List<Personaje> personajes = new ArrayList<Personaje>();


	
}
