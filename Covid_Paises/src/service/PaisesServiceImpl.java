package service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.Caso;
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

	@Override
	public List<Caso> recuperarCasos() {
		return Datos.getStreamCOVID().map(ob -> Utilidades.adaptadorCaso(ob))
				.collect(Collectors.toList());
	}

	@Override
	public long totalCasos(String pais) {
		
		return recuperarCasos().parallelStream().filter(p -> p.getCountriesAndTerritories().equalsIgnoreCase(pais)).mapToLong(c -> c.getCases()).sum();
	}

	@Override
	public long incidencia14dias(String pais) {
		return Math.round(recuperarCasos().parallelStream().filter(r -> r.getCountriesAndTerritories().equalsIgnoreCase(pais))
				.max((r1,r2) -> r1.getDateRep().getTime()<r2.getDateRep().getTime()?-1:1).get().getCases_per_100000());
				
	}

	@Override
	public long totalMuertesPais(String pais) {
		return recuperarCasos().parallelStream().filter(p -> p.getCountriesAndTerritories().equalsIgnoreCase(pais)).mapToLong(c -> c.getDeaths()).sum();
	}

	

}
