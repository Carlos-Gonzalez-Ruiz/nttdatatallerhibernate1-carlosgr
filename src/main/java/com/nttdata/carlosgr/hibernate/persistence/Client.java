package com.nttdata.carlosgr.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * NTT Data - Hibernate - Taller 1
 * 
 * Clase para la tabla de cliente.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
@Entity
@Table(name = "T_CLIENT", schema = "nttdata_hibernate_taller1_carlosgr_schema")
public class Client extends AbstractEntity implements Serializable {

	/** Serial Version ID */
	private static final long serialVersionUID = 1L;

	/** ID (Clave primaria) */
	private Long clientId;
	/** Nombre */
	private String name;
	/** Primer apellido */
	private String surname1;
	/** Segundo apellido */
	private String surname2;
	/** DNI */
	private String dni;

	/**
	 * @return the clientId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLIENT_ID")
	public Long getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the name
	 */
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname1
	 */
	@Column(name = "SURNAME1")
	public String getSurname1() {
		return surname1;
	}

	/**
	 * @param surname1 the surname1 to set
	 */
	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}

	/**
	 * @return the surname2
	 */
	@Column(name = "SURNAME2")
	public String getSurname2() {
		return surname2;
	}

	/**
	 * @param surname2 the surname2 to set
	 */
	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}

	/**
	 * @return the dni
	 */
	@Column(name = "DNI", nullable = false, unique = true, length = 9)
	@NotEmpty
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public Long getId() {
		return clientId;
	}

	@Override
	public void setId(Long id) {
		clientId = id;
	}

	@Override
	public String toString() {
		return "[id=" + clientId.toString() + ", name=\"" + name + "\", surname1=\"" + surname1 + "\", surname2=\""
				+ surname2 + "\", dni=\"" + dni + "\"]";
	}

}
