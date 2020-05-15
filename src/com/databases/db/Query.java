package com.databases.db;

public enum Query {
	INSERT {
		public String toString () {
			return "INSERT INTO contactos (nombre, apellido, telefono, email, foto) VALUES (?,?,?,?,?);";
		}
	},
	UPDATE {
		public String toString () {
			return "UPDATE contactos SET nombre = ?, apellido = ?, telefono = ?, email = ?, foto = ? WHERE id = ?";
		}
	},
	DELETE {
		public String toString () {
			return "DELETE FROM contactos WHERE id = ?;";
		}
	},
	GET_ALL {
		public String toString () {
			return "SELECT id, nombre, apellido, email, telefono, foto FROM contactos;";
		}
	},
	GET_BY_ID {
		public String toString () {
			return "SELECT id, nombre, apellido, email, telefono, foto FROM contactos WHERE id = ?;";
		}
	},
}
 