package service;

import model.Cliente;

public interface ClientesService {
	
	Cliente autenticar (String user, String pwd);
	boolean altaNuevoCliente (Cliente cliente);
	Cliente cliente (int idCliente);
	

}
