package com.nttdata.carlosgr.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * NTT Data - Hibernate - Taller 1
 * 
 * Implementación de la interfaz DAO de client.
 * 
 * @author NTT Data - Carlos González Ruiz
 * */
public class ClientDaoImpl extends CommonDaoImpl<Client> implements ClientDaoI {
	
	/** Sesión base de datos */
	private Session session;
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param session
	 */
	public ClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByNameSurname1Surname2(final String name, final String surname1, final String surname2) {
		checkSession();
		
		return session.createQuery("FROM Client WHERE name='" + name + "' AND surname1='" + surname1 + "' AND surname2='" + surname2 + "'").list();
	}

}
