package servelts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TablaNumero")
public class TablaNumero extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		
		int numero = Integer.parseInt(request.getParameter("numero"));
		out.println("Tabla del "+numero);
		out.println("<table border=\"1\">");
			
			for(int fila=1;fila<=10;fila++) {
				out.println("<tr>");
				out.println("<td>"+numero+"X"+fila+"</td>");
				out.println("<td> = "+numero*fila+"</td>");
				out.println("</tr>");
		}
		out.println("</table>");
		
		out.println("<a href=\"Tabla.html\"><input type=\"submit\" value=\"Volver\"/></a>");
		
		out.println("</body></html>");
		out.close();
		
	}

}
