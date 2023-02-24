package cl.ldominguez.createuser.sevice;

import cl.ldominguez.createuser.common.messaging.CreatedUsuarioResponse;
import cl.ldominguez.createuser.domain.dto.UsuarioDto;
import cl.ldominguez.createuser.exception.UsuarioExisteException;

/**
 * 
 * @author ldominguez
 *
 */
public interface IUsuarioService {

	/**
	 * Crea un nuevo usuario en el sistema
	 * 
	 * @param request
	 * @return
	 * @throws UsuarioExisteException
	 */
	CreatedUsuarioResponse createUser(UsuarioDto request) throws UsuarioExisteException;

}
