package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.ContactosService;
import service.ContactosServiceFactory;


@WebServlet("/Guardar")
public class Guardar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Instrucciones para evitar la cache del navegador
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
		response.setHeader("Pragma", "no-cache"); 
		response.setHeader("Expires", "0");

		ContactosService contactosService = ContactosServiceFactory.getContactosService();
		Contacto contacto = new Contacto(request.getParameter("nombre"),request.getParameter("email"),Integer.parseInt(request.getParameter("edad")));
		contactosService.agregarContacto(contacto);
		request.getRequestDispatcher("inicio.html").forward(request, response);
	}

}
