package disney.challenge.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Table(name = "personaje")
@Data
public class Personaje implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "imagen", nullable = false)
	private String imagen;

	@NotEmpty
	@Column(name = "nombre", nullable = false)
	private String nombre;

	@NotEmpty
	@Column(name = "edad", nullable = false)
	private int edad;

	@NotEmpty
	@Column(name = "peso", nullable = false)
	private double peso;

	@NotEmpty
	@Column(name = "historia", nullable = false)
	private String historia;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER) 
	@JoinTable(name = "personaje_peliSerie", joinColumns = @JoinColumn(name = "personaje_id"), inverseJoinColumns = @JoinColumn(name = "peliSerie_id"))
	private Set<PeliSerie> pelisSeries = new HashSet<PeliSerie>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public void setPelisSeries(Set<PeliSerie> pelisSeries) {
		this.pelisSeries = pelisSeries;
	}

}
