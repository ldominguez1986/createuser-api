/**
 * 
 */
package cl.ldominguez.createuser.persistence.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ldominguez
 *
 */
@Entity
@Table(name="telefono")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Telefono {
	
	@Id 
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	
	@Column
	private String number;
	
	@Column
	private String citycode;
	
	@Column
	private String countrycode;
	
	@Column(name = "id_usuario", updatable = false, nullable = false)
	private UUID idUsuario;

}
