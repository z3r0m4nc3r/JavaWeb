package util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;

import model.Caso;
import model.Pais;

public class Utilidades {
	public static Pais adaptadorPais(JSONObject object) {
		return new Pais((String)object.get("name"),
				(String)object.get("capital"),
				(String)object.get("region"),
				(Long)object.get("population"),
				(String)object.get("flag"));
	}
	
	public static Caso adaptadorCaso(JSONObject object) {
		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
		Date nuevaFecha=null;
		try {
			nuevaFecha = sdt.parse((String)object.get("dateRep"));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		double c = 0;
		
		if(!object.get("Cumulative_number_for_14_days_of_COVID-19_cases_per_100000").toString().isEmpty()) {
			c = Double.parseDouble((String) object.get("Cumulative_number_for_14_days_of_COVID-19_cases_per_100000"));
		}
		
			return new Caso(nuevaFecha
					,Long.parseLong(object.get("cases").toString())
					,Integer.parseInt(object.get("deaths").toString())
					,object.get("countriesAndTerritories").toString()
					,object.get("continentExp").toString()
					, c);
		}

}
