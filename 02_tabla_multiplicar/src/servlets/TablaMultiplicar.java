package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TablaMultiplicar")
public class TablaMultiplicar extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		out.println("<table style=\"width:100%\">");
		for(int col=1;col<=10;col++) {
			out.println("<tr>");
			
			for(int fila=1;fila<=10;fila++) {
				
				out.println("<td>"+col*fila+"</td>");
			}
		
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body></html>");
		out.close();
		
		
	}

}
