package com.nttdata.carlosgr.hibernate.service;

import java.util.List;

import com.nttdata.carlosgr.hibernate.persistence.Client;

/**
 * NTT Data - Hibernate - Taller 1
 * 
 * Interfaz para la gestión del servicio de cliente.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
public interface ClientManagementServiceI {

	/**
	 * Método para insertar un cliente.
	 * 
	 * @param client
	 */
	public void insertClient(final Client client);

	/**
	 * Método para modifcar un cliente del registro.
	 * 
	 * @param client
	 */
	public void updateClient(final Client client);

	/**
	 * Método para eliminar un cliente del registro.
	 * 
	 * @param client
	 */
	public void deleteClient(final Client client);

	/**
	 * Método que devuelve el cliente con un ID específico.
	 * 
	 * @param id
	 * @return Client
	 */
	public Client searchById(final Long id);

	/**
	 * Método que devuelve todos los registros de la tabla de clientes.
	 * 
	 * @return List<Client>
	 */
	public List<Client> searchAll();

	/**
	 * Método que devuelve todos los registros que tenga un nombre y apellidos
	 * específico.
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @return List<Client>
	 */
	public List<Client> searchByNameSurnameSurname2(final String name, final String surname1, final String surname2);

}
