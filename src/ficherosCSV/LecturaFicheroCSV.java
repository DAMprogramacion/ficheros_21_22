package ficherosCSV;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LecturaFicheroCSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Sitio> sitios  = new ArrayList<>();
		Path inPath = Paths.get("ficheros/cities.csv");
		try {
			List<String> lineas = Files.readAllLines(inPath);
			lineas.remove(0);
			for (String linea: lineas) {
				//System.out.println(linea);
				String[] tokens  = linea.split(",");
				String ciudad    = tokens[0].trim();
				String pais      = tokens[1].trim();
				String sLatitud  = tokens[2].trim(); 
				String sLongitud = tokens[3].trim();
				float fLatitud   = Float.parseFloat(sLatitud);
				float fLongitud  = Float.parseFloat(sLongitud);
				Sitio sitio = new Sitio();
				sitio.setCiudad(ciudad);
				sitio.setPais(pais);
				sitio.setLatitud(fLatitud);
				sitio.setLongitud(fLongitud);
				sitios.add(sitio);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for (Sitio sitio: sitios) {
//			System.out.println(sitio);
//		}
	//	sitios.forEach(System.out::println);
	//	sitios.forEach(s -> System.out.println(s));
		System.out.println(sitios);

	}

}
