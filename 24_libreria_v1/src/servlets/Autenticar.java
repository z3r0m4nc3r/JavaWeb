package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.LibrosService;
import service.LibrosServiceFactory;

@WebServlet("/Autenticar")
public class Autenticar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibrosService service = LibrosServiceFactory.getLibrosService();
		Cliente clienteAutenticado = service.autenticar(request.getParameter("user"), request.getParameter("pwd"));
		if(clienteAutenticado!=null) {
		request.setAttribute("clienteAutenticado", clienteAutenticado);
		request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error.html").forward(request, response);
		}
	}

}
