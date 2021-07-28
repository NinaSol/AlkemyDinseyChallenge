package disney.challenge.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "personaje")
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

	@Column(name = "edad")
	private int edad;

	@Column(name = "peso")
	private double peso;

	@NotEmpty
	@Column(name = "historia", nullable = false)
	private String historia;

	@ManyToMany(targetEntity = PeliSerie.class, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "personaje_peliSerie", joinColumns = @JoinColumn(name = "personaje_id"), inverseJoinColumns = @JoinColumn(name = "peliSerie_id"))
	private List<PeliSerie> pelisSeries = new ArrayList<PeliSerie>();

	public List<PeliSerie> getPelisSeries() {
		return this.pelisSeries;
	}

	public void addPeliSerie(PeliSerie peliSerie) {
		this.pelisSeries.add(peliSerie);
	}
	
	public void removePelisSeries() {
		this.pelisSeries.removeAll(pelisSeries);
	}

}
