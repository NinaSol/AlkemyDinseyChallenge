package disney.challenge.services;


import disney.challenge.entities.Usuario;

public interface IUsuarioService {
	public void register(Usuario usuario);
	
	public void sendGrid();
}
