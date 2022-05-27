package curso.spring.rest.api.repository;

import org.springframework.data.repository.CrudRepository;

import curso.spring.rest.api.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
