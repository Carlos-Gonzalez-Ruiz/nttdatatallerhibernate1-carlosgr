package com.nttdata.carlosgr.hibernate.persistence;

import java.util.List;

/**
 * NTT Data - Hibernate - Taller 1
 * 
 * Interfaz DAO de cliente.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
public interface ClientDaoI extends CommonDaoI<Client> {
	
	/**
	 * Método que devuelve una lista de los registros de la tabla por nombre y apellidos.
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @return List<Client>
	 */
	public List<Client> searchByNameSurname1Surname2(final String name, final String surname1, final String surname2);
	
}
