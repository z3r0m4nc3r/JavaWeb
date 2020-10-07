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

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	CajeroService service;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Instrucciones para evitar la cache del navegador
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
		response.setHeader("Pragma", "no-cache"); 
		response.setHeader("Expires", "0");
		
		Cuenta cuenta=service.recuperarCuenta(Integer.parseInt(request.getParameter("numeroCuenta")));
		if(cuenta!=null) {
			HttpSession sesion=request.getSession();
			sesion.setAttribute("cuentaSesion", cuenta);
			request.setAttribute("resultado", true);
			}else {
				request.setAttribute("resultado", false);
			}
	}

}
