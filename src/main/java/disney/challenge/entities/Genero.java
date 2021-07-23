package disney.challenge.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
	
	//agregar integridad referencial, si la peli_id no existe que no se agregue 
	//actualizar en cascada, si una peli se actualiza que se actualize en la tabla
	//eliminar "" "" "" "" "" "" "" "" "" "" "", si no existe mas el genero se eliminan las pelis
	//agregar "" "" "" "" "" es del mismo genero que se agregue
	//todo seria ALL
	//mapeo el atributo genre de PeliSerie
	@OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
	private Set<PeliSerie> pelisSeries = new HashSet<PeliSerie>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Set<PeliSerie> getPelisSeries() {
		return pelisSeries;
	}

	public void setPelisSeries(Set<PeliSerie> pelisSeries) {
		this.pelisSeries = pelisSeries;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
