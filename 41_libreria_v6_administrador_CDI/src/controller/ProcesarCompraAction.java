package controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import service.AdministradorService;

@WebServlet("/ProcesarCompraAction")
public class ProcesarCompraAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	AdministradorService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion=request.getSession();
		if(service.nuevaVenta((Cliente)sesion.getAttribute("clienteAutenticado"))) {
			request.setAttribute("resultado", true);
			Cliente cliente = (Cliente)sesion.getAttribute("clienteAutenticado");
			cliente.getCarrito().clear();
		}else {
			request.setAttribute("resultado", false);
		}
	}

}
