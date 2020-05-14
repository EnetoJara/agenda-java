package com.databases.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.databases.models.Contacto;

/**
 * Basic connection to MySQL (MariaDB) database. Conexión básica a la base de
 * datos MySQL (MariaDB).
 *
 * @author <b>El Viejon<b>
 */
public class Connector {
	private Logger log;
	
	public Connector () {
		this.log = Logger.getLogger(Connector.class.getName());
	}
	
	/**
	 * We establish the connection with the database <b>customerdb</b>. 
	 * Establecemos la conexión con la base de datos <b>customerdb</b>.
	 */
	public Connection connectDatabase () {
		this.log.log(Level.ALL, "Connector::connectDatabase");
		try {
			// We register the MySQL (MariaDB) driver
            // Registramos el driver de MySQL (MariaDB)
			Class.forName("com.mysql.jdbc.Driver");
			// Datablase Connect
			// Conectamos con la base de datos
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "xulescode", "xulescode");
			conn.setAutoCommit(false);
			conn.isValid(50000);
			return conn;
		} catch (ClassNotFoundException ex) {
			this.log.log(Level.SEVERE, "Error al registrar el Driver de MySQL: ");
			this.log.log(Level.SEVERE, ex.getMessage());
		} catch (SQLException sqle) {
			this.log.log(Level.SEVERE, "Error al registrar el Driver de MySQL: ");
			this.log.log(Level.SEVERE, sqle.getMessage());			
		}
		return null;
	}
	
	public void cierraConneccion (Connection conn) {
		this.log.log(Level.ALL, "Connector::cierraConneccion");
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Applica los cambios en la tabla fisica.
	 * 
	 * @param conn  <i>MySQL</i> connection.
	 * @return <i>true</i> si la transaccion que ejecuto.
	 */
	public boolean commitTransaction (Connection conn) {
		this.log.log(Level.ALL, "Connector::commitTransaction");
		try {
			conn.commit();
			
			return true;
		} catch (SQLException ex) {
			try {
				this.log.log(Level.SEVERE, "Error Connector::commitTransaction");
				this.log.log(Level.SEVERE, ex.getMessage());
				conn.rollback();
			} catch (SQLException e) {
				this.log.log(Level.SEVERE, "Error Connector::commitTransaction::rollback");
				this.log.log(Level.SEVERE, e.getMessage());
				e.printStackTrace();
			}
			
			return false;
		}
	}
	
	/**
	 * Agrega un contacto nuevo a la agenda.
	 * 
	 * @param conn
	 * @param contacto
	 * @return
	 */
	public long agregarContacto (Connection conn, Contacto contacto) {
		long idGenerado = 0;
		try {
			this.log.log(Level.ALL, "Connector::agregarContacto");
			this.log.log(Level.ALL, contacto.toString());
			
			PreparedStatement insert = conn.prepareStatement(Query.INSERT.toString(), Statement.RETURN_GENERATED_KEYS);
			insert.setString(1, contacto.getNombre());
			insert.setString(2, contacto.getApellido());
			insert.setString(3, contacto.getTelefono());
			insert.setString(4, contacto.getEmail());
			insert.setString(5, contacto.getFoto());
			
			insert.executeUpdate();
			
			ResultSet rs = insert.getGeneratedKeys();
			if (rs.next()) {
				idGenerado = rs.getInt(1);
			}
			
			return idGenerado;
		} catch (SQLException e) {			
			this.log.log(Level.SEVERE, "Error al registrar Contacto");
			this.log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
		
		return idGenerado;
	}
	
	/**
	 * <i>getContactoPorId</i> busca contato por id.
	 * @param conn - <i>MySQL</i> database connector.
	 * @param idContacto - <i>Identificador</i> unico de registro. 
	 * @return <b>Contacto</b>
	 */
	public Contacto getContactoPorId (Connection conn, long idContacto) {
		Contacto contact;
		try {
			this.log.log(Level.ALL, "Connector::getContactoPorId");
			this.log.log(Level.ALL, idContacto+"");
			
			PreparedStatement getById = conn.prepareStatement(Query.GET_BY_ID.toString());
			
			getById.setLong(1, idContacto);
			
			ResultSet rs = getById.executeQuery();
			if (rs.next()) {
				contact = new Contacto(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"),rs.getString("email"), rs.getString("foto"));
			}
		} catch (SQLException e) {
			this.log.log(Level.SEVERE, "Error Connector::getContactoPorId");
			this.log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * <i>getTodos</i> obtienete todos los contactos de la tabla.
	 * 
	 * @param conn - <i>MySQL</i> database connector.
	 * @return <i>Lista</i> de contactos.
	 */
	public List<Contacto> getTodos (Connection conn) {
		List<Contacto> contactos = new ArrayList<Contacto>();
		try {
			this.log.log(Level.ALL, "Connector::getTodos");

			PreparedStatement getAll = conn.prepareStatement(Query.GET_ALL.toString());
			
			ResultSet rs = getAll.executeQuery();
			
			while (rs.next()) {
				Contacto contact = new Contacto(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"),rs.getString("email"), rs.getString("foto"));
				contactos.add(contact);
			}
			
		} catch (SQLException e) {
			this.log.log(Level.SEVERE, "Error::Connector::getTodos");
			e.printStackTrace();
		}
		return contactos;
	}

	/**
	 * <i>actualizaContacto</i> actualiza un registro en la tabla contactos.
	 * @param conn - <i>MySQL</i> database connector.
	 * @param toUpdate - <i>Contacto</i> a actualizar.
	 * @return <i>true</i> si se actualizo corractamente.
	 */
	public boolean actualizaContacto (Connection conn, Contacto toUpdate) {
		this.log.log(Level.ALL, "Connector::actualizarContacto");
		this.log.log(Level.ALL, toUpdate.toString());
		try {
			PreparedStatement update = conn.prepareStatement(Query.UPDATE.toString());
			
			update.setString(1, toUpdate.getNombre());
			update.setString(2, toUpdate.getApellido());
			update.setString(3, toUpdate.getTelefono());
			update.setString(4, toUpdate.getEmail());
			update.setString(5, toUpdate.getFoto());
			update.setLong(6, toUpdate.getId());
			
			int actializdo = update.executeUpdate();
			return actializdo > 0;
		} catch (SQLException e) {
			this.log.log(Level.SEVERE, "Error::Connector::actualizarContacto");
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * Elimina un contacto de la tabla.
	 * 
	 * @param conn - <i>MySQL</i> database connector.
	 * @param idContacto <i>Identificador</i> unico de registro.
	 * @return <i>true</i> si el contacto se elimino.
	 */
	public boolean eliminarContacto (Connection conn, long idContacto) {
		this.log.log(Level.ALL, "Connector::eliminarContacto");
		this.log.log(Level.ALL, idContacto + "");
		try {
			PreparedStatement delete = conn.prepareStatement(Query.DELETE.toString());
			delete.setLong(1, idContacto);
			int eliminados = delete.executeUpdate();
			
			return eliminados > 0;
		} catch (Exception e) {
			this.log.log(Level.SEVERE, "Error::Connector::eliminarContacto");
			e.printStackTrace();
		}
		return false;
	}
}
