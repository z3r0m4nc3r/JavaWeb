package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		String url = "autentificacion.jsp";
		
		switch (option){
		case "doAutenticar":
			request.getRequestDispatcher("AutenticarAction").include(request, response);
			if((Boolean)request.getAttribute("resultado")){
				request.getRequestDispatcher("ListaTemasAction").include(request, response);
				url="temas.jsp";
			}else url="error.html";
			break;
		case "doAltaNuevo":
			request.getRequestDispatcher("AltaNuevoAction").include(request, response);
			url=(Boolean)request.getAttribute("resultado")?"autentificacion.jsp":"error.html";
			break;
		case "toAltaNuevo":
			url="nuevoUsuario.html";
			break;
		case "toSalir":
			url="autentificacion.jsp";
			break;
		case "doAgregarCarrito":
			request.getRequestDispatcher("AgregarCarritoAction").include(request, response);
			url="listaLibros.jsp";
			break;
		case "doListaTemas":
			request.getRequestDispatcher("ListaTemasAction").include(request, response);
			url="temas.jsp";
			break;
		case "doListaLibrosTema":
			request.getRequestDispatcher("ListaLibrosTemaAction").include(request, response);
			url="listaLibros.jsp";
			break;
		case "doEliminarCarrito":
        	request.getRequestDispatcher("EliminarCarritoAction").include(request, response);
            url="listaLibros.jsp";
            break;
		case "doProcesarCompra":
			request.getRequestDispatcher("ProcesarCompraAction").include(request, response);
			if((Boolean)request.getAttribute("resultado")){
				request.getRequestDispatcher("ListaTemasAction").include(request, response);
				url="temas.jsp";
			}else url="error.html";
			break;
		case "doListaVentas":
			request.getRequestDispatcher("ListaVentasAction").include(request, response);
			url="listaVentas.jsp";
			break;
		case "toAdministrador":
			url="administrador.jsp";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
