package disney.challenge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import disney.challenge.entities.Usuario;
import disney.challenge.repositories.IUsuarioRepository;

@SpringBootApplication
public class AlkemyJavaChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlkemyJavaChallengeApplication.class, args);
	}
	
//	@Autowired
//	IUsuarioRepository iUsuarioRepository;
//	
//	 @PostConstruct
//	    public void initUsers() {
//	        List<Usuario> users = Stream.of(
//	                new Usuario("javatechie", "password"),
//	                new Usuario("user1", "pwd1"),
//	                new Usuario("user2", "pwd2"),
//	                new Usuario("user3", "pwd3")
//	        ).collect(Collectors.toList());
//	        iUsuarioRepository.saveAll(users);
//	    }

}
