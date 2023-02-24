/**
 * 
 */
package cl.ldominguez.createuser.common.messaging.build;

import java.util.Date;

import cl.ldominguez.createuser.common.messaging.CreatedUsuarioResponse;
import cl.ldominguez.createuser.domain.dto.UsuarioDto;
import cl.ldominguez.createuser.persistence.entity.Usuario;

/**
 * @author ldominguez
 *
 */
public class CreatedUsuarioResponseBuilder {
	
	private Usuario user;
	
	private UsuarioDto userDto;
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public CreatedUsuarioResponseBuilder user(Usuario user) {
		this.user = user;
		return this;
	}
	
	/**
	 * 
	 * @param userDto
	 * @return
	 */
	public CreatedUsuarioResponseBuilder userDto(UsuarioDto userDto) {
		this.userDto = userDto;
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public CreatedUsuarioResponse build() {
		CreatedUsuarioResponse response = new CreatedUsuarioResponse();
		
		// asignar datos de usuario
		response.setUsuario(userDto);
		
		// asignar datos sobre la creacion del nuevo usuario
		response.setIsactive(true);
		response.setCreated(new Date());
		response.setModified(new Date());
		response.setLastLogin(new Date());
		response.setId(user.getId());
		response.setToken(user.getToken());
		
		return response;
	}

}
