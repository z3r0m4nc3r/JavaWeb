package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Comprobar")
public class Comprobar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String contrase�a = request.getParameter("contrase�a");
		
		if (usuario.contentEquals("pepito")) {
			if(contrase�a.contentEquals("1234")) {
				RequestDispatcher dispatcher=request.getRequestDispatcher("UsuarioAceptado");
				dispatcher.forward(request,response);
			}else {
				RequestDispatcher dispatcher=request.getRequestDispatcher("UsuarioRechazado");
				dispatcher.forward(request,response);
			}
		}else {
			//redireccionar:
			//response.sendRedirect("https://www.google.es");
			RequestDispatcher dispatcher=request.getRequestDispatcher("UsuarioRechazado");
			dispatcher.forward(request,response);
		}
	}

}
