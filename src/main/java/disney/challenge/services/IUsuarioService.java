package disney.challenge.services;

import java.io.IOException;
import disney.challenge.entities.Usuario;

public interface IUsuarioService {
	public void register(Usuario usuario);

	public void sendWelcomeEmail(String email) throws IOException;

}
