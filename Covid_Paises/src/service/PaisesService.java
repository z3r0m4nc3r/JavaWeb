package service;

import java.util.List;
import java.util.Map;

import model.Caso;
import model.Pais;

public interface PaisesService {
	Map<String,Pais> recuperarPaises();
	List<Caso> recuperarCasos();
	long totalCasos(String pais);
	long incidencia14dias(String pais);
	long totalMuertesPais(String pais);

}
