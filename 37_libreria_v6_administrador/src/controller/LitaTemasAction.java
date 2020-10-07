package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LibrosService;
import service.LibrosServiceFactory;

@WebServlet("/ListaTemasAction")
public class LitaTemasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibrosService service = LibrosServiceFactory.getLibrosService();
		request.setAttribute("listaTemas", service.listaTemas());
	}

}
