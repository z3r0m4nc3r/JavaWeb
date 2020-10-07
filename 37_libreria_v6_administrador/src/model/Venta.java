package model;

import java.util.Date;

public class Venta {
	private int idVenta;
	private Cliente comprador;
	private Libro libro;
	private Date fecha;

	public Venta() {
		
	}

	public Venta(Cliente comprador, Libro libro, Date fecha) {
		super();
		this.comprador = comprador;
		this.libro = libro;
		this.fecha = fecha;
	}

	public Cliente getComprador() {
		return comprador;
	}

	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	

}
