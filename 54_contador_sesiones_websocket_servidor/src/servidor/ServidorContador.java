package servidor;

import java.io.IOException;
import java.util.Set;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
@ServerEndpoint("/contador")
public class ServidorContador {

	@OnOpen
	public void open(Session sesion) {
		Set<Session> sesiones = sesion.getOpenSessions();
		sesiones.add(sesion);
			final int contador=sesiones.size();
		sesiones.forEach(s -> {
			try {
				s.getBasicRemote().sendObject(contador);
				System.out.println(sesiones.size());
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (EncodeException e) {
				
				e.printStackTrace();
			}
		});
		
	}
	
	@OnClose
	public void close(Session sesion) {
		Set<Session> sesiones = sesion.getOpenSessions();
		sesiones.remove(sesion);
			final int contador=sesiones.size();
		sesiones.forEach(s -> {
			try {
				s.getBasicRemote().sendObject(contador);
				System.out.println(sesiones.size());
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (EncodeException e) {
				
				e.printStackTrace();
			}
		});
	}
	
}
