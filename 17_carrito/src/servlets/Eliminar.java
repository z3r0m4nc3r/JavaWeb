package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Producto;

@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion=request.getSession();
		List<Producto> carro = (List<Producto>) sesion.getAttribute("carro");
		carro.remove(Integer.parseInt(request.getParameter("indice")));
		sesion.setAttribute("carro", carro);
		RequestDispatcher rd;
		rd=request.getRequestDispatcher("carrito.jsp");
		rd.forward(request, response);
	}

}
