package dao;

import java.util.List;

import model.Cliente;
import model.Cuenta;
import model.Movimiento;

public interface CajeroDAO {
	void insertarMovimiento(Movimiento movimiento);
	void actualizarCuenta(Cuenta cuenta);
	Cuenta recuperarCuenta(int numeroCuenta);
	List <Movimiento> recuperarMovimientos(int numeroCuenta);
	void insertarCliente(Cliente cliente);

}
