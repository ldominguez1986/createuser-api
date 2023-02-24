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
	private String number;
	
	@NotBlank(message="Atributo 'citycode' es obligatorio")
	private String citycode;
	
	@NotBlank(message="Atributo 'countrycode' es obligatorio")
	private String countrycode;

}
