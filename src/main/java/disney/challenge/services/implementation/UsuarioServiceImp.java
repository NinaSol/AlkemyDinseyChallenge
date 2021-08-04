package disney.challenge.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import disney.challenge.entities.Usuario;
import disney.challenge.repositories.IUsuarioRepository;
import disney.challenge.services.IUsuarioService;

import java.io.IOException;

@Service
public class UsuarioServiceImp implements IUsuarioService {
	@Autowired
	private IUsuarioRepository iUsuarioRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void register(Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		this.iUsuarioRepository.save(usuario);
	}

	@Override
	public void sendWelcomeEmail(String email) throws IOException {

		Email from = new Email("pruebasprogramacion8@gmail.com");
		String subject = "Bienvenida";
		Email to = new Email(email);
		Content content = new Content("text/plain", "Bienvenido, gracias por registrarte");
		Mail mail = new Mail(from, subject, to, content);
		// API KEY publica para que se pueda ver su funcionalidad sin adquirir una.
		SendGrid sg = new SendGrid("your sendgrid api key");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			throw ex;
		}

	}
}
