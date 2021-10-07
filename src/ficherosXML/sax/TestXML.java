package ficherosXML.sax;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class TestXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SitioHandller hanlder = new SitioHandller();
		List<Sitio> sitios = null;
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			saxParser.parse(new File("ficheros/sitios_nuevos.xml"), hanlder);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (hanlder != null ) {
			sitios = hanlder.getSitios();
			
		}
		if (sitios != null)
			sitios.forEach(System.out::println);

	}

}
