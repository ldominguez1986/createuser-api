/**
 * 
 */
package cl.ldominguez.createuser.domain.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
@Schema(name = "Usuario")
public class UsuarioDto {
	
	@NotBlank(message="Atributo 'name' es obligatorio")
	@Schema( name="name", description = "Nombres y Apellidos del nuevo usuario")
	private String name;
	
	@NotBlank(message="Atributo 'email' es obligatorio")
	@Pattern(regexp = "^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$", message="El email ingresado no es valido")
	@Schema( name="email", description = "Correo electronico", example = "correo@empresa.com")
	private String email;
	
	@NotBlank(message="Atributo 'password' es obligatorio")
	@Pattern(regexp = "^[a-zA-Z0-9]{7}", message="El password ingresado no es valido")
	@Schema( name="password", description = "Contrasenia")
	private String password;
	
	@NotNull
	@Schema(name = "phones", description = "Lista de telefonos")
	private List<TelefonoDto> phones;

}
