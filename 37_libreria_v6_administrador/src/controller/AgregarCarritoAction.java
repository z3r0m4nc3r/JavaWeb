package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import model.Libro;
import service.LibrosService;
import service.LibrosServiceFactory;

@WebServlet("/AgregarCarritoAction")
public class AgregarCarritoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession s=request.getSession();
		
		//recuperamos carrito que tenemos en un atributo de sesión
		Cliente cliente = (Cliente)s.getAttribute("clienteAutenticado");
		List<Libro> carrito= cliente.getCarrito();
		
		//recogemos el parametro con el isbn del libro a añadir
		
		int isbn = Integer.parseInt(request.getParameter("libro"));
		LibrosService glibros=LibrosServiceFactory.getLibrosService();
		//Añadimos libro obtenido al carrito
		carrito.add(glibros.libro(isbn));
		//volvemos a recuperar los libros para la página libros.jsp
		request.getRequestDispatcher("ListaLibrosTemaAction").include(request, response);
	}

}
