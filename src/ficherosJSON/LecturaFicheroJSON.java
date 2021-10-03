package ficherosJSON;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LecturaFicheroJSON {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Sitio> sitios = null ;
		// create Gson instance
		Gson gson = new Gson();
		// create a reader
	    try (Reader reader = Files.newBufferedReader(Paths.get("ficheros/cities.json"));
){
	    	// convert JSON array to list of sitios
	    	sitios = gson.fromJson(reader, new TypeToken<List<Sitio>>() {}.getType());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    sitios.forEach(System.out::println);

	}

}
