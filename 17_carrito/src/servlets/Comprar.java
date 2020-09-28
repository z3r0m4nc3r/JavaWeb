package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Producto;

@WebServlet("/Comprar")
public class Comprar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Producto> carro = new ArrayList<>();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Producto nuevoProducto= new Producto();
		nuevoProducto.setNombre(request.getParameter("nombre"));
		nuevoProducto.setPrecio(Integer.parseInt(request.getParameter("precio").isEmpty()?"0":request.getParameter("precio")));
		nuevoProducto.setCategoria(request.getParameter("categoria"));
		carro.add(nuevoProducto);
		HttpSession sesion=request.getSession();
		sesion.setAttribute("carro", carro);
		RequestDispatcher rd;
		rd=request.getRequestDispatcher("continuar.html");
		rd.forward(request, response);
		
		
	}

}
