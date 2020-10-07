package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class LibrosServiceImpl implements LibrosService {

	@Override
	public Cliente autenticar(String user, String pwd) {
		try(Connection con=Datos.getConnection()) {
			String sql="select * from libros.clientes";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			List<Cliente> listaClientes = new ArrayList<>();
			while (rs.next()) {
				listaClientes.add(new Cliente(rs.getInt("idCliente"),rs.getString("email"),rs.getString("password"),rs.getInt("telefono"),rs.getString("usuario")));
			}
			for(Cliente cliente:listaClientes) {
				if (cliente.getUsuario().equalsIgnoreCase(user) & cliente.getPassword().equals(pwd)) {
					return cliente;
				}
			}
			return null;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
