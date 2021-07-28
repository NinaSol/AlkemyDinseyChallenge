package disney.challenge.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@JsonBackReference
	@OneToMany(mappedBy = "genero", cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<PeliSerie> pelisSeries = new ArrayList<PeliSerie>();

	
}
