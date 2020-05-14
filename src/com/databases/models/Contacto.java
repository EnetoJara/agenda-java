package com.databases.models;

import java.io.Serializable;

public class Contacto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String foto;
	
	
	/**
	 * Crea una instancia de la clase contacto,
	 * con valores por default
	 */
	public Contacto () {
		this(-1, null, null, null, null, null);
	}
	
	/**
	 * Crea una instancia de la clase contacto,
	 * util para crear uno nuevo.
	 * 
	 * @param nombre
	 * @param apellido
	 * @param telefono
	 * @param email
	 * @param foto
	 */
	public Contacto (String nombre, String apellido, String telefono, String email, String foto) {
		super();
		this.id = -1;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.foto = foto;
	}
	
	/**
	 * Crea una instancia de la clase contacto,
	 * util para los contactos ya registrados
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param telefono
	 * @param email
	 * @param foto
	 */
	public Contacto (long id, String nombre, String apellido, String telefono, String email, String foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.foto = foto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", email=" + email + ", foto=" + foto + "]";
	}
}
