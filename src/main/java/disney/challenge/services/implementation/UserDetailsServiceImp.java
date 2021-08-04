package disney.challenge.services.implementation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import disney.challenge.entities.Usuario;
import disney.challenge.repositories.IUsuarioRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
	@Autowired
	private IUsuarioRepository iusuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = iusuarioRepository.findByUserName(username);
		return new org.springframework.security.core.userdetails.User(usuario.getUserName(), usuario.getPassword(),
				new ArrayList<>());
	}
}
