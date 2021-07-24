package disney.challenge.records;

public interface PersonajeRecord {
	
	
//getNombreEImagen() --> @Value("#{target.nombre + '' + target.imagen}")
	public String getNombre();

	public String getImagen();
	
	
	
}
