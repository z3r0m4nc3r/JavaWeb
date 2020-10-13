package service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Stream;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.*;
import org.json.simple.parser.*;


public class Datos {
	@SuppressWarnings("unchecked")
	public static Stream<JSONObject> getStream () {		
		JSONParser parser = new JSONParser();
		JSONArray array = null;
			try {
				URL dir=new URL("https://restcountries.eu/rest/v2/all");
				HttpsURLConnection conn=(HttpsURLConnection)dir.openConnection();
				array = (JSONArray) parser.parse(new InputStreamReader(conn.getInputStream()));
				Stream<JSONObject> st = (Stream<JSONObject>)array.parallelStream();
				return st;
			} catch (ParseException e) {
				e.printStackTrace();
				return Stream.empty();
			} catch (IOException e) {
				e.printStackTrace();
				return Stream.empty();
			}
			
	}

}
