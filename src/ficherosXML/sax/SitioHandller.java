package ficherosXML.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SitioHandller extends DefaultHandler {
	
	private List<Sitio> sitios;
	private Sitio sitio;
	private StringBuilder data;
	
	boolean bCity;
	boolean bContry;
	boolean bLatitude;
	boolean bLongitude;
	
	public List<Sitio> getSitios() {
		return sitios;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		switch (qName) {
		case "site":
			sitio = new Sitio();
			if (sitios == null)
				sitios = new ArrayList<>();
			break;
		case "city":
			bCity = true;
			break;
			
		case "country":
			bContry = true;
			break;
			
		case "latitude":
			bLatitude = true;
			break;
			
		case "longitude":
			bLongitude = true;
			break;
			
		default:
			break;
		}
		data = new StringBuilder();
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if (bCity) {
			sitio.setCiudad(data.toString());
			bCity = false;
		} else if (bContry) {
			sitio.setPais(data.toString());
			bContry = false;
		} else if (bLatitude) {
			sitio.setLatitud(Float.parseFloat(data.toString()));
			bLatitude = false;
		} else if (bLongitude) {
			sitio.setLongitud(Float.parseFloat(data.toString()));
			bLongitude = false;
		} 
		
		if (qName.equals("site"))
			sitios.add(sitio);
			
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		data.append(new String(ch, start, length));
	}
	
}
