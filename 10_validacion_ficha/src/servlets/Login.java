package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd=request.getParameter("pwd");
		RequestDispatcher rd;
		if(pwd.equals("Java")){
			Cliente cliente=new Cliente(request.getParameter("user"),29,"abc@gmail.com");
			//guardamos los datos del cliente en un atributo de petición
			request.setAttribute("ficha", cliente);
			
			//obtener requestdispatcher
			rd=request.getRequestDispatcher("Bienvenida");	
			
			
		}else{
			//obtener requestdispatcher
			 rd=request.getRequestDispatcher("Error");			
		}
		//trasnferir petición
		rd.forward(request, response);
		
		
	}

}
