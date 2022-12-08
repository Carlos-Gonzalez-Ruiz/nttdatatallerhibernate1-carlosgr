package com.nttdata.carlosgr.hibernate;

import java.util.List;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.carlosgr.hibernate.persistence.Client;
import com.nttdata.carlosgr.hibernate.service.ClientManagementServiceI;
import com.nttdata.carlosgr.hibernate.service.ClientManagementServiceImpl;

/**
 * NTT Data - Hibernate - Taller 1
 * 
 * Clase principal de la aplicación.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
public class App {
	/** LOGGER */
	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	/** Servicio de gestión de la tabla de clientes. */
	private static ClientManagementServiceI clientService;
	
	/** Auditoria - Usuario que actualiza */
	private static String updateUser;
	/** Auditoria - Fecha de actualización */
	private static Date updateDate;
	
	/**
	 * Función main de la clase.
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		try (final Session session = getSessionFactory().openSession()) {

			/// Auditoría.
			updateUser = "SYS";
			updateDate = new Date();

			/// Servicios de gestión.
			clientService = new ClientManagementServiceImpl(session);
			
			/// Inserción de datos.
			insertClient("Carlos", "González", "Ruiz", "78233940S"); // Ignorar aviso de SonarLint por no usar constantes.
			insertClient("Pepito", "Grillo", "Ramos", "78479386B");
			insertClient("Julián", "Ruiz", "Ruiz", "74878321H");
			insertClient("Pedrito", "Ramírez", "Ruiz", "92374897J");
			insertClient("Lia", "Ramos", "Gutiérrez", "84376772U");
			insertClient("David", "Ruiz", "Pérez", "12565781O");
			insertClient("Luis", "Rodríguez", "Pérez", "97834731B");
			insertClient("Carlos", "González", "Ruiz", "84638711K");
			insertClient("María", "Llopis", "Jiménez", "90182471Q");
			
			/// Consultas de prueba
			StringBuilder listString;
			List<Client> clients;
			
			// Mostrar todos los registros
			listString = new StringBuilder();
			clients = clientService.searchAll();
			for (Client c : clients) {
				listString.append("\n" + c);
			}
			LOG.info("\n > SELECT * FROM T_CLIENT{}\n", listString);
			
			// Mostrar todos los registros cuyo nombre y apellidos sean: Carlos González Ruiz
			listString = new StringBuilder();
			clients = clientService.searchByNameSurnameSurname2("Carlos", "González", "Ruiz");
			for (Client c : clients) {
				listString.append("\n" + c);
			}
			LOG.info("\n > SELECT * FROM T_CLIENT WHERE NAME='Carlos' AND SURNAME1='González' AND SURNAME2='Ruiz'{}\n", listString);
			
		} catch (HibernateException e) {
			LOG.error("No se ha podido construir la sesión: {}", e.getMessage());
		}
	}

	/**
	 * Método privado que devuelve una SessionFactory.
	 * 
	 * @return SessionFactory
	 */
	private static SessionFactory getSessionFactory() throws HibernateException {
		return new Configuration().configure().buildSessionFactory();
	}
	
	/**
	 * Método privado para insertar un cliente mediante atributos. 
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @param dni
	 */
	private static void insertClient(String name, String surname1, String surname2, String dni) {
		
		// Crear objeto cliente.
		Client client = new Client();
		client.setName(name);
		client.setSurname1(surname1);
		client.setSurname2(surname2);
		client.setDni(dni);
		client.setUpdateUser(updateUser);
		client.setUpdateDate(updateDate);
		
		// Insertar cliente.
		clientService.insertClient(client);
		
	}
	
}
