package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Venta;
import service.AdministradorService;

@WebServlet("/ListaVentasAction")
public class ListaVentasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	AdministradorService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Venta> listaVentas = new ArrayList <Venta>();
		listaVentas = service.listaVentas();
		request.setAttribute("listaVentas", listaVentas);
	}

}
