package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MegustaListener
 *
 */
@WebListener
public class MegustaListener implements ServletContextListener, HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  { 
         HttpSession sesion=se.getSession();
         sesion.setAttribute("contador", 0);
         
         //incrementaremos el contador de usuarios activos (atributo de aplicación)
         ServletContext context=se.getSession().getServletContext();
         int activos=(Integer)context.getAttribute("contadorActivos");
         context.setAttribute("contadorActivos", ++activos);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
         //decrementaremos el contador de usuarios activos (atributo de aplicación)
    	 ServletContext context=se.getSession().getServletContext();
         int activos=(Integer)context.getAttribute("contadorActivos");
         context.setAttribute("contadorActivos", --activos);
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
        ServletContext context=sce.getServletContext();
        context.setAttribute("megusta", 0);
        
        //inicializamos el contador de usuarios activos al iniciarse la aplicación
        context.setAttribute("contadorActivos", 0);
    }
	
}
