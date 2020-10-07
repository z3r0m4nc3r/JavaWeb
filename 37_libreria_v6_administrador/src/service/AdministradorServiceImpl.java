package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Cliente;
import model.Libro;
import model.Venta;

public class AdministradorServiceImpl implements AdministradorService {

	public AdministradorServiceImpl() {
		
	}

	@Override
	public boolean nuevaVenta(Cliente cliente) {
		try(Connection cn=Datos.getConnection();) {                       	           
            String sql="insert into ventas (idCliente, idLibro, fecha) values(?,?,?)";
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
            for(Libro libro:cliente.getCarrito()) {
            	ps.setInt(1, cliente.getIdCliente());
            	ps.setInt(2, libro.getIsbn());
            	ps.setTimestamp(3, java.sql.Timestamp.valueOf(LocalDateTime.now(ZoneId.systemDefault())));
            	ps.execute();
            }
            return true;
            
        }  catch (SQLException ex) {
           return false;
        }

	}

	@Override
	public List<Venta> listaVentas() {
		ClientesService serviceClientes = ClientesServiceFactory.getLibrosService();
		LibrosService serviceLibros = LibrosServiceFactory.getLibrosService();
		try (Connection con=Datos.getConnection()){
			String sql="select * from libros.ventas";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			List<Venta> listaVentas = new ArrayList<>();
			while (rs.next()) {
				listaVentas.add(new Venta (serviceClientes.cliente(rs.getInt("idCliente")),serviceLibros.libro(rs.getInt("idLibro")),rs.getDate("fecha")));
			}
			return listaVentas;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

}


