package service;

import java.util.List;

import model.Libro;
import model.Tema;

public interface LibrosService {
	List<Tema> listaTemas ();
	List<Libro> listaLibros();
	Tema tema(int idTema);
	Libro libro (int isbn);
	
}
