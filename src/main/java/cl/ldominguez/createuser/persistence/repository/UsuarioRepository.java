package cl.ldominguez.createuser.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ldominguez.createuser.persistence.entity.Usuario;

/**
 * 
 * @author ldominguez
 *
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByEmail(String email);

}
