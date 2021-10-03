package ficherosXML.dom;

public class Sitio {
	
	//atributos igual que en los campos de fichero json
	private String city;
	private String country;
	private float latitude;
	private float longitude;
	
	//getters y setters
	public String getCiudad() {
		return city;
	}
	public void setCiudad(String ciudad) {
		this.city = ciudad;
	}
	public String getPais() {
		return country;
	}
	public void setPais(String pais) {
		this.country = pais;
	}
	public float getLatitud() {
		return latitude;
	}
	public void setLatitud(float latitud) {
		this.latitude = latitud;
	}
	public float getLongitud() {
		return longitude;
	}
	public void setLongitud(float longitud) {
		this.longitude = longitud;
	}

	@Override
	public String toString() {
		return String.format("Ciudad=%s, pais=%s, latitud=%.2f, longitud=%.2f",
				city, country, latitude, longitude);
	}
	
	

	


}
