package util;

import org.json.simple.JSONObject;

import model.Pais;

public class Utilidades {
	public static Pais adaptadorPais(JSONObject object) {
		
		return new Pais((String)object.get("name"),
				(String)object.get("capital"),
				(String)object.get("region"),
				(Long)object.get("population"),
				(String)object.get("flag"));
	}

}
