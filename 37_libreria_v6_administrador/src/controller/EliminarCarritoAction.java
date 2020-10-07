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


@WebServlet("/EliminarCarritoAction")
public class EliminarCarritoAction extends HttpServlet {
	
	
	private static final long serialVersionUID = 2733385884541860736L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		//recuperamos carrito que tenemos en un atributo de sesión
		Cliente cliente = (Cliente)s.getAttribute("clienteAutenticado");
		List<Libro> carrito= cliente.getCarrito();
		//si la sesión no ha caducado y hay carrito
		if(carrito.size()>0) {
			//recogemos el parametro con la posición del libro
			int pos=Integer.parseInt(request.getParameter("pos"));
			
			carrito.remove(pos);
		}
		//volvemos a recuperar los libros para la página libros.jsp
		request.getRequestDispatcher("ListaLibrosTemaAction").include(request, response);
	}

}
