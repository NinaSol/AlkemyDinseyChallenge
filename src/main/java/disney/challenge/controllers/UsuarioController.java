package disney.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/auth")
public class UsuarioController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private IUsuarioService iUsuarioService;

	@PostMapping("/register")
	public void register(@RequestBody Usuario usuario) throws Exception {
		iUsuarioService.register(usuario);
	}

    @PostMapping("/login")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
