package com.nttdata.carlosgr.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * NTT Data - Hibernate - Taller 1
 * 
 * Clase abstracta que define la entidad abstracta (AbstractEntity).
 * 
 * @author NTT Data - Carlos González Ruiz
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** Serial Version ID */
	private static final long serialVersionUID = 1L;
	/** Auditoria - Usuario que actualiza */
	private String updateUser;
	/** Auditoria - Fecha de actualización */
	private Date updateDate;

	/**
	 * @return the updateUser
	 */
	@Column(name = "AUDIT_UPDATED_USER", nullable = false)
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * @param updateUser the updateUser to set
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * @return the updateDate
	 */
	@Column(name = "AUDIT_UPDATED_DATE", nullable = false)
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * Método abstracto para obtener ID de la columna.
	 * 
	 * @return Long
	 */
	public abstract Long getId();

	/**
	 * Método abstracto para establecer ID de la columna.
	 * 
	 * @param id
	 */
	public abstract void setId(final Long id);

}
