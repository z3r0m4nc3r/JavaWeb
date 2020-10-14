package servidor;

import java.io.IOException;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ServidorChat {
	@OnOpen
	public void open() {
		
	}
	
	@OnClose
	public void close() {
		
	}
	
	@OnMessage
	public void envioMensaje(String mensaje, Session sesion) {
		Set<Session> sesiones = sesion.getOpenSessions();
		sesiones.add(sesion);
		sesiones.forEach(s -> {
			try {
				System.out.println(mensaje);
				s.getBasicRemote().sendText(mensaje);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		});
		
	}
}
