/**
 * 
 */
package cl.ldominguez.createuser.domain.dto;

import javax.validation.constraints.NotBlank;

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
@Schema(name = "Telefono")
public class TelefonoDto {
	
	@NotBlank(message="Atributo 'number' es obligatorio")
	@Schema( name="number", description = "Numero de telefono")
	private String number;
	
	@NotBlank(message="Atributo 'citycode' es obligatorio")
	@Schema( name="citycode", description = "Codigo de Cuidad")
	private String citycode;
	
	@NotBlank(message="Atributo 'countrycode' es obligatorio")
	@Schema( name="countrycode", description = "Codigo de Pais")
	private String countrycode;

}
