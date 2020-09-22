package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FichaServlet")
public class FichaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		String nombre=request.getParameter("nombre");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String sexo = request.getParameter("sexo");
		String mensaje = sexo+" "+nombre+" Bienvenido";
		mensaje+=edad>18?" eres mayor de edad":" eres menor de edad";
		
		out.println("<h1>"+mensaje+"</h1>");

		out.println("</body></html>");
		out.close();
		
	}

}
