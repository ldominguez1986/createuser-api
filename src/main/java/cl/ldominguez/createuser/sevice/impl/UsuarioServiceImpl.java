/**
 * 
 */
package cl.ldominguez.createuser.sevice.impl;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ldominguez.createuser.common.messaging.CreatedUsuarioResponse;
import cl.ldominguez.createuser.common.messaging.build.CreatedUsuarioResponseBuilder;
import cl.ldominguez.createuser.domain.dto.TelefonoDto;
import cl.ldominguez.createuser.domain.dto.UsuarioDto;
import cl.ldominguez.createuser.exception.UsuarioExisteException;
import cl.ldominguez.createuser.persistence.entity.Telefono;
import cl.ldominguez.createuser.persistence.entity.Usuario;
import cl.ldominguez.createuser.persistence.repository.TelefonoRepository;
import cl.ldominguez.createuser.persistence.repository.UsuarioRepository;
import cl.ldominguez.createuser.sevice.IUsuarioService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ldominguez
 *
 */
@Slf4j
@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TelefonoRepository telefonoRepository;

	@Override
	@Transactional
	public CreatedUsuarioResponse createUser(UsuarioDto request) throws UsuarioExisteException {
		log.info("createUser {}", request.toString());
		
		// consultar si existe un usuario registrado con el mismo email
		Usuario oldUser = usuarioRepository.findByEmail(request.getEmail());
		log.info("oldUser {}", oldUser);
		if (oldUser != null) {
			log.error("Error {} email ingresado ya existe en base de datos", request.getEmail());
			throw new UsuarioExisteException();
		}
		
		// registrar nuevo usuario
		Usuario user = new Usuario();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setToken(UUID.randomUUID());
		
		usuarioRepository.save(user);
		
		// registrar telefonos
		for (TelefonoDto dto : request.getPhones()) {
			Telefono telefono = new Telefono();
			telefono.setCitycode(dto.getCitycode());
			telefono.setCountrycode(dto.getCountrycode());
			telefono.setNumber(dto.getNumber());
			telefono.setIdUsuario(user.getId());
			
			// registrar y asociar telefono
			telefonoRepository.save(telefono);
		}
		
		return new CreatedUsuarioResponseBuilder().user(user).userDto(request).build();
	}

}
