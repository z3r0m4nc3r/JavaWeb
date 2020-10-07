package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Contador")
public class Contador extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperamos el valor del contador, que está en sesión
		//le sumamos uno y lo volvemos a guardar
		HttpSession sesion=request.getSession();
		Integer valor=sesion.getAttribute("contador")!=null?(Integer)sesion.getAttribute("contador"):0;
		valor++;
		sesion.setAttribute("contador", valor);
		//transferimos petición a la página de inicio
		request.getRequestDispatcher("inicio.html").forward(request, response);
	}

}
