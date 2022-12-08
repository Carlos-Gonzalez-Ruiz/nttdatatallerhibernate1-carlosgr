package com.nttdata.carlosgr.hibernate.service;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.carlosgr.hibernate.persistence.Client;
import com.nttdata.carlosgr.hibernate.persistence.ClientDaoI;
import com.nttdata.carlosgr.hibernate.persistence.ClientDaoImpl;

/**
 * NTT Data - Hibernate - Taller 1
 * 
 * Implementacioń de la interfaz para la gestión del servicio de cliente.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
public class ClientManagementServiceImpl implements ClientManagementServiceI {

	/** LOGGER */
	private static final Logger LOG = LoggerFactory.getLogger(ClientManagementServiceImpl.class);

	/** Objeto DAO de Client */
	private ClientDaoI clientDao;

	/**
	 * Constructor de la clase.
	 * 
	 * @param session
	 */
	public ClientManagementServiceImpl(Session session) {
		this.clientDao = new ClientDaoImpl(session);
	}

	@Override
	public void insertClient(final Client client) {

		// Comprobar que client sea un objeto "válido". (no nulo)
		if (client != null) {
			clientDao.insert(client);
		} else {
			LOG.error("No se pudo realizar la inserción.");
		}

	}

	@Override
	public void updateClient(final Client client) {

		// Comprobar que client sea un objeto "válido". (no nulo y sin ID nula)
		if (client != null && client.getClientId() != null) {
			clientDao.update(client);
		} else {
			LOG.error("No se pudo realizar la actualización.");
		}

	}

	@Override
	public void deleteClient(final Client client) {

		// Comprobar que client sea un objeto "válido". (no nulo y sin ID nula)
		if (client != null && client.getClientId() != null) {
			clientDao.delete(client);
		} else {
			LOG.error("No se pudo realizar la eliminación.");
		}

	}

	@Override
	public Client searchById(final Long id) {
		return clientDao.searchById(id);
	}

	@Override
	public List<Client> searchAll() {
		return clientDao.searchAll();
	}

	@Override
	public List<Client> searchByNameSurnameSurname2(final String name, final String surname1, final String surname2) {
		return clientDao.searchByNameSurname1Surname2(name, surname1, surname2);
	}

}
