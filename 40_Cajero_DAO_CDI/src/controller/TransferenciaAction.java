package controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cuenta;
import service.CajeroService;

@WebServlet("/TransferenciaAction")
public class TransferenciaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	CajeroService service;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Instrucciones para evitar la cache del navegador
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
		response.setHeader("Pragma", "no-cache"); 
		response.setHeader("Expires", "0");
		
		HttpSession sesion=request.getSession();
		Cuenta cuenta = (Cuenta)sesion.getAttribute("cuentaSesion");
		
		service.transferencia(cuenta.getNumeroCuenta(), Integer.parseInt(request.getParameter("cuentaDestino")), Double.parseDouble(request.getParameter("cantidad")));
	}

}
