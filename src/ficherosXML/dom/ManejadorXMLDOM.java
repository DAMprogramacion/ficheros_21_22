package ficherosXML.dom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ManejadorXMLDOM {
	public static List<Sitio> obtenerListaCiudadesDesdeXML(String pathXML)
			throws ParserConfigurationException, SAXException, IOException {
		List<Sitio> sitios = new ArrayList<>();
		File fileXML = new File(pathXML);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
		Document doc = dbBuilder.parse(fileXML);
		doc.normalize();
		NodeList listaNodos = doc.getElementsByTagName("site");
		for (int i = 0; i < listaNodos.getLength(); i++) {
			Node node = listaNodos.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elemento = (Element) node;
				String city = elemento.getElementsByTagName("city").item(0).getTextContent();
				String country = elemento.getElementsByTagName("country").item(0).getTextContent();
				String sLatitude = elemento.getElementsByTagName("latitude").item(0).getTextContent();
				float fLatitude = Float.parseFloat(sLatitude);
				String sLongitude = elemento.getElementsByTagName("longitude").item(0).getTextContent();
				float fLongitude = Float.parseFloat(sLongitude);
				Sitio sitio = new Sitio();
				sitio.setCiudad(city);
				sitio.setPais(country);
				sitio.setLatitud(fLatitude);
				sitio.setLongitud(fLongitude);
				sitios.add(sitio);
			}
		}
		return sitios;
	}

	public static List<Sitio> obtenerCiudadesSeptentrionales(List<Sitio> lista) {
		List<Sitio> sitiosNorte = new ArrayList<>();
		for (Sitio sitio : lista) {
			if (sitio.getLatitud() > 0)
				sitiosNorte.add(sitio);
		}
		return sitiosNorte;
	}

	public static List<Sitio> obtenerCiudadesDelEste(List<Sitio> lista) {
		List<Sitio> sitiosEste = new ArrayList<>();
		for (Sitio sitio : lista) {
			if (sitio.getLongitud() > 0)
				sitiosEste.add(sitio);
		}
		return sitiosEste;
	}
	
	public static void addNodeXML ( String inPathFile , String	outPathFile , Sitio newSitio) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		File fileXML = new File(inPathFile);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
		Document doc = dbBuilder.parse(fileXML);
		doc.normalize();
		
		Element rootElement = doc.getDocumentElement();
		//System.out.println(rootElement);
		Element site = doc.createElement("site");
		
		Element city = doc.createElement("city");
		city.setTextContent(newSitio.getCiudad());
		site.appendChild(city);
		Element country = doc.createElement("country");
		country.setTextContent(newSitio.getPais());
		site.appendChild(country);
		Element latitude = doc.createElement("latitude");
		latitude.setTextContent(newSitio.getLatitud() + "");
		site.appendChild(latitude);
		Element longitude = doc.createElement("longitude");
		longitude.setTextContent(newSitio.getLongitud() + "");
		site.appendChild(longitude);

		rootElement.appendChild(site);
		
		// write the content into new xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(outPathFile));
        transformer.transform(source, result);
        
//        // Output to console for testing
//        StreamResult consoleResult = new StreamResult(System.out);
//        transformer.transform(source, consoleResult);
	}
	
	
	
	
	
	
	
	
	

}
