package cl.ldominguez.createuser.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ldominguez.createuser.persistence.entity.Telefono;

/**
 * 
 * @author ldominguez
 *
 */
public interface TelefonoRepository extends JpaRepository<Telefono, Integer> {
	
}
