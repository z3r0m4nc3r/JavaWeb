package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Libro;
import service.LibrosService;
import service.LibrosServiceFactory;

@WebServlet("/ListaLibrosTemaAction")
public class ListaLibrosTemaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibrosService service = LibrosServiceFactory.getLibrosService();
		List<Libro> listaLibros = new ArrayList<>();
		if(!request.getParameter("temas").equals("todos")) {
			listaLibros = service.listaLibros().stream().filter(l -> l.getTema().getIdTema()==Integer.parseInt(request.getParameter("temas"))).collect(Collectors.toList());
		}else listaLibros=service.listaLibros();
		
		request.setAttribute("listaLibrosTema", listaLibros);

		}
	

}
