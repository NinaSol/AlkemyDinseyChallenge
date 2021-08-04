package disney.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import disney.challenge.entities.AuthRequest;
import disney.challenge.entities.Usuario;
import disney.challenge.security.JwtUtil;
import disney.challenge.services.IUsuarioService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private IUsuarioService iUsuarioService;

	@ApiOperation("Creacion de un usuario")
	@PostMapping("/register")
	public void register(@RequestBody Usuario usuario) throws Exception {
		this.iUsuarioService.register(usuario);
		this.iUsuarioService.sendWelcomeEmail(usuario.getEmail());
	}

	@ApiOperation("Autentificacion de un usuario")
	@PostMapping("/login")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}
}
