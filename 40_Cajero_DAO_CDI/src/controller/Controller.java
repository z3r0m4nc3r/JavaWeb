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
		//Instrucciones para evitar la cache del navegador
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
		response.setHeader("Pragma", "no-cache"); 
		response.setHeader("Expires", "0");
		
		String option = request.getParameter("option");
		String url = "menu.html";
		
		switch (option){
		case "doLogin":
			request.getRequestDispatcher("LoginAction").include(request, response);
			if((Boolean)request.getAttribute("resultado")){
				url="menu.html";
			}else url="error.html";
			break;
		case "toIngresar":
			url="ingresar.html";
			break;
		case "doIngresar":
			request.getRequestDispatcher("IngresarAction").include(request, response);
			url="menu.html";
			break;
		case "toExtraer":
			url="extraer.html";
			break;
		case "doExtraer":
			request.getRequestDispatcher("ExtraerAction").include(request, response);
			url="menu.html";
			break;
		case "toTransferencia":
			url="transferencia.html";
			break;
		case "doTransferencia":
			request.getRequestDispatcher("TransferenciaAction").include(request, response);
			url="menu.html";
			break;
		case "doMovimientos":
			request.getRequestDispatcher("MovimientosAction").include(request, response);
			url="movimientos.jsp";
			break;
		case "toMenu":
			url="menu.html";
			break;
		
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
