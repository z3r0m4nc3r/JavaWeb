package controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.PaisesService;

@WebServlet("/DatosPaisAction")
public class DatosPaisAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private PaisesService servicePais;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Instrucciones para evitar la cache del navegador
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
				response.setHeader("Pragma", "no-cache"); 
				response.setHeader("Expires", "0");
				HttpSession sesion=request.getSession();
				
				if(sesion.getAttribute("paisSeleccionado")!=null) {
					sesion.removeAttribute("paisSeleccionado");
				}
				sesion.setAttribute("paisSeleccionado", servicePais.recuperarPaises().get((String)request.getParameter("pais")));
				
	}

}
