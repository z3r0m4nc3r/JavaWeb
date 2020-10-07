package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class FiltroControlLogin implements Filter {


	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//recuperamos la dirección original solicitada y si quiere autenticarse
				//le dejamos pasar
				String path=((HttpServletRequest)request).getServletPath();
				String param=((HttpServletRequest)request).getParameter("option");
				System.out.println(path);
				if(path.equals("/")||(path.equals("/Controller")&&param.equals("toAltaNuevo"))) {
					chain.doFilter(request, response);
					return;
				}
				//comprobamos la existencia del atributo de sesión "cliente"
				//si no existe, le mandamos a Inicio
				HttpSession sesion=((HttpServletRequest)request).getSession();
				if(sesion.getAttribute("clienteAutenticado")!=null) {
					chain.doFilter(request, response);
				}else {
					request.getRequestDispatcher("autentificacion.html").forward(request, response);
				}
			}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
