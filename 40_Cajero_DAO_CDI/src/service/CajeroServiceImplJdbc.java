package service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.CajeroDAO;
import model.Cuenta;
import model.Movimiento;
@RequestScoped
@Named("cajeroService")
public class CajeroServiceImplJdbc implements CajeroService {
	@Inject
	private CajeroDAO serviceDAO;

	@Override
	public Cuenta recuperarCuenta(int numeroCuenta) {
		return serviceDAO.recuperarCuenta(numeroCuenta);
	}

	@Override
	public void extraer(double cantidad, int numeroCuenta) {
		Cuenta cuenta = serviceDAO.recuperarCuenta(numeroCuenta);
		cuenta.setSaldo(cuenta.getSaldo()-cantidad);
		serviceDAO.actualizarCuenta(cuenta);
		serviceDAO.insertarMovimiento(new Movimiento(0,numeroCuenta,new java.util.Date(),cantidad,"extraccion"));
	}

	@Override
	public void ingresar(double cantidad, int numeroCuenta) {
		Cuenta cuenta = serviceDAO.recuperarCuenta(numeroCuenta);
		cuenta.setSaldo(cuenta.getSaldo()+cantidad);
		serviceDAO.actualizarCuenta(cuenta);
		serviceDAO.insertarMovimiento(new Movimiento(0,numeroCuenta,new java.util.Date(),cantidad,"ingreso"));
	}

	@Override
	public double obtenerSaldo(int numeroCuenta) {
		return serviceDAO.recuperarCuenta(numeroCuenta).getSaldo();
	}

	@Override
	public List<Movimiento> obtenerMovimientos(int numeroCuenta) {
		return serviceDAO.recuperarMovimientos(numeroCuenta);
	}

	@Override
	public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {
		extraer(cantidad, cuentaOrigen);
		ingresar(cantidad, cuentaDestino);
		
	}

}
