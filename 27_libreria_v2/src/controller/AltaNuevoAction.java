package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClientesService;
import service.ClientesServiceFactory;

@WebServlet("/AltaNuevoAction")
public class AltaNuevoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente nuevo = new Cliente();
		ClientesService service = ClientesServiceFactory.getLibrosService();
		nuevo.setUsuario(request.getParameter("usuario"));
		nuevo.setPassword(request.getParameter("password"));
		nuevo.setEmail(request.getParameter("email"));
		nuevo.setTelefono(Integer.parseInt(request.getParameter("telefono")));
		if(service.altaNuevoCliente(nuevo)) {
			request.setAttribute("resultado", true);
		}else {
			request.setAttribute("resultado", false);
		}
	}

}
