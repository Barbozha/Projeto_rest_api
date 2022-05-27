package curso.spring.rest.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.spring.rest.api.model.Usuario;
import curso.spring.rest.api.repository.UsuarioRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(value = "/" , produces = "application/json")
	public ResponseEntity<List<Usuario>> buscar(){
		List<Usuario> todosUsuarios = (List<Usuario>)usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(todosUsuarios,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}" , produces = "application/json")
	public ResponseEntity<Usuario> pesquisaUsuario(@PathVariable(value="id") Long id){
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/" , produces = "application/json")
	public ResponseEntity<Usuario> incluir(@RequestBody Usuario usuario){
		
		for(int pos = 0; pos < usuario.getTelefones().size(); pos++ ) {
			usuario.getTelefones().get(pos).setUsuario(usuario);
		}
		
		Usuario novoUsuario = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(novoUsuario, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/" , produces = "application/json")
	public ResponseEntity<Usuario> alterarUsuario(@RequestBody Usuario usuario){
		
		// Rotina de atualização de usuário
		for(int pos = 0; pos < usuario.getTelefones().size(); pos ++) {
			usuario.getTelefones().get(pos).setUsuario(usuario);
		}
		
		Usuario alteraUsuario = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(alteraUsuario, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}" , produces = "application/text")
	public String excluirUsuario(@PathVariable("id") Long id){
		usuarioRepository.deleteById(id);
		return "Registro Excluído";
	}
	
}
