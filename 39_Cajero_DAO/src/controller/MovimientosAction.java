package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cuenta;
import model.Movimiento;
import service.CajeroService;
import service.CajeroServiceFactory;

@WebServlet("/MovimientosAction")
public class MovimientosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Instrucciones para evitar la cache del navegador
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
		response.setHeader("Pragma", "no-cache"); 
		response.setHeader("Expires", "0");
		
		HttpSession sesion=request.getSession();
		Cuenta cuenta = (Cuenta)sesion.getAttribute("cuentaSesion");
		CajeroService service = CajeroServiceFactory.getCajeroService();
		List<Movimiento> listaMovimientos = service.obtenerMovimientos(cuenta.getNumeroCuenta());
		request.setAttribute("listaMovimientos", listaMovimientos);
		request.setAttribute("saldo", service.obtenerSaldo(cuenta.getNumeroCuenta()));
	}

}
