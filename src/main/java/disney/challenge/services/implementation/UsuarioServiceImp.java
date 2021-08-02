package disney.challenge.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import disney.challenge.entities.Usuario;
import disney.challenge.repositories.IUsuarioRepository;
import disney.challenge.services.IUsuarioService;

import java.util.ArrayList;

import java.io.IOException;

@Service
public class UsuarioServiceImp implements IUsuarioService {
	@Autowired
	private IUsuarioRepository iUsuarioRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void register(Usuario usuario) {
		Usuario usuarioBusqueda = this.iUsuarioRepository.findByUserName(usuario.getUserName());
		if (usuarioBusqueda == null) {
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			this.iUsuarioRepository.save(usuario);
		}
	}

	@Override
	public void sendGrid() {
//	    Email from = new Email("test@example.com");
//	    String subject = "Sending with SendGrid is Fun";
//	    Email to = new Email("test@example.com");
//	    Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
//	    Mail mail = new Mail(from, subject, to, content);
//
//	    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
//	    Request request = new Request();
//	    try {
//	      request.setMethod(Method.POST);
//	      request.setEndpoint("mail/send");
//	      request.setBody(mail.build());
//	      Response response = sg.api(request);
//	      System.out.println(response.getStatusCode());
//	      System.out.println(response.getBody());
//	      System.out.println(response.getHeaders());
//	    } catch (IOException ex) {
//	      throw ex;
//	    }
	}
}