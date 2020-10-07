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
import service.ClientesService;

@WebServlet("/AutenticarAction")
public class AutenticarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	ClientesService serviceCliente;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente clienteAutenticado = serviceCliente.autenticar(request.getParameter("user"), request.getParameter("pwd"));
		if(clienteAutenticado!=null) {
		HttpSession sesion=request.getSession();
		sesion.setAttribute("clienteAutenticado", clienteAutenticado);
		request.setAttribute("resultado", true);
		}else {
			request.setAttribute("resultado", false);
		}
	}

}
