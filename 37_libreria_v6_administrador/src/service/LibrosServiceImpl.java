package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Libro;
import model.Tema;

public class LibrosServiceImpl implements LibrosService {
	
	@Override
	public List<Tema> listaTemas() {
		
		try (Connection con=Datos.getConnection()){
			String sql="select * from libros.temas";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			List<Tema> listaTemas = new ArrayList<>();
			while (rs.next()) {
				listaTemas.add(new Tema(rs.getInt("idTema"),rs.getString("tema")));
			}
			return listaTemas;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return Collections.emptyList();
		
	}

	@Override
	public List<Libro> listaLibros() {
		try (Connection con=Datos.getConnection()){
			String sql="select * from libros.libros";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			List<Libro> listaLibros = new ArrayList<>();
			while (rs.next()) {
				listaLibros.add(new Libro(rs.getInt("isbn"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("precio"),rs.getInt("paginas"),tema(rs.getInt("idTema"))));
			}
			return listaLibros;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return Collections.emptyList();
		
	}

	@Override
	public Tema tema(int idTema) {
		return listaTemas().parallelStream().filter(t -> t.getIdTema()==idTema).findFirst().get();
	}

	@Override
	public Libro libro(int isbn) {
		return listaLibros().parallelStream().filter(l -> l.getIsbn()==isbn).findFirst().get();
	}
}


