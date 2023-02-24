/**
 * 
 */
package cl.ldominguez.createuser.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.ldominguez.createuser.common.messaging.CreateUsuarioErrorResponse;
import cl.ldominguez.createuser.common.messaging.CreatedUsuarioResponse;
import cl.ldominguez.createuser.constant.Constantes;
import cl.ldominguez.createuser.domain.dto.UsuarioDto;
import cl.ldominguez.createuser.exception.UsuarioExisteException;
import cl.ldominguez.createuser.sevice.IUsuarioService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ldominguez
 *
 */
@Slf4j
@OpenAPIDefinition(info = @Info(title = "API test Java", description = "Micro Servicio Create User"))
@RestController
@Validated
@RequestMapping(UserController.API_REST_V1_USUARIOS)
public class UserController {
	
	public static final String API_REST_V1_USUARIOS = Constantes.BASE_URI_API + Constantes.USUARIOS + "/create";
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Registra un nuevo usuario en el sistema")
	public @ResponseBody ResponseEntity<CreatedUsuarioResponse> createUser(@Valid @RequestBody UsuarioDto request) throws UsuarioExisteException {
		log.info("API: '{}', Metodo: 'createUser'", API_REST_V1_USUARIOS);
		return new ResponseEntity<>(usuarioService.createUser(request), HttpStatus.CREATED);
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UsuarioExisteException.class)
	public CreateUsuarioErrorResponse handleException(UsuarioExisteException ex) {
		CreateUsuarioErrorResponse errorResponse = new CreateUsuarioErrorResponse();
		errorResponse.setMensaje(ex.getMessage());
		log.error(errorResponse.toString());
		return errorResponse;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CreateUsuarioErrorResponse methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {
    	BindingResult result = ex.getBindingResult();
        List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();  
        CreateUsuarioErrorResponse errorResponse = new CreateUsuarioErrorResponse();
        errorResponse.setMensaje(fieldErrors.get(0).getDefaultMessage());
        return errorResponse;
    }

}
