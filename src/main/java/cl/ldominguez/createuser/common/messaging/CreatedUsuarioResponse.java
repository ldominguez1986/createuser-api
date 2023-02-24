package cl.ldominguez.createuser.common.messaging;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import cl.ldominguez.createuser.domain.dto.UsuarioDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreatedUsuarioResponse {
	
	@JsonProperty("usuario")
	private UsuarioDto usuario;
	
	@JsonProperty("id")
	private UUID id;
	
	@JsonProperty("created")
	private Date created;
	
	@JsonProperty("modified")
	private Date modified;
	
	@JsonProperty("last_login")
	private Date lastLogin;
	
	@JsonProperty("token")
	private UUID token;
	
	@JsonProperty("isactive")
	private boolean isactive;
	
}
