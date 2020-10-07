package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Venta;
import service.AdministradorService;
import service.AdministradorServiceFactory;

@WebServlet("/ListaVentasAction")
public class ListaVentasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdministradorService service = AdministradorServiceFactory.getAdministradorServiceImpl();
		List<Venta> listaVentas = new ArrayList <Venta>();
		listaVentas = service.listaVentas();
		request.setAttribute("listaVentas", listaVentas);
	}

}
