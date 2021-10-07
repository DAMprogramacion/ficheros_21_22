package ficherosXML.dom;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class TestXMLDOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Sitio> listaSitios = null;
		try {
			listaSitios = ManejadorXMLDOM.obtenerListaCiudadesDesdeXML(
					"ficheros/sites.xml");
			System.out.printf("nº de ciudades parseadas %d%n", listaSitios.size());
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (listaSitios != null) {
			System.out.printf("Nº ciudades al norte %d%n", 
					ManejadorXMLDOM.obtenerCiudadesSeptentrionales(listaSitios).size());
			System.out.printf("Nº ciudades al este %d%n", 
					ManejadorXMLDOM.obtenerCiudadesDelEste(listaSitios).size());
		}
		Sitio newSitio = new Sitio();
		newSitio.setCiudad("Jaén");
		newSitio.setPais("España");
		newSitio.setLatitud(37.76922f);
		newSitio.setLongitud(-3.79028f);
		try {
			ManejadorXMLDOM.addNodeXML("ficheros/nuevos_sitios.xml", "ficheros/sitios_nuevos.xml", newSitio);
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
