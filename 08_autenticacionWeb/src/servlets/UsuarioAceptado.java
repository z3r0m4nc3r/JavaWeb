package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UsuarioAceptado")
public class UsuarioAceptado extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String usuario = request.getParameter("usuario");
		String contraseña = request.getParameter("contraseña");
		response.setContentType("text/html");
		out.println("<html><body>");
		out.println("<h1>Bienvenido "+usuario+" con contraseña "+contraseña);
		
		out.println("</body></html>");
		out.close();
	}

}
