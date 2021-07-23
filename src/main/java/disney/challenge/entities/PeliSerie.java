package disney.challenge.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
	
	@ManyToMany(mappedBy = "pelisSeries") //definir luego el cascade type y su fetch type
	private Set<Personaje> personajes = new HashSet<Personaje>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFeachaCreacion() {
		return feachaCreacion;
	}

	public void setFeachaCreacion(String feachaCreacion) {
		this.feachaCreacion = feachaCreacion;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Set<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(Set<Personaje> personajes) {
		this.personajes = personajes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
