package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Megusta")
public class Megusta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context=request.getServletContext();
		int megusta=context.getAttribute("megusta")!=null?(int)context.getAttribute("megusta"):0;
		megusta++;
		context.setAttribute("megusta", megusta);
		request.getRequestDispatcher("inicio.html").forward(request, response);
	}

}
