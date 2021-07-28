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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private String fecha_creacion;
	
	@Column(name="calificacion")
	@Min(1)
	@Max(5)
	private int calificacion;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="genero_id")
	private Genero genero;
	
    @JsonIgnoreProperties("pelisSeries")
	@ManyToMany(mappedBy = "pelisSeries",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY) 
	private List<Personaje> personajes = new ArrayList<Personaje>();
    
    public void removePersonajes() {
    	this.personajes.removeAll(personajes);
    }

	
}
