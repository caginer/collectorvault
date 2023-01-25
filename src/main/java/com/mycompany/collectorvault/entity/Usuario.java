package com.mycompany.collectorvault.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "usuario", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuarioid")
	private int usuarioId;
	
	@Column(name = "username")
	private String username;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "password")
	private String password;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "email")
	private String email;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "coleccionid")
	private List<Coleccion> coleccion;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name= "usuario_rol", joinColumns = @JoinColumn(name = "usuarioid"), inverseJoinColumns =  @JoinColumn(name = "rolid"))
	private Set<Rol> roles = new HashSet<>();

	public Usuario() {

	}

	public Usuario(String nombre, String apellidos, String email, List<Coleccion> coleccion) {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

}
