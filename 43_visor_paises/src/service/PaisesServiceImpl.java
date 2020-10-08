package service;

import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.Pais;
import util.Utilidades;

@RequestScoped
@Named("paisesService")

public class PaisesServiceImpl implements PaisesService {

	@Override
	public Map<String, Pais> recuperarPaises() {
		return Datos.getStream().map(ob -> Utilidades.adaptadorPais(ob))
		.collect(Collectors.toMap(p -> p.getNombre(),p -> p));
		
	}

}
