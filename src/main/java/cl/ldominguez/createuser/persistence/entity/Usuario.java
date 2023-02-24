package cl.ldominguez.createuser.persistence.entity;

import java.io.Serializable;
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
 * 
 * @author ldominguez
 *
 */
@Entity
@Table(name="usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String password;

	@Column(name = "token", updatable = false, nullable = false)
	private UUID token;

}