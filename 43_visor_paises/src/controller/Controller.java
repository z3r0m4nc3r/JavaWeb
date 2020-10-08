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
		
		String option = request.getParameter("option")!=null?request.getParameter("option"):"doInfoPais";
		
		String url = "infopaises.jsp";
		
		switch (option){
		case "doInfoPais":
			request.getRequestDispatcher("NombrePaisAction").include(request, response);
			url="infopaises.jsp";
			break;
		case "doSelectPais":
			request.getRequestDispatcher("DatosPaisAction").include(request, response);
			url="infopaises.jsp";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
