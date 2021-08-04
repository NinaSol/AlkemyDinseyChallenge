package disney.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import disney.challenge.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByUserName(String userName);
}
