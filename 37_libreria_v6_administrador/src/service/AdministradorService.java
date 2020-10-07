package service;

import java.util.List;

import model.Cliente;
import model.Venta;

public interface AdministradorService {
	boolean nuevaVenta (Cliente cliente);
	List <Venta> listaVentas ();

}
