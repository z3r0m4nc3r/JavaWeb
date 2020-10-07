package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClientesServiceImpl implements ClientesService {

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

	@Override
	public boolean altaNuevoCliente(Cliente cliente) {
		try(Connection con=Datos.getConnection()) {

			String sql="insert into clientes(usuario,password,email,telefono) values(?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, cliente.getUsuario());
			st.setString(2, cliente.getPassword());
			st.setString(3, cliente.getEmail());
			st.setInt(4, cliente.getTelefono());
			st.execute();
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Cliente cliente(int idCliente) {
		try(Connection con=Datos.getConnection()) {
			String sql="select * from libros.clientes where idCliente=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, idCliente);
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
			return new Cliente(rs.getInt("idCliente"),rs.getString("email"),rs.getString("password"),rs.getInt("telefono"),rs.getString("usuario"));
			}
		} catch (SQLException e) {
			
			return null;
		}
		return null;
		
	}

	
	
	

}
