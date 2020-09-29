package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.ContactosService;
import service.ContactosServiceFactory;

@WebServlet("/Recuperar")
public class Recuperar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Instrucciones para evitar la cache del navegador
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
		response.setHeader("Pragma", "no-cache"); 
		response.setHeader("Expires", "0");

		ContactosService contactosService = ContactosServiceFactory.getContactosService();
		List<Contacto> contactos = contactosService.recuperarContactos();
		request.setAttribute("contactos", contactos);
		request.getRequestDispatcher("contactos.jsp").forward(request, response);
	}

}
