package model;

import java.util.Collections;
import java.util.List;

public class Cliente {
	private int idCliente;
	private String email;
	private String password;
	private int telefono;
	private String usuario;
	private List<Libro> carrito;
	
	public Cliente(int idCliente, String email, String password, int telefono, String usuario) {
		super();
		this.idCliente= idCliente;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.usuario = usuario;
		this.carrito = Collections.emptyList();
	}
	public Cliente() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public List<Libro> getCarrito() {
		return carrito;
	}
	public void setCarrito(List<Libro> carrito) {
		this.carrito = carrito;
	}
	
	

}
