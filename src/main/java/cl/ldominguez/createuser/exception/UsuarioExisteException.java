package cl.ldominguez.createuser.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author ldominguez
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioExisteException extends Exception {

	private static final long serialVersionUID = -3477315967838777087L;

	@JsonProperty("message")
	private String message = "Correo ya registado";
	
	@JsonProperty("status_code")
	private int statusCode;

}
