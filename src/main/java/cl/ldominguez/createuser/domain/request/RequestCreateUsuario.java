/**
 * 
 */
package cl.ldominguez.createuser.domain.request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cl.ldominguez.createuser.domain.dto.TelefonoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ldominguez
 *
 */
@Getter
@Setter
@ToString
@Schema(name = "RequestCreateUsuario")
public class RequestCreateUsuario {
	
	@NotBlank(message="Atributo 'name' es obligatorio")
	private String name;
	
	@NotBlank(message="Atributo 'email' es obligatorio")
	private String email;
	
	@NotBlank(message="Atributo 'password' es obligatorio")
	private String password;
	
	@NotNull
	private List<TelefonoDto> phones;

}
