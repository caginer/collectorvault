package com.mycompany.collectorvault.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usuarioid")
	private int usuarioId;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;

	@Column(name="email")
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="coleccionid")
	private List<Coleccion> coleccion;

	public Usuario (){
		
	}

	public Usuario( String nombre, String apellidos, String email, List<Coleccion> coleccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.coleccion = coleccion;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Coleccion> getColeccion() {
		return coleccion;
	}

	public void setColeccion(List<Coleccion> coleccion) {
		this.coleccion = coleccion;
	}

	@Override
	public String toString() {
		return "Usuario [usuarioId=" + usuarioId + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", coleccion=" + coleccion + "]";
	}
	

	

	
}
