var cajadatos, socket, usuario;
function conectar(){
	usuario = document.getElementById("usuario").value;
	cajadatos= document.getElementById("cajadatos");
	socket = new WebSocket("ws://localhost:8080/56_chat_servidor/chat");
	socket.addEventListener("open", conectado);
	socket.addEventListener("message", recibido);
	
}
function conectado(){
	socket.send(usuario.toUpperCase()+" SE HA CONECTADO<br/>");
}

function recibido(evento){
	var lista = cajadatos.innerHTML;
	cajadatos.innerHTML = lista+evento.data+"<br/>";

}


function desconectar(){
	socket.send(usuario.toUpperCase()+" SE HA DESCONECTADO<br/>");
	socket.close();
	cajadatos.innerHTML = "Desconectado del Servidor";
}

function enviar(){
	
	mensaje = document.getElementById("mensaje").value;
	var chat=usuario+": "+mensaje;
		
	socket.send(chat);
}

